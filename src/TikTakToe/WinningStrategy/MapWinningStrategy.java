package TikTakToe.WinningStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import TikTakToe.Board;
import TikTakToe.Move;
import TikTakToe.Player;

public abstract class MapWinningStrategy implements WinningStrategy {
	
	private HashMap<Integer, Map<Player, Integer>> countMap;
	private int dimension;
	

	public MapWinningStrategy(int dimension, List<Player> playerslist) {
		this.dimension = dimension;
		this.countMap = new HashMap<>();
		initializeRowMap(playerslist);
	}
	
	private void initializeRowMap(List<Player> playerslist) {
		for(int i=0;i<dimension;i++) {
			countMap.put(i, new HashMap<>());
			
			for(Player player : playerslist) {
				countMap.get(i).put(player, 0);
			}
		}
		
	}
	
	
	public void updateCountMap(int key, Player player) {
		int existingCount = countMap.get(key).get(player);
		int newCount = existingCount+1;
		countMap.get(key).put(player,newCount);
		
	}
	
	public boolean checkWinnerfunc(int key, Player player, int boardSize) {
		
		
		if(countMap.get(key).get(player) == boardSize) {
			return true;
		}
		
			return false;
	}
	
}
