package com.ifpb.atividade2.factory;

import com.ifpb.atividade2.dao.ClienteDAO;
import com.ifpb.atividade2.dao.PedidoDAO;
import java.sql.SQLException;

public interface DaoFactoryIF {

    
 public ClienteDAO criaClienteDAO() throws SQLException, ClassNotFoundException;
 
 public PedidoDAO criaPedidoDAO() throws SQLException, ClassNotFoundException;
}
