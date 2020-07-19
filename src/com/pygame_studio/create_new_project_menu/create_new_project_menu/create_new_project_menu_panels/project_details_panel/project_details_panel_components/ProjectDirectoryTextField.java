/**
 * 
 */
package com.pygame_studio.create_new_project_menu.create_new_project_menu.create_new_project_menu_panels.project_details_panel.project_details_panel_components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.pygame_studio.settings.Settings;

/**
 * @author Eno Gerguri
 *
 */
public class ProjectDirectoryTextField extends JTextField {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1116499561664895470L;
	private final String PROJECT_DIRECTORY_TEXT = "Project Directory*";
	private final Color GRAY = new Color(110, 110, 110);
	private final Color TURQUOISE = new Color(0, 168, 243);
	private Border grayBorder;
	private Border turquoiseBorder;
	private Font defaultFont;
	private final int FONT_SIZE = 14;
	private ImageIcon grayFolder;
	private ImageIcon blackFolder;
	private JLabel folderIconLabel;
	private final int GRIDX = 0;
	private final int GRIDY = 2;
	private final int GRIDWIDTH = 2;
	private final int GRIDHEIGHT = 1;
	private final Insets INSETS = new Insets(25, 25, 0, 0);

	/**
	 * 
	 */
	public ProjectDirectoryTextField(Settings settings, GridBagLayout gridBagLayout, GridBagConstraints gridBagConstraints) {
		super();
		
		this.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent event) {
				ProjectDirectoryTextField projectDirectoryTextField = (ProjectDirectoryTextField) event.getSource();
				projectDirectoryTextField.setBorder(projectDirectoryTextField.turquoiseBorder);
				projectDirectoryTextField.setForeground(projectDirectoryTextField.TURQUOISE);
				
			}

			public void focusLost(FocusEvent event) {
				ProjectDirectoryTextField projectDirectoryTextField = (ProjectDirectoryTextField) event.getSource();
				projectDirectoryTextField.setBorder(projectDirectoryTextField.grayBorder);
				projectDirectoryTextField.setForeground(projectDirectoryTextField.GRAY);
				
			}

		});
		
		this.defaultFont = new Font(settings.getAppearanceAndBehavior().getFont().getFontDirectory(),
									settings.getAppearanceAndBehavior().getFont().getFontStyle(),
									this.FONT_SIZE);
		
		this.grayFolder = new ImageIcon(settings.getIcons().get("Gray-Folder"));
		Image grayFolder = this.grayFolder.getImage();
		Image scaledGrayFolder = grayFolder.getScaledInstance(24, 24, Image.SCALE_SMOOTH);
		this.grayFolder = new ImageIcon(scaledGrayFolder);
		
		this.blackFolder = new ImageIcon(settings.getIcons().get("Black-Folder"));
		Image blackFolder = this.blackFolder.getImage();
		Image scaledBlackFolder = blackFolder.getScaledInstance(24, 24, Image.SCALE_SMOOTH);
		this.blackFolder = new ImageIcon(scaledBlackFolder);
		
		this.grayBorder = BorderFactory.createLineBorder(this.GRAY, 2, true);
		this.grayBorder = BorderFactory.createTitledBorder(this.grayBorder, this.PROJECT_DIRECTORY_TEXT, TitledBorder.LEFT, TitledBorder.ABOVE_TOP, this.defaultFont, this.GRAY);
		
		this.turquoiseBorder = BorderFactory.createLineBorder(this.TURQUOISE, 2, true);
		this.turquoiseBorder = BorderFactory.createTitledBorder(this.turquoiseBorder, this.PROJECT_DIRECTORY_TEXT, TitledBorder.LEFT, TitledBorder.ABOVE_TOP, this.defaultFont, this.TURQUOISE);
		
		this.setLayout(new BorderLayout());
		
		this.setFont(this.defaultFont);
		this.setForeground(this.GRAY);
		this.setBorder(this.grayBorder);
		
		this.setPreferredSize(new Dimension(500, 50));
		
		this.folderIconLabel = new JLabel(this.grayFolder);
		this.folderIconLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.add(this.folderIconLabel, BorderLayout.EAST);
		this.folderIconLabel.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent event) {
				JLabel folderIconLabel = (JLabel) event.getSource();
				ProjectDirectoryTextField projectDirectoryTextField = (ProjectDirectoryTextField) folderIconLabel.getParent();
				folderIconLabel.setIcon(projectDirectoryTextField.blackFolder);
			}
			
			public void mousePressed(MouseEvent event) {
				JLabel folderIconLabel = (JLabel) event.getSource();
				ProjectDirectoryTextField projectDirectoryTextField = (ProjectDirectoryTextField) folderIconLabel.getParent();
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					projectDirectoryTextField.setText(fileChooser.getSelectedFile().getPath());
				}
			}

			public void mouseExited(MouseEvent event) {
				JLabel folderIconLabel = (JLabel) event.getSource();
				ProjectDirectoryTextField projectDirectoryTextField = (ProjectDirectoryTextField) folderIconLabel.getParent();
				folderIconLabel.setIcon(projectDirectoryTextField.grayFolder);
			}
		});
		
		gridBagConstraints.gridx = this.GRIDX;
		gridBagConstraints.gridy = this.GRIDY;
		
		gridBagConstraints.gridwidth = this.GRIDWIDTH;
		gridBagConstraints.gridheight = this.GRIDHEIGHT;
		gridBagConstraints.insets = this.INSETS;
		
		gridBagLayout.setConstraints(this, gridBagConstraints);
	}

}
