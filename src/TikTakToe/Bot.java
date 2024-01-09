package TikTakToe;

import BotPlayingStrategy.BotStrategy;
import Factory.BotPlayingStrategy;
import TikTakToe_enum.BotDifficultyLevel;
import TikTakToe_enum.PlayerType;

public class Bot extends Player {
	
	private BotDifficultyLevel difficultyLevel;
	
	

	public Bot(int playerId, String name, Symbol symbol, BotDifficultyLevel difficultyLevel) {
		super(playerId, name, symbol);
		this.setPlayertype(PlayerType.BOT);
		this.difficultyLevel = difficultyLevel;
	}
	

	public BotDifficultyLevel getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(BotDifficultyLevel difficultLevel) {
		this.difficultyLevel = difficultLevel;
	}

	
     @Override
     public Move makeMove(Board board) {
    	 
    	
    	 BotStrategy playingStrategy = BotPlayingStrategy.getBotPlayingStrategyByDifficultyLevel(this);
         return playingStrategy.makeBotMove(board);
    
     }
	
	
	
}
