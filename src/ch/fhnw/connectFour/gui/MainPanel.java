/*
 * Copyright 2011 Michel Heiniger
 * This file is part of JconnectFour.
 * JconnectFour is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * JconnectFour is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with JconnectFour. If not, see http://www.gnu.org/licenses/.
 */

package ch.fhnw.connectFour.gui;

import java.awt.BorderLayout;
import java.util.logging.Logger;

import javax.swing.JPanel;

import ch.fhnw.connectFour.application.ApplicationContext;

/**
 * initializes the main panel and adds it to the main frame. In this panel the
 * grid panel gets initialized with the game board.
 * 
 * @author Michel Heiniger
 * 
 */
@SuppressWarnings("serial")
public class MainPanel extends JPanel {

	private ApplicationContext applicationContext;
	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");

	GridPanel gridPanel;

	/**
	 * adds it self to the main frame and initializes the grid panel which is
	 * the gameboard.
	 * 
	 * @param applicationContext
	 *            all instances of the main classes
	 */
	public MainPanel(ApplicationContext applicationContext) {

		this.applicationContext = applicationContext;

		initComponents();

		this.setOpaque(true);
		log.info("main panel loaded.");
	}

	private void initComponents() {
		GridPanel gridPanel = new GridPanel(applicationContext);
		this.setLayout(new BorderLayout());
		this.add(gridPanel);
	}

}
