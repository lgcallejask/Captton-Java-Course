package com.captton.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.captton.hibernate.HibernateUtil;
import com.captton.model.Libro;

public class LibroDAO 
{
	public static List<Libro> listar()
	{		

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		List<Libro> lista = s.createQuery("from Libro").list();		
		s.close();		 		
		return lista;
	}

	public static void insertarLibro(Libro libro)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();

		s.beginTransaction();
		Long id =(Long)s.save(libro);
		//libro.setId(id);
		s.getTransaction().commit();
		s.close();
	}

	public static void borrarLibro(Libro libro)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();

		s.beginTransaction();
		s.delete(libro);
		s.getTransaction().commit();
		s.close();
	}
	public static Libro getLibro(int id)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		Libro libro = s.get(Libro.class, id);		
		s.close();
		return libro;
	}
	public static void modificarLibro(Libro libro)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();		
		s.beginTransaction();
		s.update(libro);
		s.getTransaction().commit();
		s.close();
	}
}
