/*
 * Copyright 2011 Michel Heiniger
 * This file is part of JconnectFour.
 * JconnectFour is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * JconnectFour is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with JconnectFour. If not, see http://www.gnu.org/licenses/.
 */

package ch.fhnw.connectFour.application;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Starts the application logger and writes all output to a file. 
 * And the loglever can be set too.
 * @author Michel Heiniger
 *
 */
public class ApplicationLogger {
	
	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");
	private static FileHandler fh;
	
	/**
	 * constructor with the logger initialization.
	 */
	public ApplicationLogger() {
		addLogger();
		log.info("Logger added.");
	}
	
	/**
	 * - Specifies where the logger saves the log file.
	 * - the logger level can be set.
	 */
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
