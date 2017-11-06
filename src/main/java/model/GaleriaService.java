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
	
	private Map<Foto, File> fotosEnMemoria;
	private Map<Foto, File> thumbnailsEnMemoria;
	
	@Inject
	private GaleriaService() {
		random = new Random();
		
		fotosEnMemoria = new HashMap<>();
		thumbnailsEnMemoria = new HashMap<>();
		
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
	
	public void setPortada(Foto f, Propiedad p) {
		
		p.getFotos().forEach(foto -> foto.setPortada(false));
		
		f.setPortada(true);
		
		
	}
	
	public List<Foto> getFotosOf(Propiedad p, int page){
		
		int desde = page * fotosPorPagina;
		int hasta = (desde + fotosPorPagina) > p.getFotos().size() - 1?
				p.getFotos().size() - 1 : (desde + fotosPorPagina) ;
		
		return p.getFotos().subList(desde, hasta);
	}
	
	public byte[] getThumbnail(Foto f) {
		
		if(!thumbnailsEnMemoria.containsKey(f)) {
			thumbnailsEnMemoria.put(f, new File("./"+f.getThumbPath()));
			ftp.retrieveFile(f.getThumbPath(), "./"+f.getThumbPath());
		}
		
	
		try {
			return Files.readAllBytes(thumbnailsEnMemoria.get(f).toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}	
	
	public byte[] getImagen(Foto f) {
		if(!fotosEnMemoria.containsKey(f)) {
			fotosEnMemoria.put(f, new File("./"+f.getPath()));
			ftp.retrieveFile(f.getPath(), "./"+f.getPath());
		}
		
	
		try {
			return Files.readAllBytes(fotosEnMemoria.get(f).toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean isUltimaPagina(int pagina, Propiedad p) {
		
		int cantFotos = p.getFotos().size();
		int totalPaginas = cantFotos / fotosPorPagina;
		
		return totalPaginas <= pagina;
		
		
	}

}
