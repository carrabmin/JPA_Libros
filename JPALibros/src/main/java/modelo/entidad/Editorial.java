package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "editoriales")
public class Editorial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String direccion;
	
	@OneToMany(mappedBy="editorial", cascade=CascadeType.ALL)
	// Relacion de "uno a muchos"
		// Esta anotacion en este extremo es para hacer relaciones bidireccionales.
		// La anotacion que es obligatoria es la que tiene la FK, es decir, la clase Libro 
	private List<Libro> coleccionLibros;
	
	public Editorial() {
		super();
	}

	public Editorial(Integer id, String nombre, String direccion, List<Libro> coleccionLibros) {
		super();
		this.id = id;
		this.nombre = nombre;
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
		return "Editorial [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + "]";
				
	}
	
}
