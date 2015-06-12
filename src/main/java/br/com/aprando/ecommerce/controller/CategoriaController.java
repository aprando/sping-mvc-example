package br.com.aprando.ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.aprando.ecommerce.domain.Categoria;
import br.com.aprando.ecommerce.model.CategoriaService;

@Controller
@RequestMapping("admin/categorias")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listar(HttpServletRequest request) {
		try {
			List<Categoria> categorias = categoriaService.listarTodos();
			request.setAttribute("categorias", categorias);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e.getMessage());
			return "erro";
		}
		return "admin/categorias/lista";
	}

	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public String novo(HttpServletRequest request) {
		request.setAttribute("cat", new Categoria());
		return "admin/categorias/detalhe";
	}

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public String editar(Categoria formBean, HttpServletRequest request) {
		try {
			Categoria p = categoriaService.consultarPorPK(formBean.getId());
			request.setAttribute("cat", p);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e.getMessage());
			return "erro";
		}
		return "admin/categorias/detalhe";
	}

	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(@Valid Categoria formBean, RedirectAttributes redirectAttrs) {
		try {
			categoriaService.salvar(formBean);
			redirectAttrs.addFlashAttribute("message", "Categoria id " + formBean.getId() + " salvo com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttrs.addFlashAttribute("erro", e.getMessage());
			return "erro";
		}
		return "redirect:/admin/categorias/";
	}

	
	@RequestMapping(value = "/remover", method = RequestMethod.GET)
	public String remover(Categoria formBean, RedirectAttributes redirectAttrs) {
		try {
			categoriaService.remover(formBean.getId());
			redirectAttrs.addFlashAttribute("message", "Categoria id " + formBean.getId() + " removido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttrs.addFlashAttribute("erro", e.getMessage());
			return "erro";
		}		
		return "redirect:/admin/categorias/";
	}	

}
