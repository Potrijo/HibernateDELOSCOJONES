package com.marc.HibernateAnotaciones03;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
public class App {
	
	public static void nativeQuery() {
	SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	List<Libros> libros = session.createNativeQuery(
		"SELECT * "
		+"FROM libros "
		+"WHERE titulo like :name")
		.addEntity(Libros.class)
		.setParameter("name", "M%")
		.list();
	for (Libros libro: libros) {
		System.out.println(libro.getTitulo());
	}
	session.close();
	}
	
	public static void main(String[] args) {
		System.out.println("Parte 2.2");
		@SuppressWarnings("unused")
		 org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
		 java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.SEVERE);
		 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionFactory.openSession();
		 Query consulta = session.createQuery("from Escribir");
		 List<Escribir> resultados = consulta.list();
		for (Escribir resultado : resultados) {
			 System.out.println("(codautor,codlibro): ("
			+ resultado.getId().getCodautor()
			+ ","
			 + resultado.getId().getCodlibro()
			+ ") "
			+ resultado.getAutores().getNombre()
			+ " "
			 + resultado.getLibros().getTitulo()
			+ " "
			+ resultado.getAnyo());
			 }
		session.close();
		
		System.out.println("Parte 3");
		nativeQuery();
	 }
}
