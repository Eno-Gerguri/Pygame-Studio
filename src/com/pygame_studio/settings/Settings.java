/**
 * Contains everything to do with the settings, including how each setting should be stored.
 */
package com.pygame_studio.settings;

import java.io.File;

import com.pygame_studio.settings.appearance_and_behavior.AppearanceAndBehavior;

/**
 * @author Eno Gerguri
 *
 */
public class Settings {
	private File storedSettingsFile;  // Where the settings .xml file is stored.
	
	private AppearanceAndBehavior appearanceAndBehavior;  // Stores all the settings to do with the appearance and behavior of Pygame Studio.

	/**
	 * Declares how every setting should be stored.
	 * @param storedSettingsFile - Where these settings .xml file is stored.
	 * <br/>
	 * The following parameters are used for handling the Appearance and Behavior of the program:
	 * <br/>
	 * - Font Parameters:
	 * @param externalFontDirectory - Stores the directory the given external font directory.
	 * @param fontName - Stores the directory of the given font or the name of the local font given.
	 * @param fontStyle - Stores the styling to do with the font.
	 * @param fontSize - Stores the size of the given font in pixels.
	 * @param fallbackFont - Stores the directory of the given fallback font if the main font fails or has been deleted or modified.
	 */
	public Settings(File storedSettingsFile,
					/*Appearance And Behavior settings*/
					File externalFontDirectory, String fontName, int fontStyle, int fontSize, String fallbackFont /*"Font" settings*/) {
		this.setStoredSettingsFile(storedSettingsFile);
		
		this.setAppearanceAndBehavior(new AppearanceAndBehavior(externalFontDirectory, fontName, fontStyle, fontSize, fallbackFont /*Arguments for the "Font" settings*/));
	}
	
	public Settings(File storedSettingsFile,
					AppearanceAndBehavior appearanceAndBehavior) {
		this.setStoredSettingsFile(storedSettingsFile);
		
		this.setAppearanceAndBehavior(appearanceAndBehavior);
	}
	
	/**
	 * @return storedSettingsFile
	 */
	public File getStoredSettingsFile() {
		return storedSettingsFile;
	}

	/**
	 * @param storedSettingsFile - storedSettingsFile to set.
	 */
	public void setStoredSettingsFile(File storedSettingsFile) {
		this.storedSettingsFile = storedSettingsFile;
	}

	/**
	 * @return appearanceAndBehavior
	 */
	public AppearanceAndBehavior getAppearanceAndBehavior() {
		return appearanceAndBehavior;
	}

	/**
	 * @param appearanceAndBehavior - appearanceAndBehavior to set.
	 */
	public void setAppearanceAndBehavior(AppearanceAndBehavior appearanceAndBehavior) {
		this.appearanceAndBehavior = appearanceAndBehavior;
	}

}
