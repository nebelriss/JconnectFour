/*
 * Copyright 2011 Michel Heiniger
 * This file is part of JconnectFour.
 * JconnectFour is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * JconnectFour is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with JconnectFour. If not, see http://www.gnu.org/licenses/.
 */

package ch.fhnw.connectFour.gui;

import java.awt.Toolkit;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JLabel;

import ch.fhnw.connectFour.application.ApplicationContext;

/**
 * About window.
 * 
 * @author Michel Heiniger
 * 
 */
@SuppressWarnings("serial")
public class AboutFrame extends JFrame {

	Properties lang;
	Properties prop;
	int width;
	int height;

	private JLabel titleLabel;
	private JLabel autorLabel;
	private JLabel versionLabel;

	// private JLabel licenceLabel;

	/**
	 * New frame for the about window.
	 * 
	 * @param applicationContext
	 */
	public AboutFrame(ApplicationContext applicationContext) {

		lang = applicationContext.getLanguage();
		prop = applicationContext.getProperties();

		width = 400;
		height = 300;

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int x = (toolkit.getScreenSize().width - width) / 2;
		int y = (toolkit.getScreenSize().height - height) / 2;

		initComponents();

		setBounds(x, y, width, height);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);

	}

	private void initComponents() {

		titleLabel = new JLabel(prop.getProperty("applicationName"));
		add(titleLabel);

		autorLabel = new JLabel(prop.getProperty("autor"));
		add(autorLabel);

		versionLabel = new JLabel(prop.getProperty("version"));
		add(versionLabel);

	}

}
