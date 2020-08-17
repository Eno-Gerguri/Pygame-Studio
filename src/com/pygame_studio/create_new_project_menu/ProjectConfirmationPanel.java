/**
 * 
 */
package com.pygame_studio.create_new_project_menu;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import com.pygame_studio.settings.Settings;

/**
 * @author Eno Gerguri
 *
 */
public class ProjectConfirmationPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8574364121714951430L;
	private Settings settings;
	private GridBagLayout gridBagLayout;
	private GridBagConstraints gridBagConstraints;
	private final Color LIGHT_GRAY = new Color(242, 242, 242);
	private final int GRIDX = 0;
	private final int GRIDY = 1;
	private final int GRIDWIDTH = 2;
	private final int GRIDHEIGHT = 1;
	private final Insets INSETS = new Insets(25, 0, 0, 0);

	/**
	 * 
	 */
	public ProjectConfirmationPanel(Settings settings, GridBagLayout frameGridBagLayout, GridBagConstraints frameGridBagConstraints) {
		this.settings = settings;
		this.gridBagLayout = new GridBagLayout();
		this.gridBagConstraints = new GridBagConstraints();
		
		this.setBackground(this.LIGHT_GRAY);
		this.setLayout(this.gridBagLayout);
		
		this.addComponents();
		
		frameGridBagConstraints.gridx = this.GRIDX;
		frameGridBagConstraints.gridy = this.GRIDY;
		
		frameGridBagConstraints.gridwidth = this.GRIDWIDTH;
		frameGridBagConstraints.gridheight = this.GRIDHEIGHT;
		frameGridBagConstraints.insets = this.INSETS;
		
		frameGridBagLayout.setConstraints(this, frameGridBagConstraints);
	}
	
	/**
	 * Adds all of the components associated with this "ProjectConfirmationPanel" to the panel.
	 */
	private void addComponents() {
		this.add(new CreateProjectButton(this.settings, this.gridBagLayout, this.gridBagConstraints));
		this.add(new CancelProjectButton(this.settings, this.gridBagLayout, this.gridBagConstraints));
	}

}
