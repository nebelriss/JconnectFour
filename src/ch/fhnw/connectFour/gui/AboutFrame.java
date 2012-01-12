package ch.fhnw.connectFour.gui;

import java.awt.Toolkit;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JLabel;

import ch.fhnw.connectFour.application.ApplicationContext;

/**
 * 
 * @author crashdown
 *
 */
@SuppressWarnings("serial")
public class AboutFrame extends JFrame {
	
	Properties lang;
	Properties prop;
	int width;
	int height;
	
	private JLabel titleLabel;
	private JLabel autorLabel;
	private JLabel versionLabel;
	//private JLabel licenceLabel;
	
	/**
	 * 
	 * @param applicationContext
	 */
	public AboutFrame(ApplicationContext applicationContext) {
		
		lang = applicationContext.getLanguage();
		prop = applicationContext.getProperties();
		
		width = 400;
		height = 300;
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int x = (toolkit.getScreenSize().width - width) / 2;
		int y = (toolkit.getScreenSize().height - height) / 2;

		initComponents();
		
		setBounds(x, y, width, height);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}
	
	/**
	 * 
	 */
	private void initComponents() {
		
		titleLabel = new JLabel(prop.getProperty("applicationName"));
		add(titleLabel);
		
		autorLabel = new JLabel(prop.getProperty("autor"));
		add(autorLabel);
		
		versionLabel = new JLabel(prop.getProperty("version"));
		add(versionLabel);
		
	}

}
