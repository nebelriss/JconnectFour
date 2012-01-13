package ch.fhnw.connectFour.logic;

import java.util.logging.Logger;

import ch.fhnw.connectFour.application.ApplicationContext;
import ch.fhnw.connectFour.logic.listeners.FieldListener;
import ch.fhnw.connectFour.persistance.FieldOwner;

/**
 * 
 * @author Michel Heiniger
 *
 */
public class GameController {
	
	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");
	
	private FourConnected fourConnected;
	private GameLogic logic;
	private FieldModel field;
	
	boolean gameFinished;
	boolean player;
	
	/**
	 * constructor.
	 * @param applicationContext
	 */
	public GameController(ApplicationContext applicationContext) {
		
		fourConnected = applicationContext.getFourConnected();
		logic = applicationContext.getGameLogic();
		field = applicationContext.getFieldModel();
		
		gameFinished = false;
		
		// if player == true -> player can play
		player = true;
		
		applicationContext.getFieldModel().addListener(new FieldListener() {
			
			@Override
			public void dataChanged() {
				player = !player;
				if (!player) {
					playerPlayed();
				}
			}
		});

	}
	/**
	 * Test if it's the turn of the human player.
	 * @return returns true if it's the players turn, else false.
	 */
	public boolean canPlayerPlay() {
		if (!gameFinished) {
			return player;
		}
		return false;
	}
	
	/**
	 * 
	 */
	public void playerPlayed() {

		if (!gameFinished) {

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
			
			computersTurn();
		}
	}
	
	/**
	 * 
	 */
	private void computersTurn() {
		if (!gameFinished) {
			int nextMove = logic.getNextMove();
			
			field.setFieldChanged(nextMove, 0, FieldOwner.computer);
			
		}
		
	}

}
