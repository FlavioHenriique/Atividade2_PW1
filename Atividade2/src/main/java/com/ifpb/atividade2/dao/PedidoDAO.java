package com.ifpb.atividade2.dao;

import com.ifpb.atividade2.factory.ConFactory;
import com.ifpb.atividade2.modelo.Pedido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

    private Connection con;

    public PedidoDAO() throws ClassNotFoundException, SQLException {

        ConFactory factory = new ConFactory();
        con = factory.getConnection();
    }

    public boolean incluir(Pedido p) throws SQLException {

        String sql = "INSERT INTO PEDIDO (data,cliente,valor) VALUES (?,?,?)";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setDate(1, Date.valueOf(LocalDate.now()));
        stmt.setInt(2, p.getCliente());
        stmt.setFloat(3, (float) p.getValor());

        stmt.execute();
        return true;
    }

    public List<Pedido> listar() throws SQLException {

        String sql = "SELECT * FROM PEDIDO";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet result = stmt.executeQuery();

        List<Pedido> lista = new ArrayList<>();

        while (result.next()) {

            Pedido p = new Pedido();
            p.setCliente(result.getInt("cliente"));
            p.setData(result.getDate("data").toLocalDate());
            p.setId(result.getInt("id"));
            p.setValor(result.getFloat("valor"));

            lista.add(p);
        }

        return lista;
    }
}
