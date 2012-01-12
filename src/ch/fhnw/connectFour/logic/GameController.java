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
	
	private ApplicationContext applicationContext;
	
	boolean gameFinished;
	boolean player;
	
	public GameController(ApplicationContext applicationContext) {
		
		this.applicationContext = applicationContext;
		
		
		gameFinished = false;
		
		// if player == true -> player can play
		player = true;

	}
	
	public boolean canPlayerPlay() {
		return player;
	}
	
	public void playerPlayed() {
		player = false;
		
		
		
		log.info("player played");
	}

}
