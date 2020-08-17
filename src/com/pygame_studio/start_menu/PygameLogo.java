/**
 * 
 */
package com.pygame_studio.start_menu;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.pygame_studio.settings.Settings;

/**
 * @author Eno Gerguri
 *
 */
public class PygameLogo extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7218074513102145058L;
	private final ImageIcon PYGAME_LOGO;
	private final int GRIDX = 1;
	private final int GRIDY = 0;
	private final int GRIDWIDTH = 1;
	private final int GRIDHEIGHT = 2;

	/**
	 * Sets the attributes of the PygameLogo as well as the given gridBagConstraints.
	 */
	public PygameLogo(Settings settings, GridBagLayout gridBagLayout, GridBagConstraints gridBagConstraints) {
		super();
		
		this.PYGAME_LOGO = new ImageIcon(settings.getIcons().get("Pygame-Logo"));
		
		this.setIcon(this.PYGAME_LOGO);
		
		gridBagConstraints.gridx = this.GRIDX;
		gridBagConstraints.gridy = this.GRIDY;
		
		gridBagConstraints.gridwidth = this.GRIDWIDTH;
		gridBagConstraints.gridheight = this.GRIDHEIGHT;
		
		gridBagLayout.setConstraints(this, gridBagConstraints);
	}

}
