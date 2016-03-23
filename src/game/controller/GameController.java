package game.controller;

import game.display.GameFrame;
import game.model.GameBot;

public class GameController
	{
		private GameFrame frame;
		private GameBot gameBot;
		
		public GameController()
		{
			frame = new GameFrame(this);
			gameBot = new GameBot(this);
		}
		
		public GameFrame getFrame()
		{
			return frame;
		}
		
		public GameBot getBot()
		{
			return gameBot;
		}
	}
