package com.accenture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.data.EmpleadoDAO;
import com.accenture.data.OrdenDeTrabajoDAO;
import com.accenture.data.PropietarioDAO;
import com.accenture.model.OrdenDeTrabajo;


@Controller
@RequestMapping("OrdenDeTrabajo")
public class OrdenDeTrabajoController {

	@Autowired
	OrdenDeTrabajoDAO ordenDeTrabajoDAO;

	@Autowired
	PropietarioDAO propietarioDAO;

	@Autowired
	EmpleadoDAO empleadoDAO;

	@RequestMapping("/ListaOrdenes")
	public ModelAndView ListarOrdenes(){
		ModelAndView m = new ModelAndView("OrdenesDeTrabajo/ListaOrdenes");
		List<OrdenDeTrabajo> lista = ordenDeTrabajoDAO.listar();
		m.addObject("listaOrdenes", lista);
		return m;
	}

	@RequestMapping(path="NuevaOrden", method=RequestMethod.GET)
	public ModelAndView insertarOrden(){
		ModelAndView m = new ModelAndView("OrdenesDeTrabajo/InsertarOrden");
		m.addObject("orden", new OrdenDeTrabajo());
		m.addObject("propietarios", propietarioDAO.listar());
		m.addObject("empleados", empleadoDAO.listar());
		return m;
	}

	@RequestMapping(path="NuevaOrden", method=RequestMethod.POST)
	public String insertarOrden(@ModelAttribute("orden") OrdenDeTrabajo orden){
		ordenDeTrabajoDAO.insertarOrdenDeTrabajo(orden);
		return "redirect:/OrdenDeTrabajo/ListaOrdenes";
	}

	@RequestMapping("/Borrar/{id}")
	public String borrarOrden(@PathVariable Long id){
		OrdenDeTrabajo orden = ordenDeTrabajoDAO.getOrdenDeTrabajo(id);
		ordenDeTrabajoDAO.eliminarOrdenDeTrabajo(orden);
		return "redirect:/Empleado/Lista";
	}

	@RequestMapping("/ModificarOrden/{id}")
	public ModelAndView modificarOrden(@PathVariable Long id){
		OrdenDeTrabajo orden = ordenDeTrabajoDAO.getOrdenDeTrabajo(id);
		ModelAndView m = new ModelAndView("OrdenesDeTrabajo/ModificarOrden");
		m.addObject("orden",orden);
		m.addObject("propietarios", propietarioDAO.listar());
		m.addObject("empleados", empleadoDAO.listar());
		return m;

	}

	@RequestMapping(path = "ModificarOrden/{id}", method =RequestMethod.POST)
	public String modificarOrden(@ModelAttribute("orden") OrdenDeTrabajo orden, @PathVariable Long id){
		orden.setId(id);
		ordenDeTrabajoDAO.modificarOrdenDeTrabajo(orden);
		return "redirect:/OrdenDeTrabajo/ListaOrdenes";
	}

}
