package com.accenture.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.model.Empleado;

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
	public void insertarEmpleado(Empleado empleado){
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		long id = (Long)s.save(empleado);
		empleado.setId(id);
		s.getTransaction().commit();
		s.close();
	}
	
	@Transactional
	public void eliminarEmpleado(Empleado empleado){
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.delete(empleado);
		s.getTransaction().commit();
		s.close();
	}
	
	@Transactional
	public Empleado getEmpleado(long id){
		Session s = sessionFactory.openSession();
		s.getTransaction();
		Empleado empleado = s.get(Empleado.class, id);
		s.close();
		return empleado;
	}
	
	@Transactional
	public void modificarEmpleado(Empleado empleado){
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.update(empleado);
		s.getTransaction().commit();
		s.close();
	}
		
}
