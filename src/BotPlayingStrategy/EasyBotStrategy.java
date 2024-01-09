package BotPlayingStrategy;

import java.util.*;

import TikTakToe.Board;
import TikTakToe.Bot;
import TikTakToe.Cell;
import TikTakToe.Move;
import TikTakToe_enum.CellState;

public class EasyBotStrategy implements BotStrategy{
	
	Bot bot;
	
	public EasyBotStrategy(Bot bot) {
		this.bot = bot;
	}
	
	
	@Override
	public Move makeBotMove(Board board) {
		System.out.println("It's a "+ bot.getName()+ "turn and it's thinking to make a move...\n");
		List<Cell> empytCellsList = getEmptyCells(board);
		
		Cell chosenCell = empytCellsList.get(0);
		chosenCell.setPlayer(bot);
		chosenCell.setCellstate(CellState.OCCUPIED);
		return  new Move(chosenCell, bot);
	}
	
	
	public List<Cell> getEmptyCells(Board board) {
		// TODO Auto-generated method stub
		int boardSize =  board.getSize();
		List<Cell> emptyCells = new ArrayList<>();
		 
		 for(int i=0;i<boardSize;i++) {
			 for(int j=0;j<boardSize;j++) {
				 Cell currentCell = board.getBoard().get(i).get(j);
				  if(currentCell.getCellstate() == CellState.EMPTY) {
					    emptyCells.add(currentCell);
				  }
			 }
		 }
		 
		 return emptyCells;
	}
	
	

}
