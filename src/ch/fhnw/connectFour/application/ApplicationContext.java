package ch.fhnw.connectFour.application;

import java.util.Properties;
import java.util.logging.Logger;

import javax.swing.JFrame;

public class ApplicationContext {
	
	private static Logger logger = Logger.getLogger("ch.fhnw.connectFour");
	private Properties prop;
	
	private JFrame mainFrame;
	
	public ApplicationContext(JFrame mainFrame, Properties prop) {
		this.mainFrame = mainFrame;
		this.prop = prop;
	}
	
	public JFrame getMainFrame() {
		return mainFrame;
	}
	
	public Properties getProperties() {
		return prop;
	}

}
