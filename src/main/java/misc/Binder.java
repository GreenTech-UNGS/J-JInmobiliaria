package misc;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

import javax.swing.JTextField;

public class Binder<T> {
	
	enum Condition{STRVOIDISNULL};
	
	private Map<String, Supplier<Object>> getters;
	private Map<String, Consumer<Object>> setters;
	private Map<String, Condition> conditions;
	private T objective;

	public Binder() {
		getters = new HashMap<>();
		setters = new HashMap<>();
	}
	
	public void setObjective(T objective){
		this.objective = objective;
	}
	
	public void bind(String campo, JTextField field) {
		bind(campo, () -> field.getText(), t -> field.setText((String) t));
	}
	
	public void bind(String campo, Supplier<Object> getter, Consumer<Object> setter){
		
		getters.put(campo, getter);
		setters.put(campo, setter);
		
	}
	
	public void toBean(String campo, Supplier<Object> getter){

		getters.put(campo, getter);
	}	
	
	public void toField(String campo, Consumer<Object> setter){

		setters.put(campo, setter);
	}
	
	public void fillBean(){
		
		for(String s : getters.keySet()){
			String[] fields = s.split("\\.");
			
			try {
				
				setBeanFields(s, fields, objective, 0);
				
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	private void setBeanFields(String key, String[] fields, Object o, int i) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{

		Field f = null;
		Class<?> cAux = o.getClass();
		
		while(cAux != null && f == null) {
			Field[] declaredFields = cAux.getDeclaredFields();
			for(int j = 0; j < declaredFields.length; j++)
				if(fields[i].equals(declaredFields[j].getName())){
					f = declaredFields[j];
					break;
			}
			
			cAux = cAux.getSuperclass();
		}
		
		if(f == null) throw new RuntimeException("Propiedad no encontrada " + fields[i]);
		
		if(!f.isAccessible()) f.setAccessible(true);

		if(fields.length == i + 1){
			try {
				f.set(o, getters.get(key).get());
			} catch (Exception e) {
				throw new RuntimeException("Exception en  " + key + ": " + e.getMessage());
			}
		}
		else{
			Object o2 = f.get(o);
			setBeanFields(key,fields, o2, i + 1);
		}
		
	}
	
	public void fillFields(){
		
		for(String s : setters.keySet()){

			String[] fields = s.split("\\.");
			try {
				
				setFormFields(s, fields, objective, 0);
				
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	private void setFormFields(String key, String[] fields, Object o, int i) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		
		Field f = null;
		Class<?> cAux = o.getClass();
		
		while(cAux != null && f == null) {
			Field[] declaredFields = cAux.getDeclaredFields();
			for(int j = 0; j < declaredFields.length; j++)
				if(fields[i].equals(declaredFields[j].getName())){
					f = declaredFields[j];
					break;
				
			}
			
			cAux = cAux.getSuperclass();
			
		}
		
		if(f == null) throw new RuntimeException("Propiedad no encontrada " + fields[i]);
		
		if(!f.isAccessible()) f.setAccessible(true);

		if(fields.length == i + 1){
			try {
				setters.get(key).accept(f.get(o));
			} catch (Exception e) {
				throw new RuntimeException("Exception en  " + key );
			}
			
			
		}
		else{
			Object o2 = f.get(o);
			setFormFields(key,fields, o2, i + 1);
		}
	}
	
}
