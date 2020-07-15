/**
 * 
 */
package com.pygame_studio.create_new_project_menu;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.pygame_studio.create_new_project_menu.create_new_project_menu.create_new_project_menu_panels.templates_panel.TemplatesPanel;
import com.pygame_studio.settings.Settings;

/**
 * @author Eno Gerguri
 *
 */
public class CreateNewProjectMenuFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7226033662361158711L;
	private List<JPanel> CreateNewProjectMenuPanels;
	private String frameTitle = "Create a Pygame Studio Project";
	private int closeOperation = WindowConstants.DISPOSE_ON_CLOSE;

	/**
	 * Sets its own attributes to do with the CreateNewProjectMenuFrame.
	 */
	public CreateNewProjectMenuFrame(Settings settings) {
		super();
		
		this.setTitle(this.frameTitle);
		Image pygameLogo = new ImageIcon(settings.getIcons().get("Pygame-Logo")).getImage();
		Image scaledPygameLogoImage = pygameLogo.getScaledInstance(40, 40, Image.SCALE_SMOOTH);  // 40x40 pixels is the size of the displayed Desktop icon when running the program
		pygameLogo = scaledPygameLogoImage;
		this.setIconImage(pygameLogo);
		this.setDefaultCloseOperation(this.closeOperation);
		
		this.setCreateNewProjectMenuPanels(settings);  // Adds all of the panels for the StartMenuFrame
		
		this.displayCreateNewProjectMenuFrame(this.CreateNewProjectMenuPanels);
	}
	
	/**
	 * Adds all of the panels for the CreateNewProjectMenuPanels.
	 * @param settings - A Settings object to make the panels that are needed.
	 */
	private void setCreateNewProjectMenuPanels(Settings settings) {
		this.CreateNewProjectMenuPanels = new ArrayList<JPanel>();
		this.CreateNewProjectMenuPanels.add(new TemplatesPanel(settings));
	}
	
	/**
	 * Handles displaying the frame and also adding the panels to the frame.
	 * @param startMenuPanels - All of the panels that need to be added to the StartMenuFrame.
	 */
	public void displayCreateNewProjectMenuFrame(List<JPanel> CreateNewProjectMenuPanels) {
		for (JPanel panel : CreateNewProjectMenuPanels) {
			this.add(panel);
		}
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setVisible(true);
	}

}
