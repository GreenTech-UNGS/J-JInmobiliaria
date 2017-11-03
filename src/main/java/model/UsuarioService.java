package model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import dto.Mail;
import entities.EstadoUsuario;
import entities.Persona;
import entities.Rol;
import entities.Usuario;
import entities.Persona.TipoCredencial;
import persistencia.dao.iface.UsuarioDao;

@Singleton
public class UsuarioService {
	
	private Usuario logeado;
	private Random random;
	
	@Inject UsuarioDao usuarioDao;
	@Inject MailSenderService mailSender;

	@Inject
	private UsuarioService() {
		random = new Random();
	}
	
	public Usuario getUsuarioLogeado() {

		return logeado;
	}
	
	public void logearUsuario(String nombre, String password) throws LogicaNegocioException {

		//TODO: harcodeado
		if(nombre.equals("")){
			System.out.println("ESTA ENTRANDO CON EL USUARIO DE TEST. SEA CAUTELOSO");
		logeado = new Usuario();
		logeado.getRoles().add(Rol.ADMINISTRADOR);
		return;
		}
		
		String md5 = getMD5Of(password);

		if(!usuarioDao.existeUsuarioCon(nombre, md5))
			throw new LogicaNegocioException("Nombre de usuario o contrase�a invalidos");

		
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
	
	public void saveUsuario(Usuario toSave) throws LogicaNegocioException {
		
		if(existeUsuarioCon(toSave.getPersona()) && usuarioDao.existeUsuarioCon(toSave.getPersona().getEmail()))
			throw new LogicaNegocioException("Ya existe un usuario con la misma credencial");
		
		if(!usuarioDao.existeUsuarioCon(toSave.getPersona().getEmail()))
			toSave.setPswHash(getMD5Of(toSave.getPersona().getCredencial().substring(2)));
		
		toSave.setEstado(EstadoUsuario.HABILITADO);
		usuarioDao.save(toSave);
	}
	
	public void editarUsuario(Usuario toEdit) throws LogicaNegocioException {
		
		usuarioDao.save(toEdit);
	}
	
	public boolean existeUsuarioCon(Persona t) {
		
		return usuarioDao.existeUsuarioCon(t);	
	}

	public List<Usuario> getAll(){
		return usuarioDao.getAll();
	}

	public Usuario getNuevoUsuario() {
		
		Persona persona = new Persona();
		Usuario nuevo = new Usuario();
		nuevo.setPersona(persona);
		
		persona.setTipoCred(TipoCredencial.DNI);
		
		return nuevo;
	}

	public void actualizarContrasenaOf(String email) throws LogicaNegocioException{
		
		if(!usuarioDao.existeUsuarioCon(email))
			throw new LogicaNegocioException("El email no se encuentra registrado");
		
		Usuario toActualize = usuarioDao.getUsuarioBy(email);
		
		String newPass = random.nextInt(9) + "" 
						+ random.nextInt(9) + "" 
						+ random.nextInt(9) + "" 
						+ random.nextInt(9);
		
		String newPassHash = getMD5Of(newPass);
		toActualize.setPswHash(newPassHash);
		
		Mail mail = new Mail(email, "Restauración de constraseña", "Contraseña nueva: " + newPass);
		try {
			mailSender.send(mail);
			usuarioDao.save(toActualize);
		} catch (MessagingException e) {
			throw new LogicaNegocioException("Error al enviar el mail.\n"
					+ "Chequee su conexion a internet");
		}
		
	
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
	
	public void habilitarUsuario(Usuario usuario){
		
		usuario.setEstado(EstadoUsuario.HABILITADO);
	}
	
	public void deshabilitarUsuario(Usuario usuario){
		
		usuario.setEstado(EstadoUsuario.DESHABILITADO);
	}

}
