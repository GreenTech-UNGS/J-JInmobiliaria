package presentacion.validators;

public class Regex {

	public static String onlyLetters(){
		return "^[a-zA-Z\\s]*$";
	}
	
	public static String onlyNumbers(){
		return "^[0-9]*$";
	}
	
	public static String email(){
		return "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	}
	
	public static String DNI(){
		return "[1-9][0-9]\\.[0-9]{3}\\.[0-9]{3}";
	}
	
	public static String OnlyNumbersDNI(){
		return "[1-9][0-9]{7}";
	}
	
	public static String CUIT(){
		return "(20|23|24|27|30|33|34)-[1-9][0-9]{7}-[1-9]";
		
	}
	
	public static String onlyNumbersCUIT(){
		return "(20|23|24|27|30|33|34)[1-9][0-9]{7}[1-9]";
	}
	
}
