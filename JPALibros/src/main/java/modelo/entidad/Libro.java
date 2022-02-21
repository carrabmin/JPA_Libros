package modelo.entidad;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "libros")
public class Libro {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;

		private String titulo;
		private double precio;
		
		@ManyToOne (cascade=CascadeType.PERSIST) 
		// En una relacion de "uno a muchos", la FK siempre esta en el lado de "Muchos", en una
		// relacion de "uno a uno" podemos poner la FK donde queramos.
		// Por lo tanto la @JoinColumn siempre estará en este lado en este tipo de relaciones
		@JoinColumn(name="fk_id_editorial", referencedColumnName="id")
		private Editorial editorial;
		
		@ManyToOne (cascade=CascadeType.PERSIST)
		// En una relacion de "uno a muchos", la FK siempre esta en el lado de "Muchos", en una
		// relacion de "uno a uno" podemos poner la FK donde queramos.
		// Por lo tanto la @JoinColumn siempre estará en este lado en este tipo de relaciones
		@JoinColumn(name="fk_id_autor", referencedColumnName="id")
		private Autor autor;
		
		@ManyToMany(cascade=CascadeType.PERSIST)
		//En este caso @JoinTable daremos instrucciones para crear la tabla intermedia
		//que JPA creara para hacer la realcion "Many to Many" 
		//Usa los siguientes parametros
		//1. name -> El nombre de la tabla intermedia
		//2. joinColumns -> las columnas FK y PK que aporta esta entidad (LIBRO)
		//3. inverseJoinColumns -> las columnas FK y PK que me aporta la otra Entidad (LIBRERIA)
		@JoinTable(name="libros_librerias",
				   joinColumns= { @JoinColumn(name="fk_id_libro", referencedColumnName="id") }, //FK que aporta Libro
				   inverseJoinColumns= { @JoinColumn(name="fk_id_libreria", referencedColumnName="id")}) //FKs que aportan el resto de entidades
		private List<Libreria> librerias;

		public Libro() {
			super();
		}
		
		public Libro(Integer id, String titulo, double precio, Editorial editorial, Autor autor, List<Libreria> librerias) {
			super();
			this.id = id;
			this.titulo = titulo;
			this.precio = precio;
			this.editorial = editorial;
			this.autor = autor;
			this.librerias = librerias;
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

		public Editorial getEditorial() {
			return editorial;
		}

		public void setEditorial(Editorial editorial) {
			this.editorial = editorial;
		}

		public Autor getAutor() {
			return autor;
		}

		public void setAutor(Autor autor) {
			this.autor = autor;
		}
		
		public List<Libreria> getLibrerias() {
			return librerias;
		}

		public void setLibrerias(List<Libreria> librerias) {
			this.librerias = librerias;
		}

		@Override
		public String toString() {
			return "Libro [id=" + id + ", titulo=" + titulo + ", precio=" + precio + ", editorial=" + editorial
					+ ", autor=" + autor + "]"; 
		}
}



