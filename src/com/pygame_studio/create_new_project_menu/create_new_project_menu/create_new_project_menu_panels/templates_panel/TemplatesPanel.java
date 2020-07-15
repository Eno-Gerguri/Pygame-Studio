/**
 * 
 */
package com.pygame_studio.create_new_project_menu.create_new_project_menu.create_new_project_menu_panels.templates_panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
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

	/**
	 * 
	 */
	public TemplatesPanel(Settings settings) {
		this.settings = settings;
		this.gridBagLayout = new GridBagLayout();
		this.gridBagConstraints = new GridBagConstraints();
		
		this.setLayout(this.gridBagLayout);
		
		this.addComponents();
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
