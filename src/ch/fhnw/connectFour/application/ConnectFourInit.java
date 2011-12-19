package ch.fhnw.connectFour.application;

import java.util.logging.Logger;

import javax.swing.JFrame;

import ch.fhnw.connectFour.gui.MainPanel;

public class ConnectFourInit {

	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");
	
	final String version;
	final String applicationName;
	
	final JFrame mainFrame;

	public ConnectFourInit() {
		log.info("ConnectFour started");
		
		version = "0.1";
		applicationName = "connectFour - AlphaBeta-Algorithm";
		
		mainFrame = new JFrame(applicationName);
		ApplicationContext applicationContext = new ApplicationContext(mainFrame);
		
		MainPanel mainPanel = new MainPanel(applicationContext);
		
		mainFrame.setContentPane(mainPanel);
		mainFrame.pack();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(800, 600);
		mainFrame.setVisible(true);
		
	}

}
