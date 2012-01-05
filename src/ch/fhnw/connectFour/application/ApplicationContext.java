package ch.fhnw.connectFour.application;

import java.util.Properties;
import java.util.logging.Logger;

import javax.swing.JFrame;

import org.eclipse.swt.widgets.Shell;

import ch.fhnw.connectFour.logic.FieldModel;
import ch.fhnw.connectFour.logic.impl.FieldModelImpl;

public class ApplicationContext {

	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");
	private ApplicationProperties prop;

	private JFrame mainFrame;
	private FieldModel fieldModel;

	public ApplicationContext(JFrame mainFrame, ApplicationProperties prop) {
		this.mainFrame = mainFrame;
		this.prop = prop;
		
		fieldModel = new FieldModelImpl(this);

		log.info("applicationContext loaded");
	}

	public JFrame getMainFrame() {
		return mainFrame;
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