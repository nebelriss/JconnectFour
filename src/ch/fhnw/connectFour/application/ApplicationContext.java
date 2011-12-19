package ch.fhnw.connectFour.application;

import java.util.logging.Logger;

import javax.swing.JFrame;

public class ApplicationContext {
	
	private static Logger logger = Logger.getLogger("ch.fhnw.connectFour");
	
	private JFrame mainFrame;
	
	public ApplicationContext(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	public JFrame getMainFrame() {
		return mainFrame;
	}

}
