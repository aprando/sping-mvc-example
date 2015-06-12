package br.com.aprando.ecommerce.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.aprando.ecommerce.domain.Categoria;
import br.com.aprando.ecommerce.domain.Produto;
import br.com.aprando.ecommerce.model.CategoriaService;
import br.com.aprando.ecommerce.model.ProdutoService;

@Controller
@RequestMapping("admin/produtos")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;

	@Autowired
	CategoriaService categoriaService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Set.class, "categorias",
				new CustomCollectionEditor(Set.class) {
					@Override
					protected Object convertElement(Object element) {
						try {
							Long id = null;
	
							if (element instanceof String && !((String) element).equals("")) {
								try {
									id = Long.parseLong((String) element);
								} catch (NumberFormatException e) {
									System.out.println("Element was " + ((String) element));
									e.printStackTrace();
								}
							} else if (element instanceof Long) {
								id = (Long) element;
							}

							return id != null ? categoriaService.consultarPorPK(id.intValue()) : null;
						} catch (Exception e) {
							e.printStackTrace();
							return null;
						}
					}
				});
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listar(HttpServletRequest request) {
		try {
			List<Produto> produtos = produtoService.listarTodos();
			request.setAttribute("produtos", produtos);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e.getMessage());
			return "erro";
		}
		return "admin/produtos/lista";
	}

	@RequestMapping(value = "/detalhe", method = RequestMethod.GET)
	public String detalhe(HttpServletRequest request) {
		try {
			List<Produto> produtos = produtoService.listarTodos();
			request.setAttribute("produtos", produtos);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e.getMessage());
			return "erro";
		}
		return "admin/produtos/lista";
	}	
	
	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public String novo(HttpServletRequest request) {
		List<Categoria> categorias = categoriaService.listarTodos();

		request.setAttribute("prod", new Produto());
		request.setAttribute("listaCategorias", categorias);
		return "admin/produtos/detalhe";
	}

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public String editar(Produto formBean, HttpServletRequest request) {
		try {
			Produto produto = produtoService.consultarPorPK(formBean.getId());
			List<Categoria> categorias = categoriaService.listarTodos();

			request.setAttribute("prod", produto);
			request.setAttribute("listaCategorias", categorias);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e.getMessage());
			return "erro";
		}
		return "admin/produtos/detalhe";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Produto formBean, RedirectAttributes redirectAttrs) {
		try {
			produtoService.salvar(formBean);
			redirectAttrs.addFlashAttribute("message",
					"Usuairo id " + formBean.getId() + " salvo com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttrs.addFlashAttribute("erro", e.getMessage());
			return "erro";
		}
		return "redirect:/admin/produtos/";
	}

	@RequestMapping(value = "/remover", method = RequestMethod.GET)
	public String remover(Produto formBean, RedirectAttributes redirectAttrs) {
		try {
			produtoService.remover(formBean.getId());
			redirectAttrs
					.addFlashAttribute("message",
							"Usuairo id " + formBean.getId()
									+ " removido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttrs.addFlashAttribute("erro", e.getMessage());
			return "erro";
		}
		return "redirect:/admin/produtos/";
	}

}
