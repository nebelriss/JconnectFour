package ch.fhnw.connectFour.gui;

import java.awt.MenuBar;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.eclipse.swt.widgets.Shell;

import ch.fhnw.connectFour.application.ApplicationContext;

@SuppressWarnings("serial")
public class MainPanel extends JPanel{
	
	private ApplicationContext applicationContext;
	private Properties prop;
	
	public MainPanel(ApplicationContext applicationContext) {
		
		this.applicationContext = applicationContext;
		
		initComponents();
		
	}

	private void initComponents() {
		new MainMenuBar(applicationContext);
		new GridPanel(applicationContext);
	}

}
