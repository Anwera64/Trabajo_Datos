/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracleconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ALVAR
 */
public class Conexion {

    String user;
    String url;
    String password;

    public Conexion() {
        String serverName = "DESKTOP-52SBCRG";
        String serverPort = "1521";
        String sid = "XE";
        url = "jdbc:oracle:thin:@" + serverName + ":" + serverPort + ":" + sid;
        user = "alvaro"; //el usuario hemos creado en sql command line
        password = "sistemas";
    }
    
    public Connection Conectar() {
         Connection conn = null;
        try {
            String driverName = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Se ha conectado exitosamente a la base de datos");
        } catch (ClassNotFoundException e) {
            System.out.println("No se pudo enconrtar el driver de la base de datos" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos" + e.getMessage());
        }
        return conn;
    }
}
