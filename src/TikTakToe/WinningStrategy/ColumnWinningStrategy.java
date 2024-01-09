package TikTakToe.WinningStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import TikTakToe.Board;
import TikTakToe.Cell;
import TikTakToe.Move;
import TikTakToe.Player;

public class ColumnWinningStrategy extends MapWinningStrategy {
	
	
	public ColumnWinningStrategy(int dimension, List<Player> playerslist) {
		
		super(dimension, playerslist);
		 
	}
	
	
	@Override
	public void updateCount(Board board, Move lastMove) {
		Cell  cell = lastMove.getCell();
		int column  = cell.getColumn();
		Player player = lastMove.getPlayers();
		
		 updateCountMap(column, player);
	}
	
	@Override
	public boolean checkWinner(Board board, Move lastMove) {
		
		Cell  cell = lastMove.getCell();
		int column = cell.getColumn();
		Player player = lastMove.getPlayers();
		
		return checkWinnerfunc(column,player, board.getSize());
	}


}
