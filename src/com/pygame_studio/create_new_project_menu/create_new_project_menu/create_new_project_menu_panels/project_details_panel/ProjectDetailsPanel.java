/**
 * 
 */
package com.pygame_studio.create_new_project_menu.create_new_project_menu.create_new_project_menu_panels.project_details_panel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import com.pygame_studio.create_new_project_menu.create_new_project_menu.create_new_project_menu_panels.project_details_panel.project_details_panel_components.DetailsLabel;
import com.pygame_studio.create_new_project_menu.create_new_project_menu.create_new_project_menu_panels.project_details_panel.project_details_panel_components.ProjectDirectoryTextField;
import com.pygame_studio.create_new_project_menu.create_new_project_menu.create_new_project_menu_panels.project_details_panel.project_details_panel_components.ProjectNameTextField;
import com.pygame_studio.settings.Settings;

/**
 * @author Eno Gerguri
 *
 */
public class ProjectDetailsPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3021948179589920068L;
	private Settings settings;
	private GridBagLayout gridBagLayout;
	private GridBagConstraints gridBagConstraints;
	private final int GRIDX = 1;
	private final int GRIDY = 0;
	private final int GRIDWIDTH = 1;
	private final int GRIDHEIGHT = 1;
	private final Insets INSETS = new Insets(0, 0, 0, 0);

	/**
	 * 
	 */
	public ProjectDetailsPanel(Settings settings, GridBagLayout gridBagLayout, GridBagConstraints gridBagConstraints) {
		this.settings = settings;
		this.gridBagLayout = new GridBagLayout();
		this.gridBagConstraints = new GridBagConstraints();
		
		this.setBackground(Color.WHITE);
		this.setLayout(this.gridBagLayout);
		
		this.addComponents();
		
		gridBagConstraints.gridx = this.GRIDX;
		gridBagConstraints.gridy = this.GRIDY;
		
		gridBagConstraints.gridwidth = this.GRIDWIDTH;
		gridBagConstraints.gridheight = this.GRIDHEIGHT;
		gridBagConstraints.insets = this.INSETS;
		
		gridBagLayout.setConstraints(this, gridBagConstraints);
	}
	
	/**
	 * Adds all of the components associated with this "ProjectDetailsPanel" to the panel.
	 */
	private void addComponents() {
		this.add(new DetailsLabel(this.settings, this.gridBagLayout, this.gridBagConstraints));
		this.add(new ProjectNameTextField(this.settings, this.gridBagLayout, this.gridBagConstraints));
		this.add(new ProjectDirectoryTextField(this.settings, this.gridBagLayout, this.gridBagConstraints));
	}

}
