package com.ifpb.atividade2.dao;

import com.ifpb.atividade2.factory.ConFactory;
import com.ifpb.atividade2.modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private Connection con;

    public ClienteDAO() throws ClassNotFoundException, SQLException {
        ConFactory factory = new ConFactory();
        con = factory.getConnection();
    }

    public boolean incluir(Cliente c) throws SQLException {

        String sql = "INSERT INTO CLIENTE (Nome,documento,saldo,ativo) VALUES (?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, c.getNome());
        stmt.setString(2, c.getDocumento());
        stmt.setFloat(3, c.getSaldo());
        stmt.setBoolean(4, c.isAtivo());
        stmt.execute();
        return true;
    }

    public List<Cliente> listar() throws SQLException {

        String sql = "SELECT * FROM CLIENTE";

        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet result = stmt.executeQuery();
        
        List<Cliente> lista = new ArrayList<>();
        
        while(result.next()){
            Cliente c = new Cliente();
            c.setAtivo(result.getBoolean("ativo"));
            c.setDocumento(result.getString("documento"));
            c.setId(result.getInt("id"));
            c.setNome(result.getString("nome"));
            c.setSaldo(result.getFloat("saldo"));
            lista.add(c);
        }
        
        return lista;
    }
}
