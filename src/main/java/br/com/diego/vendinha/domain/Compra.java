package br.com.diego.vendinha.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

public class Compra {
	
	Random random = new Random();
	
	private Long id;	
	private Cliente cliente;
	private List<ItemCompra> itens;
	private BigDecimal total;
	
	public Compra(Cliente c, Produto p, Integer qtd) {
		this.cliente = c;
	}

	public Long getId() {
		return this.id = Math.abs(random.nextLong());
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public BigDecimal getTotal() {
		return total;
	}
}
