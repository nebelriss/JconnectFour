/*
 * Copyright 2011 Michel Heiniger
 * This file is part of JconnectFour.
 * JconnectFour is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * JconnectFour is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with JconnectFour. If not, see http://www.gnu.org/licenses/.
 */

package ch.fhnw.connectFour.application;

import java.util.Properties;
import java.util.logging.Logger;

import javax.swing.JFrame;

import ch.fhnw.connectFour.logic.FieldModel;
import ch.fhnw.connectFour.logic.FourConnected;
import ch.fhnw.connectFour.logic.GameController;
import ch.fhnw.connectFour.logic.GameLogic;
import ch.fhnw.connectFour.logic.impl.FieldModelImpl;
import ch.fhnw.connectFour.logic.impl.FourConnectedImpl;
import ch.fhnw.connectFour.logic.impl.GameLogicImpl;

/**
 * Every major class is initialized with this class as argument, so every class
 * has accesses to the same instances. And it ensures the each of these classes
 * are unique.
 * 
 * @author Michel Heiniger
 * 
 */
public class ApplicationContext {

	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");
	private ApplicationProperties prop;

	private JFrame mainFrame;
	private FieldModel fieldModel;
	private GameController gameController;
	private GameLogic gameLogic;
	private FourConnected fourConnected;

	/**
	 * Creates new instances for the most used classes where there should be
	 * just one instance.
	 * 
	 * @param mainFrame
	 *            the main frame of the application
	 * @param prop
	 *            application properties with all final values and strings
	 */
	public ApplicationContext(JFrame mainFrame, ApplicationProperties prop) {
		this.mainFrame = mainFrame;
		this.prop = prop;

		fieldModel = new FieldModelImpl(this);
		gameLogic = new GameLogicImpl(this);
		fourConnected = new FourConnectedImpl(this);
		gameController = new GameController(this);

		log.info("applicationContext loaded");
	}

	public JFrame getMainFrame() {
		return mainFrame;
	}

	public Properties getProperties() {
		return prop.getProperties();
	}

	public Properties getLanguage() {
		return prop.getLanguage();
	}

	public FieldModel getFieldModel() {
		return fieldModel;
	}

	public GameController getGameController() {
		return gameController;
	}

	public FourConnected getFourConnected() {
		return fourConnected;
	}

	public GameLogic getGameLogic() {
		return gameLogic;
	}

}