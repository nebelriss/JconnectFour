package ch.fhnw.connectFour.gui.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import ch.fhnw.connectFour.application.ApplicationContext;
import ch.fhnw.connectFour.gui.MenuBar;

public class MenuBarController {
	
	public MenuBarController(ApplicationContext applicationContext, MenuBar menubar) {
		
		menubar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

}
