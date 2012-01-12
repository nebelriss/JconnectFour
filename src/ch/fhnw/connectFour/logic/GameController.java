package ch.fhnw.connectFour.logic;

import java.util.logging.Logger;

import ch.fhnw.connectFour.application.ApplicationContext;
import ch.fhnw.connectFour.persistance.FieldOwner;

/**
 * 
 * @author Michel Heiniger
 *
 */
public class GameController {
	
	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");
	
	private FourConnected fourConnected;
	
	boolean gameFinished;
	boolean player;
	
	public GameController(ApplicationContext applicationContext) {
		
		fourConnected = applicationContext.getFourConnected();

		gameFinished = false;
		
		// if player == true -> player can play
		player = true;

	}
	
	public boolean canPlayerPlay() {
		if (!gameFinished) {
			return player;
		}
		return false;
	}
	
	public void playerPlayed() {
		if (!gameFinished) {
			player = false;

			// test if player wins
			FieldOwner owner = fourConnected.testNow();

			if (owner != FieldOwner.none) {
				// someone won
				gameFinished = true;
				log.info(owner + " - won");
				// TODO open messagebox with the name of the player who won and
				// reset the game
			}
			log.info("player played");
			
			
		}
	}

}
