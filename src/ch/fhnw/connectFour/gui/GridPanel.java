/*
 * Copyright 2011 Michel Heiniger
 * This file is part of JconnectFour.
 * JconnectFour is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * JconnectFour is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with JconnectFour. If not, see http://www.gnu.org/licenses/.
 */

package ch.fhnw.connectFour.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Properties;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ch.fhnw.connectFour.application.ApplicationContext;
import ch.fhnw.connectFour.gui.controller.GridPanelController;
import ch.fhnw.connectFour.logic.FieldModel;
import ch.fhnw.connectFour.logic.listeners.FieldListener;
import ch.fhnw.connectFour.persistance.FieldOwner;

/**
 * This panel draws a grid which is the gameboard. Everytime when a
 * dataChanged() is fired be the field listener all pins get redrawn.
 * 
 * @author Michel Heiniger
 * 
 */
@SuppressWarnings("serial")
public class GridPanel extends JPanel {

	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");

	Properties prop;
	JFrame mainFrame;

	FieldModel fieldModel;

	int width, height;
	int boardWidth, boardHeight;

	int border;

	/**
	 * Initializes all necessary stuff and registers a new field listener which
	 * causes a repaint() when it gets fired.
	 * 
	 * @param applicationContext
	 */
	public GridPanel(ApplicationContext applicationContext) {
		prop = applicationContext.getProperties();

		fieldModel = applicationContext.getFieldModel();

		new GridPanelController(applicationContext, this);

		mainFrame = applicationContext.getMainFrame();

		border = new Integer(prop.getProperty("border"));

		boardWidth = new Integer(prop.getProperty("boardWidth"));
		boardHeight = new Integer(prop.getProperty("boardHeight"));

		applicationContext.getFieldModel().addListener(new FieldListener() {
			@Override
			public void dataChanged() {
				repaint();
			}
		});

		log.info("grid panel loaded");

	}

	private void updateBounds() {
		width = mainFrame.getWidth();
		height = mainFrame.getHeight();
		log.info("windowResolution is now, x: " + width + " // y: " + height);
	}

	/**
	 * Paints the grid and all pins who have a owner.
	 */
	@Override
	public void paintComponent(final Graphics g) {
		super.paintComponent(g);

		updateBounds();
		drawHorizontal(g);
		drawVertical(g);
		drawPins(g);

		log.info("everthing painted");
	}

	/**
	 * Draws the horizontal lines.
	 * 
	 * @param g
	 */
	private void drawHorizontal(Graphics g) {

		// draw horizontal lines
		int step = (height - (2 * border)) / boardHeight;
		int x1 = border;
		int x2 = width - border;
		int y = height - border;

		for (int i = 0; i < boardHeight + 1; i++) {
			g.drawLine(x1, y, x2, y);
			y -= step;
		}

	}

	/**
	 * Draws the vertical lines.
	 * 
	 * @param g
	 */
	private void drawVertical(Graphics g) {
		// draw vertical lines
		int step = (width - (2 * border)) / boardWidth;
		int y1 = border;
		int y2 = height - border;
		int x = border;

		for (int i = 0; i < boardWidth + 1; i++) {
			g.drawLine(x, y1, x, y2);
			x += step;
		}
	}

	/**
	 * Checks if a field has a owner (computer, human), if yes the pin gets
	 * drawn at the position.
	 * 
	 * @param g
	 */
	private void drawPins(Graphics g) {

		int verticalStep = (width - (2 * border)) / boardWidth;
		int horizontalStep = (height - (2 * border)) / boardHeight;

		for (int i = 0; i < boardWidth; i++) {
			for (int j = 0; j < boardHeight; j++) {

				if (fieldModel.getFieldOwner(i, j) == FieldOwner.computer) {
					int x = (border + (verticalStep * i) + 25);
					int y = height - (2 * border) - (horizontalStep * j) + 25;

					g.setColor(Color.BLUE);
					g.fillOval(x, y, 50, 50);

				} else if (fieldModel.getFieldOwner(i, j) == FieldOwner.human) {
					int x = (border + (verticalStep * i) + 25);
					int y = height - (2 * border) - (horizontalStep * j) + 25;

					g.setColor(Color.RED);
					g.fillOval(x, y, 50, 50);
				}
			}
		}
	}

}
