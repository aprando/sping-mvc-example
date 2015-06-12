package br.com.aprando.ecommerce.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.aprando.ecommerce.model.CategoriaService;
import br.com.aprando.ecommerce.model.VitrineService;

@Controller
@RequestMapping("/vitrine")
public class VitrineController {

	@Autowired
	VitrineService vitrineService;

	@Autowired
	CategoriaService categoriaService;

	@RequestMapping(value = "/categoria", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		try {
			Long idCategoria = Long.parseLong(request.getParameter("id"));
			request.setAttribute("vitrine",
					vitrineService.listarProdutosPorCategoria(idCategoria));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e.getMessage());
			return "erro";
		}

		return "home";
	}
}
