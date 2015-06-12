package br.com.aprando.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.aprando.ecommerce.domain.Categoria;
import br.com.aprando.ecommerce.domain.Menu;
import br.com.aprando.ecommerce.model.CategoriaService;
import br.com.aprando.ecommerce.model.VitrineService;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	VitrineService vitrineService;

	@Autowired
	CategoriaService categoriaService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		try {
			List<Menu> menus = new ArrayList<Menu>();
			Menu menu = null;
			for(Categoria pai : categoriaService.listarCategoriaPai()){
				menu = new Menu(pai.getId(), pai.getNome());
				for(Categoria filha : categoriaService.listarPorIdCategoriaPai(pai.getId())){
					menu.getFilhos().add(new Menu(filha.getId(), filha.getNome()));
				}
				menus.add(menu);
			}
			
			//request.setAttribute("promocoes", vitrineService.listarProdutosPromocao());
			request.setAttribute("vitrine", vitrineService.listarProdutosVitrine());
			request.getSession().setAttribute("menu", menus);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e.getMessage());
			return "erro";
		}	
		
		return "home";
	}
}
