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
	public void eliminarOrdenDeTrabajo(OrdenDeTrabajo orden){
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.delete(orden);
		s.getTransaction().commit();
		s.close();
	}

	@Transactional
	public OrdenDeTrabajo getOrdenDeTrabajo(long id){
		Session s = sessionFactory.openSession();
		s.getTransaction();
		OrdenDeTrabajo orden = s.get(OrdenDeTrabajo.class, id);
		s.close();
		return orden;
	}

	@Transactional
	public void modificarOrdenDeTrabajo(OrdenDeTrabajo orden){
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.update(orden);
		s.getTransaction().commit();
		s.close();
	}

}
