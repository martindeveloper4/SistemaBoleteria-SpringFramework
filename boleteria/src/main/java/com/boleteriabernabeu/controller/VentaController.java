package com.boleteriabernabeu.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boleteriabernabeu.entity.Compra;
import com.boleteriabernabeu.entity.Entrada;
import com.boleteriabernabeu.repository.ICompraRepository;
import com.boleteriabernabeu.service.IEntradaService;




@Controller
public class VentaController {
		
		private static final String VIEW_TABLE_ENTRADA="entrada";
		private static final String VIEW_TABLE_COMPRA="listar";
		
		
		@Autowired
		private IEntradaService entradaService;
		
		


		@RequestMapping(value="/listar",method=RequestMethod.GET )
		public ModelAndView listarCompras() {
			ModelAndView mav=new ModelAndView(VIEW_TABLE_ENTRADA);
			
			
			List<Entrada> entradas=entradaService.listaAllEntradas();
			
			mav.addObject("titulo", "Formulario de Entradas");
			mav.addObject("entradas", entradas);
			return mav;
		}
		
		@GetMapping("/form/{id}")
		public String crear(@PathVariable(value = "id") Long id, Map<String, Object> model,
				RedirectAttributes flash) {

			Entrada entrada = entradaService.getId(id);
			

			if (entrada == null) {
				flash.addFlashAttribute("error", "La entrada no existe en la base de datos");
				return "redirect:/listar";
			}

			Compra compra = new Compra();
			compra.setEntrada(entrada);
			
			model.put("compra", compra);
			model.put("titulo", "Crear Compra");

			return "form";
		}
		
		
		
		
		@PostMapping("/compra")
		public String guardar(@Valid Compra compra,
				@RequestParam(name = "entrada.id", required = false) Long  identrada,
				@RequestParam(name = "cantidad", required = false) int  cantidad) {
			
			entradaService.saveCompra(compra);
			entradaService.updateEntrada(identrada, cantidad);
			return "redirect:/listarcompras";
		}
		
		
		
		
		
		@RequestMapping(value="/listarcompras",method=RequestMethod.GET )
		public ModelAndView listar() {
			ModelAndView mav=new ModelAndView(VIEW_TABLE_COMPRA);
			
			
			List<Compra> compras=entradaService.listAllCompras();
			
			mav.addObject("titulo", "Lista de Compras");
			mav.addObject("compras", compras);
			return mav;
		}
		
		
		
		
		
		/*
		@RequestMapping(value="/form/{id}")
		public ModelAndView EditForm(@PathVariable(name="id") Long id) {
			ModelAndView mav=new ModelAndView(VIEW_TABLE);
			Entrada entrad=entradaService.getId(id);
			mav.addObject("entrad",entrad);
			return mav;
		}
		*/
		
		
		
		
		
		
		
		/*
		@RequestMapping(value="/form/{id}",method=RequestMethod.GET )
		public ModelAndView EditForm(@PathVariable(name="id") Long id) {
			ModelAndView mav=new ModelAndView(VIEW_FORM);
			Entrada entrada=entradaService.getId(id);
			mav.addObject("entrada",entrada);
			return mav;
		}*/
		
		
}
