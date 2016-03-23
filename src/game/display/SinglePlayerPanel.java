package game.display;

import game.controller.GameController;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SinglePlayerPanel extends JPanel
	{
		private GameController controller;
		private SpringLayout layout;
		private JLabel userNameLabel;
		private JTextField spUserNameField;

		private JButton rockButton;
		private JButton paperButton;
		private JButton scissorsButton;

		private JLabel displayInfo;
		private JLabel displayGames;
		
		private String userAnswer;

		public SinglePlayerPanel(GameController controller)
			{
				this.controller = controller;

				layout = new SpringLayout();
				userNameLabel = new JLabel("Player UserName: ");
				spUserNameField = new JTextField();

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
				buildListeners();
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
				add(spUserNameField);
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
				layout.putConstraint(SpringLayout.NORTH, displayInfo, 54, SpringLayout.SOUTH, rockButton);
				layout.putConstraint(SpringLayout.WEST, displayInfo, 0, SpringLayout.WEST, userNameLabel);
				layout.putConstraint(SpringLayout.NORTH, displayGames, 6, SpringLayout.SOUTH, displayInfo);
				layout.putConstraint(SpringLayout.WEST, displayGames, 0, SpringLayout.WEST, userNameLabel);
			}

		private void buildListeners()
			{
				rockButton.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent click)
							{
								userAnswer = "Rock";
								checkAnswer();
							}
					});
				paperButton.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent click)
							{
								userAnswer = "Paper";
								checkAnswer();
							}
					});
				scissorsButton.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent click)
							{
								userAnswer = "Scissors";
								checkAnswer();
							}
					});
			}

		public String getAnswer()
			{
				return userAnswer;
			}

		private void checkAnswer()
			{
				if (checkForUserName())
					{
						controller.getBot().generateBotAnswer();
						controller.getBot().compareAnswers();
					}
			}

		private boolean checkForUserName()
			{
				if (this.spUserNameField.getText().isEmpty())
					{
						displayInfo.setText("Please Type a UserName");
						return false;
					}
				else
					return true;
			}

		public void updateText(String status)
			{
				displayInfo.setText("<html>" + spUserNameField.getText() + " has " + status + "<br>The Bot selected " + controller.getBot().getBotAnswer() + "<br>You selected " + userAnswer + "<html>");
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
