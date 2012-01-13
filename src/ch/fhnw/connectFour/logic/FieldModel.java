package ch.fhnw.connectFour.logic;

import ch.fhnw.connectFour.logic.listeners.FieldListener;
import ch.fhnw.connectFour.persistance.FieldOwner;

/**
 * Handles all fields and sets/remove owners of them.
 * 
 * @author Michel Heiniger
 * 
 */
public interface FieldModel {

	/**
	 * Sets a move but it causes no repaint of the gameboard.
	 * 
	 * @param x
	 *            row of the gameboard
	 * @param fieldOwner
	 *            none, computer or human
	 * @return true if successful
	 */
	boolean setMove(int x, FieldOwner fieldOwner);

	/**
	 * Removes a move from the gameboard but it causes no repaint of it.
	 * 
	 * @param x
	 *            row of the gameboard
	 * @return true if successful
	 */
	boolean rmMove(int x);

	/**
	 * Tests if a row is full.
	 * 
	 * @param x
	 *            row of the gameboard
	 * @return true if full
	 */
	boolean isRowFull(int x);

	/**
	 * Sets a move and causes a repaint of the gameboard.
	 * 
	 * @param x
	 *            row
	 * @param y
	 *            line
	 * @param fieldOwner
	 *            none, computer or human
	 * @return true if successful
	 */
	boolean setFieldChanged(int x, int y, FieldOwner fieldOwner);

	/**
	 * Return the field owner of a specific field, important to test someone
	 * won.
	 * 
	 * @param x
	 *            row of the gameboard
	 * @param y
	 *            line of the gameboard
	 * @return the owner of the field, none, computer or human
	 */
	FieldOwner getFieldOwner(int x, int y);

	/**
	 * clear all field for a reset of the gameboard.
	 */
	void clearFields();

	/**
	 * to add a new listener to retrieve changes.
	 * 
	 * @param fieldListener
	 *            a new field listener
	 */
	void addListener(FieldListener fieldListener);

}
