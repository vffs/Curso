
package com.vffs.persistencia;

import exception.SqlException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author valeria
 */
public class ConnectionFactory {
    private static ConnectionFactory instancia;
    
    private ConnectionFactory(){        
    }
    
    public static ConnectionFactory getInstance(){
        if(instancia == null){
            instancia  = new ConnectionFactory();
        }
        return instancia;
    }   
    
    public Connection getConnection() {
       
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "root");
        } catch (SQLException ex) {
            System.out.println("Código erro" + ex.getErrorCode());
            System.out.println(ex.getMessage());
            throw new SqlException(ex);
        }
        
    } 
}
