package TikTakToe;

import java.util.*;

import TikTakToe_enum.CellState;


public class Board {
	
	private  int size;  // to define the board size  N.
	
	private List<List<Cell>> board;
	
	//Constructor
	public Board(int size) {
		this.size = size;
		initializeBoard();
	}
	


	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public List<List<Cell>> getBoard() {
		return board;
	}
	
	public void setBoard(List<List<Cell>> board) {
		this.board = board;
	}
	
	public void initializeBoard() {
		this.board = new ArrayList<>();
		 for(int i=0;i<size;i++) {
			 List<Cell> rowCell =  new ArrayList<>();
			 for(int j=0;j<size;j++) {
				  rowCell.add(new Cell(i,j));
			 }
			 board.add(rowCell);
		 }
	}

	public void displayBoard() {
		// TODO Auto-generated method stub
		
		System.out.println();
		 for(int i=0;i<size;i++) {
			 for(int j=0;j<size;j++) {
				 Cell cell = board.get(i).get(j);
				 if(cell.getCellstate()==CellState.EMPTY) {
					 System.out.print("  ");
				 } else {
					 System.out.print(" "+cell.getPlayer().getSymbol().getCharacter()+" ");
				 }
				 
				 if(j<size-1) {
					 System.out.print("|");
				 }
			 }
			 
			 System.out.println();
			  for(int j=0;j<size-1 && j<size;j++) {
				  System.out.print("----");
			  }
			  System.out.println();
		 }
	}


	

}
