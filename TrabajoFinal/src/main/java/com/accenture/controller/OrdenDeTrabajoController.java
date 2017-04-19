package com.accenture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.data.OrdenDeTrabajoDAO;
import com.accenture.model.OrdenDeTrabajo;



@Controller
@RequestMapping("OrdenDeTrabajo")
public class OrdenDeTrabajoController {
	
	@Autowired
	OrdenDeTrabajoDAO ordenDAO;
	
	@RequestMapping("/Lista")
	public ModelAndView ListarEmpleado(){
		ModelAndView m = new ModelAndView("OrdenesDeTrabajo/ListaOrdenes");
		List<OrdenDeTrabajo> lista = ordenDAO.listar();
		m.addObject("listaOrdenes", lista);
		return m;
	}
	
}
