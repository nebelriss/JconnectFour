/*
 * Copyright 2011 Michel Heiniger
 * This file is part of JconnectFour.
 * JconnectFour is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * JconnectFour is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with JconnectFour. If not, see http://www.gnu.org/licenses/.
 */

package ch.fhnw.connectFour.gui.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Properties;
import java.util.logging.Logger;

import javax.swing.JFrame;

import ch.fhnw.connectFour.application.ApplicationContext;
import ch.fhnw.connectFour.gui.GridPanel;
import ch.fhnw.connectFour.logic.FieldModel;
import ch.fhnw.connectFour.logic.GameController;
import ch.fhnw.connectFour.persistance.FieldOwner;

/**
 * Controller for the gridpanel. It calculates the field which was clicked and
 * sets the new owner.
 * 
 * @author Michel Heiniger
 * 
 */
public class GridPanelController {

	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");

	/**
	 * @param applicationController
	 * @param gridPanel
	 */
	public GridPanelController(ApplicationContext applicationController,
			GridPanel gridPanel) {

		final GameController gameController = applicationController
				.getGameController();
		final FieldModel field = applicationController.getFieldModel();
		final Properties prop = applicationController.getProperties();
		final JFrame mainFrame = applicationController.getMainFrame();

		final int border = new Integer(prop.getProperty("border"));
		final int width = mainFrame.getSize().width;
		final int height = mainFrame.getSize().height;

		gridPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int boardWidth = new Integer(prop.getProperty("boardWidth"));
				int boardHeight = new Integer(prop.getProperty("boardHeight"));

				int widthStep = (width - (2 * border)) / boardWidth;
				int heightStep = (height - (2 * border)) / boardHeight;

				int x = (e.getX() - (2 * border)) / widthStep + 1;
				int y = (e.getY() - (2 * border)) / heightStep;

				y = boardHeight - y;

				if (gameController.canPlayerPlay() == true) {

					field.setFieldChanged(x, y, FieldOwner.human);

					log.info("field set");
				}
			}

		});

	}

}
