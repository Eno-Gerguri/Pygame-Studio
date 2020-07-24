/**
 * 
 */
package com.pygame_studio.create_new_project_menu.create_new_project_menu.create_new_project_menu_panels.project_confirmation_panel.project_confirmation_panel_components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import com.pygame_studio.settings.Settings;

/**
 * @author Eno Gerguri
 *
 */
public class CreateProjectButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1689288431123560180L;
	private final String CREATE_PROJECT_TEXT = "Create";
	private final Color TURQUOISE = new Color(0, 168, 243);
	private Font defaultFont;
	private final int FONT_SIZE = 16;
	private final int GRIDX = 1;
	private final int GRIDY = 0;
	private final int GRID_WIDTH = 1;
	private final int GRID_HEIGHT = 1;
	private final Insets INSETS = new Insets(10, 910, 10, 10);

	/**
	 * 
	 */
	public CreateProjectButton(Settings settings, GridBagLayout gridBagLayout, GridBagConstraints gridBagConstraints) {
		super();
		
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("Create Project!");
				Window win = SwingUtilities.getWindowAncestor((Component) event.getSource());
	            if (win != null) {
	                win.dispose();  // dispose of it
	            }
			}
		});
		
		this.defaultFont = new Font(settings.getAppearanceAndBehavior().getFont().getFontDirectory(),
				settings.getAppearanceAndBehavior().getFont().getFontStyle(),
				this.FONT_SIZE);
		
		this.setForeground(Color.WHITE);
		this.setBackground(this.TURQUOISE);
		this.setText(this.CREATE_PROJECT_TEXT);
		this.setFont(this.defaultFont);
		
		gridBagConstraints.gridx = this.GRIDX;
		gridBagConstraints.gridy = this.GRIDY;
		
		gridBagConstraints.gridwidth = this.GRID_WIDTH;
		gridBagConstraints.gridheight = this.GRID_HEIGHT;
		gridBagConstraints.insets = this.INSETS;
		
		gridBagLayout.setConstraints(this, gridBagConstraints);
	}

}
