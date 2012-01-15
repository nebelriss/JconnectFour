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
import ch.fhnw.connectFour.logic.listeners.FieldListener;
import ch.fhnw.connectFour.persistance.Field;
import ch.fhnw.connectFour.persistance.FieldOwner;

/**
 * Handles all fields and sets/remove owners of them.
 * 
 * @author Michel Heiniger
 * 
 */
public class FieldModelImpl implements FieldModel {

	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");
	private List<FieldListener> listeners;

	int boardHeight;
	int boardWidth;

	private Field[][] field;

	/**
	 * 
	 * @param applicationContext
	 */
	public FieldModelImpl(ApplicationContext applicationContext) {
		// properties
		Properties prop = applicationContext.getProperties();

		// get board size
		boardHeight = new Integer(prop.getProperty("boardHeight"));
		boardWidth = new Integer(prop.getProperty("boardWidth"));

		// create all fields
		createFields();

		// init listener arreylist
		listeners = new ArrayList<FieldListener>();

		log.info("FieldModelImpl loaded.");
	}

	/**
	 * {@inheritDoc}
	 */
	private void createFields() {
		// init 2d field array with boardSize
		field = new Field[boardWidth][boardHeight];

		// fill the array
		for (int i = 0; i < boardWidth; i++) {
			for (int j = 0; j < boardHeight; j++) {
				field[i][j] = new Field();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean setFieldChanged(int x, int y, FieldOwner fieldOwner) {

		for (int i = 0; i < boardHeight; i++) {

			try {
				if (field[x][i].getFieldOwner() == FieldOwner.none) {

					field[x][i].setFieldOwner(fieldOwner);

					log.info("Found a free field.\nFree field was: " + x
							+ " / " + i);

					// if free field was found fire and return true
					fireChanged();
					return true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				log.info("Index out of bounds\n");
				return false;
			}
		}

		// if all vertical field are occupied
		log.info("All vertikal fields are occupied, so false is going returned");
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FieldOwner getFieldOwner(int x, int y) {
		return field[x][y].getFieldOwner();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clearFields() {
		for (int i = 0; i < boardWidth; i++) {
			for (int j = 0; j < boardHeight; j++) {
				field[i][j].setFieldOwner(FieldOwner.none);
			}
		}
		fireChanged();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addListener(FieldListener fieldListener) {
		listeners.add(fieldListener);

	}

	protected void fireChanged() {
		for (FieldListener listener : listeners) {
			listener.dataChanged();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean setMove(int x, FieldOwner fieldOwner) {
		for (int i = 0; i < boardHeight; i++) {
			try {
				if (field[x][i].getFieldOwner() != FieldOwner.none) {
					field[x][i].setFieldOwner(fieldOwner);
					return true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				return false;
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean rmMove(int x) {
		for (int i = boardHeight; i <= 0; i--) {
			if (field[x][i].getFieldOwner() != FieldOwner.none) {
				field[x][i].setFieldOwner(FieldOwner.none);
				return true;
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isRowFull(int x) {
		try {
			if (field[x][boardHeight].getFieldOwner() == FieldOwner.none) {
				return false;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			log.info("array is full");
		}
		return true;
	}

}
