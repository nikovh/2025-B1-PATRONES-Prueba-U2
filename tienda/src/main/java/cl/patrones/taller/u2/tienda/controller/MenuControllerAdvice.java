package cl.patrones.taller.u2.tienda.controller;


import java.util.List;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import cl.patrones.taller.u2.tienda.menu.ItemMenu;

@ControllerAdvice
public class MenuControllerAdvice {


	@ModelAttribute("menu")
	public List<ItemMenu> menu() {
		// TODO: Actividad 1
		return List.of();
	}
	
}
