package com.accenture.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.model.OrdenDeTrabajo;
import com.accenture.model.Repuesto;

public class RepuestoDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	public List <Repuesto> listar(){
		Session s = sessionFactory.openSession();
		List<Repuesto> lista = s.createQuery("from Repuesto").list();
		s.close();
		return lista;
	}

	@Transactional
	public Repuesto getRepuesto(long id){
		Session s = sessionFactory.openSession();
		s.getTransaction();
		Repuesto repuesto = s.get(Repuesto.class, id);
		s.close();
		return repuesto;
	}
	
}
