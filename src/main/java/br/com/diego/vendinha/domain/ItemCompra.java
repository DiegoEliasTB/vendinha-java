package br.com.diego.vendinha.domain;

import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;

public class ItemCompra {
	
	private Produto produto;
	private Integer qtd;
	private BigDecimal valorUnit;
	
	
	private Long id;	
	
	public ItemCompra(Compra c) {
		
	}

	public Produto getProduto() {
		return produto;
	}
	
	public Integer getQtd() {
		return qtd;
	}

	public BigDecimal getValorUnit() {
		return valorUnit;
	}
}
