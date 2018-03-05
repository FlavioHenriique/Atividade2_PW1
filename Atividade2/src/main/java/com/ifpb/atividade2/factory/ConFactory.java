package com.ifpb.atividade2.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConFactory {

    private String url = "jdbc:postgresql://127.0.0.1:5432/atividade2_pw1";
    private String user = "postgres";
    private String password = "flavio22";

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, user, password);
    }
}
