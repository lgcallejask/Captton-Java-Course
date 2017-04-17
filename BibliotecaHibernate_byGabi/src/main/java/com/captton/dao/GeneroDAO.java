package com.captton.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.captton.hibernate.HibernateUtil;
import com.captton.model.Editorial;
import com.captton.model.Genero;

public class GeneroDAO {
	public static List<Genero> listarGeneros()
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		
		List<Genero> lista = s.createQuery("FROM Genero").list();
		s.close();
		return lista; 
	}
	
	public static Genero getGenero(Long id)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		Genero gen = s.get(Genero.class, id);
		s.close();
		
		return gen;
	}
}
