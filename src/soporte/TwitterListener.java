/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package soporte;

import base.Tabla;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.User;

/**
 *
 * @author camm
 */
public class TwitterListener implements StatusListener{

	@Override
	public void onStatus(Status status) {
		// AQUI SI
		Tabla tabla = new Tabla();
		User user = status.getUser();
		String username = status.getUser().getScreenName();
		System.out.println(username);
		String content = status.getText();
		System.out.println(content +"\n");
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
}
