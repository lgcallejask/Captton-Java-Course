package com.captton.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.captton.data.DepartamentoDAO;
import com.captton.data.EmpleadoDAO;
import com.captton.model.Empleado;

@Controller
@RequestMapping("Empleado")
public class EmpleadoController {
	
	@Autowired
	EmpleadoDAO empleadoDAO;
	
	@Autowired
	DepartamentoDAO departamentoDAO;
	
	@RequestMapping("/Lista")
	public ModelAndView ListarEmpleado(){
		ModelAndView m = new ModelAndView("Empleados/ListaEmpleados");
		List<Empleado> lista = empleadoDAO.listar();
		m.addObject("listaEmp", lista);
		return m;
	}
	
	@RequestMapping("/Borrar/{id}")
	public String borrarEmpleado(@PathVariable Long id){
		Empleado emple = empleadoDAO.getEmpleado(id);
		empleadoDAO.eliminarEmpleado(emple);
		return "redirect:/Empleado/Lista";
	}
	
	//Metodo get
	@RequestMapping(path="Nuevo", method=RequestMethod.GET)
	public ModelAndView insertarEmpleado(){
		ModelAndView m = new ModelAndView("Empleados/Insertar");
		m.addObject("emple", new Empleado());
		m.addObject("departamentos", departamentoDAO.listar());
		
		return m;
	}
	
	//Metodo post
	@RequestMapping(path="Viejo", method=RequestMethod.POST)
	public String insertarEmpleado(@ModelAttribute("emple") Empleado emple){
		empleadoDAO.insertarEmpleado(emple);
		return "redirect:/Empleado/Lista";
	}
	
	@RequestMapping("/Mostrar/{id}")
	public ModelAndView mostrarEmpleado(@PathVariable Long id){
		Empleado emple = empleadoDAO.getEmpleado(id);
		ModelAndView m = new ModelAndView("Empleados/ModificarEmpleado");
		m.addObject("emple", emple);
		m.addObject("departamentos", departamentoDAO.listar());
		
		return m;
		
	}
	
	@RequestMapping(path = "Modificar/{id}", method =RequestMethod.POST)
	public String modificarEmpleado(@ModelAttribute("emple") Empleado emple, @PathVariable Long id){
		emple.setId(id);
		empleadoDAO.modificarEmpleado(emple);
		return "redirect:/Empleado/Lista";
	}
}
