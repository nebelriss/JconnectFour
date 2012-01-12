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
				log.info("Index out of bounds");
				return false;
			}
		}

		// if all vertical field are occupied
		log.info("All vertikal fields are occupied, so false is going returned");
		return false;
	}

	@Override
	public FieldOwner getFieldOwner(int x, int y) {
		return field[x][y].getFieldOwner();
	}
	
	@Override
	public void clearFields() {
		for (int i = 0; i < boardWidth; i++) {
			for (int j = 0; j < boardHeight; j++) {
				field[i][j].setFieldOwner(FieldOwner.none);
			}
		}
	}

	@Override
	public void addListener(FieldListener fieldListener) {
		listeners.add(fieldListener);

	}
	
	protected void fireChanged() {
		for(FieldListener listener : listeners) {
			listener.dataChanged();
		}
	}


	@Override
	public boolean setMove(int x, FieldOwner fieldOwner) {
		for (int i = 0; i < boardHeight; i++) {
			try {
				if (field[x][i].getFieldOwner() != FieldOwner.none) {
					field[x][i].setFieldOwner(fieldOwner);
					return true;
				}
			} catch(ArrayIndexOutOfBoundsException e) {
				return false;
			}
		}
		return false;
	}

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

	@Override
	public boolean isRowFull(int x) {
		if (field[x][boardHeight].getFieldOwner() == FieldOwner.none) {
			return false;
		}
		return true;
	}

}
