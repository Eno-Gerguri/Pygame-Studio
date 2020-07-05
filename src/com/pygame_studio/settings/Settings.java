/**
 * Contains everything to do with the settings, including how each setting should be stored.
 */
package com.pygame_studio.settings;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.pygame_studio.settings.appearance_and_behavior.AppearanceAndBehavior;

/**
 * @author Eno Gerguri
 *
 */
public class Settings {
	private File storedSettingsFile;  // Where the settings .xml file is stored.
	private File iconsDirectory;
	private Map<String, String> icons = new HashMap<String, String>();
	
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
	public Settings() {
		super();
	}
	
	public Settings(File storedSettingsFile, File iconsDirectory,
					/*Appearance And Behavior settings*/
					String lookAndFeel,
					File externalFontDirectory, String fontName, int fontStyle, int fontSize, String fallbackFont /*"Font" settings*/) {
		this.setStoredSettingsFile(storedSettingsFile);
		this.setIconsDirectory(iconsDirectory);
		this.setIcons();
		
		this.setAppearanceAndBehavior(new AppearanceAndBehavior(lookAndFeel, externalFontDirectory, fontName, fontStyle, fontSize, fallbackFont /*Arguments for the "Font" settings*/));
	}
	
	public Settings(File storedSettingsFile, File iconsDirectory,
					AppearanceAndBehavior appearanceAndBehavior) {
		this.setStoredSettingsFile(storedSettingsFile);
		this.setIconsDirectory(iconsDirectory);
		this.setIcons();
		
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
	
	public File getIconsDirectory() {
		return this.iconsDirectory;
	}
	
	public void setIconsDirectory(File iconsDirectory) {
		this.iconsDirectory = iconsDirectory;
	}
	
	public Map<String, String> getIcons() {
		return this.icons;
	}
	
	public Map<String, String> getIcons(File iconsDirectory) {
		Map<String, String> icons = new HashMap<String, String>();
		
		final File[] directoryFiles = iconsDirectory.listFiles();
		
		if (directoryFiles != null) {
			for (File file : directoryFiles) {
				if (file.isDirectory()) {  // If the file is a sub-directory.
					icons.putAll(this.getIcons(file));  // Calls itself onto the directory.
				} else {
					for (String fileType : ImageIO.getReaderFileSuffixes()) {
						fileType = '.' + fileType;
						if (file.getName().contains(fileType)) {  // If it is an accepted icon type
							String iconName = file.getName().replace(fileType, "");
							icons.put(iconName, file.getPath());  // Puts the, name of the icon : ImageIcon of icon
							break;
						}
					}
				}
			}
		}
		
		return icons;
	}
	
	public void setIcons() {
		this.icons = this.getIcons(this.iconsDirectory);
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
