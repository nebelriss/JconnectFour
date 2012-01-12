package ch.fhnw.connectFour.gui;

import java.awt.BorderLayout;
import java.util.logging.Logger;

import javax.swing.JPanel;

import ch.fhnw.connectFour.application.ApplicationContext;

@SuppressWarnings("serial")
public class MainPanel extends JPanel{
	
	private ApplicationContext applicationContext;
	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");
	
	GridPanel gridPanel;
	
	public MainPanel(ApplicationContext applicationContext) {
		
		this.applicationContext = applicationContext;
		
		initComponents();
		configComponents();
		
		this.setOpaque(true);
		log.info("main panel loaded.");
	}

	private void initComponents() {
		GridPanel gridPanel = new GridPanel(applicationContext);
		this.setLayout(new BorderLayout());
		this.add(gridPanel);
	}
	
	private void configComponents() {
		
	}

}
