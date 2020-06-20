/**
 * Controls the frame that displays the start menu and then displays the start menu.
 */
package com.pygame_studio.start_menu;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

import com.pygame_studio.settings.Settings;
import com.pygame_studio.settings.SettingsManager;
import com.pygame_studio.settings.default_settings.DefaultSettings;

/**
 * @author Eno Gerguri
 *
 */
public class StartMenu {
	private SettingsManager settingsManager = new SettingsManager();
	private Settings defaultSettings = settingsManager.deserializeSettings(DefaultSettings.DEFAULT_SETTINGS_FILE_DIRECTORY);
	
	private String windowTitle = "Welcome to Pygame Studio";
	
	private JFrame startMenu = new JFrame();

	/**
	 * 
	 */
	public StartMenu() {
		startMenu.setPreferredSize(new Dimension(300,300));
		startMenu.setTitle("Hello Center");
		startMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		startMenu.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent event) {
				titleAlignCenter(startMenu);
			}
		});
		
		startMenu.pack();
		startMenu.setLocationRelativeTo(null);
		startMenu.setVisible(true);
	}
	
	private void titleAlignCenter(JFrame frame) {
		Font titleFont = new Font(defaultSettings.getAppearanceAndBehavior().getFont().getFontDirectory(),
								  defaultSettings.getAppearanceAndBehavior().getFont().getFontStyle(),
								  defaultSettings.getAppearanceAndBehavior().getFont().getFontSize());
		
		String currentTitle = frame.getTitle().trim();
		FontMetrics fontMetrics = frame.getFontMetrics(titleFont);
		
		int frameWidth = frame.getWidth();
		int titleWidth = fontMetrics.stringWidth(currentTitle);
		int spaceWidth = fontMetrics.stringWidth(" ");
		int centerPos = (frameWidth / 2) - (titleWidth / 2);
		int spaceCount = centerPos / spaceWidth;
		
		String spacePadding = "";
		spacePadding = String.format("%" + (spaceCount - 14) + "s", spacePadding);
		frame.setTitle(spacePadding + currentTitle);
	}

}
