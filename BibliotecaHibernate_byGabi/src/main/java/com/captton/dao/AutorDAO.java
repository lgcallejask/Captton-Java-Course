package com.captton.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.captton.hibernate.HibernateUtil;
import com.captton.model.Autor;
import com.captton.model.Libro;


public class AutorDAO {
	public static List<Autor> listarAutores()
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		
		List<Autor> lista = s.createQuery("FROM Autor").list();
		s.close();
		return lista; 
	}
	
	public static Autor getAutor(Long id)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		Autor aut = s.get(Autor.class, id);
		s.close();
		
		return aut;
	}
}
