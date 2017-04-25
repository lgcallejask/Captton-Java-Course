package com.accenture.controller;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

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
	OrdenDeTrabajoDAO ordenDAO;

	@Autowired
	PropietarioDAO propietarioDAO;

	@Autowired
	EmpleadoDAO empleadoDAO;

	@RequestMapping("/ListaOrdenes")
	public ModelAndView ListarOrdenes(){
		ModelAndView m = new ModelAndView("OrdenesDeTrabajo/ListaOrdenes");
		List<OrdenDeTrabajo> lista = ordenDAO.listar();
		m.addObject("listaOrdenes", lista);
		return m;
	}

	@RequestMapping(path="/ListaOrdenes" , method =RequestMethod.POST)
	public ModelAndView ListarOrdenesActivas(){
		ModelAndView m = new ModelAndView("OrdenesDeTrabajo/ListaOrdenes");
		List<OrdenDeTrabajo> lista = ordenDAO.listarFiltradas();
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
		orden.setManoDeObra(150);
		orden.setCosto(orden.getManoDeObra()*orden.getHorasTrabajadas());
		orden.setFechaIngreso(new Date());
		try{
			ordenDAO.insertarOrdenDeTrabajo(orden);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Revise los datos a cargar.", "Error", JOptionPane.ERROR_MESSAGE);
			return "redirect:/OrdenDeTrabajo/NuevaOrden";
		}
		return "redirect:/OrdenDeTrabajo/ListaOrdenes";
	}

	@RequestMapping("/Borrar/{id}")
	public String borrarOrden(@PathVariable Long id){
		OrdenDeTrabajo orden = ordenDAO.getOrdenDeTrabajo(id);
		ordenDAO.eliminarOrdenDeTrabajo(orden);
		return "redirect:/Empleado/Lista";
	}

	@RequestMapping("/ModificarOrden/{id}")
	public ModelAndView modificarOrden(@PathVariable Long id){
		OrdenDeTrabajo orden = ordenDAO.getOrdenDeTrabajo(id);
		ModelAndView m = new ModelAndView("OrdenesDeTrabajo/ModificarOrden");
		m.addObject("orden",orden);
		m.addObject("propietarios", propietarioDAO.listar());
		m.addObject("empleados", empleadoDAO.listar());
		return m;

	}

	@RequestMapping(path = "ModificarOrden/{id}", method =RequestMethod.POST)
	public String modificarOrden(@ModelAttribute("orden") OrdenDeTrabajo orden, @PathVariable Long id){
		orden.setId(id);
		orden.setManoDeObra(150);
		OrdenDeTrabajo antiguaOrden = ordenDAO.getOrdenDeTrabajo(id);
		orden.setCosto(antiguaOrden.getCosto()+orden.getManoDeObra()*(orden.getHorasTrabajadas()-antiguaOrden.getHorasTrabajadas()));
		orden.setFechaIngreso(antiguaOrden.getFechaIngreso());
		ordenDAO.modificarOrdenDeTrabajo(orden);
		return "redirect:/OrdenDeTrabajo/ListaOrdenes";
	}

	@RequestMapping("/FinalizarOrden/{id}")
	public ModelAndView FinalizarOrden(@PathVariable Long id){
		OrdenDeTrabajo orden = ordenDAO.getOrdenDeTrabajo(id);
		ModelAndView m = new ModelAndView("OrdenesDeTrabajo/FinalizarOrden");
		m.addObject("orden",orden);
		return m;

	}

	@RequestMapping(path = "FinalizarOrden/{id}", method =RequestMethod.POST)
	public String finalizarOrden(@ModelAttribute("orden") OrdenDeTrabajo orden, @PathVariable Long id){
		orden.setId(id);
		orden.setManoDeObra(150);
		orden.setCosto(orden.getCosto()+orden.getManoDeObra()*orden.getHorasTrabajadas());
		OrdenDeTrabajo antiguaOrden = ordenDAO.getOrdenDeTrabajo(id);
		orden.setFechaIngreso(antiguaOrden.getFechaIngreso());		
		ordenDAO.modificarOrdenDeTrabajo(orden);
		return "redirect:/OrdenDeTrabajo/ListaOrdenes";
	}
	
}
