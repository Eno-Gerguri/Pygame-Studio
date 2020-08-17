/**
 * 
 */
package com.pygame_studio.start_menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import com.pygame_studio.settings.Settings;

/**
 * @author Eno Gerguri
 *
 */
public class PygameStudioVersion extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8519503099242798050L;
	private final String PYGAME_STUDIO_VERSION = "2020.6";
	private final Color GRAY = new Color(110, 110, 110);
	private Font defaultFont;
	private final int FONT_SIZE = 36;
	private final int GRIDX = 1;
	private final int GRIDY = 3;
	private final int GRIDWIDTH = 1;
	private final int GRIDHEIGHT = 1;

	/**
	 * Sets the attributes of the PygameStudioVersion as well as the given gridBagConstraints.
	 */
	public PygameStudioVersion(Settings settings, GridBagLayout gridBagLayout, GridBagConstraints gridBagConstraints) {
		super();
		
		this.defaultFont = new Font(settings.getAppearanceAndBehavior().getFont().getFontDirectory(),
									settings.getAppearanceAndBehavior().getFont().getFontStyle(),
									this.FONT_SIZE);
		
		this.setForeground(this.GRAY);
		this.setText(this.PYGAME_STUDIO_VERSION);
		this.setFont(this.defaultFont);
		
		gridBagConstraints.gridx = this.GRIDX;
		gridBagConstraints.gridy = this.GRIDY;
		
		gridBagConstraints.gridwidth = this.GRIDWIDTH;
		gridBagConstraints.gridheight = this.GRIDHEIGHT;
		
		gridBagLayout.setConstraints(this, gridBagConstraints);
	}

}
