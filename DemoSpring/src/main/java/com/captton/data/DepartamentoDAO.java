package com.captton.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.captton.model.Departamento;
import com.captton.model.Empleado;

public class DepartamentoDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	
	public List<Departamento> listar()
	{				
		Session s = sessionFactory.openSession();
		List<Departamento> lista = s.createQuery("from Departamento").list();		
		s.close();		 		
		return lista;
	}

}
