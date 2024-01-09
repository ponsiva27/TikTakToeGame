package BotPlayingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import TikTakToe.Board;
import TikTakToe.Bot;
import TikTakToe.Cell;
import TikTakToe.Move;
import TikTakToe_enum.CellState;

public class HardBotStrategy implements BotStrategy {
	
	
Bot bot;
	
	public HardBotStrategy(Bot bot) {
		this.bot = bot;
	}
	
	
	@Override
	public Move makeBotMove(Board board) {
		System.out.println("It's "+ bot.getName()+  "turn and it's thinking to make a move...\n");
		List<Cell> empytCellsList = getEmptyCells(board);
		
		Random random = new Random();
		
		int randomChosenIndex = random.nextInt(empytCellsList.size());
		Cell randomChosenCell =  empytCellsList.get(randomChosenIndex);
		
		randomChosenCell.setPlayer(bot);
		randomChosenCell.setCellstate(CellState.OCCUPIED);
		return new Move(randomChosenCell, bot);
		
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
