/**
 * Is the frame that guides the user to make or open a project.
 */
package com.pygame_studio.start_menu;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.pygame_studio.settings.Settings;

/**
 * @author Eno Gerguri
 *
 */
public class StartMenuFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2887070921541651804L;
	private List<JPanel> startMenuPanels;
	private String frameTitle = "Welcome to Pygame Studio";
	private int closeOperation = WindowConstants.DISPOSE_ON_CLOSE;

	/**
	 * Sets its own attributes to do with the StartMenuFrame.
	 */
	public StartMenuFrame(Settings settings) {
		super();
		
		this.setTitle(this.frameTitle);
		Image pygameLogo = new ImageIcon(settings.getIcons().get("Pygame-Logo")).getImage();
		Image scaledPygameLogoImage = pygameLogo.getScaledInstance(40, 40, Image.SCALE_SMOOTH);  // 40x40 pixels is the size of the displayed Desktop icon when running the program
		pygameLogo = scaledPygameLogoImage;
		this.setIconImage(pygameLogo);
		this.setDefaultCloseOperation(this.closeOperation);
		
		this.setStartMenuPanels(settings);  // Adds all of the panels for the StartMenuFrame
		
		this.displayStartMenuFrame(this.startMenuPanels);
	}
	
	/**
	 * Adds all of the panels for the StartMenuPanels.
	 * @param settings - A Settings object to make the panels that are needed.
	 */
	private void setStartMenuPanels(Settings settings) {
		this.startMenuPanels = new ArrayList<JPanel>();
		this.startMenuPanels.add(new StartMenuPanel(settings));
	}

	/**
	 * Handles displaying the frame and also adding the panels to the frame.
	 * @param startMenuPanels - All of the panels that need to be added to the StartMenuFrame.
	 */
	public void displayStartMenuFrame(List<JPanel> startMenuPanels) {
		for (JPanel panel : startMenuPanels) {
			this.add(panel);
		}
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}

}
