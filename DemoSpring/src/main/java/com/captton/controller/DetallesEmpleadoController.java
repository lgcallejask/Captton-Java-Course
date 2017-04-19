package com.captton.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.captton.data.DetalleDAO;
import com.captton.data.EmpleadoDAO;
import com.captton.model.DetallesEmpleado;
import com.captton.model.Empleado;

@Controller
@RequestMapping("DetallesEmpleado")

public class DetallesEmpleadoController {
	
	@Autowired
	EmpleadoDAO empleadoDAO;
	
	@Autowired
	DetalleDAO detalleDAO;

	@RequestMapping("/Detalles/{id}")
	public ModelAndView mostrarDetalles(@PathVariable Long id){
		ModelAndView m = new ModelAndView("DetallesEmpleados/ListaDetalles");
		DetallesEmpleado detalle = detalleDAO.getDetalle(id);
		detalle.setId(id);
		m.addObject("Detalle", detalle);
		
		
		
		return m;
	}
	
	@RequestMapping("/ModificarDetalles/{id}")
	public ModelAndView modificarDetalles(@PathVariable Long id){
		DetallesEmpleado detalle = detalleDAO.getDetalle(id);
		ModelAndView m = new ModelAndView("DetallesEmpleados/ModificarDetalles");
		m.addObject("detalle", detalle);
		
		return m;
		
	}
	
	@RequestMapping(path = "ModificarDetalles/{id}", method =RequestMethod.POST)
	public String modificarDetalles(@ModelAttribute("detalle") DetallesEmpleado detalle, @PathVariable Long id){
		detalle.setId(id);
		detalleDAO.modificarDetalle(detalle);
		return "redirect:/DetallesEmpleado/Detalles/{id}";
	}
}
