package model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.joda.time.DateTime;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Foto;
import entities.Propiedad;
import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;
import persistencia.dao.iface.DAOftp;
import persistencia.dao.iface.FotoDao;
import persistencia.dao.iface.PropiedadDao;

@Singleton
public class GaleriaService {
	
	@Inject private FotoDao fotoDao;
	@Inject private DAOftp ftp;
	
	private Random random;
	private int fotosPorPagina = 9;
	
	private List<Foto> fotosEnMemoria;
	
	@Inject
	private GaleriaService() {
		random = new Random();
		
		fotosEnMemoria = new ArrayList<>();
		
	}
	
	public void saveFoto(Propiedad p, File file){
		
		int numImagesNew = p.getFotos().size() + 1;
		
		String fileName = DateTime.now().getMillis() + "_" + 
				random.nextInt(10000) + numImagesNew + file.getName();
		
		String fileNameThumb = DateTime.now().getMillis() + "_" + 
				random.nextInt(10000) + numImagesNew + "_thumbnail_"+ file.getName();
		
		
		File thumbnail = new File("./"+fileNameThumb);
		
		try {
			Thumbnails.of(file)
				.size(100, 100)
				.toFile(thumbnail);
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		ftp.storeFile(file, fileName);
		ftp.storeFile(thumbnail, fileNameThumb);
		
		Foto image = new Foto();
		image.setPath(fileName);
		image.setThumbPath(fileNameThumb);
		
		p.getFotos().add(image);

	}
	
	public List<byte[]> getImagesOf(Propiedad p, int page){
		
		List<Foto> fotos = p.getFotos();
		List<File> thumbnails = new ArrayList<>();
		List<byte[]> toRet = new ArrayList<>();
		
		for (Foto foto : fotos) {
			if(!fotosEnMemoria.contains(foto)) {
				fotosEnMemoria.add(foto);
				ftp.retrieveFile(foto.getThumbPath(), "./"+foto.getThumbPath());
				thumbnails.add(new File("./"+foto.getThumbPath()));
			}
			
			else {
				thumbnails.add(new File("./"+foto.getThumbPath()));
			}
		}
		
		for(int i = page * fotosPorPagina; i < (page * fotosPorPagina) + fotosPorPagina; i++){
			if(i >= thumbnails.size())
				break;
			
			try {
				toRet.add(Files.readAllBytes(thumbnails.get(i).toPath()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return toRet;
	}

}
