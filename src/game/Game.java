package game;

import java.util.Random;

public class Game {
	private int boardSize;
	private int numberOfTreasures;
	private int[][] treasuresLocation;
	private int[][] playersLocation;
	
	public void Game(int boardSize, int numberOfTreasures){
		//Set variables- 
		this.boardSize = boardSize;
		this.numberOfTreasures = numberOfTreasures;
		treasuresLocation = new int[numberOfTreasures][numberOfTreasures];
		playersLocation = new int[boardSize][boardSize];
		//Place treasures on the board
		placeTreasures(numberOfTreasures);
		
	}
	//Randomly place treasures on the board.
	private void placeTreasures(int numberOfTreasures){
		int randomX = new Random().nextInt(numberOfTreasures);
		int randomY = new Random().nextInt(numberOfTreasures);
		int treasureNumber;
		
		for(int i=0;i<numberOfTreasures;i++){
			treasuresLocation[randomX][randomY] = numberOfTreasures;
		}
	}
}
