/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

/**
 *
 * @author camm
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		int puerto = 6969;
		String host = "10.0.0.2";
		Servidor servidor = new Servidor(puerto);
		HeartBeat heartBeat = new HeartBeat(8000, host);
		heartBeat.start();
		servidor.iniciar();
	}
}