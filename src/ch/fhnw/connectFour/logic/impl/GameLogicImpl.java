/*
 * Copyright 2011 Michel Heiniger
 * This file is part of JconnectFour.
 * JconnectFour is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * JconnectFour is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with JconnectFour. If not, see http://www.gnu.org/licenses/.
 */

package ch.fhnw.connectFour.logic.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import ch.fhnw.connectFour.application.ApplicationContext;
import ch.fhnw.connectFour.logic.FieldModel;
import ch.fhnw.connectFour.logic.GameLogic;
import ch.fhnw.connectFour.persistance.FieldOwner;

/**
 * This is the logic of the game which calculates the next move for the
 * computer. It uses a alphabeta algorithm.
 * 
 * @author Michel Heiniger
 * 
 */
public class GameLogicImpl implements GameLogic {

	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");

	Properties prop;
	FieldModel field;

	int boardHeight;

	int depth;
	int alpha;
	int beta;
	FieldOwner compOwner;

	int initDepth;
	int chosenMove = 0;

	/**
	 * Sets the alpha, beta and depth
	 * 
	 * @param applicationContext
	 */
	public GameLogicImpl(ApplicationContext applicationContext) {

		prop = applicationContext.getProperties();
		field = applicationContext.getFieldModel();

		boardHeight = new Integer(prop.getProperty("boardHeight"));
		
		compOwner = FieldOwner.computer;

		initDepth = depth;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getNextMove() {
		// reset values
		depth = 7;
		alpha = -1000;
		beta = 1000;
		chosenMove = 0;
		
		int x = alphaBeta(compOwner, depth, alpha, beta);

		log.info("result of alphaBeta " + x);
		
		return chosenMove;
	}

	/**
	 * Calculates the next move with the alphabeta algorithm.
	 * 
	 * @param owner
	 *            Enum: none, computer, human
	 * @param depth
	 *            the depth of the gametree
	 * @param alpha
	 *            alpha value
	 * @param beta
	 *            beta value
	 * @return the row of the next move
	 */
	private int alphaBeta(FieldOwner owner, int depth, int alpha, int beta) {

		// generate possible moves
		List<Integer> moves = new ArrayList<Integer>();
		for (int i = 0; i < boardHeight; i++) {
			if (field.isRowFull(i)) {
				moves.add(i);
			}
		}

		// if depth <= 0 get the evaluate value
		if (depth <= 0) {
			return evaluate();
		}

		// run all moves
		for (int i = 0; i < moves.size(); i++) {
			// make move
			field.setMove(i, owner);

			// change owner for the recursive
			if (owner == FieldOwner.human) {
				owner = FieldOwner.computer;
			} else {
				owner = FieldOwner.human;
			}

			// get value from recursive
			int value = (-1) * alphaBeta(owner, depth - 1, -beta, -alpha);

			// undo move
			field.rmMove(i);

			if (value >= beta) {
				// beta cut
				return beta;
			}
			if (value > alpha) {
				// set new alpha
				alpha = value;

				/*
				 * if the alpha value gets overwritten in the starting knot,
				 * this means that this limp is at the moment the best move.
				 */
				if (depth == initDepth) {
					chosenMove = moves.get(i);
				}
			}
		}

		return alpha;

	}

	/**
	 * Returns the points of a knot in the end of the depth.
	 * 
	 * @return points of the last knot.
	 */
	private int evaluate() {

		int points = (int) (Math.random() * 10);

		return points;
	}

}
