package modelo.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "libros_exito_ventas")
public class LibroExitoVentas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String titulo;
	private double precio;
	private int unidadesVendidas;
	
	@OneToOne
	// Mediante @JoinColumn establecemos que la FK estará en esta tabla (libros_exito_ventas).
	// Le podemos dar el nombre de la columna y a que columna de la tabla
	// cliente estamos referenciando, que normalmente es la Primary Key (PK)
	@JoinColumn(name = "fk_id_autor", referencedColumnName = "id")
	private Autor autor;
	
	public LibroExitoVentas() {
		super();
	}

	public LibroExitoVentas(Integer id, String titulo, double precio, int unidadesVendidas, Autor autor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
		this.unidadesVendidas = unidadesVendidas;
		this.autor = autor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getUnidadesVendidas() {
		return unidadesVendidas;
	}

	public void setUnidadesVendidas(int unidadesVendidas) {
		this.unidadesVendidas = unidadesVendidas;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "LibroExitoVentas [id=" + id + ", titulo=" + titulo + ", precio=" + precio + ", unidadesVendidas="
				+ unidadesVendidas + ", autor=" + autor + "]";
	}

}
