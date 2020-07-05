/**
 * Controls the frame that displays the start menu and then displays the start menu.
 */
package com.pygame_studio.start_menu;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.pygame_studio.settings.Settings;
import com.pygame_studio.settings.XmlManager;
import com.pygame_studio.settings.default_settings.DefaultSettings;
import com.pygame_studio.start_menu.start_menu_panels.start_menu_panel_components.ConfigureComboBox;
import com.pygame_studio.start_menu.start_menu_panels.start_menu_panel_components.CreateNewProjectButton;
import com.pygame_studio.start_menu.start_menu_panels.start_menu_panel_components.HelpComboBox;
import com.pygame_studio.start_menu.start_menu_panels.start_menu_panel_components.OpenProjectButton;
import com.pygame_studio.start_menu.start_menu_panels.start_menu_panel_components.PygameLogo;
import com.pygame_studio.start_menu.start_menu_panels.start_menu_panel_components.PygameStudioTitle;
import com.pygame_studio.start_menu.start_menu_panels.start_menu_panel_components.PygameStudioVersion;

/**
 * @author Eno Gerguri
 *
 */
public class StartMenu {
	private XmlManager xmlManager = new XmlManager();
	private Settings settings = (Settings) xmlManager.deserializeObject(Settings.class, DefaultSettings.DEFAULT_SETTINGS_FILE_DIRECTORY);  // Gets the settings from the .xml "Settings" file
	
	private String windowTitle = "Welcome to Pygame Studio";
	
	private StartMenuFrame startMenuFrame;

	/**
	 * Manages everything to do with the StartMenuFrame.
	 */
	public StartMenu() {
		this.initializeLookAndFeel();
		this.startMenuFrame = new StartMenuFrame(this.settings);
		
	}
	
	/**
	 * Sets the look and feel to be what is in the settings.
	 */
	private void initializeLookAndFeel() {
		try {
			UIManager.setLookAndFeel(this.settings.getAppearanceAndBehavior().getLookAndFeel());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

}
