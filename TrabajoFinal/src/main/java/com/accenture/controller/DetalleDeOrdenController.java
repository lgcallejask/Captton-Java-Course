package com.accenture.controller;

import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.data.OrdenDeTrabajoDAO;
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
	
	@Autowired
	OrdenDeTrabajoDAO ordenDAO;

	@RequestMapping("/ListaDetalles/{id}")
	public ModelAndView ListarOrdenes(@PathVariable Long id){
		ModelAndView m = new ModelAndView("DetallesDeOrden/ListaDetalles");
		List<OrdenDeTrabajo_Repuesto> lista = detalleDAO.listar(id);
		OrdenDeTrabajo orden = ordenDAO.getOrdenDeTrabajo(id);
		m.addObject("listaDetalles", lista);
		m.addObject("listaDetalles", lista);
		m.addObject("orden",orden);
		return m;
	}

	@RequestMapping(path="/NuevoDetalle/{id}")
	public ModelAndView insertarDetalle(@PathVariable Long id){
		OrdenDeTrabajo_Repuesto detalle = new OrdenDeTrabajo_Repuesto();
		detalle.setOrden(ordenDAO.getOrdenDeTrabajo(id));
		List<Repuesto> repuestos = repuestoDAO.listar();
		ModelAndView m = new ModelAndView("DetallesDeOrden/InsertarDetalle");
		m.addObject("detalle", detalle);
		m.addObject("repuestos",repuestos);
		return m;
	}

	@RequestMapping(path="/NuevoDetalle", method=RequestMethod.POST)
	public String insertarDetalle(@ModelAttribute("detalle") OrdenDeTrabajo_Repuesto detalle){
		try{
			Repuesto repuesto = repuestoDAO.getRepuesto(detalle.getRepuesto().getId());
			detalle.setCosto(repuesto.getPrecio()*detalle.getCantidadUsadaDeRepuesto());
			detalleDAO.insertarDetalle(detalle);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "El repuesto ya se encuentra cargado.", "Error", JOptionPane.ERROR_MESSAGE);
			return "redirect:/DetalleDeOrden/ListaDetalles/"+detalle.getOrden().getId();
		}
		OrdenDeTrabajo orden = ordenDAO.getOrdenDeTrabajo(detalle.getOrden().getId());
		orden.setCosto(orden.getCosto()+detalle.getCosto());
		ordenDAO.modificarOrdenDeTrabajo(orden);
		return "redirect:/DetalleDeOrden/ListaDetalles/"+detalle.getOrden().getId();
	}
	
	@RequestMapping("/BorrarDetalle/{idOrden}/{idRepuesto}")
	public String borrarOrden(@PathVariable Long idOrden, @PathVariable Long idRepuesto){
		OrdenDeTrabajo_Repuesto detalle = detalleDAO.getDetalle(idOrden, idRepuesto);
		OrdenDeTrabajo orden = ordenDAO.getOrdenDeTrabajo(idOrden);
		orden.setCosto(orden.getCosto()-detalle.getCosto());
		ordenDAO.modificarOrdenDeTrabajo(orden);
		detalleDAO.eliminarDetalle(detalle);
		return "redirect:/DetalleDeOrden/ListaDetalles/{idOrden}";
	}

	@RequestMapping("/ModificarDetalle/{idOrden}/{idRepuesto}")
	public ModelAndView modificarDetalle(@PathVariable Long idOrden, @PathVariable Long idRepuesto){
		OrdenDeTrabajo_Repuesto detalle = detalleDAO.getDetalle(idOrden, idRepuesto);
		ModelAndView m = new ModelAndView("DetallesDeOrden/ModificarDetalle");
		m.addObject("detalle",detalle);
		return m;

	}

	@RequestMapping(path = "/ModificarDetalle/{idOrden}/{idRepuesto}", method =RequestMethod.POST)
	public String modificarOrden(@ModelAttribute("detalle") OrdenDeTrabajo_Repuesto detalle, @PathVariable Long idOrden, @PathVariable Long idRepuesto){
		detalle.getOrden().setId(idOrden);
		detalle.getRepuesto().setId(idRepuesto);
		Repuesto repuesto = repuestoDAO.getRepuesto(detalle.getRepuesto().getId());
		detalle.setCosto(repuesto.getPrecio()*detalle.getCantidadUsadaDeRepuesto());
		OrdenDeTrabajo_Repuesto antiguoDetalle = detalleDAO.getDetalle(idOrden, idRepuesto);
		OrdenDeTrabajo orden = ordenDAO.getOrdenDeTrabajo(idOrden);
		orden.setCosto(orden.getCosto()+detalle.getCosto()- antiguoDetalle.getCosto());
		ordenDAO.modificarOrdenDeTrabajo(orden);
		detalleDAO.modificarDetalle(detalle);
		return "redirect:/DetalleDeOrden/ListaDetalles/{idOrden}";
	}

}
