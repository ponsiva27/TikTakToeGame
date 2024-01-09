package ClientFolder;

import java.util.List;

import Exception.BotCountException;
import Exception.DimensionException;

import java.util.ArrayList;

import GameController.GameControllerFlow;
import TikTakToe.Bot;
import TikTakToe.Game;
import TikTakToe.Player;
import TikTakToe.Symbol;
import TikTakToe.WinningStrategy.ColumnWinningStrategy;
import TikTakToe.WinningStrategy.DiagonalWinningStrategy;
import TikTakToe.WinningStrategy.RowWinningStrategy;
import TikTakToe.WinningStrategy.WinningStrategy;
import TikTakToe_enum.BotDifficultyLevel;
import TikTakToe_enum.GameStatus;

public class Client {
	
	

	public static void main(String[] args) throws BotCountException, DimensionException {
		// TODO Auto-generated method stub
		
		int size =3;
		
		GameControllerFlow gameFlow = new GameControllerFlow();
		
		
		//Add a Player to a Game
		List<Player> players = new ArrayList<>();
		
		players.add(new Player(1, "Ponsiva", new Symbol('X')));
		players.add(new Bot(2, "Bot Sophieya",new Symbol('B'), BotDifficultyLevel.MEDIUM));
		
	
		//Add a WinningStrategy to a Game
		List<WinningStrategy> winningStrategy = new ArrayList<>();
		
		winningStrategy.add(new ColumnWinningStrategy(size,players));
		winningStrategy.add(new RowWinningStrategy(size, players));
		winningStrategy.add(new DiagonalWinningStrategy(players));
		
		 Game game = gameFlow.startGame(size, players, winningStrategy);
		 
		System.out.println("game has been started");
		//Game game =  gameFlow.startGame(Size, players, winningStrategy);   // this enable to create different game  and passing to controller.
		
		while(game.getGameStatus()==GameStatus.IN_PROGRESS) {
			
			gameFlow.displayBoard(game);   			  	//Note:- We should not add the game reference (game Object) as part of Controller attributes is not a good design.
			gameFlow.makeMove(game); 					// we should be getting the reference for each game and giving it to controller.  e.g :- I want to make move for this game. ; I want to undo for that game.
														// This ensures we have multiple game running simultaneously and controller control it .
			 
		}	
			if(game.getGameStatus()==GameStatus.COMPLETED) {
				 	System.out.println("\n Game is Completed !!"+" "+"Winner is"+" "+game.getWinner().getName());
				 
			 }  if (game.getGameStatus() == GameStatus.DRAW) {
				   System.out.println("Game is Completed, and ended up in DRAW "+" "+"No Winner's from this game");
				 
			    } 
			 
			
		
	}

}
