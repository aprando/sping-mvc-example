package br.com.aprando.ecommerce.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.aprando.ecommerce.domain.Produto;
import br.com.aprando.ecommerce.model.ProdutoService;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	ProdutoService produtoService;

	@RequestMapping(value = "/detalhe", method = RequestMethod.GET)
	public String detalhar(Integer id, HttpServletRequest request) {
		try {
			Produto produto = produtoService.consultarPorPK(id);
			request.setAttribute("item", produto);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e.getMessage());
			return "erro";
		}
		return "itemDetalhe";
	}

}
