package model.permisos;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import entities.Rol;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface PermissableField {

	Rol[] roles();
	
}
