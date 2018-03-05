package com.ifpb.atividade2.controle;

import com.ifpb.atividade2.dao.PedidoDAO;
import com.ifpb.atividade2.factory.DaoFactory;
import com.ifpb.atividade2.factory.DaoFactoryIF;
import com.ifpb.atividade2.modelo.Pedido;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class GerenciadorPedido {

    private DaoFactoryIF fabrica = null;
    private PedidoDAO dao;

    public GerenciadorPedido() throws SQLException, ClassNotFoundException {

        fabrica = DaoFactory.createFactory();
        dao = fabrica.criaPedidoDAO();
    }

    public boolean incluirPedido(int cliente, float valor) throws SQLException {
        
        Pedido p = new Pedido();
        p.setCliente(cliente);
        p.setData(LocalDate.now());
        p.setValor(valor);
        
        return dao.incluir(p);
    }
    
    public List<Pedido> listarPedidos() throws SQLException{
        
        return dao.listar();
    }
}
