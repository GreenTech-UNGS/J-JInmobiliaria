package model;

import java.io.File;
import java.io.IOException;

import org.joda.time.LocalDateTime;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import persistencia.backup.BackUper;

@Singleton
public class BackUpService {
	
	@Inject private BackUper backup;
	
	public BackUpService() {
		
	}
	
	public void createBackUp(File toFile) throws LogicaNegocioException{
		
		if(!toFile.exists())
			try {
				toFile.createNewFile();
			} catch (IOException e) {
				throw new LogicaNegocioException("No se pudo crear el archivo");
			}
		
		backup.exportBackUp(toFile, "backup_inmobiliaria" + LocalDateTime.now().toString("yyyyMMddss"));
	}
	
	public void importBackUp(File fromFile) throws LogicaNegocioException{
		backup.importBackUp(fromFile);
	}

}
