package ch.fhnw.connectFour.gui;

import ch.fhnw.connectFour.gui.MenuBar;

import ch.fhnw.connectFour.application.ApplicationContext;

public class MainPanel {
	
	private ApplicationContext applicationContext;
	
	public MainPanel(ApplicationContext applicationContext) {
		
		this.applicationContext = applicationContext;
		
		initComponents();
	}

	private void initComponents() {
		new MenuBar(applicationContext);
		new GridPanel(applicationContext);
	}

}
