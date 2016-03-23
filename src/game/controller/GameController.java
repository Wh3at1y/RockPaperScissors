package game.controller;

import game.display.GameFrame;

public class GameController
	{
		private GameFrame frame;
		
		public GameController()
		{
			frame = new GameFrame(this);
		}
	}
