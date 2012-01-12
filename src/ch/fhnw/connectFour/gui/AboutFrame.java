package ch.fhnw.connectFour.gui;

import java.awt.Toolkit;

import javax.swing.JFrame;

import ch.fhnw.connectFour.application.ApplicationContext;

public class AboutFrame extends JFrame {
	
	int width;
	int height;
	
	public AboutFrame(ApplicationContext applicationContext) {
		
		width = 400;
		height = 300;
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int x = (toolkit.getScreenSize().width - width) / 2;
		int y = (toolkit.getScreenSize().height - height) / 2;
		
		setBounds(x, y, width, height);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}

}
