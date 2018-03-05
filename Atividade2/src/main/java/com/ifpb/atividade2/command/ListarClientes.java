package com.ifpb.atividade2.command;

import com.ifpb.atividade2.controle.GerenciadorCliente;
import com.ifpb.atividade2.modelo.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarClientes implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            GerenciadorCliente g = new GerenciadorCliente();
            PrintWriter out = response.getWriter();

            List<Cliente> clientes = g.listarClientes();

            out.print("<center><h1>Lista de Clientes</h1>");
            out.print("<table border=1><tr><td>ID</td><td>Nome</td><td>Documento</td><td>Ativo</td><td>Saldo</td></tr>");

            for (Cliente cliente : clientes) {

                out.print("<td>"+cliente.getId()+"</td>");
                out.print("<td>" + cliente.getNome() + "</td>");
                out.print("<td>" + cliente.getDocumento() + "</td>");
                out.print("<td>" + cliente.isAtivo() + "</td>");
                out.print("<td>" + cliente.getSaldo() + "</td>");
                
                out.print("</tr>");
            }
            out.print("</table></center>");
            

        } catch (SQLException ex) {
            Logger.getLogger(ListarClientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListarClientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ListarClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
