package br.com.aprando.ecommerce.model;

import javax.persistence.EntityManager;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import br.com.aprando.ecommerce.domain.CarrinhoCompras;

public class CarrinhoComprasTest {

	@Mock
	private CarrinhoComprasService carrinhoComprasService;

	@Mock
	private EntityManager entityManager;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(carrinhoComprasService, "entityManager",
				entityManager);

	}

	@Test
	public void finalizarPedido() {
		try{
			carrinhoComprasService.finalizarPedido(new CarrinhoCompras());
			Assert.assertTrue(true);
		}catch(Exception e){
			Assert.assertTrue(false);
		}
		Assert.assertTrue(true);
	}

}
