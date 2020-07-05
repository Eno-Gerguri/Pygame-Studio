/**
 * Handles the main font, the editor uses everywhere, apart from specified places from the user.
 */
package com.pygame_studio.settings.appearance_and_behavior;

import java.awt.GraphicsEnvironment;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Eno Gerguri
 *
 */
public class Font {
	private File externalFontDirectory;  // Stores the directory of the external fonts folder, where the user can add their own fonts from.
	
	private String fontDirectory;  // Stores the directory of the given font.
	private int fontStyle;  // Stores the given font style.
	private int fontSize;  // Stores the given font size.
	private String fallbackFont;  // Stores the directory of the given fallback font if the main font fails or has been deleted or modified.
	
	private Map<String, String> externalFonts = new HashMap<String, String>();  // Stores all fonts in the externalFontsDirectory.
	private List<String> localFonts = new ArrayList<>();  // Stores all fonts that are available locally.
	
	/**
	 * Declares how every setting to do with a font should be stored.
	 * 
	 * <br/>
	 * The following parameters are used for handling the Font settings:
	 * <br/>
	 * - Font Parameters:
	 * @param externalFontDirectory - Stores the directory the given external font directory.
	 * @param fontName - Stores the directory of the given font or the name of the local font given.
	 * @param fontStyle - Stores the styling to do with the font.
	 * @param fontSize - Stores the size of the given font in pixels.
	 * @param fallbackFont - Stores the directory of the given fallback font if the main font fails or has been deleted or modified.
	 */
	public Font() {
		super();
	}
	
	public Font(File externalFontDirectory, String fontName, int fontStyle, int fontSize, String fallbackFont) {
        this.setExternalFontDirectory(externalFontDirectory);
		
		this.setExternalFonts();
		this.setLocalFonts();
		
		this.setFontDirectory(fontName);
		
		this.setFontStyle(fontStyle);
		
		this.setFontSize(fontSize);
		
		this.setFallbackFont(fallbackFont);
	}
	
	/**
	 * @return externalFontDirectory
	 */
	public File getExternalFontDirectory() {
		return this.externalFontDirectory;
	}
	
	/**
	 * @param externalFontDirectory - sets the externalFontDirectory to be the given externalFontDirectory.
	 */
	public void setExternalFontDirectory(File externalFontDirectory) {
		this.externalFontDirectory = externalFontDirectory;
	}
	
	/**
	 * @return externalFonts
	 */
	public Map<String, String> getExternalFonts() {
		return this.externalFonts;
	}
	
	/**
	 * Sets the external fonts to "externalFonts".
	 */
	public void setExternalFonts() {
		this.externalFonts = this.getExternalFonts(this.externalFontDirectory);
	}
	
	/**
	 * @return localFonts
	 */
	public List<String> getLocalFonts() {
		return this.localFonts;
	}
	
	/**
	 * Adds the array of available fonts on the local device itself to the list.
	 */
	public void setLocalFonts() {
		this.localFonts.addAll(Arrays.asList(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()));
	}

	/**
	 * @return fontDirectory.
	 */
	public String getFontDirectory() {
		return this.fontDirectory;
	}
	
	/**
	 * Finds the directory of the font if it is an external font and/or checks if the font exists locally on the device its being run from.
	 * Otherwise it is returned null.
	 * @param fontDirectory - fontDirectory to set.
	 */
	public void setFontDirectory(String fontDirectory) {
		if (externalFonts.containsKey(fontDirectory)) {
			this.fontDirectory = externalFonts.get(fontDirectory);
		} else if (localFonts.contains(fontDirectory)) {
			this.fontDirectory = fontDirectory;
		} else {
			this.fontDirectory = this.getFallbackFont();
		}
	}
	
	/**
	 * @return style
	 */
	public int getFontStyle() {
		return this.fontStyle;
	}
	
	/**
	 * @param style - style to be set.
	 */
	public void setFontStyle(int style) {
		this.fontStyle = style;
	}
	
	/**
	 * @return fontSize
	 */
	public int getFontSize() {
		return this.fontSize;
	}
	
	/**
	 * Sets the font size to the given font size.
	 * @param fontSize - font size to be set.
	 */
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
	
	/**
	 * @return fallbackFont
	 */
	public String getFallbackFont() {
		return this.fallbackFont;
	}
	
	/**
	 * Sets the fallback font to the given fallback font.
	 * @param fallbackFont - fallback font to be set.
	 */
	public void setFallbackFont(String fallbackFont) {
		this.fallbackFont = fallbackFont;
	}
	
	/**
	 * Recursively finds all of the fonts in the externalFontDirectory.
	 * 
	 * @param externalFontDirectory - Stores all of the external and customizable fonts the user can use.
	 * @return Map - A Map filled with the name of the font as the key and the font's directory as the value.
	 */
	public Map<String, String> getExternalFonts(File externalFontDirectory) {
		Map<String, String> externalFonts = new HashMap<String, String>();
		
		final File[] directoryFiles = externalFontDirectory.listFiles();
		
		if (directoryFiles != null) {
			for (File file : directoryFiles) {
				if (file.isDirectory()) {  // If the file is a sub-directory.
					externalFonts.putAll(this.getExternalFonts(file));  // Calls itself onto the directory.
				} else if (file.getName().contains(".ttf")) {  // If the file is a font.
					String fontName = file.getName().replace(".ttf", "");  // Gets the name of the font.
					externalFonts.put(fontName, file.getPath());  // Puts the, name of the font : font's directory, into the Map.
				}
			}
		}
		return externalFonts;
	}

}
