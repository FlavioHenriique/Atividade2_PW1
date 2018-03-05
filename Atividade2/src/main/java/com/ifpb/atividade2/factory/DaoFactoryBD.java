package com.ifpb.atividade2.factory;

import com.ifpb.atividade2.dao.ClienteDAO;
import java.sql.SQLException;

public class DaoFactoryBD  implements DaoFactoryIF{
    
    public DaoFactoryBD(){
    
    }

    @Override
    public ClienteDAO criaClienteDAO() throws SQLException, ClassNotFoundException {
        return new ClienteDAO(); 
    }
    
        
}
