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
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class Conexion {
	 private Connection conexion;
	 public Conexion() {
        conexion = null;
        try {
            Class.forName("org.postgresql.Driver");
			URI dbUri;
			try {
				dbUri = new URI(System.getenv("DATABASE_URL"));
				String username = dbUri.getUserInfo().split(":")[0];
				String password = dbUri.getUserInfo().split(":")[1];
				String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

				// "jdbc:postgresql://localhost:5432/sample?user=camm&password=1234"
				conexion = DriverManager.getConnection(dbUrl, username, password);;
			} catch (URISyntaxException ex) {
				System.err.print("Error la PTM: " + ex);
				System.exit(1);
			}
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.print("Error la PTM: " + ex);
			System.exit(1);
        }
    }

    public Connection getConexion(){ return conexion; }
}
