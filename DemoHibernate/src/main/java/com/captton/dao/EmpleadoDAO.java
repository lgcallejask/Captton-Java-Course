package com.captton.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.captton.hibernate.HibernateUtil;
import com.captton.model.Empleado;

public class EmpleadoDAO 
{
	public static List<Empleado> listar()
	{		
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		List<Empleado> lista = s.createQuery("from Empleado").list();		
		s.close();		 		
		return lista;
	}
	
	public static void insertarEmpleado(Empleado emple)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		Long id =(Long)s.save(emple);
		//Emple.setId(id);
		s.getTransaction().commit();
		s.close();
	}
	
	public static void borrarEmpleado(Empleado emple)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		s.delete(emple);
		s.getTransaction().commit();
		s.close();
	}
	public static Empleado getEmpleado(long id)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		Empleado emple = s.get(Empleado.class, id);		
		s.close();
		return emple;
	}
	public static void modificarEmpleado(Empleado emple)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();		
		s.beginTransaction();
		s.update(emple);
		s.getTransaction().commit();
		s.close();		
	}
	

}
