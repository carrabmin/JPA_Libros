package vista;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.entidad.Autor;
import modelo.entidad.Editorial;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;

public class MainLibros {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("PruebaJPALibros");
			
		// REQUERIMIENTO 01: Gestión de BBDD -->
		
		EntityManager em01 = null;
		EntityManager em02 = null;
		EntityManager em03 = null;
		EntityManager em04 = null;
		
		// Generamos objetos autor
		@SuppressWarnings("deprecation")
		Autor autor01 = new Autor(null, "Gabriel", "García Márquez", new Date(27,2,6), null);
		@SuppressWarnings("deprecation")
		Autor autor02 = new Autor(null, "Eloy", "Moreno Olaria", new Date(76,0,12), null);
		@SuppressWarnings("deprecation")
		Autor autor03 = new Autor(null, "Stephen", "Edwin King", new Date(47,8,21), null);
		
		em01 = emf.createEntityManager();
		em01.getTransaction().begin();
		
		// Persistimos los autores
		em01.persist(autor01);
		em01.persist(autor02); 
		em01.persist(autor03); 
		
		em01.getTransaction().commit(); 
		System.out.println(" ----- Autores dados de alta ----- \n");
		
		em01.close();
		
		// Generamos objetos editorial
		Editorial editorial01 = new Editorial(null, "Bancroft Press", "4527 Glenwood Ave, La Crescenta - CA 91214", null);
		Editorial editorial02 = new Editorial(null, "Salamandra", "Almogavers 55 2A, 08018 Barcelona", null);
		em02 = emf.createEntityManager();
		em02.getTransaction().begin();
		
		// Persistimos las editoriales
		em02.persist(editorial01);
		em02.persist(editorial02);  
		
		em02.getTransaction().commit(); 
		System.out.println(" ----- Editoriales dadas de alta ----- \n");
		
		em02.close();
		
		em03 = emf.createEntityManager();
		
		// Generamos los objetos libro
		Libro libro01 = new Libro(null, "Doctor Sueño", 25.95, em03.find(Editorial.class, 1), em03.find(Autor.class, 3), null);
		Libro libro02 = new Libro(null, "El resplandor", 20.75, em03.find(Editorial.class, 1), em03.find(Autor.class, 3), null);
		Libro libro03 = new Libro(null, "Misery", 17.85, em03.find(Editorial.class, 1), em03.find(Autor.class, 3), null);
		Libro libro04 = new Libro(null, "El regalo", 16.25, em03.find(Editorial.class, 2), em03.find(Autor.class, 2), null);
		Libro libro05 = new Libro(null, "Invisible", 12.25, em03.find(Editorial.class, 2), em03.find(Autor.class, 2), null);
		Libro libro06 = new Libro(null, "Diferente", 18.55, em03.find(Editorial.class, 2), em03.find(Autor.class, 2), null);
		Libro libro07 = new Libro(null, "Cien años de soledad", 22.85, em03.find(Editorial.class, 2), em03.find(Autor.class, 1), null);
		Libro libro08 = new Libro(null, "Crónica de una muerte anunciada", 19.95, em03.find(Editorial.class, 2), em03.find(Autor.class, 1), null);
		
		// Asignamos una coleccion de libros a la editorial01
		List<Libro> listaLibrosEditorial01 = new ArrayList<Libro>();
		listaLibrosEditorial01.add(libro01);
		listaLibrosEditorial01.add(libro02);
		editorial01.setColeccionLibros(listaLibrosEditorial01);
		
		// Asignamos una coleccion de libros a la editorial02
		List<Libro> listaLibrosEditorial02 = new ArrayList<Libro>();
		listaLibrosEditorial02.add(libro03);
		listaLibrosEditorial02.add(libro04);
		listaLibrosEditorial02.add(libro05);
		listaLibrosEditorial02.add(libro06);
		listaLibrosEditorial02.add(libro07);
		listaLibrosEditorial02.add(libro08);
		editorial02.setColeccionLibros(listaLibrosEditorial02);
		
		// Asignamos libros al autor03
		List<Libro> listaLibrosAutor03 = new ArrayList<Libro>();
		listaLibrosAutor03.add(libro01);
		listaLibrosAutor03.add(libro02);
		listaLibrosAutor03.add(libro03);
		autor03.setLibros(listaLibrosAutor03);
		
		// Asignamos libros al autor02
		List<Libro> listaLibrosAutor02 = new ArrayList<Libro>();
		listaLibrosAutor02.add(libro04);
		listaLibrosAutor02.add(libro05);
		listaLibrosAutor02.add(libro06);
		autor02.setLibros(listaLibrosAutor02);
		
