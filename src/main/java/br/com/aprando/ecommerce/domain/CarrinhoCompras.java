package br.com.aprando.ecommerce.domain;

import java.util.HashMap;

public class CarrinhoCompras {

	private Double total = 0.0;

	private HashMap<Integer, Item> items = new HashMap<Integer, Item>();

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public HashMap<Integer, Item> getItems() {
		return items;
	}

	public void setItems(HashMap<Integer, Item> items) {
		this.items = items;
	}

}
