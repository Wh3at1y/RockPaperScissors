package game.display;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class SinglePlayerPanel extends JPanel
	{
		private SpringLayout layout;
		private JLabel userNameLabel;
		private JTextField spUserNameField;
		
		private JButton rockButton;
		private JButton paperButton;
		private JButton scissorsButton;
		
		public SinglePlayerPanel()
		{
			layout = new SpringLayout();
			userNameLabel = new JLabel("Player UserName: ");
			spUserNameField = new JTextField();
			
			rockButton = new JButton("Rock");
			paperButton = new JButton("Paper");
			scissorsButton = new JButton("Scissors");
			
			buildFont(userNameLabel);
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
			add(userNameLabel);
			add(spUserNameField);
			add(rockButton);
			add(paperButton);
			add(scissorsButton);
		}
		
		private void buildPlacements()
		{
			layout.putConstraint(SpringLayout.NORTH, userNameLabel, 16, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.WEST, userNameLabel, 10, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, spUserNameField, 0, SpringLayout.NORTH, userNameLabel);
			layout.putConstraint(SpringLayout.WEST, spUserNameField, 6, SpringLayout.EAST, userNameLabel);
			layout.putConstraint(SpringLayout.SOUTH, spUserNameField, 0, SpringLayout.SOUTH, userNameLabel);
			layout.putConstraint(SpringLayout.EAST, spUserNameField, 212, SpringLayout.EAST, userNameLabel);
			layout.putConstraint(SpringLayout.EAST, paperButton, -6, SpringLayout.WEST, scissorsButton);
			layout.putConstraint(SpringLayout.SOUTH, scissorsButton, 0, SpringLayout.SOUTH, rockButton);
			layout.putConstraint(SpringLayout.NORTH, scissorsButton, 34, SpringLayout.SOUTH, spUserNameField);
			layout.putConstraint(SpringLayout.WEST, scissorsButton, 388, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.EAST, scissorsButton, -10, SpringLayout.EAST, this);
			layout.putConstraint(SpringLayout.NORTH, paperButton, 34, SpringLayout.SOUTH, userNameLabel);
			layout.putConstraint(SpringLayout.WEST, paperButton, 6, SpringLayout.EAST, rockButton);
			layout.putConstraint(SpringLayout.SOUTH, paperButton, 0, SpringLayout.SOUTH, rockButton);
			layout.putConstraint(SpringLayout.NORTH, rockButton, 34, SpringLayout.SOUTH, userNameLabel);
			layout.putConstraint(SpringLayout.WEST, rockButton, 3, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.SOUTH, rockButton, -237, SpringLayout.SOUTH, this);
			layout.putConstraint(SpringLayout.EAST, rockButton, -402, SpringLayout.EAST, this);
		}
		
	}
