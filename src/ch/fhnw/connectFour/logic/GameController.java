package ch.fhnw.connectFour.logic;

import java.util.logging.Logger;

import ch.fhnw.connectFour.application.ApplicationContext;

/**
 * 
 * @author Michel Heiniger
 *
 */
public class GameController {
	
	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");

	boolean player;
	
	public GameController(ApplicationContext applicationContext) {
		// player begins
		player = true;
		
	}
	
	public boolean canPlayerPlay() {
		return player;
	}
	
	public void playerPlayed(boolean b) {
		player = b;
		log.info("player played");
	}

}
