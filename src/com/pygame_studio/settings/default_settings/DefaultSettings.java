/**
 * Contains and can store the default settings, hard-coded into this file.
 */
package com.pygame_studio.settings.default_settings;

import java.awt.Font;
import java.io.File;

import com.formdev.flatlaf.FlatLightLaf;
import com.pygame_studio.settings.Settings;
import com.pygame_studio.settings.appearance_and_behavior.AppearanceAndBehavior;

/**
 * @author Eno Gerguri
 *
 */
public class DefaultSettings {
	public static final File DEFAULT_SETTINGS_FILE_DIRECTORY = new File(System.getProperty("user.dir") + "\\Settings\\defaultSettings.xml");  // Stores the directory where the default settings file is stored.
	private File iconsDirectory = new File(System.getProperty("user.dir") + "\\Icons");
	
	public Settings defaultSettings;  // The settings object, which will contain all of the hard-coded Default Settings.

	/**
	 * Holds all of the variables for the Appearance and Behavior of Pygame Studio.
	 */
	private AppearanceAndBehavior appearanceAndBehavior;

	// Appearance and Behavior - Fonts variables:
	
	private File externalFontDirectory = new File(System.getProperty("user.dir") + "\\Fonts");
	private String fontName = "SourceSansPro-Black";
	private int fontStyle = Font.BOLD;
	private int fontSize = 14;
	private String fallbackFont = "Helvetica Rounded";
	
	// Appearance and Behavior - LookAndFeel variable:
	
	private String lookAndFeel = new FlatLightLaf().getClass().getName();
	
	public DefaultSettings() {
		appearanceAndBehavior = new AppearanceAndBehavior(this.lookAndFeel, this.externalFontDirectory, this.fontName, this.fontStyle, this.fontSize, this.fallbackFont /*Arguments for the "Font" settings.*/);
		
		defaultSettings = new Settings(DEFAULT_SETTINGS_FILE_DIRECTORY, this.iconsDirectory, this.appearanceAndBehavior);
	}

}
