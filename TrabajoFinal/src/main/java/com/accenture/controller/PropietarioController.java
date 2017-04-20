package com.accenture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.data.PropietarioDAO;
import com.accenture.model.Propietario;


@Controller
@RequestMapping("Propietario")
public class PropietarioController {

	@Autowired
	PropietarioDAO propietarioDAO;

	
	@RequestMapping("/ListaPropietarios")
	public ModelAndView ListarPropietarios(){
		ModelAndView m = new ModelAndView("OrdenesDeTrabajo/ListaOrdenes");
		List<Propietario> lista = propietarioDAO.listar();
		m.addObject("listaPropietarios", lista);
		return m;
	}

	@RequestMapping(path="NuevoPropietario", method=RequestMethod.GET)
	public ModelAndView insertarOrden(){
		Propietario propietario = new Propietario();
		ModelAndView m = new ModelAndView("Propietarios/InsertarPropietario");
		m.addObject("propietario", propietario);
		return m;
	}

	@RequestMapping(path="NuevoPropietario", method=RequestMethod.POST)
	public String insertarOrden(@ModelAttribute("propietario") Propietario propietario){
		propietarioDAO.insertarPropietario(propietario);
		return "redirect:/OrdenDeTrabajo/NuevaOrden";
	}

	@RequestMapping("/ModificarPropietario/{id}")
	public ModelAndView modificarOrden(@PathVariable Long id){
		Propietario propietario = propietarioDAO.getPropietario(id);
		ModelAndView m = new ModelAndView("Propietarios/ModificarPropietario");
		m.addObject("propietario",propietario);
		return m;
		
	}
	
	@RequestMapping(path = "ModificarPropietario/{id}", method =RequestMethod.POST)
	public String modificarOrden(@ModelAttribute("propietario") Propietario propietario, @PathVariable Long id){
		propietario.setId(id);
		propietarioDAO.modificarPropietario(propietario);
		return "redirect:/OrdenDeTrabajo/NuevaOrden";
	}
	
}
