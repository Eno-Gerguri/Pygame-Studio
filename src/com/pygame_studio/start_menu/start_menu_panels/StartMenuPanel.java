/**
 * The main panel of the StartMenuFrame.
 */
package com.pygame_studio.start_menu.start_menu_panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import com.pygame_studio.settings.Settings;
import com.pygame_studio.start_menu.start_menu_panels.start_menu_panel_components.ConfigureComboBox;
import com.pygame_studio.start_menu.start_menu_panels.start_menu_panel_components.CreateNewProjectButton;
import com.pygame_studio.start_menu.start_menu_panels.start_menu_panel_components.HelpComboBox;
import com.pygame_studio.start_menu.start_menu_panels.start_menu_panel_components.OpenProjectButton;
import com.pygame_studio.start_menu.start_menu_panels.start_menu_panel_components.PygameLogo;
import com.pygame_studio.start_menu.start_menu_panels.start_menu_panel_components.PygameStudioTitle;
import com.pygame_studio.start_menu.start_menu_panels.start_menu_panel_components.PygameStudioVersion;

/**
 * @author Eno Gerguri
 *
 */
public class StartMenuPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2583785237333482974L;
	private Settings settings;
	private GridBagLayout gridBagLayout;
	private GridBagConstraints gridBagConstraints;

	/**
	 * Sets all of the attributes of the JPanel.
	 */
	public StartMenuPanel(Settings settings) {
		this.settings = settings;
		this.gridBagLayout = new GridBagLayout();
		this.gridBagConstraints = new GridBagConstraints();
		
		this.setLayout(this.gridBagLayout);
		
		this.addComponents();
	}
	
	/**
	 * Adds all of the components associated with this "StartMenuPanel" to the frame.
	 */
	private void addComponents() {
		this.add(new PygameLogo(this.settings, this.gridBagLayout, this.gridBagConstraints));
		this.add(new PygameStudioTitle(this.settings, this.gridBagLayout, this.gridBagConstraints));
		this.add(new PygameStudioVersion(this.settings, this.gridBagLayout, this.gridBagConstraints));
		this.add(new CreateNewProjectButton(this.settings, this.gridBagLayout, this.gridBagConstraints));
		this.add(new OpenProjectButton(this.settings, this.gridBagLayout, this.gridBagConstraints));
		this.add(new HelpComboBox(this.settings, this.gridBagLayout, this.gridBagConstraints));
		this.add(new ConfigureComboBox(this.settings, this.gridBagLayout, this.gridBagConstraints));
	}

}
