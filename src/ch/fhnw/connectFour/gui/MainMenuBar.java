package ch.fhnw.connectFour.gui;

import java.util.Properties;
import java.util.logging.Logger;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import ch.fhnw.connectFour.application.ApplicationContext;

public class MainMenuBar {

	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");
	private Properties lang;
	private Shell shell;
	private Menu menubar;
	
	/**
	 * 
	 * @param applicationContext
	 */
	public MainMenuBar(ApplicationContext applicationContext) {
		super();
		
		lang = applicationContext.getLanguage();
		shell = applicationContext.getShell();
		
		menubar = new Menu(shell, SWT.BAR);
		
		fileMenu();
		helpMenu();
		
		shell.setMenuBar(menubar);
		
		log.info("MenuBar loaded.");
	}

	private void fileMenu() {
		
		// file menu
		Menu fileMenu = new Menu(menubar);
		
		MenuItem fileItem = new MenuItem(menubar, SWT.CASCADE | SWT.NO_RADIO_GROUP);
		fileItem.setText(lang.getProperty("fileMenu"));
		fileItem.setMenu(fileMenu);
		
		// file -> new
		MenuItem fileNew = new MenuItem(fileMenu, SWT.CASCADE | SWT.NO_RADIO_GROUP);
		fileNew.setText(lang.getProperty("fileNew"));
		
		// file -> exit
		MenuItem fileExit = new MenuItem(fileMenu, SWT.NONE);
		fileExit.setText(lang.getProperty("fileExit"));
		
		log.info("file menu loaded");
		
	}
	
	private void helpMenu() {
		
		// help menu
		Menu helpMenu = new Menu(menubar);
		
		MenuItem helpItem = new MenuItem(menubar, SWT.CASCADE | SWT.NO_RADIO_GROUP);
		helpItem.setText(lang.getProperty("helpMenu"));
		helpItem.setMenu(helpMenu);
		
		// help -> about
		MenuItem helpAbout = new MenuItem(helpMenu, SWT.CASCADE | SWT.NO_RADIO_GROUP);
		helpAbout.setText(lang.getProperty("helpAbout"));
		
	}

}
