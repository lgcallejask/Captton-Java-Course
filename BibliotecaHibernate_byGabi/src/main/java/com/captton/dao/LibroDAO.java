package com.captton.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.captton.hibernate.HibernateUtil;
import com.captton.model.Libro;

public class LibroDAO {
	public static List<Libro> listarLibros()
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		
		List<Libro> lista = s.createQuery("FROM Libro").list();
		s.close();
		return lista; 
	}
	
	public static void agregarLibro(Libro lib)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		Long id = (Long)s.save(lib);
		s.getTransaction().commit();
		s.close();
	}
	
	public static void borrarLibro(Libro lib)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		s.delete(lib);
		s.getTransaction().commit();
		s.close();
	}
	
	public static void modificarLibro(Libro lib)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		s.update(lib);
		s.getTransaction().commit();
		s.close();
	}
	
	public static Libro getLibro(Long id)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		Libro lib = s.get(Libro.class, id);
		s.close();
		
		return lib;
	}
	
	
}
