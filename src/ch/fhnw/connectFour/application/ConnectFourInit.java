package ch.fhnw.connectFour.application;

import java.util.Properties;
import java.util.logging.Logger;

import javax.swing.JFrame;

import ch.fhnw.connectFour.gui.MainPanel;

public class ConnectFourInit {

	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");
	private Properties prop;
	
	final String version;
	final String applicationName;
	
	final JFrame mainFrame;

	public ConnectFourInit() {
		log.info("ConnectFour started");
		prop = new ApplicationProperties().getProperties();

		version = prop.getProperty("version");
		applicationName = prop.getProperty("applicationName");
		
		mainFrame = new JFrame(applicationName + " | " + version);
		ApplicationContext applicationContext = new ApplicationContext(mainFrame, prop);
		
		MainPanel mainPanel = new MainPanel(applicationContext);
		
		mainFrame.setContentPane(mainPanel);
		mainFrame.pack();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(800, 600);
		mainFrame.setVisible(true);
		
	}

}