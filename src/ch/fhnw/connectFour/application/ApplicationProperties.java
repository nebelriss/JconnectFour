/*
 * Copyright 2011 Michel Heiniger
 * This file is part of JconnectFour.
 * JconnectFour is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * JconnectFour is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with JconnectFour. If not, see http://www.gnu.org/licenses/.
 */

package ch.fhnw.connectFour.application;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Initializes the different properties. language properties are just used for
 * text that is specific to a language default properties are used when there's
 * no application properties set by the user. application properties are used
 * when the user specified different properties, inside the application, then
 * the default ones. This way it pretends that the default properties get
 * overwritten.
 * 
 * @author Michel Heiniger
 * 
 */
public class ApplicationProperties {

	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");

	private Properties defaultProperties;
	private Properties applicationProperties;
	private Properties languageProperties;

	/**
	 * Constructor
	 */
	public ApplicationProperties() {
		loadDefaultProperties();
		loadApplicationProperties();
		loadLanguageProperties();
		log.info("properties loaded.");
	}

	/**
	 * Loads the default properties which are used when there's no application
	 * properties set by the user.
	 */
	private void loadDefaultProperties() {

		defaultProperties = new Properties();
		try {
			FileInputStream in = new FileInputStream(
					"properties/default.properties");
			defaultProperties.load(in);
			in.close();
		} catch (IOException e) {
			log.warning(e.toString());
		}
	}

	/**
	 * loads the application properties which are used when the user sets
	 * different properties in the application. this prevents that the default
	 * properties get overwritten.
	 */
	private void loadApplicationProperties() {
		applicationProperties = new Properties(defaultProperties);
		try {
			FileInputStream in = new FileInputStream(
					"properties/application.properties");
			applicationProperties.load(in);
			in.close();
		} catch (IOException e) {
			log.warning(e.toString());
		}
	}

	/**
	 * load the language file
	 */
	private void loadLanguageProperties() {
		languageProperties = new Properties();
		String path = "language/"
				+ applicationProperties.getProperty("language") + ".properties";
		try {
			FileInputStream in = new FileInputStream(path);
			languageProperties.load(in);
			in.close();
		} catch (IOException e) {
			log.warning(e.toString());
		}
	}

	public Properties getProperties() {
		return applicationProperties;
	}

	public Properties getLanguage() {
		return languageProperties;
	}
}
