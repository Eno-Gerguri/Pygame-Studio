/**
 * 
 */
package com.pygame_studio.create_new_project_menu;

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
import com.pygame_studio.start_menu.StartMenu;

/**
 * @author Eno Gerguri
 *
 */
public class CancelProjectButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6012266718250742073L;
	private final String CANCEL_PROJECT_TEXT = "Cancel";
	private Font defaultFont;
	private final int FONT_SIZE = 16;
	private final int GRIDX = 0;
	private final int GRIDY = 0;
	private final int GRID_WIDTH = 1;
	private final int GRID_HEIGHT = 1;
	private final Insets INSETS = new Insets(0, 0, 0, -1725);

	/**
	 * 
	 */
	public CancelProjectButton(Settings settings, GridBagLayout gridBagLayout, GridBagConstraints gridBagConstraints) {
		super();
		
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Window win = SwingUtilities.getWindowAncestor((Component) event.getSource());
	            if (win != null) {
	                win.dispose();  // dispose of it
	            }
	            
	            new StartMenu(settings);
			}
		});
		
		this.defaultFont = new Font(settings.getAppearanceAndBehavior().getFont().getFontDirectory(),
				settings.getAppearanceAndBehavior().getFont().getFontStyle(),
				this.FONT_SIZE);
		
		this.setForeground(Color.BLACK);
		this.setBackground(Color.WHITE);
		this.setText(this.CANCEL_PROJECT_TEXT);
		this.setFont(this.defaultFont);
		
		gridBagConstraints.gridx = this.GRIDX;
		gridBagConstraints.gridy = this.GRIDY;
		
		gridBagConstraints.gridwidth = this.GRID_WIDTH;
		gridBagConstraints.gridheight = this.GRID_HEIGHT;
		gridBagConstraints.insets = this.INSETS;
		
		gridBagLayout.setConstraints(this, gridBagConstraints);
	}

}
