/**
 * 
 */
package com.pygame_studio.create_new_project_menu.create_new_project_menu.create_new_project_menu_panels.templates_panel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import com.pygame_studio.create_new_project_menu.create_new_project_menu.create_new_project_menu_panels.templates_panel.templates_panel_components.PygameFunctionsToggleButton;
import com.pygame_studio.create_new_project_menu.create_new_project_menu.create_new_project_menu_panels.templates_panel.templates_panel_components.TemplatesLabel;
import com.pygame_studio.settings.Settings;

/**
 * @author Eno Gerguri
 *
 */
public class TemplatesPanel extends JPanel {
	
	private Settings settings;
	private GridBagLayout gridBagLayout;
	private GridBagConstraints gridBagConstraints;
	private final int GRIDX = 0;
	private final int GRIDY = 0;
	private final int GRIDWIDTH = 1;
	private final int GRIDHEIGHT = 1;
	private final Insets INSETS = new Insets(0, 0, 0, 0);

	/**
	 * 
	 */
	public TemplatesPanel(Settings settings, GridBagLayout gridBagLayout, GridBagConstraints gridBagConstraints) {
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
	 * Adds all of the components associated with this "TemplatesPanel" to the panel.
	 */
	private void addComponents() {
		this.add(new TemplatesLabel(this.settings, this.gridBagLayout, this.gridBagConstraints));
		
		ButtonGroup templates = new ButtonGroup();
		JToggleButton pygameFunctionsToggleButton = new PygameFunctionsToggleButton(this.settings, this.gridBagLayout, this.gridBagConstraints);
		templates.add(pygameFunctionsToggleButton);
		this.add(pygameFunctionsToggleButton);
	}

}
