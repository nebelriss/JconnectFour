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
 * {@inheritDoc}
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

	/**
	 * Sets the alpha, beta and depth
	 * 
	 * @param applicationContext
	 */
	public GameLogicImpl(ApplicationContext applicationContext) {

		prop = applicationContext.getProperties();
		field = applicationContext.getFieldModel();

		boardHeight = new Integer(prop.getProperty("boardHeight"));

		depth = 6;
		alpha = -1000;
		beta = 1000;
		compOwner = FieldOwner.computer;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getNextMove() {
		int x = alphaBeta(compOwner, depth, alpha, beta);

		log.info("result of alphaBeta " + x);
		return x;
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

		System.out.println(moves.size());
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
