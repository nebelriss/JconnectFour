package ch.fhnw.connectFour.gui;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Properties;
import java.util.logging.Logger;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import ch.fhnw.connectFour.application.ApplicationContext;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar{
	
	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");
	private Properties lang;

	public MenuBar(ApplicationContext applicationContext) {
		super();
		// properties
		lang = applicationContext.getLanguage();
		
		
		fileMenu();
		helpMenu();
		log.info("MenuBar loaded");
	}

	private void fileMenu() {
		JMenu fileMenu = new JMenu(lang.getProperty("fileMenu"));
		this.add(fileMenu);
		
		// File -> New
		JMenuItem fileNewItem = new JMenuItem(lang.getProperty("fileNew"));
		fileMenu.add(fileNewItem);
		// keystroke
		fileNewItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		
		// File -> Exit
		JMenuItem fileExitItem = new JMenuItem(lang.getProperty("fileExit"));
		fileMenu.add(fileExitItem);
		// keystroke
		fileExitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
		
	}
	
	private void helpMenu() {
		JMenu helpMenu = new JMenu(lang.getProperty("helpMenu"));
		this.add(helpMenu);
		
		// Help -> About
		JMenuItem helpAboutItem = new JMenuItem(lang.getProperty("helpAbout"));
		helpMenu.add(helpAboutItem);
		
	}

}
