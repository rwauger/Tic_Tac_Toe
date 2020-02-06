package cpsc2150.extendedTicTacToe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameBoardMem extends AbsGameBoard implements IGameBoard {
	/**
	 *Correspondences:
	 * 	rows = row
	 * 	cols = col
	 * 	number_to_win = num_to_win
	 * 	gameboard = new HashMap()
	 *
	 * @invariant number_to_win > 0
	 * @invariant rows > 0
	 * @invariant cols > 0
	 * @invariant [gameBoard has to be a map with the keys being Characters and values being a list of BoardPositions]
	 *
	 */
	private int number_to_win;
	private int rows;
	private int cols;
	private Map<Character, List<BoardPosition>> gameboard;

	/**
	 * @pre
	 * none
	 * @post
	 * [map of gameboard in initialized]
	 */
	public GameBoardMem(int row, int col, int num_to_win){
		this.number_to_win = num_to_win;
		this.rows = row;
		this.cols = col;
		gameboard = new HashMap<>();
	}

	public void placeMarker(BoardPosition marker, char player) {
		//places the character in marker on the position specified by
		//marker, and should not be called if the space is not available.
		List<BoardPosition> list;
		if(gameboard.containsKey(player)){
			list = gameboard.get(player);
			list.add(marker);
		}
		else{
			list = new ArrayList<>();
			list.add(marker);
			gameboard.put(player, list);
		}
	}

	public char whatsAtPos(BoardPosition pos) {
		//returns what is in the GameBoard at position pos
		//If no marker is there it returns a blank space char ‘ ‘
		for(Map.Entry<Character,List<BoardPosition>> entry : gameboard.entrySet()){
			List<BoardPosition> list;
			list = entry.getValue();
			for(BoardPosition tmp: list){
				if(tmp.equals(pos)){
					return entry.getKey();
				}
			}
		}
		return ' ';
	}

	public boolean isPlayerAtPos(BoardPosition pos, char player){
		for(Map.Entry<Character,List<BoardPosition>> entry : gameboard.entrySet()){
			if(entry.getKey().equals(player)){
				List<BoardPosition> list;
				list = entry.getValue();
				for(BoardPosition tmp : list){
					if(tmp.equals(pos)){
						return true;
					}
				}
				return false;
			}
		}
		return false;
	}

	public int getNumToWin(){return this.number_to_win; }

	public int getNumRows() { return this.rows; }

	public int getNumColumns(){ return this.cols; }

}
