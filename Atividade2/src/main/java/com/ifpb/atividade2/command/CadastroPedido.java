package com.ifpb.atividade2.command;

import com.ifpb.atividade2.controle.GerenciadorPedido;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroPedido implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            GerenciadorPedido g = new GerenciadorPedido();
            PrintWriter out = response.getWriter();

            if (g.incluirPedido(Integer.parseInt(request.getParameter("cliente")),
                    Float.parseFloat(request.getParameter("valor")))) {

                out.print("Pedido cadastrado!");
            } else {
                out.print("Nao foi possivel cadastrar o pedido");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroPedido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroPedido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CadastroPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
