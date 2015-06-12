package br.com.aprando.ecommerce.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.aprando.ecommerce.domain.CarrinhoCompras;
import br.com.aprando.ecommerce.domain.Item;
import br.com.aprando.ecommerce.domain.ItemPedido;
import br.com.aprando.ecommerce.domain.Pedido;
import br.com.aprando.ecommerce.domain.Produto;

@Transactional
@Service
public class CarrinhoComprasService {

	@PersistenceContext(name = "ecommerce-pu")
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Produto> listarProdutosPromocao() throws Exception {
		Query q = entityManager.createQuery("select p from Produto p ");
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listarProdutosPorCategoria(Long idCategoria) {
		Query q = entityManager.createQuery("select distinct p from Produto p join p.categorias c where c.id = " + idCategoria);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listarProdutosVitrine() {
		Query q = entityManager.createQuery("select p from Produto p").setMaxResults(9);
		return q.getResultList();
	}
	
	public Long finalizarPedido(CarrinhoCompras carrinho) {
		Pedido pedido = new Pedido();
		pedido.setTotal(carrinho.getTotal());
		
		//Salva pedido
		entityManager.persist(pedido);
		
		//Salva itens
		ItemPedido item = null;
		for(Item i : carrinho.getItems().values()){
			item = new ItemPedido();
			item.setIdPedido(pedido.getId());
			item.setIdProduto(i.getProduto().getId().longValue());
			item.setPreco(i.getProduto().getPreco());
			item.setQuantidade(new Long(i.getQuantidade()));
			
			entityManager.persist(item);
		}
		
		return pedido.getId();
	}	
	
}
