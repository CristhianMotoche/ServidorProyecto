/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.servidor.soporte;

import com.servidor.base.Resultado;
import com.servidor.base.Tabla;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

/**
 *
 * @author camm
 */
public class TwitterListener implements StatusListener{

	@Override
	public void onStatus(Status status) {
		String content = status.getText();
		insertarPalabras(filtrarPendejadas(content));
	}

	@Override
	public void onDeletionNotice(StatusDeletionNotice sdn) {}

	@Override
	public void onTrackLimitationNotice(int i) {}

	@Override
	public void onScrubGeo(long l, long l1) { }

	@Override
	public void onStallWarning(StallWarning sw) { }

	@Override
	public void onException(Exception excptn) {	}

	public String filtrarPendejadas(String tweet){
		tweet = tweet.replaceAll("@\\w*|~|-|_|\\n|y|  |\\|quito|—|rt|'|=|https://tcp/\\w*|…|\\d|\\(|\\)|#\\w*|:|¡|\\+|\\*|!|,|\\.|¿|\"|\\?|http.*.co\\/\\w*", "");
		tweet = tweet.replaceAll("á", "a");
		tweet = tweet.replaceAll("é", "e");
		tweet = tweet.replaceAll("í", "i");
		tweet = tweet.replaceAll("ó", "o");
		tweet = tweet.replaceAll("ú", "u");
		tweet = tweet.replaceAll("ñ", "n");
		return tweet.toLowerCase().trim();
	}

	public void insertarPalabras(String palabras){
		Tabla tabla = new Tabla();
		for (String palabra : palabras.split(" ")) {
			if (!palabra.equals(" ")) {
				Resultado resultado = new Resultado();
				resultado.clave = palabra;
				resultado.valor = Cifrador.md5(palabra);
				tabla.insertar(resultado);
			}
		}
	}
}
