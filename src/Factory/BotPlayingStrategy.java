package Factory;

import BotPlayingStrategy.BotStrategy;
import BotPlayingStrategy.EasyBotStrategy;
import BotPlayingStrategy.HardBotStrategy;
import BotPlayingStrategy.MediumBotStrategy;
import TikTakToe.Bot;
import TikTakToe_enum.BotDifficultyLevel;

public class BotPlayingStrategy {
	
	public static BotStrategy getBotPlayingStrategyByDifficultyLevel(Bot bot){
		
        BotDifficultyLevel difficultyLevel = bot.getDifficultyLevel();
        
        if(difficultyLevel == BotDifficultyLevel.EASY){
            return new EasyBotStrategy(bot);
        } 
        else if(difficultyLevel == BotDifficultyLevel.MEDIUM){
            return new MediumBotStrategy(bot);
        } 
        else if(difficultyLevel == BotDifficultyLevel.HARD){
            return new HardBotStrategy(bot);
        }
        
        return null;
    }
}
