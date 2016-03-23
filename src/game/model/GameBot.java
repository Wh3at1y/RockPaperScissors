package game.model;

import game.controller.GameController;
import java.util.ArrayList;
import java.util.Random;

public class GameBot
	{
		private GameController controller;
		private ArrayList<String> wordList;
		private Random randomizer;
		private String selectedAnswer;
		private int counter;
		private int tieCounter;

		public GameBot(GameController controller)
			{
				this.controller = controller;
				randomizer = new Random();
				counter = 0;
				tieCounter = 0;
				wordList = new ArrayList<String>();
				wordList.add("Rock");
				wordList.add("Paper");
				wordList.add("Scissors");
			}

		public void compareAnswers()
			{
				String userAnswer = controller.getFrame().getPanel().getSpPanel().getAnswer();
				if (getBotAnswer().equals("Rock") && userAnswer.equals("Paper"))
					{
						counter++;
						controller.getFrame().getPanel().getSpPanel().updateText("Won!!!");
					}
				else if (getBotAnswer().equals("Paper") && userAnswer.equals("Scissors"))
					{
						counter++;
						controller.getFrame().getPanel().getSpPanel().updateText("Won!!!");
					}
				else if (getBotAnswer().equals("Scissors") && userAnswer.equals("Rock"))
					{
						counter++;
						controller.getFrame().getPanel().getSpPanel().updateText("Won!!!");
					}
				else if (getBotAnswer().equals(userAnswer))
					{
						tieCounter++;
						controller.getFrame().getPanel().getSpPanel().updateText("Tied!");
					}
				else
					{
						counter--;
						controller.getFrame().getPanel().getSpPanel().updateText("Lost.");
					}

			}

		public void generateBotAnswer()
			{
				selectedAnswer = wordList.get(randomizer.nextInt(wordList.size()));
				System.out.println(selectedAnswer);
			}

		public String getBotAnswer()
			{
				return selectedAnswer;
			}
		
		public int getCounter()
		{
			return counter;
		}
		public int getTieCounter()
		{
			return tieCounter;
		}
	}
