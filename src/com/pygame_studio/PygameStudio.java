/**
 * The main script of Pygame Studio. Handles the entire program.
 */
package com.pygame_studio;

import java.io.File;

import com.pygame_studio.settings.XmlManager;
import com.pygame_studio.settings.default_settings.DefaultSettings;
import com.pygame_studio.start_menu.StartMenu;

/**
 * @author Eno Gerguri
 *
 */
public class PygameStudio {
	
	public static final File SETTINGS_FILE_DIRECTORY = new File(System.getProperty("user.dir") + "\\Settings\\Settings.xml");
	
	/**
	 * Manages all of Pygame Studio's frames
	 */
	public PygameStudio() {
		XmlManager xmlManager = new XmlManager();
		DefaultSettings defaultSettings = new DefaultSettings();
		xmlManager.serializeObject((Object) defaultSettings.defaultSettings, DefaultSettings.DEFAULT_SETTINGS_FILE_DIRECTORY);
		xmlManager.serializeObject((Object) defaultSettings.defaultSettings, SETTINGS_FILE_DIRECTORY);
		new StartMenu();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new PygameStudio();

	}

}
