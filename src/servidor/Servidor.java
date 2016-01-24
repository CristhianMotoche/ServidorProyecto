/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import base.Conexion;
import base.Tabla;

/**
 *
 * @author camm
 */
public class Servidor {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Conexion con = new Conexion();
		Tabla tabla = new Tabla();
		System.out.println(tabla.encontrarClavePorValor("4d186321c1a7f0f354b297e8914ab240").clave);
	}
}