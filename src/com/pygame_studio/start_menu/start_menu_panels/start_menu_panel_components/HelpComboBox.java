/**
 * 
 */
package com.pygame_studio.start_menu.start_menu_panels.start_menu_panel_components;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JComboBox;

import com.pygame_studio.settings.Settings;

/**
 * @author Eno Gerguri
 *
 */
public class HelpComboBox extends JComboBox<String> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5692309905031886691L;
	private final String HELP_TEXT = "Help";
	private final String GITHUB_TEXT = "Github Page";
	private final String DOCUMENTATION_TEXT = "Docs";
	private Font defaultFont;
	private final int FONT_SIZE = 16;
	private final int GRIDX = 1;
	private final int GRIDY = 6;
	private final int GRID_WIDTH = 1;
	private final int GRID_HEIGHT = 1;
	private final Insets INSETS = new Insets(0, 0, 0, 0);

	/**
	 * Sets the attributes of the HelpComboBox as well as the given gridBagConstraints.
	 */
	public HelpComboBox(Settings settings, GridBagLayout gridBagLayout, GridBagConstraints gridBagConstraints) {
		super();

		this.addItem(this.HELP_TEXT);
		this.addItem(this.GITHUB_TEXT);
		this.addItem(this.DOCUMENTATION_TEXT);
		
		this.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					String currentSelectedName = event.getItem().toString();
					if (currentSelectedName == "Github Page") {
						this.openPygameStudioGithubPage();
					} else if (currentSelectedName == "Docs") {
						this.openPygameStudioDocumentation();
					}
				}
			}
			
			private void openPygameStudioGithubPage() {
				try {
					java.awt.Desktop.getDesktop().browse(new URI("https://github.com/Eno-Gerguri/Pygame-Studio"));
				} catch (IOException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
			
			private void openPygameStudioDocumentation() {
				try {
					java.awt.Desktop.getDesktop().browse(new URI("https://github.com/Eno-Gerguri/Pygame-Studio/wiki/Pygame-Studio-Home"));
				} catch (IOException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
		});
		
		this.defaultFont = new Font(settings.getAppearanceAndBehavior().getFont().getFontDirectory(),
				settings.getAppearanceAndBehavior().getFont().getFontStyle(),
				this.FONT_SIZE);
		
		// this.setForeground(this.GRAY);
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
