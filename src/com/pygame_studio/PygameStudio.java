/**
 * The main script of Pygame Studio. Handles the entire program.
 */
package com.pygame_studio;

import com.pygame_studio.start_menu.StartMenu;

/**
 * @author Eno Gerguri
 *
 */
public class PygameStudio {
	
	/**
	 * Manages all of Pygame Studio's frames
	 */
	public PygameStudio() {
		new StartMenu();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new PygameStudio();

	}

}
