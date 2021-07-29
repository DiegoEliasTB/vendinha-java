package br.com.diego.vendinha.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.SplittableRandom;

public class Compra {	
	
	private EnumStatusPagamento statusPagamento;
	private Long id;	
	private BigDecimal valorPago;
	private Cliente cliente;
	private List<ItemCompra> itens;
	private LocalDateTime dataCompra, dataPagamento, dataCancelamento;
	
	public Compra(Cliente c, Produto p, Integer qtd) {
		this.itens = new ArrayList<>();
		this.id = new SplittableRandom().nextLong(1, Long.MAX_VALUE);
		this.cliente = c;
		this.dataCompra = LocalDateTime.now();
		this.statusPagamento = EnumStatusPagamento.AGUARDANDO;
		this.addProduto(p, qtd);
	}

	public void addProduto(Produto p, Integer qtd) {
		this.itens.add(new ItemCompra(p, qtd));
	}
	
	public BigDecimal pagar(BigDecimal valor) {
		
		if(statusPagamento.equals(EnumStatusPagamento.PAGO)) {
			throw new RuntimeException("Pagamento já realizado!");
		}
		
		if(Objects.isNull(valor)) {
			throw new RuntimeException("Dinheiro inválido!");
		}
		
		if(valor.compareTo(this.getTotal()) < 0) {
			throw new RuntimeException("Dinheiro insuficiente!");
		}
		
		if(statusPagamento.equals(EnumStatusPagamento.CANCELADO)) {
			this.dataCancelamento = null;
		}
		
		this.statusPagamento = EnumStatusPagamento.PAGO;
		this.dataPagamento = LocalDateTime.now();
		this.valorPago = valor;
		
		return getTotal().subtract(valor);
		
		
		//Validar o valor
	}
	
	public void cancelaPagamento() { //Cancela
		this.statusPagamento = EnumStatusPagamento.CANCELADO;
		this.dataPagamento = LocalDateTime.now();
		
		if(this.statusPagamento == EnumStatusPagamento.PAGO) {
			getTotal().add(valorPago);
		}
		//Calcular estorno - ok
	}
	
	public EnumStatusPagamento getStatusPagamento() {
		return statusPagamento;
	}
	
	public LocalDateTime getDataCompra() {
		return dataCompra;
	}
	
	public LocalDateTime getDataPagamento() {
		dataPagamento = LocalDateTime.now();
		return dataPagamento;
	}
	
	public LocalDateTime getDataCancelamento() {
		dataCancelamento = LocalDateTime.now();
		return dataCancelamento;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public Long getId() {
		return id;
	}

	public List<ItemCompra> getItens() {
		return itens;
	}
	
	public BigDecimal getTotal() {
		BigDecimal soma = BigDecimal.ZERO;
		for (ItemCompra i : itens) {
			soma = soma.add(i.getTotal());
		}
		return soma;
	}
}
