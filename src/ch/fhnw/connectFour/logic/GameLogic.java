/*
 * Copyright 2011 Michel Heiniger
 * This file is part of JconnectFour.
 * JconnectFour is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * JconnectFour is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with JconnectFour. If not, see http://www.gnu.org/licenses/.
 */

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
