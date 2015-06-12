package br.com.aprando.ecommerce.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nome;

	private List<Menu> filhos = new ArrayList<Menu>();

	public List<Menu> getFilhos() {
		return filhos;
	}

	public Menu(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Menu() {
		super();
	}

	public void setFilhos(List<Menu> filhos) {
		this.filhos = filhos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
