package com.pygame_studio.create_new_project_menu.create_new_project_menu.create_new_project_menu_panels.templates_panel.templates_panel_components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import com.pygame_studio.settings.Settings;

public class PygameFunctionsToggleButton extends JToggleButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3973832157204583522L;
	private final String PYGAME_FUNCTIONS_TEXT = "<html>Pygame<br/>Functions</html>";
	private final Color GRAY = new Color(110, 110, 110);
	private final int ICON_TEXT_GAP = 0;
	private Font defaultFont;
	private final int FONT_SIZE = 16;
	private ImageIcon grayPersonSolid;
	private ImageIcon blackPersonSolid;
	private final int GRIDX = 0;
	private final int GRIDY = 1;
	private final int GRIDWIDTH = 2;
	private final int GRIDHEIGHT = 2;
	private final Insets INSETS = new Insets(0, 0, 0, 350);

	public PygameFunctionsToggleButton(Settings settings, GridBagLayout gridBagLayout, GridBagConstraints gridBagConstraints) {
		super();
		
		this.addMouseListener(new ClickHoldMouseListener(1000, (event) -> {
			String pygameFunctionsInformationTitle = "Pygame Functions";
			String pygameFunctionsDescription = "<html>\r\n" + 
					"<html>Pygame Functions is an easy to use python library, which is perfect for beginners or people coming from scratch.<br/>\r\n" + 
					"<html>Its simple human readable code is great for people looking to learn to code small games in python.<br/>\r\n" + 
					"<html>It should be used for/by:\r\n" + 
					"<html><ul>\r\n" + 
					"<html><li>Simple and small games.</li>\r\n" + 
					"<html><li>Beginners coming from scratch</li>\r\n" + 
					"<html><li>People who want to make games using the python programming language in a simple readable way</li>\r\n" + 
					"<html></ul>\r\n" + 
					"<html>It should not be used by/for:\r\n" + 
					"<html><ul>\r\n" + 
					"<html><li>Large Projects</li>\r\n" + 
					"<html><li>Projects which require fully customizable objects</li>\r\n" + 
					"<html></ul>\r\n";
			int pygameFunctionsMessageType = JOptionPane.INFORMATION_MESSAGE;
			JOptionPane.showMessageDialog(null, pygameFunctionsDescription, pygameFunctionsInformationTitle, pygameFunctionsMessageType);
		}));  // Adds a click hold listener, where if the user holds for more than the first argument the second argument occurs.
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent event) {
				PygameFunctionsToggleButton pygameFunctionsToggleButton = (PygameFunctionsToggleButton) event.getSource();
				pygameFunctionsToggleButton.setIcon(pygameFunctionsToggleButton.blackPersonSolid);
			}
			
			public void mouseClicked(MouseEvent event) {
				PygameFunctionsToggleButton pygameFunctionsToggleButton = (PygameFunctionsToggleButton) event.getSource();
				if (pygameFunctionsToggleButton.isSelected()) {
					pygameFunctionsToggleButton.setForeground(Color.BLACK);
				} else {
					pygameFunctionsToggleButton.setForeground(pygameFunctionsToggleButton.GRAY);
				}
			}
			
			public void mouseExited(MouseEvent event) {
				PygameFunctionsToggleButton pygameFunctionsToggleButton = (PygameFunctionsToggleButton) event.getSource();
				if (!pygameFunctionsToggleButton.isSelected()) {
					pygameFunctionsToggleButton.setIcon(pygameFunctionsToggleButton.grayPersonSolid);
				}
			}
		});
		
		this.defaultFont = new Font(settings.getAppearanceAndBehavior().getFont().getFontDirectory(),
				settings.getAppearanceAndBehavior().getFont().getFontStyle(),
				this.FONT_SIZE);
		
		this.grayPersonSolid = new ImageIcon(settings.getIcons().get("Gray-PersonSolid"));
		Image grayPersonSolid = this.grayPersonSolid.getImage();
		Image scaledGrayPersonSolid = grayPersonSolid.getScaledInstance(48, 48, Image.SCALE_SMOOTH);
		this.grayPersonSolid = new ImageIcon(scaledGrayPersonSolid);
		
		this.blackPersonSolid = new ImageIcon(settings.getIcons().get("Black-PersonSolid"));
		Image blackPersonSolid = this.blackPersonSolid.getImage();
		Image scaledBlackPersonSolid = blackPersonSolid.getScaledInstance(48, 48, Image.SCALE_SMOOTH);
		this.blackPersonSolid = new ImageIcon(scaledBlackPersonSolid);
		
		this.setForeground(this.GRAY);
		this.setText(this.PYGAME_FUNCTIONS_TEXT);
		this.setFont(this.defaultFont);
		this.setIcon(this.grayPersonSolid);
		
		this.setVerticalTextPosition(SwingConstants.BOTTOM);
		this.setIconTextGap(this.ICON_TEXT_GAP);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		
		gridBagConstraints.gridx = this.GRIDX;
		gridBagConstraints.gridy = this.GRIDY;
		
		gridBagConstraints.gridwidth = this.GRIDWIDTH;
		gridBagConstraints.gridheight = this.GRIDHEIGHT;
		gridBagConstraints.insets = this.INSETS;
		
		this.setPreferredSize(new Dimension(100, 100));
		
		gridBagLayout.setConstraints(this, gridBagConstraints);
	}

}
