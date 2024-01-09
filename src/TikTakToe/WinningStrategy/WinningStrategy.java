package TikTakToe.WinningStrategy;

import TikTakToe.Board;
import TikTakToe.Move;

public interface WinningStrategy {
	
    void updateCount(Board board, Move move);
	 
	 boolean checkWinner(Board board, Move lastMove);
	 
	

}
