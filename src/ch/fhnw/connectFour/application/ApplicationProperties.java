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
