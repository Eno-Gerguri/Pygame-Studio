/**
 * 
 */
package com.pygame_studio.create_new_project_menu.create_new_project_menu.create_new_project_menu_panels.project_details_panel.project_details_panel_components;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;

import com.pygame_studio.settings.Settings;

/**
 * @author Eno Gerguri
 *
 */
public class DetailsLabel extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -880029947517590976L;
	private final String DETAILS_TEXT = "Details";
	private final Color GRAY = new Color(110, 110, 110);
	private Font defaultFont;
	private final int FONT_SIZE = 16;
	private final int GRIDX = 0;
	private final int GRIDY = 0;
	private final int GRIDWIDTH = 1;
	private final int GRIDHEIGHT = 1;
	private final Insets INSETS = new Insets(0, 25, 0, 0);

	/**
	 * 
	 */
	public DetailsLabel(Settings settings, GridBagLayout gridBagLayout, GridBagConstraints gridBagConstraints) {
		super();
		
		this.defaultFont = new Font(settings.getAppearanceAndBehavior().getFont().getFontDirectory(),
				settings.getAppearanceAndBehavior().getFont().getFontStyle(),
				this.FONT_SIZE);
		
		this.setText(this.DETAILS_TEXT);
		this.setFont(this.defaultFont);
		this.setForeground(this.GRAY);
		
		gridBagConstraints.gridx = this.GRIDX;
		gridBagConstraints.gridy = this.GRIDY;
		
		gridBagConstraints.gridwidth = this.GRIDWIDTH;
		gridBagConstraints.gridheight = this.GRIDHEIGHT;
		gridBagConstraints.insets = this.INSETS;
		
		gridBagLayout.setConstraints(this, gridBagConstraints);
	}

}
