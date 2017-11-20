package model;

import java.io.File;

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
		backup.exportBackUp(toFile, "backup_inmobiliaria" + LocalDateTime.now().toString("yyyyMMddss"));
	}
	
	public void importBackUp(File fromFile) throws LogicaNegocioException{
		backup.importBackUp(fromFile);
	}

}
