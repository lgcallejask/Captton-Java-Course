package com.captton.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.captton.hibernate.HibernateUtil;
import com.captton.model.Editorial;
import com.captton.model.Libro;

public class EditorialDAO {
	public static List<Editorial> listarEditoriales()
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		
		List<Editorial> lista = s.createQuery("FROM Editorial").list();
		s.close();
		return lista; 
	}
	
	public static Editorial getEditorial(Long id)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		Editorial edi = s.get(Editorial.class, id);
		s.close();
		
		return edi;
	}
	
}
