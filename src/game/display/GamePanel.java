package game.display;

import game.controller.GameController;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GamePanel extends JPanel
	{
		private SpringLayout layout;
		private JLabel background;
		private JButton mpButton;
		private JButton spButton;
		private SinglePlayerPanel spPanel;
		private MultiPlayerPanel mpPanel;
		
		public GamePanel(GameController controller)
		{
			layout = new SpringLayout();
			background = new JLabel();
			mpButton = new JButton("2-Players");
			spButton = new JButton("Single-Player");
			spPanel = new SinglePlayerPanel(controller);
			mpPanel = new MultiPlayerPanel();
			
			stretchBackgroundImage();
			buildComponents();
			buildPlacements();
			buildListeners();
		}
		
		public void stretchBackgroundImage()
			{
				ImageIcon imageIcon = new ImageIcon(GamePanel.class.getResource("/resources/background.gif")); // load the image to a imageIcon
				Image image = imageIcon.getImage(); // transform it
				Image newimg = image.getScaledInstance(600, 500, java.awt.Image.SCALE_FAST); // scale it the smooth way
				imageIcon = new ImageIcon(newimg); // transform it back
				background.setIcon(imageIcon);
			}
		
		private void buildComponents()
		{
			setLayout(layout);
			add(mpButton);
			add(spButton);
			add(mpPanel);
			add(spPanel);
			add(background);
		}
		
		private void buildListeners()
		{
			mpButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent clicked)
						{
							spPanel.setVisible(false);
							mpPanel.setVisible(true);
						}
					
				});
			
			spButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent clicked)
					{
						spPanel.setVisible(true);
						mpPanel.setVisible(false);
					}
				});
		}
		
		private void buildPlacements()
		{
			layout.putConstraint(SpringLayout.NORTH, background, 0, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.WEST, background, 0, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.SOUTH, background, 0, SpringLayout.SOUTH, this);
			layout.putConstraint(SpringLayout.EAST, background, 0, SpringLayout.EAST, this);
			layout.putConstraint(SpringLayout.WEST, spButton, -286, SpringLayout.EAST, this);
			layout.putConstraint(SpringLayout.SOUTH, spButton, 69, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.NORTH, spButton, 10, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.EAST, spButton, -10, SpringLayout.EAST, this);
			layout.putConstraint(SpringLayout.NORTH, mpButton, 10, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.WEST, mpButton, 10, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.SOUTH, mpButton, 69, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.EAST, mpButton, 286, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, spPanel, 0, SpringLayout.SOUTH, mpButton);
			layout.putConstraint(SpringLayout.WEST, spPanel, 0, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.SOUTH, spPanel, 0, SpringLayout.SOUTH, this);
			layout.putConstraint(SpringLayout.EAST, spPanel, 0, SpringLayout.EAST, this);
			layout.putConstraint(SpringLayout.NORTH, mpPanel, 0, SpringLayout.SOUTH, mpButton);
			layout.putConstraint(SpringLayout.WEST, mpPanel, 0, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.SOUTH, mpPanel, 0, SpringLayout.SOUTH, this);
			layout.putConstraint(SpringLayout.EAST, mpPanel, 0, SpringLayout.EAST, this);
		}

		public JButton getSpButton()
			{
				return spButton;
			}

		public SinglePlayerPanel getSpPanel()
			{
				return spPanel;
			}
		
	}
