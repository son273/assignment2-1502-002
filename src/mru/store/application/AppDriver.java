package mru.store.application;

import mru.store.controller.StoreManager;
import mru.store.exceptions.MinPlayerException;
/**
 * Responsible for running application
 * @author Steven and Caesar
 * @version 6.9
 */
public class AppDriver {
	public static void main(String[] args) throws MinPlayerException { //Main Method of Application
		new StoreManager();
	}

}
