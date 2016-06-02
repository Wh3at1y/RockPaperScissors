package game.display;

import javax.swing.*;
import game.controller.GameController;

public class GameFrame extends JFrame
	{
		private GamePanel panel;
		
		public GameFrame(GameController controller)
		{
			panel = new GamePanel(controller);
			buildFrame();
		}
		
		private void buildFrame()
		{
			this.setTitle("Rock Paper Scissors");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);
			this.setSize(600,500);
			this.setContentPane(panel);
			this.setVisible(true);
		}
		
		public GamePanel getPanel()
		{
			return panel;
		}
	}
