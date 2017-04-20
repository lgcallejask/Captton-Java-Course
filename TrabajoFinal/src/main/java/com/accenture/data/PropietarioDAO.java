package com.accenture.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.model.Propietario;

public class PropietarioDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	public List <Propietario> listar(){
		
		Session s = sessionFactory.openSession();
		List<Propietario> lista = s.createQuery("from Propietario").list();
		s.close();
		return lista;
	}
	
	@Transactional
	public void insertarPropietario(Propietario propietario){
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		long id = (Long)s.save(propietario);
		propietario.setId(id);
		s.getTransaction().commit();
		s.close();
	}
	
	@Transactional
	public void eliminarPropietario(Propietario propietario){
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.delete(propietario);
		s.getTransaction().commit();
		s.close();
	}
	
	@Transactional
	public Propietario getPropietario(long id){
		Session s = sessionFactory.openSession();
		s.getTransaction();
		Propietario propietario = s.get(Propietario.class, id);
		s.close();
		return propietario;
	}
	
	@Transactional
	public void modificarPropietario(Propietario propietario){
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.update(propietario);
		s.getTransaction().commit();
		s.close();
	}
		
}
