package game.display;

import java.awt.Font;
import javax.swing.*;

public class MultiPlayerPanel extends JPanel
	{
		private SpringLayout layout;
		private JLabel playerOneLabel;
		private JTextField playerOneUserNameField;
		
		public MultiPlayerPanel()
		{
			layout = new SpringLayout();
			playerOneLabel = new JLabel("Player One UserName: ");
			playerOneUserNameField = new JTextField();
			
			buildFont(playerOneLabel);
			
			buildComponents();
			buildPlacements();
		}
		
		private void buildFont(JLabel button)
			{
				button.setFont(new Font("Microsoft Yi Baiti", Font.BOLD, 32));
			}
		
		private void buildComponents()
		{
			setVisible(false);
			setOpaque(false);
			setLayout(layout);
			add(playerOneLabel);
			add(playerOneUserNameField);
		}
		
		private void buildPlacements()
		{
			layout.putConstraint(SpringLayout.NORTH, playerOneLabel, 16, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.WEST, playerOneLabel, 10, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, playerOneUserNameField, 0, SpringLayout.NORTH, playerOneLabel);
			layout.putConstraint(SpringLayout.WEST, playerOneUserNameField, 6, SpringLayout.EAST, playerOneLabel);
			layout.putConstraint(SpringLayout.SOUTH, playerOneUserNameField, 0, SpringLayout.SOUTH, playerOneLabel);
			layout.putConstraint(SpringLayout.EAST, playerOneUserNameField, 244, SpringLayout.EAST, playerOneLabel);
		}
		
	}
