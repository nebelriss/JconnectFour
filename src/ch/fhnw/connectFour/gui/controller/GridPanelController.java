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
		
		final int border = new Integer(prop.getProperty("border"));
		final int width = mainFrame.getSize().width;
		final int height = mainFrame.getSize().height;
		
		gridPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int boardWidth = new Integer(prop.getProperty("boardWidth"));
				int boardHeight = new Integer(prop.getProperty("boardHeight"));
				
				int widthStep = (mainFrame.getSize().width - (2 * border))  / boardWidth;
				int heightStep = (mainFrame.getSize().height - (2 * border)) / boardHeight;
				
				int x = (e.getX() - (2 * border)) / widthStep + 1;
				int y = (e.getY() - (2 * border)) / heightStep;
				
				y = boardHeight - y;
				System.out.println(x + "  " + y);
				
				if (gameController.canPlayerPlay() == true) {

					field.setFieldChanged(x, y, FieldOwner.red);
					
					log.info("field set");
				}
			}
			
		});
		
	}

}
