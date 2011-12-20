package ch.fhnw.connectFour.application;

import java.util.Properties;

import org.junit.Test;

public class ApplicationPropertiesTest {

	@Test
	public void testApplicationProperties() {
		
		ApplicationProperties ap = new ApplicationProperties();
		Properties p = ap.getProperties();
		String version = p.getProperty("version");
		System.out.println(version);
		Properties lang = ap.getLanguage();
		System.out.println(lang.getProperty("fileNew"));
	}

}
