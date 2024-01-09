package TikTakToe.WinningStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import TikTakToe.Board;
import TikTakToe.Cell;
import TikTakToe.Move;
import TikTakToe.Player;

public class DiagonalWinningStrategy extends MapWinningStrategy {


	public DiagonalWinningStrategy(List<Player> playerslist) {
		 super(2, playerslist);
		 
	}
	
	@Override
	public void updateCount(Board board, Move lastMove) {
		Cell  cell = lastMove.getCell();
		int row = cell.getRow();
		int column  = cell.getColumn();
		Player player = lastMove.getPlayers();
		
		
		//left diagonal is type 0
		if(row==column) {
			 updateCountMap(0, player);
		}
		
		//right Diagonal is type 1.
		
		if(row+column ==board.getSize()-1) {
			updateCountMap(1,player);
		}
		
	
	}
	
	@Override
	public boolean checkWinner(Board board, Move lastMove) {
		
		Cell  cell = lastMove.getCell();
		int column = cell.getColumn();
		Player player = lastMove.getPlayers();
		int row = cell.getRow();
		
	
		//Left Diagonal  is type 0
		if(row==column) {
			  if(checkWinnerfunc(0,player,board.getSize())){
				  return true;
			  }
		
		}
		

		//Right Diagonal  is type 1
		if(row+column== board.getSize()-1) {
			if(checkWinnerfunc(1,player,board.getSize())) {
				return true;
			}
		}
		
		return false;
	}


}
