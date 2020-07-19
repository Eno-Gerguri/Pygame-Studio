/**
 * 
 */
package com.pygame_studio.create_new_project_menu.create_new_project_menu.create_new_project_menu_panels.project_details_panel.project_details_panel_components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.pygame_studio.settings.Settings;

/**
 * @author Eno Gerguri
 *
 */
public class ProjectNameTextField extends JTextField {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7773248597327149807L;
	private final String PROJECT_NAME_TEXT = "Project Name*";
	private final Color GRAY = new Color(110, 110, 110);
	private final Color TURQUOISE = new Color(0, 168, 243);
	private Border grayBorder;
	private Border turquoiseBorder;
	private Font defaultFont;
	private final int FONT_SIZE = 14;
	private final int GRIDX = 0;
	private final int GRIDY = 1;
	private final int GRIDWIDTH = 2;
	private final int GRIDHEIGHT = 1;
	private final Insets INSETS = new Insets(25, 25, 0, 0);

	/**
	 * 
	 */
	public ProjectNameTextField(Settings settings, GridBagLayout gridBagLayout, GridBagConstraints gridBagConstraints) {
		super();
		
		this.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent event) {
				ProjectNameTextField projectNameTextField = (ProjectNameTextField) event.getSource();
				projectNameTextField.setBorder(projectNameTextField.turquoiseBorder);
				projectNameTextField.setForeground(projectNameTextField.TURQUOISE);
				
			}

			public void focusLost(FocusEvent event) {
				ProjectNameTextField projectNameTextField = (ProjectNameTextField) event.getSource();
				projectNameTextField.setBorder(projectNameTextField.grayBorder);
				projectNameTextField.setForeground(projectNameTextField.GRAY);
				
			}

		});
		
		this.defaultFont = new Font(settings.getAppearanceAndBehavior().getFont().getFontDirectory(),
									settings.getAppearanceAndBehavior().getFont().getFontStyle(),
									this.FONT_SIZE);
		
		this.grayBorder = BorderFactory.createLineBorder(this.GRAY, 2, true);
		this.grayBorder = BorderFactory.createTitledBorder(this.grayBorder, this.PROJECT_NAME_TEXT, TitledBorder.LEFT, TitledBorder.ABOVE_TOP, this.defaultFont, this.GRAY);
		
		this.turquoiseBorder = BorderFactory.createLineBorder(this.TURQUOISE, 2, true);
		this.turquoiseBorder = BorderFactory.createTitledBorder(this.turquoiseBorder, this.PROJECT_NAME_TEXT, TitledBorder.LEFT, TitledBorder.ABOVE_TOP, this.defaultFont, this.TURQUOISE);
		
		this.setFont(this.defaultFont);
		this.setForeground(this.GRAY);
		this.setBorder(this.grayBorder);
		
		this.setPreferredSize(new Dimension(500, 50));
		
		gridBagConstraints.gridx = this.GRIDX;
		gridBagConstraints.gridy = this.GRIDY;
		
		gridBagConstraints.gridwidth = this.GRIDWIDTH;
		gridBagConstraints.gridheight = this.GRIDHEIGHT;
		gridBagConstraints.insets = this.INSETS;
		
		gridBagLayout.setConstraints(this, gridBagConstraints);
	}

}
