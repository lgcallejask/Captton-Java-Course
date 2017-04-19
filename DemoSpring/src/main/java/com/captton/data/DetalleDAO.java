package com.captton.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.captton.model.DetallesEmpleado;

public class DetalleDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Transactional
	public void insertarDetalle(DetallesEmpleado detalle){
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		Long id = (Long)s.save(detalle);
		detalle.setId(id);
		s.getTransaction().commit();
		s.close();
	}
	
	@Transactional
	public void eliminarDetalle(DetallesEmpleado detalle){
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.delete(detalle);
		s.getTransaction().commit();
		s.close();
	}
	
	@Transactional
	public DetallesEmpleado getDetalle(long id){
		Session s = sessionFactory.openSession();
		s.getTransaction();
		DetallesEmpleado detalle = s.get(DetallesEmpleado.class, id);
		s.close();
		return detalle;
	}
	
	@Transactional
	public void modificarDetalle(DetallesEmpleado detalle){
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.update(detalle);
		s.getTransaction().commit();
		s.close();
	}
		
}

