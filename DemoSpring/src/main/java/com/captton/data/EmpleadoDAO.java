package com.captton.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.captton.model.Empleado;

public class EmpleadoDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	public List <Empleado> listar(){
		
		Session s = sessionFactory.openSession();
		List<Empleado> lista = s.createQuery("from Empleado").list();
		s.close();
		return lista;
	}
	
	@Transactional
	public void insertarEmpleado(Empleado emple){
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		Long id = (Long)s.save(emple);
		emple.setId(id);
		s.getTransaction().commit();
		s.close();
	}
	
	@Transactional
	public void eliminarEmpleado(Empleado emple){
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.delete(emple);
		s.getTransaction().commit();
		s.close();
	}
	
	@Transactional
	public Empleado getEmpleado(long id){
		Session s = sessionFactory.openSession();
		s.getTransaction();
		Empleado emple = s.get(Empleado.class, id);
		s.close();
		return emple;
	}
	
	@Transactional
	public void modificarEmpleado(Empleado emple){
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.update(emple);
		s.getTransaction().commit();
		s.close();
	}
		
}
