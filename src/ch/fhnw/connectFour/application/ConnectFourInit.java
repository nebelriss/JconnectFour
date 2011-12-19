package ch.fhnw.connectFour.application;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectFourInit {
	
	private static Logger logger = Logger.getLogger("ch.fhnw.connectFour");
	private static FileHandler fh;
	
	public ConnectFourInit() {
		
		myLogger();
		logger.info("ConnectFour started");
		
	}
	
	
	private static void myLogger() {
		// open new fileHandler
		try {
			fh = new FileHandler("connectFour.log");
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}

		// send logger output to file
		logger.addHandler(fh);
		
		// set level
		logger.setLevel(Level.ALL);
	
	}

}
