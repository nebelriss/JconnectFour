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
	public void setFieldChanged(int x, int y, FieldOwner fieldOwner) {
		field[x][y].setFieldOwner(fieldOwner);
		log.info("new fieldOwner for " + x + "/" + y + ": " + fieldOwner);
	}

	@Override
	public FieldOwner getFieldOwner(int x, int y) {
		return field[x][y].getFieldOwner();
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

}
