/*
 * Copyright 2011 Michel Heiniger
 * This file is part of JconnectFour.
 * JconnectFour is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * JconnectFour is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with JconnectFour. If not, see http://www.gnu.org/licenses/.
 */

package ch.fhnw.connectFour.main;

import ch.fhnw.connectFour.application.ConnectFourInit;

/**
 * This is a simple implementation of the famous game "connect four". Like the
 * names saying the goal in this game is to connect four of your stones to
 * gether. They can be connected horizontal, vertical or diagonal. The game uses
 * a simple gui where just the gameboard is displayed.
 * 
 * The AI is using a alpha-beta algorithm, but the evaluation is very poorly
 * implemented and needs a lot of work for it.
 * 
 * Have Fun!
 * 
 * @author Michel Heiniger
 * 
 */
public class ConnectFour {
	
	/**
	 * entry point
	 */
	public static void main(String[] args) {
		
		new ConnectFourInit();

	}
}
