/**
 * Controls the frame that displays the start menu and then displays the start menu.
 */
package com.pygame_studio.start_menu;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.pygame_studio.settings.Settings;

/**
 * @author Eno Gerguri
 *
 */
public class StartMenu {
	
	private Settings settings;
	
	private StartMenuFrame startMenuFrame;

	/**
	 * Manages everything to do with the StartMenu.
	 */
	public StartMenu(Settings settings) {
		this.settings = settings;
		this.startMenuFrame = new StartMenuFrame(this.settings);
		
	}

}
