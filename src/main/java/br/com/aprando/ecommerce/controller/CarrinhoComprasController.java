package br.com.aprando.ecommerce.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.aprando.ecommerce.domain.CarrinhoCompras;
import br.com.aprando.ecommerce.domain.Item;
import br.com.aprando.ecommerce.model.CarrinhoComprasService;
import br.com.aprando.ecommerce.model.ProdutoService;

@Controller
@RequestMapping("/carrinho-compras")
public class CarrinhoComprasController {

	@Autowired
	ProdutoService produtoService;

	@Autowired
	CarrinhoComprasService carrinhoService;
	
	public CarrinhoCompras getCarrinho(HttpServletRequest request) {
		CarrinhoCompras carrinho = (CarrinhoCompras) request.getSession()
				.getAttribute("CARRINHO");
		if (carrinho == null) {
			carrinho = new CarrinhoCompras();
			request.getSession().setAttribute("CARRINHO", carrinho);
		}

		return carrinho;
	}

	public void setCarrinho(HttpServletRequest request, CarrinhoCompras carrinho) {
		request.getSession().setAttribute("CARRINHO", carrinho);
	}

	@RequestMapping(value = "/adicionar-item", method = RequestMethod.GET)
	public String adicionar(Integer id, Integer quantidade,
			HttpServletRequest request) {
		try {
			CarrinhoCompras carrinho = getCarrinho(request);
			Item i = carrinho.getItems().get(id);
			if (i == null) {
				i = new Item();
				i.setProduto(produtoService.consultarPorPK(id));
			}
			i.setQuantidade(i.getQuantidade() + quantidade);
			carrinho.getItems().put(id, i);

			request.setAttribute("carrinho", carrinho);

			setCarrinho(request, carrinho);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e.getMessage());
			return "erro";
		}

		return "carrinhoCompras";
	}

	@RequestMapping(value = "/remover-item", method = RequestMethod.GET)
	public String remover(Integer id, Integer quantidade,
			HttpServletRequest request) {
		try {
			CarrinhoCompras carrinho = getCarrinho(request);
			Item i = carrinho.getItems().get(id);
			if (i != null) {
				i.setQuantidade(i.getQuantidade() - quantidade);
				if (i.getQuantidade() == 0)
					carrinho.getItems().remove(id);
			}
			request.setAttribute("carrinho", carrinho);
			setCarrinho(request, carrinho);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e.getMessage());
			return "erro";
		}

		return "carrinhoCompras";
	}

	@RequestMapping(value = "/finalizar-compra", method = RequestMethod.GET)
	public String finalizar(HttpServletRequest request) {
		CarrinhoCompras carrinho = getCarrinho(request);
		for(Item i: carrinho.getItems().values())
			carrinho.setTotal(carrinho.getTotal() + (i.getQuantidade() * i.getProduto().getPreco()));
		
		carrinhoService.finalizarPedido(carrinho);
		
		request.getSession().removeAttribute("CARRINHO");
		request.setAttribute("mensagem", "Pedido finalizado com sucesso!");
		return "forward:/home/";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		request.setAttribute("carrinho", getCarrinho(request));
		return "carrinhoCompras";
	}
}
