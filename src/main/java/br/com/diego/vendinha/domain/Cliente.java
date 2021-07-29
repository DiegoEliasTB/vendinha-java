package br.com.diego.vendinha.domain;

import java.util.SplittableRandom;

public class Cliente {
	
	private String nome;
	private Long id;
	
	public Cliente(String nome) {
		this.id = new SplittableRandom().nextLong(1, Long.MAX_VALUE);
		this.nome = nome;
	}
	
	public Compra comprar(Produto p, Integer qtd) {
		return new Compra(this, p, qtd);
	}
	
	public String getNome() {
		return nome;
	}
	
	public Long getId() {
		return id;
	}

}
