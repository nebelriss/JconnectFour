package ch.fhnw.connectFour.gui;

import java.awt.Graphics;
import java.util.Properties;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ch.fhnw.connectFour.application.ApplicationContext;

@SuppressWarnings("serial")
public class GridPanel extends JPanel{

	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");
	
	Properties prop;
	JFrame mainFrame;
	
	int width, height;
	int boardWidth, boardHeight;
	
	int border;
	
	public GridPanel(ApplicationContext applicationContext) {
		prop = applicationContext.getProperties();
		mainFrame = applicationContext.getMainFrame();
		
		border = 80;
		
		boardWidth = new Integer(prop.getProperty("boardWidth"));
		boardHeight = new Integer(prop.getProperty("boardHeight"));
		
		log.info("grid panel loaded");
		updateBounds();
		
	}
	
	private void updateBounds() {
		width = this.getX();
		height = mainFrame.getHeight();
		log.info("windowResolution is now, x: " + width + " // y: " + height);
	}
	

	public void PaintComponent(final Graphics g) {
		super.paintComponent(g);
		
		updateBounds();
		drawHorizontal(g);
		g.drawRect(0, 0, 300, 300);
		
		log.info("everthing painted");
	}

	private void drawHorizontal(Graphics g) {
		// the grid has border of 80px
		
		// draw horizontal lines
		int step = (height - (2 * border) ) / boardHeight;
		int x1 = border;
		int x2 = width - border;
		int y = height - border;
		log.info("horizontal step is: " + step);
		for (int i = 0; i < boardHeight; i++) {
			g.drawLine(x1, y, x2, y);
			y -= step;
			
		}
		
	}

}
