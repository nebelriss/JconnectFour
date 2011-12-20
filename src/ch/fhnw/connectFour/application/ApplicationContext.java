package ch.fhnw.connectFour.application;

import java.util.Properties;
import java.util.logging.Logger;

import org.eclipse.swt.widgets.Shell;

import ch.fhnw.connectFour.logic.FieldModel;
import ch.fhnw.connectFour.logic.impl.FieldModelImpl;

public class ApplicationContext {

	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");
	private ApplicationProperties prop;

	private Shell shell;
	private FieldModel fieldModel;

	public ApplicationContext(Shell shell, ApplicationProperties prop) {
		this.shell = shell;
		this.prop = prop;
		
		fieldModel = new FieldModelImpl(this);

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
	
	public FieldModel getFieldModel() {
		return fieldModel;
	}

}