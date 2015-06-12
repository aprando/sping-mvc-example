package br.com.aprando.ecommerce.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.aprando.ecommerce.domain.Produto;

@Transactional
@Service
public class VitrineService {

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
	
}
