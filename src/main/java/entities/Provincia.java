package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "provincias")
public class Provincia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private String nombre;
	private float impuesto;
	
	private Provincia(){
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getImpuesto() {
		return impuesto;
	}
	public void setImpuesto(float impuesto) {
		this.impuesto = impuesto;
	}
	public int getID() {
		return ID;
	}
	
	
	
	/*Buenos_Aires,
	Capital_Federal,
	Catamarca,
	Chaco,
	Chubut,
	Cordoba,
	Corrientes,
	Entre_Rios,
	Formosa,
	Jujuy,
	La_Pampa,
	La_Rioja,
	Mendoza,
	Misiones,
	Neuquen,
	Rio_Negro,
	Salta,
	San_Juan,
	San_Luis,
	Santa_Cruz,
	Santa_Fe,
	Santiago_del_Estero,
	Tierra_del_Fuego,
	Tucuman,*/
}
