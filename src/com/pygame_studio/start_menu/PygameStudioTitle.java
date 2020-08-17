/**
 * 
 */
package com.pygame_studio.start_menu;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import com.pygame_studio.settings.Settings;

/**
 * @author Eno Gerguri
 *
 */
public class PygameStudioTitle extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7190000329954410112L;
	private final String PYGAME_STUDIO_TITLE = "Pygame Studio";
	private Font defaultFont;
	private final int FONT_SIZE = 48;
	private final int GRIDX = 1;
	private final int GRIDY = 2;
	private final int GRIDWIDTH = 1;
	private final int GRIDHEIGHT = 1;

	/**
	 * Sets the attributes of the PygameStudioTitle as well as the given gridBagConstraints.
	 */
	public PygameStudioTitle(Settings settings, GridBagLayout gridBagLayout, GridBagConstraints gridBagConstraints) {
		super();
		
		this.defaultFont = new Font(settings.getAppearanceAndBehavior().getFont().getFontDirectory(),
									settings.getAppearanceAndBehavior().getFont().getFontStyle(),
									this.FONT_SIZE);
		
		this.setText(this.PYGAME_STUDIO_TITLE);
		this.setFont(this.defaultFont);
		
		gridBagConstraints.gridx = this.GRIDX;
		gridBagConstraints.gridy = this.GRIDY;
		
		gridBagConstraints.gridwidth = this.GRIDWIDTH;
		gridBagConstraints.gridheight = this.GRIDHEIGHT;
		
		gridBagLayout.setConstraints(this, gridBagConstraints);
	}

}
