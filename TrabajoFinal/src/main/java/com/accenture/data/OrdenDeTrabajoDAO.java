package com.accenture.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.model.OrdenDeTrabajo;

public class OrdenDeTrabajoDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	public List <OrdenDeTrabajo> listar(){
		
		Session s = sessionFactory.openSession();
		List<OrdenDeTrabajo> lista = s.createQuery("from OrdenDeTrabajo").list();
		s.close();
		return lista;
	}
	
	@Transactional
	public void insertarOrdenDeTrabajo(OrdenDeTrabajo orden){
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		long id = (Long)s.save(orden);
		orden.setId(id);
		s.getTransaction().commit();
		s.close();
	}
	
	@Transactional
	public void eliminarOrdenDeTrabajo(OrdenDeTrabajo emple){
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.delete(emple);
		s.getTransaction().commit();
		s.close();
	}
	
	@Transactional
	public OrdenDeTrabajo getOrdenDeTrabajo(long id){
		Session s = sessionFactory.openSession();
		s.getTransaction();
		OrdenDeTrabajo emple = s.get(OrdenDeTrabajo.class, id);
		s.close();
		return emple;
	}
	
	@Transactional
	public void modificarOrdenDeTrabajo(OrdenDeTrabajo emple){
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.update(emple);
		s.getTransaction().commit();
		s.close();
	}
		
}
