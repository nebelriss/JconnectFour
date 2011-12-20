package ch.fhnw.connectFour.application;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class ApplicationProperties {
	
	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");
	
	private Properties defaultProperties;
	private Properties applicationProperties;
	private Properties languageProperties;
	
	public ApplicationProperties() {
		loadDefaultProperties();
		loadApplicationProperties();
		loadLanguageProperties();
		log.info("properties loaded.");
	}
	
	private void loadDefaultProperties() {
		
		defaultProperties = new Properties();
		try {
			FileInputStream in = new FileInputStream("properties/default.properties");
			defaultProperties.load(in);
			in.close();
		} catch (IOException e) {
			log.warning(e.toString());
		}
	}
	
	private void loadApplicationProperties() {
		applicationProperties = new Properties(defaultProperties);
		try {
			FileInputStream in = new FileInputStream("properties/application.properties");
			applicationProperties.load(in);
			in.close();
		} catch (IOException e) {
			log.warning(e.toString());
		}
	}
	
	private void loadLanguageProperties() {
		languageProperties = new Properties();
		String path = "language/" + applicationProperties.getProperty("language") + ".properties";
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
