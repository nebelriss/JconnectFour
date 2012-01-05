package ch.fhnw.connectFour.gui;

import javax.swing.JMenuBar;
import javax.swing.JPanel;

import ch.fhnw.connectFour.gui.MenuBar;

import ch.fhnw.connectFour.application.ApplicationContext;

public class MainPanel extends JPanel{
	
	private ApplicationContext applicationContext;
	
	public MainPanel(ApplicationContext applicationContext) {
		
		this.applicationContext = applicationContext;
		
		initComponents();
		configComponents();
	}

	private void initComponents() {
		new GridPanel(applicationContext);
	}
	
	private void configComponents() {
		
	}

}
