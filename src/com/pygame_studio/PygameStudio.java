/**
 * The main script of Pygame Studio. Handles the entire program.
 */
package com.pygame_studio;

import java.io.File;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.pygame_studio.settings.Settings;
import com.pygame_studio.settings.XmlManager;
import com.pygame_studio.settings.default_settings.DefaultSettings;
import com.pygame_studio.start_menu.StartMenu;

/**
 * @author Eno Gerguri
 *
 */
public class PygameStudio {
	
	public static final File SETTINGS_FILE_DIRECTORY = new File(System.getProperty("user.dir") + "\\Settings\\Settings.xml");
	
	private XmlManager xmlManager = new XmlManager();
	private Settings settings = (Settings) xmlManager.deserializeObject(Settings.class, SETTINGS_FILE_DIRECTORY);  // Gets the settings from the .xml "Settings" file
	
	/**
	 * Manages all of Pygame Studio's frames
	 */
	public PygameStudio() {
		XmlManager xmlManager = new XmlManager();
		DefaultSettings defaultSettings = new DefaultSettings();
		xmlManager.serializeObject((Object) defaultSettings.defaultSettings, DefaultSettings.DEFAULT_SETTINGS_FILE_DIRECTORY);
		xmlManager.serializeObject((Object) defaultSettings.defaultSettings, SETTINGS_FILE_DIRECTORY);
		this.initializeLookAndFeel();
		new StartMenu(this.settings);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new PygameStudio();

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
