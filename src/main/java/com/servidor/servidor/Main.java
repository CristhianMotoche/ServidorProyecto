/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servidor.servidor;

import com.servidor.soporte.TwitterThread;

/**
 *
 * @author camm
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		int puerto = Integer.parseInt(System.getenv("PORT"));
		String host = "190.10.167.212";
		Servidor servidor = new Servidor(puerto);
		// Enviar latidos
		HeartBeat heartBeat = new HeartBeat(8000, host);
		heartBeat.start();
		// Obtener tweets
		//TwitterThread tt = new TwitterThread();
		//tt.start();
		// Iniciar servidor
		servidor.iniciar();
	}
}
