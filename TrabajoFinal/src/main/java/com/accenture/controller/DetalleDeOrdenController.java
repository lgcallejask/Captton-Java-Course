package com.accenture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.data.OrdenDeTrabajo_RepuestoDAO;
import com.accenture.data.RepuestoDAO;
import com.accenture.model.OrdenDeTrabajo;
import com.accenture.model.OrdenDeTrabajo_Repuesto;
import com.accenture.model.Repuesto;


@Controller
@RequestMapping("DetalleDeOrden")
public class DetalleDeOrdenController {

	@Autowired
	OrdenDeTrabajo_RepuestoDAO detalleDAO;
	
	@Autowired
	RepuestoDAO repuestoDAO;

	@RequestMapping("/ListaDetalles/{id}")
	public ModelAndView ListarOrdenes(@PathVariable Long id){
		ModelAndView m = new ModelAndView("DetallesDeOrden/ListaDetalles");
		List<OrdenDeTrabajo_Repuesto> lista = detalleDAO.listar(id);
		m.addObject("listaDetalles", lista);
		return m;
	}

	@RequestMapping(path="NuevoDetalle")
	public ModelAndView insertarDetalle(){
		OrdenDeTrabajo_Repuesto detalle = new OrdenDeTrabajo_Repuesto();
		List<Repuesto> repuestos = repuestoDAO.listar();
		ModelAndView m = new ModelAndView("DetallesDeOrden/InsertarDetalle");
		m.addObject("detalle", detalle);
		m.addObject("repuestos",repuestos);
		return m;
	}

	@RequestMapping(path="NuevoDetalle", method=RequestMethod.POST)
	public String insertarDetalle(@ModelAttribute("detalle") OrdenDeTrabajo_Repuesto detalle){
		detalleDAO.insertarDetalle(detalle);
		return "redirect:/OrdenDeTrabajo/ListaOrdenes";
	}
	
	@RequestMapping("/BorrarDetalle/{idOrden}/{idRepuesto}")
	public String borrarOrden(@PathVariable Long idOrden, @PathVariable Long idRepuesto){
		OrdenDeTrabajo_Repuesto detalle = detalleDAO.getDetalle(idOrden, idRepuesto);
		detalleDAO.eliminarDetalle(detalle);
		return "redirect:/DetalleDeOrden/ListaDetalles/{idOrden}";
	}

	@RequestMapping("/ModificarDetalle/{idOrden}/{idRepuesto}")
	public ModelAndView modificarDetalle(@PathVariable Long idOrden, @PathVariable Long idRepuesto){
		OrdenDeTrabajo_Repuesto detalle = detalleDAO.getDetalle(idOrden, idRepuesto);
		ModelAndView m = new ModelAndView("DetallesDeOrden/ModificarDetalle/");
		m.addObject("detalle",detalle);
		return m;

	}

	@RequestMapping(path = "/ModificarDetalle/{idOrden}/{idRepuesto}", method =RequestMethod.POST)
	public String modificarOrden(@ModelAttribute("detalle") OrdenDeTrabajo_Repuesto detalle, @PathVariable Long idOrden, @PathVariable Long idRepuesto){
		detalle.getOrden().setId(idOrden);
		detalle.getRepuesto().setId(idRepuesto);
		detalleDAO.modificarDetalle(detalle);
		return "redirect:/OrdenDeTrabajo/NuevaOrden";
	}

}
