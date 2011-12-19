package ch.fhnw.connectFour.application;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationProperties {
	
	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");

	
	public ApplicationProperties() {
		loadDefaultProps();
		log.info("properties loaded.");
	}
	
	private void loadDefaultProps() {
		
		Properties defaultProps = new Properties();
		try {
			FileInputStream in = new FileInputStream("default.properties");
			defaultProps.load(in);
			in.close();
		} catch (IOException e) {
			log.warning(e.toString());
		}
		
	}
}
