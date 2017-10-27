package model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Rol;
import entities.Usuario;
import net.sf.jasperreports.engine.util.DigestUtils;
import persistencia.dao.iface.UsuarioDao;

@Singleton
public class UsuarioService {
	
	private Usuario logeado;
	@Inject UsuarioDao usuarioDao;

	@Inject
	private UsuarioService() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario getUsuarioLogeado() {

		return logeado;
	}
	
	public void logearUsuario(String nombre, String password) throws LogicaNegocioException {

		String md5 = getMD5Of(password);

		if(!usuarioDao.existeUsuarioCon(nombre, md5))
			throw new LogicaNegocioException("Nombre de usuario o contraseña invalidos");
		
		logeado = usuarioDao.getUsuarioBy(nombre, md5);
		
	}
	
	public boolean tieneRolElLogeado(Rol... r) {
		
		if(logeado == null)
			return false;
		
		for (Rol rol: r) {
			
			if(logeado.getRoles().contains(rol))
				return true;
			
		}
		
		return false;
		
	}
	
	private String getMD5Of(String s) {
		
		try {
			byte[] byteData = MessageDigest.getInstance("MD5").digest(s.getBytes("UTF-8"));
			
			StringBuffer sb = new StringBuffer();
		    for (int i = 0; i < byteData.length; i++)
		        sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		    
		    return sb.toString();
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
	
}
