package br.com.aprando.ecommerce.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.aprando.ecommerce.domain.Categoria;

@Transactional
@Service
public class CategoriaService {

	@PersistenceContext(name = "ecommerce-pu")
	EntityManager entityManager;

	public void salvar(final Categoria categoria) {
		if (categoria.getId() == null || categoria.getId().intValue() == 0)
			entityManager.persist(categoria);
		else
			entityManager.merge(categoria);
	}

	public Categoria consultarPorPK(int pk) throws Exception {
		Query q = entityManager.createQuery("select p from Categoria p where p.id = " + pk);
		return (Categoria) q.getSingleResult();
	}

	public void remover(final int id) {
		Query q = entityManager.createQuery("select p from Categoria p where p.id = " + id);
		Categoria p = (Categoria) q.getSingleResult();
		entityManager.remove(p);
	}

	@SuppressWarnings("unchecked")
	public List<Categoria> listarTodos() {
		Query q = entityManager.createQuery("select p from Categoria p");
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> listarCategoriaPai() {
		Query q = entityManager.createQuery("select p from Categoria p where p.idCategoriaPai = null");
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> listarPorIdCategoriaPai(Integer idCategoriaPai) {
		Query q = entityManager.createQuery("select p from Categoria p where p.idCategoriaPai = " + idCategoriaPai);
		return q.getResultList();
	}	
	
}
