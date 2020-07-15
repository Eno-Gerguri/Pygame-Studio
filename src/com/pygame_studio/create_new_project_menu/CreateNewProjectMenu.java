/**
 * 
 */
package com.pygame_studio.create_new_project_menu;

import com.pygame_studio.settings.Settings;
import com.pygame_studio.start_menu.StartMenuFrame;

/**
 * @author Eno Gerguri
 *
 */
public class CreateNewProjectMenu {
	
	private Settings settings;
	
	private CreateNewProjectMenuFrame createNewProjectMenuFrame;

	/**
	 * 
	 */
	public CreateNewProjectMenu(Settings settings) {
		this.settings = settings;
		this.createNewProjectMenuFrame = new CreateNewProjectMenuFrame(this.settings);
	}

}
