package br.com.diego.archetypes.vendinha;

import java.math.BigDecimal;
import java.util.Arrays;

import br.com.diego.vendinha.domain.Cliente;
import br.com.diego.vendinha.domain.Compra;
import br.com.diego.vendinha.domain.Produto;
import br.com.diego.vendinha.domain.ItemCompra;

public class App {

    public static void main(String[] args) {
        
        Produto p1 = new Produto("cenoura", BigDecimal.valueOf(0.5));
        Produto p2 = new Produto("beterraba", BigDecimal.valueOf(0.6));
       
        Cliente c = new Cliente("Carlos");
        
        Compra compra = c.comprar(p1, 5);
        
        //ItemCompra item = compra.(compra);
              
        
        System.out.println("Id compra.... " + compra.getId());
        System.out.println("Cliente...... " + compra.getCliente().getNome());
        System.out.println("Produto...... " + item.getProduto());
        //System.out.println("Produto...... " + compra.getProduto().getNome());
        //System.out.println("Quantidade... " + compra.getQtd());
        //System.out.println("Valor........ R$ " + compra.getValorUnit());
        System.out.println("Total........ R$ " + compra.getTotal());
        
    }
}
