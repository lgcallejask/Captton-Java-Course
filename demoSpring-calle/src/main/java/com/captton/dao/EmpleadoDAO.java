package com.captton.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.captton.model.Empleado;

public class EmpleadoDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Empleado> listar()
	{		
		Session s = sessionFactory.openSession();
		List<Empleado> lista = s.createQuery("from Empleado").list();		
		s.close();		 		
		return lista;
	}
	
	public void insertarEmpleado(Empleado emple)
	{
		Session s = sessionFactory.openSession();
		
		s.beginTransaction();
		Long id =(Long)s.save(emple);
		//Emple.setId(id);
		s.getTransaction().commit();
		s.close();
	}
	
	public void borrarEmpleado(Empleado emple)
	{
		Session s = sessionFactory.openSession();
		
		s.beginTransaction();
		s.delete(emple);
		s.getTransaction().commit();
		s.close();
	}
	public Empleado getEmpleado(long id)
	{
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		Empleado emple = s.get(Empleado.class, id);		
		s.close();
		return emple;
	}
	public void modificarEmpleado(Empleado emple)
	{
		Session s = sessionFactory.openSession();		
		s.beginTransaction();
		s.update(emple);
		s.getTransaction().commit();
		s.close();		
	}
	

}
