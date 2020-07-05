/**
 * Handles all settings that have to do with the appearance and behavior of Pygame Studio.
 */
package com.pygame_studio.settings.appearance_and_behavior;

import java.io.File;

/**
 * @author Eno Gerguri
 *
 */
public class AppearanceAndBehavior {
	private String lookAndFeel;  // Stores the look and feel of the program.
	
	private Font font;  // Stores everything to do with the program's font.

	/**
	 * Declares how all settings, to do with the appearance and behavior of Pygame Studio, should be stored.
	 * 
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
	public AppearanceAndBehavior() {
		super();
	}
	
	public AppearanceAndBehavior(String lookAndFeel,
								 File externalFontDirectory, String fontName, int fontStyle, int fontSize, String fallbackFont /*Parameters for the "Font" settings.*/) {
		this.setLookAndFeel(lookAndFeel);
		
		this.setFont(new Font(externalFontDirectory,
				              fontName,
				              fontStyle,
				              fontSize,
				              fallbackFont));
	}
	
	/**
	 * @return - lookAndFeel
	 */
	public String getLookAndFeel() {
		return this.lookAndFeel;
	}

	/**
	 * @param lookAndFeel - lookAndFeel to set
	 */
	public void setLookAndFeel(String lookAndFeel) {
		this.lookAndFeel = lookAndFeel;
	}
	
	/**
	 * @return - font
	 */
	public Font getFont() {
		return this.font;
	}

	/**
	 * @param font - font to set
	 */
	public void setFont(Font font) {
		this.font = font;
	}

}
