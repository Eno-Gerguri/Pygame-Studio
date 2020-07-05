/**
 * 
 */
package com.pygame_studio.start_menu.start_menu_panels.start_menu_panel_components;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.pygame_studio.settings.Settings;

/**
 * @author Eno Gerguri
 *
 */
public class OpenProjectButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5069772708671414910L;
	private final String OPEN_PROJECT_TEXT = "Open Project";
	private final Color GRAY = new Color(110, 110, 110);
	private Font defaultFont;
	private final int FONT_SIZE = 16;
	private ImageIcon grayFolder;
	private ImageIcon blackFolder;
	private final int GRIDX = 1;
	private final int GRIDY = 5;
	private final int GRID_WIDTH = 1;
	private final int GRID_HEIGHT = 1;
	private final Insets INSETS = new Insets(0, 0, 15, 0);

	/**
	 * Sets the attributes of the OpenProjectButton as well as the given gridBagConstraints.
	 */
	public OpenProjectButton(Settings settings, GridBagLayout gridBagLayout, GridBagConstraints gridBagConstraints) {
		super();
		
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("Open a Project!");
			}
		});

		this.defaultFont = new Font(settings.getAppearanceAndBehavior().getFont().getFontDirectory(),
									settings.getAppearanceAndBehavior().getFont().getFontStyle(),
									this.FONT_SIZE);
		
		this.grayFolder = new ImageIcon(settings.getIcons().get("Gray-Folder"));
		Image grayPlus = this.grayFolder.getImage();
		Image scaledGrayPlus = grayPlus.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		this.grayFolder = new ImageIcon(scaledGrayPlus);
		
		this.setForeground(this.GRAY);
		this.setText(this.OPEN_PROJECT_TEXT);
		this.setFont(this.defaultFont);
		this.setIcon(this.grayFolder);
		
		gridBagConstraints.gridx = this.GRIDX;
		gridBagConstraints.gridy = this.GRIDY;
		
		gridBagConstraints.gridwidth = this.GRID_WIDTH;
		gridBagConstraints.gridheight = this.GRID_HEIGHT;
		gridBagConstraints.insets = this.INSETS;
		
		gridBagLayout.setConstraints(this, gridBagConstraints);
	}

}
