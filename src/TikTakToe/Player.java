package TikTakToe;

import TikTakToe_enum.CellState;
import TikTakToe_enum.PlayerType;
import java.util.*;

public class Player {
	
	private int playerId;
	private String name;
	private Symbol symbol;
	private PlayerType playertype;
	
	
	public Player(int playerId, String name, Symbol symbol) {
		
		this.playerId= playerId;
		this.name = name;
		this.symbol = symbol;
		this.playertype = playertype.HUMAN;
	}
	
	
	public int getPlayerId() {
		return playerId;
	}
	
	public void setPlayerId(int playerId) {
		playerId = playerId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Symbol getSymbol() {
		return symbol;
	}
	
	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}
	
	public PlayerType getPlayertype() {
		return playertype;
	}
	
	public void setPlayertype(PlayerType playertype) {
		this.playertype = playertype;
	}


	public Move makeMove(Board board) {
		// TODO Auto-generated method stub
		
		Cell SelectedCell = getSelectedCell(board);
		
		SelectedCell.setPlayer(this);
		SelectedCell.setCellstate(CellState.OCCUPIED);
		
		Move move = new Move(SelectedCell, this);
		
		return move;
		
	}
	
	public Cell getSelectedCell(Board board) {
	  while(true) {
		System.out.println("Player"+" "+this.getName()+":-"+" "+"Please make your move");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Row:");
		int row = sc.nextInt();
		System.out.print("Enter the column:");
		int col = sc.nextInt();
		
		//validate the row, column, inputs within the boundary of board
		
		if(!isValidInput(row, col,board.getSize())) {
			 	continue;
		   }
		
	   Cell selectedCell = board.getBoard().get(row).get(col);
	   
	    if(isValidSelectedCell(selectedCell)) {
	           return selectedCell;
	    }
	         
	   }
	   
	
	}
	
	 private boolean isValidSelectedCell(Cell selectedCell) {
		 
		 if(selectedCell.getCellstate()==CellState.OCCUPIED) {
			  System.out.println("\n This cell is already occupied"+ " Please try again \n");
			  
			    return false;
		 }
		 
		 	return true;
	}
	 
	 private boolean isValidInput(int row, int col, int size) {
			// TODO Auto-generated method stub
			 if(row >=0 && row <size && col >=0  && col <size) {
				 return true;
			 }
		System.out.println("\n Please Provide the inputs within boundary!"); 
			 return false;
	 }
		
	
}
