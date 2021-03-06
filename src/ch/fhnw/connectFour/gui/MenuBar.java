/*
 * Copyright 2011 Michel Heiniger
 * This file is part of JconnectFour.
 * JconnectFour is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * JconnectFour is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with JconnectFour. If not, see http://www.gnu.org/licenses/.
 */

package ch.fhnw.connectFour.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Properties;
import java.util.logging.Logger;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import ch.fhnw.connectFour.application.ApplicationContext;
import ch.fhnw.connectFour.logic.FieldModel;

/**
 * Creates the menubar in the mainframe.
 * 
 * @author Michel Heiniger
 * 
 */
@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {

	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");
	private Properties lang;

	private ApplicationContext applicationContext;
	private FieldModel field;

	/**
	 * Initializes the menubar and adds it to the main frame.
	 * 
	 * @param applicationContext
	 */
	public MenuBar(ApplicationContext applicationContext) {
		super();

		this.applicationContext = applicationContext;
		field = applicationContext.getFieldModel();

		// properties
		lang = applicationContext.getLanguage();

		fileMenu();
		helpMenu();
		log.info("MenuBar loaded");
	}

	private void fileMenu() {
		JMenu fileMenu = new JMenu(lang.getProperty("fileMenu"));
		this.add(fileMenu);

		// File -> New
		JMenuItem fileNewItem = new JMenuItem(lang.getProperty("fileNew"));
		fileMenu.add(fileNewItem);
		fileNewItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// reset all fields
				field.clearFields();				
			}
		});
		// keystroke
		fileNewItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				InputEvent.CTRL_DOWN_MASK));

		// File -> Exit
		JMenuItem fileExitItem = new JMenuItem(lang.getProperty("fileExit"));
		fileMenu.add(fileExitItem);

		fileExitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		// keystroke
		fileExitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				InputEvent.CTRL_DOWN_MASK));

	}

	private void helpMenu() {
		JMenu helpMenu = new JMenu(lang.getProperty("helpMenu"));
		this.add(helpMenu);

		// Help -> About
		JMenuItem helpAboutItem = new JMenuItem(lang.getProperty("helpAbout"));
		helpMenu.add(helpAboutItem);

		helpAboutItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new AboutFrame(applicationContext);

			}
		});

	}

}
