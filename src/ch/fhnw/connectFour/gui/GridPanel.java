package ch.fhnw.connectFour.gui;

import org.eclipse.swt.widgets.Shell;

import ch.fhnw.connectFour.application.ApplicationContext;

/**
 * 
 * @author Michel Heiniger
 *
 */
public class GridPanel {
	
	private Shell shell;
	
	public GridPanel(ApplicationContext applicationContext) {
		shell = applicationContext.getShell();
	}

}
