package com.ifpb.atividade2.command;

import com.ifpb.atividade2.controle.GerenciadorPedido;
import com.ifpb.atividade2.modelo.Pedido;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarPedidos implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            GerenciadorPedido g = new GerenciadorPedido();

            PrintWriter out = response.getWriter();

            List<Pedido> pedidos = g.listarPedidos();

            out.print("<center><h1>Lista de Pedidos</h1>");
            out.print("<table border=1><tr><td>ID</td><td>Valor</td><td>Cliente"
                    + "</td><td>Data</td></tr>");

            for (Pedido p : pedidos) {
                out.print("<tr><td>" + p.getId() + "</td>");
                out.print("<td>" + p.getValor() + "</td>");
                out.print("<td>" + p.getCliente() + "</td>");
                out.print("<td>" + p.getData() + "</td></tr>");
            }
            
            out.print("</table>");

        } catch (SQLException ex) {
            Logger.getLogger(ListarPedidos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListarPedidos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ListarPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
