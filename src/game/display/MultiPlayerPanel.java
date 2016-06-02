package game.display;

import game.controller.GameController;
import java.awt.Font;
import javax.swing.*;

public class MultiPlayerPanel extends JPanel
	{
		private GameController controller;
		private SpringLayout layout;
		private JLabel userNameLabel;
		private JTextField oneUserNameField;

		private JButton rockButton;
		private JButton paperButton;
		private JButton scissorsButton;

		private JLabel displayInfo;
		private JLabel displayGames;

		public MultiPlayerPanel(GameController controller)
			{
				this.controller = controller;

				layout = new SpringLayout();
				userNameLabel = new JLabel("Player One UserName: ");
				oneUserNameField = new JTextField();

				rockButton = new JButton("Rock");
				paperButton = new JButton("Paper");
				scissorsButton = new JButton("Scissors");

				displayInfo = new JLabel("Will you win?!");
				displayGames = new JLabel("");

				buildFont(userNameLabel);
				buildFont(displayInfo);
				buildFont(displayGames);
				buildComponents();
				buildPlacements();
			}

		private void buildFont(JLabel button)
			{
				button.setFont(new Font("Popular Std Black", Font.BOLD, 30));
			}

		private void buildComponents()
			{
				setVisible(false);
				setOpaque(false);
				setLayout(layout);
				add(userNameLabel);
				add(oneUserNameField);
				add(rockButton);
				add(paperButton);
				add(scissorsButton);
				add(displayInfo);
				add(displayGames);
			}

		private void buildPlacements()
			{
				layout.putConstraint(SpringLayout.NORTH, userNameLabel, 16, SpringLayout.NORTH, this);
				layout.putConstraint(SpringLayout.WEST, userNameLabel, 10, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, oneUserNameField, 0, SpringLayout.NORTH, userNameLabel);
				layout.putConstraint(SpringLayout.WEST, oneUserNameField, 6, SpringLayout.EAST, userNameLabel);
				layout.putConstraint(SpringLayout.SOUTH, oneUserNameField, 0, SpringLayout.SOUTH, userNameLabel);
				layout.putConstraint(SpringLayout.EAST, oneUserNameField, 212, SpringLayout.EAST, userNameLabel);
				layout.putConstraint(SpringLayout.EAST, paperButton, -6, SpringLayout.WEST, scissorsButton);
				layout.putConstraint(SpringLayout.SOUTH, scissorsButton, 0, SpringLayout.SOUTH, rockButton);
				layout.putConstraint(SpringLayout.NORTH, scissorsButton, 34, SpringLayout.SOUTH, oneUserNameField);
				layout.putConstraint(SpringLayout.WEST, scissorsButton, 388, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.EAST, scissorsButton, -10, SpringLayout.EAST, this);
				layout.putConstraint(SpringLayout.NORTH, paperButton, 34, SpringLayout.SOUTH, userNameLabel);
				layout.putConstraint(SpringLayout.WEST, paperButton, 6, SpringLayout.EAST, rockButton);
				layout.putConstraint(SpringLayout.SOUTH, paperButton, 0, SpringLayout.SOUTH, rockButton);
				layout.putConstraint(SpringLayout.NORTH, rockButton, 34, SpringLayout.SOUTH, userNameLabel);
				layout.putConstraint(SpringLayout.WEST, rockButton, 3, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.SOUTH, rockButton, -237, SpringLayout.SOUTH, this);
				layout.putConstraint(SpringLayout.EAST, rockButton, -402, SpringLayout.EAST, this);
				layout.putConstraint(SpringLayout.NORTH, displayInfo, 54, SpringLayout.SOUTH, rockButton);
				layout.putConstraint(SpringLayout.WEST, displayInfo, 0, SpringLayout.WEST, userNameLabel);
				layout.putConstraint(SpringLayout.NORTH, displayGames, 6, SpringLayout.SOUTH, displayInfo);
				layout.putConstraint(SpringLayout.WEST, displayGames, 0, SpringLayout.WEST, userNameLabel);
			}


		public void updateText(String status)
			{
				displayInfo.setText("<html>" + oneUserNameField.getText() + " has " + status + "<br>The Bot selected " + controller.getBot().getBotAnswer() + "<br>You selected " + "<html>");
				displayGames.setText("Games Won : " + controller.getBot().getCounter() + " Tie Games : " + controller.getBot().getTieCounter());
			}

		public JButton getRockButton()
			{
				return rockButton;
			}

		public JButton getPaperButton()
			{
				return paperButton;
			}

		public JButton getScissorsButton()
			{
				return scissorsButton;
			}

	}
