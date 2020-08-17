/**
 * 
 */
package com.pygame_studio.start_menu;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;

import com.pygame_studio.settings.Settings;

/**
 * @author Eno Gerguri
 *
 */
public class ConfigureComboBox extends JComboBox<String> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7199339908722933942L;
	private final String CONFIGURE_TEXT = "Configure";
	private Font defaultFont;
	private final int FONT_SIZE = 16;
	private final int GRIDX = 1;
	private final int GRIDY = 6;
	private final int GRID_WIDTH = 1;
	private final int GRID_HEIGHT = 1;
	private final Insets INSETS = new Insets(0, 0, 0, 135);

	/**
	 * Sets the attributes of the ConfigureComboBox as well as the given gridBagConstraints.
	 */
	public ConfigureComboBox(Settings settings, GridBagLayout gridBagLayout, GridBagConstraints gridBagConstraints) {
		super();

		this.addItem(this.CONFIGURE_TEXT);
		
		this.defaultFont = new Font(settings.getAppearanceAndBehavior().getFont().getFontDirectory(),
				settings.getAppearanceAndBehavior().getFont().getFontStyle(),
				this.FONT_SIZE);
		
		// this.setForeground(settings.GRAY);
		// this.setText(this.CONFIGURE_TEXT);
		this.setFont(this.defaultFont);
		
		gridBagConstraints.gridx = this.GRIDX;
		gridBagConstraints.gridy = this.GRIDY;
		
		gridBagConstraints.gridwidth = this.GRID_WIDTH;
		gridBagConstraints.gridheight = this.GRID_HEIGHT;
		gridBagConstraints.insets = this.INSETS;
		
		gridBagConstraints.anchor = GridBagConstraints.LAST_LINE_END;
		
		gridBagLayout.setConstraints(this, gridBagConstraints);
	}

}
