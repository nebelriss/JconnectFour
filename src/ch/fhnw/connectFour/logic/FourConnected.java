/*
 * Copyright 2011 Michel Heiniger
 * This file is part of JconnectFour.
 * JconnectFour is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * JconnectFour is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with JconnectFour. If not, see http://www.gnu.org/licenses/.
 */

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