		// Asignamos libros al autor01
		List<Libro> listaLibrosAutor01 = new ArrayList<Libro>();
		listaLibrosAutor01.add(libro07);
		listaLibrosAutor01.add(libro08);
		listaLibrosAutor01.add(libro06);
		autor01.setLibros(listaLibrosAutor01);
		
		// Generamos las obejtos librería
		Libreria libreria01 = new Libreria(null, "Librería Arroyo", "Gabriel Arroyo", "C/ Muro 6", null);
		Libreria libreria02 = new Libreria(null, "Libros Domínguez", "Andrés Domínguez", "C/ Alta 12", null);
		
		//Asignamos librerías a los libros
		List<Libreria> libreriasLibros01 = new ArrayList<Libreria>();
		libreriasLibros01.add(libreria01);
		libreriasLibros01.add(libreria02);
		libro01.setLibrerias(libreriasLibros01);
		libro02.setLibrerias(libreriasLibros01);
		libro03.setLibrerias(libreriasLibros01);
		libro04.setLibrerias(libreriasLibros01);
		
		List<Libreria> libreriasLibros02 = new ArrayList<Libreria>();
		libreriasLibros02.add(libreria01);
		libro05.setLibrerias(libreriasLibros02);
		libro06.setLibrerias(libreriasLibros02);
		
		List<Libreria> libreriasLibros03 = new ArrayList<Libreria>();
		libreriasLibros03.add(libreria02);
		libro07.setLibrerias(libreriasLibros03);
		libro08.setLibrerias(libreriasLibros03);
		
		// Asignamos libros a las librerías
		List<Libro> listaLibrosLibreria01 = new ArrayList<Libro>();
		listaLibrosLibreria01.add(libro01);
		listaLibrosLibreria01.add(libro02);
		listaLibrosLibreria01.add(libro03);
		listaLibrosLibreria01.add(libro04);
		libreria01.setColeccionLibros(listaLibrosLibreria01);
		
		List<Libro> listaLibrosLibreria02 = new ArrayList<Libro>();
		listaLibrosLibreria01.add(libro05);
		listaLibrosLibreria01.add(libro06);
		listaLibrosLibreria01.add(libro07);
		listaLibrosLibreria01.add(libro08);
		libreria02.setColeccionLibros(listaLibrosLibreria02);
		
		em03.getTransaction().begin();
		
		// Persistimos los libros que persistiran a su vez las librerías
		// por tener establecido el CASCADE
		em03.persist(libro01);
		em03.persist(libro02); 
		em03.persist(libro03); 
		em03.persist(libro04);
		em03.persist(libro05); 
		em03.persist(libro06); 
		em03.persist(libro07);
		em03.persist(libro08); 
		
		em03.getTransaction().commit(); 
		System.out.println(" ----- Libros y Librerías dados de alta ----- \n");
		
		em03.close();
		
		// REQUERIMIENTO 02: CONSULTAS -->
		
		em04 = emf.createEntityManager();
		
		Query query = em04.createQuery("SELECT lib.titulo, lib.editorial.nombre, lib.autor.nombre, lib.autor.apellidos FROM Libro lib");
		List<Object[]> resultados = query.getResultList();
		System.out.println("==== Listado de libros, su editorial y su autor ====");
		for (Object[] p : resultados) {
			System.out.println("Libro: " + p[0] + " / Editorial: " + p[1] + " / Autor: " + p[2] + " " + p[3]);
		}
		
		System.out.println("");
		
		query = em04.createQuery("SELECT aut, aut.libros FROM Autor aut"); 
		List<Object[]> resultados01 = query.getResultList();
		System.out.println("\n==== Listado de autores y libros asociados ====");
		for (Object[] p1 : resultados01) {
			System.out.println(p1[0] + " - Libro: " +  p1[1]);
		}
		
		System.out.println("");
		
		query = em04.createQuery("SELECT libreria, libreria.coleccionLibros FROM Libreria libreria");
		List<Object[]> resultados02 = query.getResultList();
		System.out.println("\n==== Listado de librerias y  sus libros asociadas ====");
		for (Object[] p : resultados02) {
			System.out.println(p[0] + " - Libros asociados: " + p[1]);
		}
		
		System.out.println("");
		
		query = em04.createQuery("SELECT lib, lib.librerias FROM Libro lib");
		List<Object[]> resultados03 = query.getResultList();
		System.out.println("\n==== Listado de libros y  sus librerias asociadas ====");
		for (Object[] p : resultados03) {
			System.out.println(p[0] + " - Librerías: " + p[1]);
		}
		
		em04.close();
		emf.close();

	}
	
}
