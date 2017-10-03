package Principal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**********************************************************************************************
 * Trabalho de Laboratório de Programação III - 2017.3          Data de entrega:03/10/2017    *
 *                                                                                            *
 * Última atualização:   Data:01/10/2017                        Hora: 15:53                   *
 *                                                                                            *
 * Aluno: Lucas Diniz da Costa         Matrícula:201465524A     Curso: Ciências Exatas        *
 * Tema: Desenvolver um sistema de controle de pedidos de um (bar/lanchonete/restaurante)     *
 * caracteristicas do sistema:                                                                *
 * -> Clientes devem poder realizar seus pedidos a partir de uma interface;                   *
 * -> O sistema deve captar a hora e data de inicio do pedido e de finalização do pedido      *
 * -> O sistema deve fornecer a gerencia um relatório dos pedidos exibindo o que foi pedido   *
 * e os horarios do mesmo;                                                                    *
 * -> O sistema deve permitir a administração do sistema cadastrar produtos em seu estoque    *
 * de modo que o cliente possa utilizar esses produtos cadastrados para fazer seu pedido      *
 * -> O sistema não precisa apresentar persistencia de dados, portanto é possivel ser inserido*
 * os dados de forma manual fora da interface.                                                *
 **********************************************************************************************/

public class Main {
    public static void main(String[] args) {
        
        /*******************************************************************************
         * Dados de teste                                                              *
         * Os dados não exibirão as datas pois elas são inicilizadas no cadastrarPedido*
         *******************************************************************************/
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Coca Cola 600ml", BigDecimal.valueOf(2.80)));
        produtos.add(new Produto("XTudo", BigDecimal.valueOf(10.90)));
        produtos.add(new Produto("X-Bacon", BigDecimal.valueOf(12.60)));
        List<Pedido> pedidos = new ArrayList<>();
        Pedido pedido = new Pedido();
        pedido.adicionarProduto(produtos.get(0));
        pedido.adicionarProduto(produtos.get(0));
        pedido.adicionarProduto(produtos.get(0));
        pedido.adicionarProduto(produtos.get(0));
        pedido.adicionarProduto(produtos.get(1));
        pedido.adicionarProduto(produtos.get(1));
        pedido.adicionarProduto(produtos.get(2));
        pedido.setNumeroMesa(1);
        pedido.setNumeroPedido(1);
        Calendario calInicio = new Calendario(20,8,2017,15,35,50);
        Calendario calFim = new Calendario(20,8,2017,19,27,59);
        pedido.setCalendarioInicial(calInicio);
        pedido.setCalendarioFinal(calFim);
        pedidos.add(pedido);

        Pedido pedido2 = new Pedido();
        pedido2.adicionarProduto(produtos.get(0));
        pedido2.adicionarProduto(produtos.get(0));
        pedido2.adicionarProduto(produtos.get(1));
        pedido2.adicionarProduto(produtos.get(1));
        pedido2.adicionarProduto(produtos.get(2));
        pedido2.adicionarProduto(produtos.get(2));
        pedido2.adicionarProduto(produtos.get(2));
        pedido2.adicionarProduto(produtos.get(2));
        pedido2.adicionarProduto(produtos.get(2));
        pedido2.setNumeroMesa(150);
        pedido2.setNumeroPedido(2);
        pedido2.setCalendarioInicial(calInicio);
        pedido2.setCalendarioFinal(calFim);
        pedidos.add(pedido2);
        
        CaixaDiario caixaDiario = new CaixaDiario();
        caixaDiario.setCalendario(new Calendario(20, 8, 2017));
        caixaDiario.setControleCaixa(pedidos);
        
        FluxoCaixa fluxoCaixa = new FluxoCaixa();
        fluxoCaixa.getCaixa().add(caixaDiario);
        
        
        MenuPrincipal mp = new MenuPrincipal(produtos, fluxoCaixa);
        mp.setSize(350,380);
        mp.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mp.setResizable(false);
        mp.setLocationRelativeTo(null);
        mp.setVisible(true);
    }
}
