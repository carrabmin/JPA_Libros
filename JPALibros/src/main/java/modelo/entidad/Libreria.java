package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "librerias")
public class Libreria {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nombre;
	private String propietario;
	private String direccion;
	
	@ManyToMany(mappedBy="librerias", cascade=CascadeType.PERSIST, fetch = FetchType.EAGER) 
	private List<Libro> coleccionLibros;

	public Libreria() {
		super();
	}	
	
	public Libreria(Integer id, String nombre, String propietario, String direccion, List<Libro> coleccionLibros) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.propietario = propietario;
		this.direccion = direccion;
		this.coleccionLibros = coleccionLibros;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Libro> getColeccionLibros() {
		return coleccionLibros;
	}

	public void setColeccionLibros(List<Libro> coleccionLibros) {
		this.coleccionLibros = coleccionLibros;
	}

	@Override
	public String toString() {
		return "Libreria [id=" + id + ", nombre=" + nombre + ", propietario=" + propietario + ", direccion=" + direccion
				+ ", coleccionLibros=" + coleccionLibros + "]";
	}


	
	
	
	
	
	

}
