package com.ifpb.atividade2.controle;

import com.ifpb.atividade2.dao.ClienteDAO;
import com.ifpb.atividade2.factory.DaoFactory;
import com.ifpb.atividade2.factory.DaoFactoryIF;
import com.ifpb.atividade2.modelo.Cliente;
import java.sql.SQLException;
import java.util.List;

public class GerenciadorCliente {


    private DaoFactoryIF fabrica = null;
    private ClienteDAO dao;
    
    public GerenciadorCliente() throws SQLException, ClassNotFoundException{
        fabrica = DaoFactory.createFactory();
        dao = fabrica.criaClienteDAO();
    }
    
    public boolean incluirCliente(String nome, String documento, boolean ativo, float saldo) throws SQLException{
        
        Cliente c = new Cliente(nome,documento,ativo,saldo);
        return dao.incluir(c);
    }
    
    public List<Cliente> listarClientes() throws SQLException{
        
        List<Cliente> lista = dao.listar();
        return lista;
    }
}
