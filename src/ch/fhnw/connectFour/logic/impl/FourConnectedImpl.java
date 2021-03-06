/*
 * Copyright 2011 Michel Heiniger
 * This file is part of JconnectFour.
 * JconnectFour is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * JconnectFour is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with JconnectFour. If not, see http://www.gnu.org/licenses/.
 */

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
 * @author Michel Heiniger
 */
public class FourConnectedImpl implements FourConnected{

	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");

	private Properties prop;
	private FieldModel field;

	private FieldOwner player;

	private Integer boardHeight;
	private Integer boardWidth;
	
	/**
	 * 
	 * @param applicationContext
	 */
	public FourConnectedImpl(ApplicationContext applicationContext) {
		prop = applicationContext.getProperties();
		field = applicationContext.getFieldModel();

		boardHeight = new Integer(prop.getProperty("boardHeight"));
		boardWidth = new Integer(prop.getProperty("boardWidth"));
		
		log.info("FourConnect loaded.");
	}

	/**
	 * {@inheritDoc}
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
