/**
 * 
 */
package com.pygame_studio.create_new_project_menu;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.pygame_studio.create_new_project_menu.create_new_project_menu.create_new_project_menu_panels.project_details_panel.ProjectDetailsPanel;
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
	private JPanel containerPanel;
	private GridBagLayout gridBagLayout;
	private GridBagConstraints gridBagConstraints;
	private String frameTitle = "Create a Pygame Studio Project";
	private int closeOperation = WindowConstants.DISPOSE_ON_CLOSE;

	/**
	 * Sets its own attributes to do with the CreateNewProjectMenuFrame.
	 */
	public CreateNewProjectMenuFrame(Settings settings) {
		super();
		
		this.gridBagLayout = new GridBagLayout();
		this.gridBagConstraints = new GridBagConstraints();
		
		this.setTitle(this.frameTitle);
		Image pygameLogo = new ImageIcon(settings.getIcons().get("Pygame-Logo")).getImage();
		Image scaledPygameLogoImage = pygameLogo.getScaledInstance(40, 40, Image.SCALE_SMOOTH);  // 40x40 pixels is the size of the displayed Desktop icon when running the program
		pygameLogo = scaledPygameLogoImage;
		this.setIconImage(pygameLogo);
		this.setDefaultCloseOperation(this.closeOperation);
		this.containerPanel = new JPanel();

		this.displayCreateNewProjectMenuFrame(settings);
	}
	
	/**
	 * Handles displaying the frame and also adding the panels to the frame.
	 * @param startMenuPanels - All of the panels that need to be added to the StartMenuFrame.
	 */
	public void displayCreateNewProjectMenuFrame(Settings settings) {
		this.containerPanel.setLayout(new GridBagLayout());
		this.containerPanel.setBackground(Color.WHITE);
		
		this.containerPanel.add(new TemplatesPanel(settings, this.gridBagLayout, this.gridBagConstraints));
		this.containerPanel.add(new ProjectDetailsPanel(settings, this.gridBagLayout, this.gridBagConstraints));
		
		this.add(this.containerPanel);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setVisible(true);
	}

}
