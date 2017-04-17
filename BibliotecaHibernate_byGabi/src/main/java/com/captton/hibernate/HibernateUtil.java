package com.captton.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	private static SessionFactory sf = crearSession();

	private static SessionFactory crearSession()

	// CREAR LA SESSIONFACTORY A TRAVES DEL ARCHIVO .CFG
	{
		SessionFactory sf = null;
		try {
			Configuration conf = new Configuration().configure();
			sf = conf.buildSessionFactory();
		} catch (Throwable e) {
			throw new ExceptionInInitializerError("Se rompio papu, " + e.getMessage());
		}
		return sf;
	}

	public static SessionFactory getSessionFactory() {
		return sf;
	}
}