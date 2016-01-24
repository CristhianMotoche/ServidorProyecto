/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author camm
 */
public class HeartBeat extends Thread{
	private Socket socket;
	private PrintWriter salida;
	String host;
	int puerto;

	public HeartBeat(int puerto, String host) {
		this.puerto = puerto;
		this.host = host;
	}
	@Override
	public void run(){
		establecerConexion();
		enviarLatidos();
	}

	private void enviarLatidos() {
		while (true) {			
			try {
				System.out.println("Enviando...");
				this.salida.println("-1<quien");
				Thread.sleep(3000);
			} catch (InterruptedException ex) {
				Logger.getLogger(HeartBeat.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	private void establecerConexion() {
		try {
			this.socket = new Socket(this.host, this.puerto);
			this.salida = new PrintWriter(this.socket.getOutputStream(), true);
		} catch (IOException ex) {
			System.err.println("No se pudo establecer la conexión\n" + ex);
			interrupt();
		}
	}
}
