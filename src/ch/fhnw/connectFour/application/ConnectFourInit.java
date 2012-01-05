package ch.fhnw.connectFour.application;

import java.util.Properties;
import java.util.logging.Logger;

import javax.swing.JFrame;

import ch.fhnw.connectFour.gui.MainPanel;
import ch.fhnw.connectFour.gui.MenuBar;

public class ConnectFourInit {

	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");
	private ApplicationProperties appProp;
	
	final String version;
	final String applicationName;
	
	final JFrame mainFrame;

	public ConnectFourInit() {
		log.info("ConnectFour started");
		appProp = new ApplicationProperties();
		Properties prop = appProp.getProperties();

		version = prop.getProperty("version");
		applicationName = prop.getProperty("applicationName");
		String title = applicationName + " | " + version;
		
		mainFrame = new JFrame(applicationName + " | " + version);
		ApplicationContext applicationContext = new ApplicationContext(mainFrame, appProp);
		
		// add MenuBar and MainPanel to the mainFrame
		mainFrame.setJMenuBar(new MenuBar(applicationContext));
		MainPanel mainPanel = new MainPanel(applicationContext);
		
		mainFrame.setContentPane(mainPanel);
		mainFrame.pack();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(800, 600);
		mainFrame.setVisible(true);
	}

}