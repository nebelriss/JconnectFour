package ch.fhnw.connectFour.logic.impl;

import java.util.Properties;
import java.util.logging.Logger;

import ch.fhnw.connectFour.application.ApplicationContext;
import ch.fhnw.connectFour.logic.FieldModel;
import ch.fhnw.connectFour.logic.FourConnected;
import ch.fhnw.connectFour.persistance.FieldOwner;


/**
 * 
 * With this class the application checks if there are four fields in a row
 * occupied by the same player (human of computer). If someone gets found it
 * returns the number of the player. if player == 1 -> human if player == 2 ->
 * computer if 0 gets returned it means that nobody has won.
 * 
 */
public class FourConnectedImpl implements FourConnected{

	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");

	private Properties prop;
	private FieldModel field;

	private FieldOwner player;

	private Integer boardHeight;
	private Integer boardWidth;

	public FourConnectedImpl(ApplicationContext applicationContext) {
		prop = applicationContext.getProperties();
		field = applicationContext.getFieldModel();

		boardHeight = new Integer(prop.getProperty("boardHeight"));
		boardWidth = new Integer(prop.getProperty("boardWidth"));
		
		log.info("FourConnect loaded.");
	}

	/**
	 * 
	 * Every possibility to get four in a row is checked. horizontal, vertical,
	 * diagonal from low left to right and low right to left.
	 * 
	 * 
	 */
	public FieldOwner testNow() {
		log.info("testing now if someone has won.");
		
		int num;

		for (int y = 0; y < boardHeight; y++) {
			// reset num and player
			num = 0;
			player = FieldOwner.none;
			for (int x = 0; x < boardWidth; x++) {
				// if this field has the same owner like the previous one num
				// gets increased.
				if (field.getFieldOwner(x, y) == player) {
					num++;
				} else {
					// if the next one is a different one or its the first
					// check, num get reseted.
					num = 1;
					player = field.getFieldOwner(x, y);
				}
				if (num == 4 && player != FieldOwner.none) {
					log.info("found horizontal four in a row");
					return player;
				}
			}
		}

		// check vertical
		for (int x = 0; x < boardWidth; x++) {
			// reset num and player
			num = 0;
			player = FieldOwner.none;
			for (int y = 0; y < boardHeight; y++) {
				// if this field has the same owner like the previous one num
				// gets increased.
				if (field.getFieldOwner(x, y) == player) {
					num++;
				} else {
					// if the next one is a different one or its the first
					// check, num get reseted.
					num = 1;
					player = field.getFieldOwner(x, y);
				}
				if (num == 4 && player != FieldOwner.none) {
					log.info("found vertical four in a row");
					return player;
				}
			}
		}

		// check diagonal from left low to right high
		for (int xStart = 0, yStart = boardHeight - 4; xStart < 5;) {
			// reset num and player
			num = 0;
			player = FieldOwner.none;
			for (int x = xStart, y = yStart; x < boardWidth && y < boardHeight; x++, y++) {
				// if this field has the same owner like the previous one num
				// gets increased.
				if (field.getFieldOwner(x, y) == player) {
					num++;
				} else {
					// if the next one is a different one or its the first
					// check, num get reseted.
					num = 1;
					player = field.getFieldOwner(x, y);
				}
				if (num == 4 && player != FieldOwner.none) {
					log.info("found diagonal four in a row");
					return player;
				}
			}
			// when the inner four is finished it checks if the check is in a
			// corner.
			// when yes the xStart value is raised now.
			if (yStart == 0) {
				xStart++;
			} else {
				yStart--;
			}
		}

		// check diagonal from left upper to right low
		for (int xStart = 0, yStart = 3; xStart < 4;) {
			// reset num and player
			num = 0;
			player = FieldOwner.none;
			for (int x = xStart, y = yStart; x < boardWidth && y >= 0; x++, y--) {
				// if this field has the same owner like the previous one num
				// gets increased.
				if (field.getFieldOwner(x, y) == player) {
					num++;
				} else {
					// if the next one is a different one or its the first
					// check, num get reseted.
					num = 1;
					player = field.getFieldOwner(x, y);
				}
				if (num == 4 && player != FieldOwner.none) {
					log.info("found diagonal four in a row");
					return player;
				}
			}
			if (yStart == boardHeight - 1) {
				xStart++;
			} else {
				yStart++;
			}
		}

		return FieldOwner.none;
	}

}
