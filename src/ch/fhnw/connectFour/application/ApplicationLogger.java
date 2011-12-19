package ch.fhnw.connectFour.application;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationLogger {
	
	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");
	private static FileHandler fh;
	
	public ApplicationLogger() {
		addLogger();
		log.info("Logger added.");
	}
	
	private void addLogger() {
		// open new fileHandler
		try {
			fh = new FileHandler("connectFour.log");
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}

		// send logger output to file
		log.addHandler(fh);
		
		// set level
		log.setLevel(Level.ALL);
	
	}

}
