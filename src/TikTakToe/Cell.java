package TikTakToe;

import TikTakToe_enum.CellState;

public class Cell {
	
	private int row;
	private int column;
	private CellState cellstate;
	private Player player;
	
	
	public Cell(int row, int column) {
		this.row = row;
		this.column = column;
		this.cellstate =cellstate.EMPTY;
	}
	
	public int getRow() {
		return row;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public void setColumn(int column) {
		this.column = column;
	}
	
	public CellState getCellstate() {
		return cellstate;
	}
	
	public void setCellstate(CellState cellstate) {
		this.cellstate = cellstate;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
	
	

}
