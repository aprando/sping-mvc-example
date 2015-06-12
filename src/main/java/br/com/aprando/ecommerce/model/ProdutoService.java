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
public class ProdutoService {

	@PersistenceContext(name = "ecommerce-pu")
	EntityManager entityManager;

	public void salvar(final Produto produto) {
		if(produto.getId() == null || produto.getId().intValue() == 0)
			entityManager.persist(produto);
		else
			entityManager.merge(produto);
	}

	public Produto consultarPorPK(int pk) throws Exception {
		Query q = entityManager.createQuery("select p from Produto p where p.id = " + pk);
		return (Produto)q.getSingleResult();
	}
	
	public void remover(final int id) {
		Query q = entityManager.createQuery("select p from Produto p where p.id = " + id);
		Produto p = (Produto)q.getSingleResult();		
		entityManager.remove(p);
	}	
	
	@SuppressWarnings("unchecked")
	public List<Produto> listarTodos() {
		Query q = entityManager.createQuery("select p from Produto p");
		return q.getResultList();
	}
}
