package ch.fhnw.connectFour.application;

import java.util.Properties;
import java.util.logging.Logger;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import ch.fhnw.connectFour.gui.MainPanel;

public class ConnectFourInit {

	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");
	private ApplicationProperties appProp;
	
	final String version;
	final String applicationName;
	
	final Shell shell;

	public ConnectFourInit() {
		log.info("ConnectFour started");
		appProp = new ApplicationProperties();
		Properties prop = appProp.getProperties();

		version = prop.getProperty("version");
		applicationName = prop.getProperty("applicationName");
		String title = applicationName + " | " + version;
		
		Display display = new Display();
		shell = new Shell(display);
		shell.setLayout(new GridLayout());
		
		ApplicationContext applicationContext = new ApplicationContext(shell, appProp);	
		new MainPanel(applicationContext);
		
		shell.setText(title);
		//shell.pack();
		shell.open();
		
		while(!shell.isDisposed()) {
			if(display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}