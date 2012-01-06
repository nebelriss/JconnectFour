package ch.fhnw.connectFour.gui;

import java.util.logging.Logger;

import javax.swing.JMenuBar;
import javax.swing.JPanel;

import ch.fhnw.connectFour.gui.MenuBar;

import ch.fhnw.connectFour.application.ApplicationContext;

public class MainPanel extends JPanel{
	
	private ApplicationContext applicationContext;
	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");

	
	public MainPanel(ApplicationContext applicationContext) {
		
		this.applicationContext = applicationContext;
		
		initComponents();
		configComponents();
		
		log.info("main panel loaded.");
	}

	private void initComponents() {
		new GridPanel(applicationContext);
	}
	
	private void configComponents() {
		
	}

}
