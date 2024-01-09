package TikTakToe;

import java.util.List;

import Exception.BotCountException;
import Exception.DimensionException;

import java.util.*;

import TikTakToe.WinningStrategy.WinningStrategy;
import TikTakToe_enum.GameStatus;
import TikTakToe_enum.PlayerType;

public class Game {
	
	private Board board;
	private List<Player> players;
	private List<WinningStrategy> winningStrategy;
	private Player winner;
	private List<Move> moves;
	private int currentPlayerIndex;
	private GameStatus gameStatus;
	
	

	private Game(Builder build) {
	  this.players =  build.players;
	  this.winningStrategy = build.winningStrategy;
	  this.board = new Board(build.size);
	  this.gameStatus =GameStatus.IN_PROGRESS;
	  this.moves = new ArrayList<>();
	  this.winner = null;
	  this.currentPlayerIndex = 0;
	
	}

	public Board getBoard() {
		return board;
	}
	
	
	public void setBoard(Board board) {
		this.board = board;
	}
	
	
	public List<Player> getPlayers() {
		return players;
	}
	
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	public List<WinningStrategy> getWinningStrategy() {
		return winningStrategy;
	}
	
	public void setWinningStrategy(List<WinningStrategy> winningStrategy) {
		
		this.winningStrategy = winningStrategy;
	}
	
	public Player getWinner() {
		return winner;
	}
	
	public void setWinner(Player winner) {
		this.winner = winner;
	}
	
	public List<Move> getMoves() {
		return moves;
	}
	
	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}
	
	public int getCurrentPlayerIndex() {
		return currentPlayerIndex;
	}
	public void setCurrentPlayerIndex(int currentPlayerIndex) {
		this.currentPlayerIndex = currentPlayerIndex;
	}
	public GameStatus getGameStatus() {
		return gameStatus;
	}
	public void setGameStatus(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}
	
	public static Builder getBuilder() {
		return new Builder();
	}
	
	
	//Builder design Pattern
	 public static class  Builder {
		 
		 	private int size;
			private List<Player> players;
			private List<WinningStrategy> winningStrategy;
			
			
			public Builder setBoard(int size) {
				this.size = size;
				return this;
			}
			
			public Builder setPlayers(List<Player> players) {
				this.players = players;
				return this;
			}
			
			public Builder setWinningStrategy(List<WinningStrategy> winningStrategy) {
				this.winningStrategy = winningStrategy;
				return this;
			}
			
			public Game build() throws DimensionException, BotCountException {
				//validation 
				validate();
				return new Game(this);
			}
			
			private void validateBotCount() throws BotCountException {
				//Bot Validation 	//Only one bot in the game;
				 int botCount=0;
				 
				 for(Player player : players) {
					  if(player.getPlayertype()==PlayerType.BOT) {
						  botCount++;
					  }
				 }
				 
				 if(botCount >1) {
					 throw new BotCountException("Bot should not be more than 1 Player");
				 }		
		 
			}
			
			private void validateDimension() throws DimensionException {
				// Board size must be or greater than 3;
				if(size<3) {
					throw new DimensionException("Board Dimension should not be less than 3");
				}
			}
			
			private void validatePlayer() {
				//Player Validation // No.of.Player should be size-1;
				if(players.size()!=size-1) {
					throw new IllegalArgumentException("Please add Player equal to Board size-1");
				}
			}
			
			private void validateSymbol() {
				//Duplicate Symbol Validation //No duplicate symbols;
				HashSet<Character> symbol = new HashSet<>();
				  for(Player player:players) {
					  if(symbol.contains(player.getSymbol().getCharacter())) {
						  throw new IllegalArgumentException("Duplicate Symbols Found, Please try again with new other Symbol");
					  }
					 symbol.add(player.getSymbol().getCharacter());
				  }
			}
			

			private void validate() throws DimensionException, BotCountException  {
				
				validateDimension();
				validatePlayer();
				validateSymbol();
				validateBotCount();
				
		
		}

	}
	 
	     public void makeMove() {
	 
		
	    	 int currentPlayerIndex = this.getCurrentPlayerIndex();
	    	 Player currentPlayer = this.getPlayers().get(currentPlayerIndex);
		
	    	 Move move = currentPlayer.makeMove(this.getBoard());
	    	 this.moves.add(move);
	    	 
	    	 //Update the count Map
	    	 for(WinningStrategy winningStrategy : this.winningStrategy) {
	    		 winningStrategy.updateCount(this.getBoard(), move);
	    	 }
	    	 
	    	 //check if there is a winner for this move
	    	 for(WinningStrategy winningStrategy : this.winningStrategy) {
	    		if( winningStrategy.checkWinner(board,move)) {
	    			this.setWinner(currentPlayer);
	    			this.setGameStatus(GameStatus.COMPLETED);
	    			return;
	    		}
	    		
	    		if(this.moves.size() == board.getSize()*board.getSize()) {
	    			this.setGameStatus(gameStatus.DRAW);
	    			   return;
	    		}
	    	 }
		
	    	 int nextPlayerIndex = (currentPlayerIndex+1) % (this.getBoard().getSize()-1);
	    	 this.setCurrentPlayerIndex(nextPlayerIndex);
      }
	  	
}
