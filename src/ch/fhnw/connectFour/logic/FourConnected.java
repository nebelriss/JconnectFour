package ch.fhnw.connectFour.logic;

import ch.fhnw.connectFour.persistance.FieldOwner;

/**
 * 
 * With this class the application checks if there are four fields in a row
 * occupied by the same player (human of computer). If someone gets found it
 * returns the number of the player. if player == 1 -> human if player == 2 ->
 * computer if 0 gets returned it means that nobody has won.
 * 
 * @author Michel Heiniger
 */
public interface FourConnected {

	/**
	 * Every possibility to get four in a row is checked. horizontal, vertical,
	 * diagonal from low left to right and low right to left.
	 * 
	 * @return winner or none
	 */
	public FieldOwner testNow();

}
