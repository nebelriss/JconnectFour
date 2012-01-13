package ch.fhnw.connectFour.logic;

/**
 * This is the logic of the game which calculates the next move for the
 * computer. It uses a alphabeta algorithm.
 * 
 * @author Michel Heiniger
 * 
 */
public interface GameLogic {

	/**
	 * Calculates the next move for the computer.
	 * 
	 * @return row for the next move.
	 */
	public int getNextMove();

}
