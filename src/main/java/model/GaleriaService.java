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
import net.coobird.thumbnailator.tasks.UnsupportedFormatException;
import persistencia.dao.iface.DAOftp;
import persistencia.dao.iface.FotoDao;
import persistencia.dao.iface.PropiedadDao;

@Singleton
public class GaleriaService {
	
	@Inject private PropiedadDao propiedadDao;
	@Inject private DAOftp ftp;
	
	private Random random;
	private int fotosPorPagina = 9;
	
	
	@Inject
	private GaleriaService() {
		random = new Random();
		
		
	}
	
	public void saveFoto(Propiedad p, File file) throws LogicaNegocioException{
		
		int numImagesNew = p.getFotos().size() + 1;
		
		String fileName = DateTime.now().getMillis() + "_" + 
				random.nextInt(10000) + numImagesNew + file.getName();
		
		String fileNameThumb = DateTime.now().getMillis() + "_" + 
				random.nextInt(10000) + numImagesNew + "_thumbnail_"+ file.getName();
		
		
		File thumbnail = new File("./"+fileNameThumb);
		File foto = new File("./"+fileName);
		
		try {
			Thumbnails.of(file)
				.size(100, 100)
				.toFile(thumbnail);
			Thumbnails.of(file)
				.size(1024, 600)
				.toFile(foto);
		} catch (UnsupportedFormatException e) {
			
			throw new LogicaNegocioException("El archivo " + file.getName() + " no es una imagen");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ftp.storeFile(foto, fileName);
		ftp.storeFile(thumbnail, fileNameThumb);
		
		thumbnail.delete();
		foto.delete();
		
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
		int hasta = (desde + fotosPorPagina) >= p.getFotos().size()?
				p.getFotos().size() : (desde + fotosPorPagina) ;
		
		return p.getFotos().subList(desde, hasta);
	}
	
	public void borrarFoto(Propiedad p, Foto f) {
		
		ftp.deleteFile(f.getPath());

		ftp.deleteFile(f.getThumbPath());
		
		p.getFotos().remove(f);
		
		propiedadDao.save(p);
		
	}
	
	public byte[] getThumbnail(Foto f) {

		try {
			File tempFile = File.createTempFile(f.getThumbPath(), ".tmp");
			ftp.retrieveFile(f.getThumbPath(), tempFile.getAbsolutePath());
			return Files.readAllBytes(tempFile.toPath());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		return null;
	}	
	
	public byte[] getImagen(Foto f) {
		try {
			File tempFile = File.createTempFile(f.getPath(), ".tmp");
			ftp.retrieveFile(f.getPath(), tempFile.getAbsolutePath());
			return Files.readAllBytes(tempFile.toPath());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		return null;
	}
	
	public boolean isUltimaPagina(int pagina, Propiedad p) {
		
		int cantFotos = p.getFotos().size();
		int totalPaginas = cantFotos / fotosPorPagina;
		
		return totalPaginas <= pagina;
		
		
	}

}
