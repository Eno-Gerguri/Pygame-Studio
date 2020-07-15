/**
 * 
 */
package com.pygame_studio.start_menu.start_menu_panels.start_menu_panel_components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import com.pygame_studio.create_new_project_menu.CreateNewProjectMenu;
import com.pygame_studio.settings.Settings;

/**
 * @author Eno Gerguri
 *
 */
public class CreateNewProjectButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -813487267284039767L;
	private final String CREATE_NEW_PROJECT_TEXT = "Create New Project";
	private final Color GRAY = new Color(110, 110, 110);
	private Font defaultFont;
	private final int FONT_SIZE = 16;
	private ImageIcon grayPlus;
	private ImageIcon blackPlus;
	private final int GRIDX = 1;
	private final int GRIDY = 4;
	private final int GRIDWIDTH = 1;
	private final int GRIDHEIGHT = 1;
	private final Insets INSETS = new Insets(10, 0, 0, 0);

	/**
	 * Sets the attributes of the CreateNewProjectButton as well as the given gridBagConstraints.
	 */
	public CreateNewProjectButton(Settings settings, GridBagLayout gridBagLayout, GridBagConstraints gridBagConstraints) {
		super();
		
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Window win = SwingUtilities.getWindowAncestor((Component) event.getSource());
	            if (win != null) {
	                win.dispose();  // dispose of it
	            }
	            
				new CreateNewProjectMenu(settings);
			}
		});
		
		this.defaultFont = new Font(settings.getAppearanceAndBehavior().getFont().getFontDirectory(),
									settings.getAppearanceAndBehavior().getFont().getFontStyle(),
									this.FONT_SIZE);
		
		this.grayPlus = new ImageIcon(settings.getIcons().get("Gray-Plus"));
		Image grayPlus = this.grayPlus.getImage();
		Image scaledGrayPlus = grayPlus.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		this.grayPlus = new ImageIcon(scaledGrayPlus);
		
		this.blackPlus = new ImageIcon(settings.getIcons().get("Black-Plus"));
		Image blackPlus = this.blackPlus.getImage();
		Image scaledBlackPlus = blackPlus.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		this.blackPlus = new ImageIcon(scaledBlackPlus);
		
		this.setForeground(this.GRAY);
		this.setText(this.CREATE_NEW_PROJECT_TEXT);
		this.setFont(this.defaultFont);
		this.setIcon(this.grayPlus);
		
		gridBagConstraints.gridx = this.GRIDX;
		gridBagConstraints.gridy = this.GRIDY;
		
		gridBagConstraints.gridwidth = this.GRIDWIDTH;
		gridBagConstraints.gridheight = this.GRIDHEIGHT;
		gridBagConstraints.insets = this.INSETS;
		
		gridBagLayout.setConstraints(this, gridBagConstraints);
	}

}
