package ch.fhnw.connectFour.gui.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Properties;
import java.util.logging.Logger;

import javax.swing.JFrame;

import ch.fhnw.connectFour.application.ApplicationContext;
import ch.fhnw.connectFour.gui.GridPanel;
import ch.fhnw.connectFour.logic.FieldModel;
import ch.fhnw.connectFour.logic.GameController;
import ch.fhnw.connectFour.persistance.FieldOwner;

public class GridPanelController {
	
	private static Logger log = Logger.getLogger("ch.fhnw.connectFour");
	
	public GridPanelController(ApplicationContext applicationController, GridPanel gridPanel) {
		
		final GameController gameController = applicationController.getGamecontroller();
		final FieldModel field = applicationController.getFieldModel();
		final Properties prop = applicationController.getProperties();
		final JFrame mainFrame = applicationController.getMainFrame();
		
		gridPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int boardWidth = new Integer(prop.getProperty("boardWidth"));
				int boardHeight = new Integer(prop.getProperty("boardHeight"));
				
				int widthStep = mainFrame.getSize().width / boardWidth;
				int heightStep = mainFrame.getSize().height / boardHeight;
				
				int x = e.getX() / widthStep;
				int y = e.getY() / heightStep;
				
				if (gameController.canPlayerPlay() == true) {
					field.setFieldChanged(x, y, FieldOwner.red);
					gameController.playerPlayed(true);
					log.info("field set");
				}
			}
			
		});
		
	}

}
