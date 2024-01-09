package TikTakToe;

public class Move {

	private Player players;
	private Cell cell;
	
	public Move(Cell cell, Player players) {
		this.cell = cell;
		this.players = players;
	}

	public Player getPlayers() {
		return players;
	}

	public void setPlayers(Player players) {
		this.players = players;
	}

	public Cell getCell() {
		return cell;
	}

	public void setCell(Cell cell) {
		this.cell = cell;
	}


	
	

}
