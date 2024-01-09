package GameController;

import java.util.List;

import Exception.BotCountException;
import Exception.DimensionException;
import TikTakToe.Game;
import TikTakToe.Player;
import TikTakToe.WinningStrategy.WinningStrategy;

public class GameControllerFlow {
	
		//stateless Class
	
		public Game startGame(int size, List<Player> players , List<WinningStrategy> winningStrategy) throws BotCountException, DimensionException  {
			return Game.getBuilder().
			setBoard(size).
			setPlayers(players).
			setWinningStrategy(winningStrategy).
			build();
			
			
		}
		
		public void displayBoard(Game game) {
			 game.getBoard().displayBoard();
		}
		
		public void makeMove(Game game) {
			 game.makeMove();
		}
		
		public void checkWinner(Game game) {
			
		}
		
		public void undoFeature(Game game) {
			
		}
		
		

}
