package ch.fhnw.connectFour.application;

import java.util.Properties;
import java.util.logging.Logger;

import javax.swing.JFrame;

import ch.fhnw.connectFour.gui.MainPanel;
import ch.fhnw.connectFour.gui.MenuBar;

/**
 * Initialization class of the application. It initialisizes the main components
 * like the mainframe and the applicationcontext.
 * 
 * @author Michel Heiniger
 * 
 */
public class ConnectFourInit {

	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");
	private ApplicationProperties appProp;

	final String version;
	final String applicationName;

	final JFrame mainFrame;

	/**
	 * constructor which inits the elements.
	 */
	public ConnectFourInit() {
		
		new ApplicationLogger();
		
		log.info("ConnectFour started");
		appProp = new ApplicationProperties();
		Properties prop = appProp.getProperties();

		// get information for the window title
		version = prop.getProperty("version");
		applicationName = prop.getProperty("applicationName");
		String title = applicationName + " | " + version;

		mainFrame = new JFrame(title);

		mainFrame.pack();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainFrame.setSize(800, 600);

		// new application context
		ApplicationContext applicationContext = new ApplicationContext(
				mainFrame, appProp);

		// init and add menubar
		mainFrame.setJMenuBar(new MenuBar(applicationContext));

		// init and add mainpanel
		MainPanel mainPanel = new MainPanel(applicationContext);
		mainFrame.setContentPane(mainPanel);

		mainFrame.setVisible(true);
	}

}