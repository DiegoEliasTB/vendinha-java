package br.com.diego.archetypes.vendinha;

import java.math.BigDecimal;

import br.com.diego.vendinha.domain.Cliente;
import br.com.diego.vendinha.domain.Compra;
import br.com.diego.vendinha.domain.Produto;
import br.com.diego.vendinha.domain.ItemCompra;

public class App {

    public static void main(String[] args) {
        
        Produto p1 = new Produto("cenoura", BigDecimal.valueOf(0.5));
        //Produto p2 = new Produto("beterraba", BigDecimal.valueOf(0.6));
       
        Cliente c = new Cliente("Carlos");
        
        Compra compra = c.comprar(p1, 5);
        
        //compra.addProduto(p2, 2);
        
              
        System.out.println("Cliente....: " + compra.getCliente().getId() + " - " + compra.getCliente().getNome());
        
        System.out.println("\nStatus.....: " + compra.getStatusPagamento());
        System.out.println("Comprado...: " + compra.getDataCompra());
    	for (ItemCompra i : compra.getItens()) {
    		System.out.println("");
    		System.out.println("Produto....: " + i.getProduto().getNome());
    		System.out.println("Qtd........: " + i.getQtd());
    		System.out.println("Valor UN...: " + i.getProduto().getValor());
    		System.out.println("Total......: " + i.getTotal());
		}
    	System.out.println("\nTotal G....: " + compra.getTotal());
    	System.out.println("\nTroco......: " + compra.pagar(BigDecimal.valueOf(100,00)));    	   	
    	
    }
}
