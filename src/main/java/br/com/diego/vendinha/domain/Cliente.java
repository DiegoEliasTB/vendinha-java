package br.com.diego.vendinha.domain;

public class Cliente {
	
	private String nome;
	
	public Cliente(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Compra comprar(Produto p, Integer qtd) {
		return new Compra(this, p, qtd);
	}
}
