package com.accenture.data;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.model.OrdenDeTrabajo;
import com.accenture.model.OrdenDeTrabajo_Repuesto;

public class OrdenDeTrabajo_RepuestoDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	public List <OrdenDeTrabajo_Repuesto> listar(long id){
		Session s = sessionFactory.openSession();
		Criteria crit = s.createCriteria(OrdenDeTrabajo_Repuesto.class);
		crit.add(Restrictions.eq("orden.id", id ));
		List<OrdenDeTrabajo_Repuesto> lista = crit.list();
		s.close();
		return lista;
	}
	
	@Transactional
	public void insertarDetalle(OrdenDeTrabajo_Repuesto detalle){
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.save(detalle);
		detalle.setOrden(detalle.getOrden());
		detalle.setRepuesto(detalle.getRepuesto());
		s.getTransaction().commit();
		s.close();
	}
	
	@Transactional
	public void eliminarDetalle(OrdenDeTrabajo_Repuesto detalle){
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.delete(detalle);
		s.getTransaction().commit();
		s.close();
	}
	
	@Transactional
	public OrdenDeTrabajo_Repuesto getDetalle(long idOrden, long idRepuesto){
		Session s = sessionFactory.openSession();
		Criteria crit = s.createCriteria(OrdenDeTrabajo_Repuesto.class);
		crit.add(Restrictions.eq("orden.id", idOrden ));
		crit.add(Restrictions.eq("repuesto.id", idRepuesto ));
		OrdenDeTrabajo_Repuesto detalle = (OrdenDeTrabajo_Repuesto)crit.list().get(0);
		s.close();
		return detalle;
	}
	
	@Transactional
	public void modificarDetalle(OrdenDeTrabajo_Repuesto detalle){
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.update(detalle);
		s.getTransaction().commit();
		s.close();
	}
		
}
