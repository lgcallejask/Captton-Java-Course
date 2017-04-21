package com.accenture.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

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

}
