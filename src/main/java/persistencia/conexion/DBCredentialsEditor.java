package persistencia.conexion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class DBCredentialsEditor {
	
	private static DBCredentialsEditor instancia;
	
	public static DBCredentialsEditor getEditor(){
		if(instancia == null)
			instancia = new DBCredentialsEditor();
		return instancia;
	}
	
    private File propsFile = new File("config.properties");
    private Properties props = new Properties();
	
    private DBCredentialsEditor(){
    	
    }
    
	public void setIP(String ip){
		loadProps();
		
		props.setProperty("dbip", ip);
		
		saveProps();
	}
	
	public void setPuerto(String puerto){
		loadProps();
		
		props.setProperty("dbport", puerto);
		
		saveProps();
	}
	
	public void setUsuario(String user){
		loadProps();
		
		props.setProperty("dbuser", user);
		
		saveProps();
	}
	
	public void setPass(String pass){
		loadProps();
		
		props.setProperty("dbpass", pass);
		
		saveProps();
	}
	
	public String getIP(){
		loadProps();
		
		String prop = props.getProperty("dbip");
		
		if(prop == null)
			return "";
		return prop;
	}
	
	public String getPuerto(){
		loadProps();
		
		String prop = props.getProperty("dbport");
		
		if(prop == null)
			return "";
		return prop;
	}
	
	public String getUsuario(){
		loadProps();
		
		String prop = props.getProperty("dbuser");
		
		if(prop == null)
			return "";
		return prop;
	}
	
	public String getPass(){
		loadProps();
		
		String prop = props.getProperty("dbpass");
		
		if(prop == null)
			return "";
		return prop;
	}
	
	private void loadProps(){
		try {
			props.load(new FileInputStream(propsFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void saveProps(){
		try {
			props.store(new FileOutputStream(propsFile), null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}