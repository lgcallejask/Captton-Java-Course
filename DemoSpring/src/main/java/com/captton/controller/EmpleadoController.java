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
@RequestMapping("Empleado/")
public class EmpleadoController 
{
	@Autowired
	EmpleadoDAO empleadoDAO;
	
	@Autowired
	DepartamentoDAO departamentoDAO;
	
	@RequestMapping("Lista")
	public ModelAndView listarEmpleado()
	{
		ModelAndView m = new ModelAndView("Empleados/ListaEmpleados");
		List<Empleado> lista = empleadoDAO.listar();
		m.addObject("listaEmp", lista);
		return m;
		
	}
	
	@RequestMapping("Borrar/{id}")
	public String borrarEmpleado(@PathVariable Long id)
	{
		Empleado emple = empleadoDAO.getEmpleado(id);
		empleadoDAO.borrarEmpleado(emple);
		return "redirect:/Empleado/Lista";		
	}
	
	//Es el metodo GET
	@RequestMapping(path="Nuevo")
	public ModelAndView insertarEmpleado()
	{
		ModelAndView m = new ModelAndView("Empleados/Insertar");
		m.addObject("empleado", new Empleado());
		m.addObject("departamentos", departamentoDAO.listar() );
		return m;
	}
	
	
	@RequestMapping(path="Nuevo", method=RequestMethod.POST)
	public String insertarEmpleado(@ModelAttribute("empleado") Empleado e )
	{
		empleadoDAO.insertarEmpleado(e);
		return "redirect:/Empleado/Lista";
	}
}

