/**
 * 
 */
package com.pygame_studio.create_new_project_menu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

import javax.swing.Timer;

/**
 * @author Eno Gerguri
 *
 */
public class ClickHoldMouseListener extends MouseAdapter {
	
	private Timer fireTimer;
    private MouseEvent lastEvent;

	/**
	 * 
	 */
	public ClickHoldMouseListener(int holdTime, Consumer<MouseEvent> eventConsumer) {
        fireTimer = new Timer(holdTime, e -> eventConsumer.accept(lastEvent));
        fireTimer.setRepeats(false);
    }

    public void mousePressed(MouseEvent e) {
        lastEvent = e;
        fireTimer.restart();
    }

    public void mouseReleased(MouseEvent e) {
        fireTimer.stop();
    }

}
