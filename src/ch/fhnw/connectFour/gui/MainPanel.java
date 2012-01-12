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
