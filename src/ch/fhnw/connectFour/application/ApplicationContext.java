package ch.fhnw.connectFour.application;

import java.util.Properties;
import java.util.logging.Logger;

import org.eclipse.swt.widgets.Shell;

public class ApplicationContext {

	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");
	private ApplicationProperties prop;

	private Shell shell;

	public ApplicationContext(Shell shell, ApplicationProperties prop) {
		this.shell = shell;
		this.prop = prop;

		log.info("applicationContext loaded");
	}

	public Shell getShell() {
		return shell;
	}

	public Properties getProperties() {
		return prop.getProperties();
	}
	
	public Properties getLanguage() {
		return prop.getLanguage();
	}

}