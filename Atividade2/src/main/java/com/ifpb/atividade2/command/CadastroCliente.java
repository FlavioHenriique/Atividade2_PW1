package com.ifpb.atividade2.command;

import com.ifpb.atividade2.controle.GerenciadorCliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroCliente implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        try {

            PrintWriter out = response.getWriter();
            GerenciadorCliente gerenciador = new GerenciadorCliente();
            if (gerenciador.incluirCliente(request.getParameter("nome"), request.getParameter("documento"),
                    true, Float.parseFloat(request.getParameter("saldo")))) {

                out.print("Cliente cadastrado");
            } else {
                out.print("Não foi possível cadastrar o cliente");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
