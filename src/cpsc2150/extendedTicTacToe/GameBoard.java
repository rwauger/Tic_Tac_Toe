package cpsc2150.extendedTicTacToe;

public class GameBoard extends AbsGameBoard implements IGameBoard{
	/**
	 *  Correspondences:
	 * 	  rows = row
	 * 	  cols = col
	 * 	  number_to_win = num_to_win
	 * 	  gameboard = new char[row][col]
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
	private char[][] gameBoard;

	/**
	 * @pre
	 * none
	 * @post
	 * [GameBoard is initialized to all ' ']
	 */
	public GameBoard(int row, int col, int num_to_win){
		int i, j;
		gameBoard = new char[row][col];
		this.number_to_win = num_to_win;
		this.rows = row;
		this.cols = col;
		for(i = 0; i < row; i++) {
			for(j = 0; j < col; j++) {
				gameBoard[i][j] = ' ';
			}
		}
	}

	public void placeMarker(BoardPosition marker, char player) {
		//places the character in marker on the position specified by
		//marker, and should not be called if the space is not available.
		gameBoard[marker.getRow()][marker.getColumn()] = player;
	}

	public char whatsAtPos(BoardPosition pos) {
		//returns what is in the GameBoard at position pos
		//If no marker is there it returns a blank space char ‘ ‘
		return gameBoard[pos.getRow()][pos.getColumn()];
	}


	public int getNumToWin(){ return this.number_to_win; }

	public int getNumRows() { return this.rows; }

	public int getNumColumns(){ return this.cols; }

}
