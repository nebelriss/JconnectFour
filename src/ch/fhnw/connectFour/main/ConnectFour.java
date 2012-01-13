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
