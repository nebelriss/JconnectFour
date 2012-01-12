package ch.fhnw.connectFour.gui;

import java.awt.Graphics;
import java.util.Properties;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ch.fhnw.connectFour.application.ApplicationContext;
import ch.fhnw.connectFour.logic.FieldModel;
import ch.fhnw.connectFour.logic.listeners.FieldListener;
import ch.fhnw.connectFour.persistance.FieldOwner;

/**
 * 
 * @author Michel Heiniger
 *
 */
@SuppressWarnings("serial")
public class GridPanel extends JPanel{

	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");
	
	Properties prop;
	JFrame mainFrame;
	
	FieldModel fieldModel;
	
	int width, height;
	int boardWidth, boardHeight;
	
	int border;
	
	public GridPanel(ApplicationContext applicationContext) {
		prop = applicationContext.getProperties();
		
		fieldModel = applicationContext.getFieldModel();
		
		applicationContext.getFieldModel().addListener(new FieldListener() {
			@Override
			public void dataChanged() {
				repaint();
			}
		});
		
		mainFrame = applicationContext.getMainFrame();
		
		border = 80;
		
		boardWidth = new Integer(prop.getProperty("boardWidth"));
		boardHeight = new Integer(prop.getProperty("boardHeight"));
		
		log.info("grid panel loaded");
		this.setOpaque(true);
		
	}
	
	private void updateBounds() {
		width = mainFrame.getWidth();
		height = mainFrame.getHeight();
		log.info("windowResolution is now, x: " + width + " // y: " + height);
	}
	

	@Override
	public void paintComponent(final Graphics g) {
		super.paintComponent(g);
		
		updateBounds();
		drawHorizontal(g);
		drawVertical(g);
		drawPins(g);
		
		log.info("everthing painted");
	}

	private void drawHorizontal(Graphics g) {
	
		// draw horizontal lines
		int step = (height - (2 * border) ) / boardHeight;
		int x1 = border;
		int x2 = width - border;
		int y = height - border;
		log.info("horizontal step is: " + step);
		for (int i = 0; i < boardHeight + 1; i++) {
			g.drawLine(x1, y, x2, y);
			y -= step;	
		}
		
	}
	
	private void drawVertical(Graphics g) {
		// draw vertical lines
		int step = (width - (2 * border) ) / boardWidth;
		int y1 = border;
		int y2 = height - border;
		int x = border;
		log.info("vertical step is: " + step);
		for (int i = 0; i < boardWidth + 1; i++) {
			g.drawLine(x, y1, x, y2);
			x += step;
		}
	}
	
	private void drawPins(Graphics g) {
		for (int i = 0; i < boardWidth; i++) {
			for (int j = 0; j < boardHeight; j++) {
				if ( fieldModel.getFieldOwner(i, j) == FieldOwner.blue) {
					g.drawOval(3, 3, 3, 3);
				} else if (fieldModel.getFieldOwner(i, j) == FieldOwner.red) {
					
				} else {}
			}
		}
	}

}
