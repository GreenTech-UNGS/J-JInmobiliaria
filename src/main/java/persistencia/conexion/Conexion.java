package persistencia.conexion;

import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.google.inject.Inject;

public class Conexion {
	
    private SessionFactory factory;
    private File configuration = new File("hibernate.cfg.xml");
    
    private DBCredentialsEditor dbProps = DBCredentialsEditor.getEditor();
	
    @Inject
	private Conexion(){

		Configuration c = new Configuration();
		c.configure(configuration);
		
		String url = "jdbc:mariadb://" + dbProps.getIP() + ":" + dbProps.getPuerto() + "/inmobiliaria";
		
		c.setProperty("hibernate.connection.url", url);
		c.setProperty("hibernate.connection.username", dbProps.getUsuario());
		c.setProperty("hibernate.connection.password", dbProps.getPass());
		
		System.out.println("asd");
    	factory = c.buildSessionFactory();
	}
	/*
	public static void resetConexion() throws HibernateException{
		instancia = new Conexion();
	}*/
	
	
	public SessionFactory getSessionFactory(){
		return factory;
	}
	
	
	public void cerrar()
	{
		factory.close();
	}
}
