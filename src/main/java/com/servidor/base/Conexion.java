/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servidor.base;

/**
 *
 * @author camm
 */
import java.sql.*;

public class Conexion {
	 private Connection conexion;
	 public Conexion() {
        conexion = null;
        try {
            Class.forName("org.postgresql.Driver");
			String dbUrl = System.getenv("DATABASE_URL");
			// "jdbc:postgresql://localhost:5432/sample?user=camm&password=1234"
            conexion = DriverManager.getConnection(dbUrl);
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.print("Error " + ex);
        }
    }

    public Connection getConexion(){ return conexion; }
}
