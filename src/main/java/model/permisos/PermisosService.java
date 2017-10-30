package model.permisos;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.management.relation.Role;

import org.apache.lucene.index.Fields;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Rol;
import entities.Usuario;
import model.UsuarioService;

@Singleton
public class PermisosService {
	
	@Inject UsuarioService usuarioService;
	
	@Inject
	private PermisosService() {
		
	}
	
	public void setupViews(List<Object> viewsClass) {
		
		Usuario u = usuarioService.getUsuarioLogeado();
		//TODO: asumimos que el usuario se loge
		
		for (Object view : viewsClass) {
			
			if(view instanceof PermissionView) {
				PermissionView pView = (PermissionView) view;
				
				Field[] fields = pView.getClass().getDeclaredFields();
				
				for (Field field : fields) {
					field.setAccessible(true);
					Annotation annotation = field.getAnnotation(PermissableField.class);
					if(annotation != null) {
						
						PermissableField permisable = (PermissableField) annotation;
						Rol[] rolesDelField = permisable.roles();
						
						if(!usuarioService.tieneRolElLogeado(rolesDelField)) {
							try {
								pView.ocultarComponente(field.get(pView));
							} catch (IllegalArgumentException | IllegalAccessException e) {
								e.printStackTrace();
							}
						}
						
					}
					
				}
			}
			
		}
		
	}
	
	public List<String> getPermisosOf(Rol r) {
		throw new RuntimeException("No implementado");
	}
	
}
