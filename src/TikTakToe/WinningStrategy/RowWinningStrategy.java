package TikTakToe.WinningStrategy;
import java.util.*;

import TikTakToe.Board;
import TikTakToe.Cell;
import TikTakToe.Move;
import TikTakToe.Player;


public class RowWinningStrategy extends MapWinningStrategy {
	

	
	
	public RowWinningStrategy(int dimension, List<Player> playerslist) {
		 super(dimension, playerslist);
		 
	}
	

	@Override
	public void updateCount(Board board, Move lastMove) {
		Cell  cell = lastMove.getCell();
		int row  = cell.getRow();
		Player player = lastMove.getPlayers();
		
		 updateCountMap(row, player);
	}
	
	@Override
	public boolean checkWinner(Board board, Move lastMove) {
		
		Cell  cell = lastMove.getCell();
		int row  = cell.getRow();
		Player player = lastMove.getPlayers();
		
		
		return checkWinnerfunc(row, player, board.getSize());
	}
	
}
