package cpsc2150.extendedTicTacToe;

/**
 * this object will run the game TicTacToe
 * @Defines: rows: R
 *           cols: Z
 *           number_to_win: S
 * @Initialization Ensures: [the gameboard is set to all empty spaces or a map has been set] [the number of columns are set]
 *                          [the number of rows are set] [the number to win is set] [the gameboard is initialized]
 * @Constraints: number_to_win > 0, gameBoard_length > 0, [gameBoard has to be a 2D matrix of type char or gameboard has to be a Map]
 *
 */
public interface IGameBoard {
	public static int min_rows = 3;
	public static int min_cols = 3;
	public static int min_num_to_win = 3;

	/**
	 * @return rows which are the number of rows in the gameboard
	 * @pre
	 * none
	 * @post
	 * getNumRows = rows
	 */
	int getNumRows();

	/**
	 * @return columns which are the number of columns in the gameboard
	 * @pre
	 * none
	 * @post
	 * getNumColumns = cols
	 */
	int getNumColumns();

	/**
	 * @return number_to_win which is the number in a row to win
	 * @pre
	 * none
	 * @post
	 * getNumToWin = number_to_win
	 */
	int getNumToWin();

	/**
	 * @param pos is the area of the matrix we are looking at
	 * @return marker is what is at the current position
	 * @pre
	 * pos == valid
	 * @post
	 * whatsAtPos = 'X' or whatsAtPos = 'O' or whatsAtPos = ' '
	 */
	char whatsAtPos(BoardPosition pos);

	/**
	 * @param pos is the area of the matrix we are looking at
	 * @return true if the space is available and false otherwise
	 * @pre
	 * pos != null and pos == valid
	 * @post
	 * checkSpace = true or checkSpace = false
	 */
	default boolean checkSpace(BoardPosition pos) {
		//returns true if the position specified in pos is available,
		//false otherwise
		return pos.getColumn() >= 0 && pos.getRow() >= 0 && pos.getColumn() < getNumColumns()
						&& pos.getRow() < getNumRows() && whatsAtPos(pos) == ' ';
	}

	/**
	 * @param lastPos is the last position that we had placed a marker
	 * @return true if there is a winner and false otherwise
	 * @pre
	 * lastpos == valid
	 * @post
	 * checkForWinner = true or checkForWinner = false
	 */
	default boolean checkForWinner(BoardPosition lastPos) {
		//this function will check to see if the lastPos placed resulted
		//in a winner. It so it will return true, otherwise false.
		//Passing in the last position will help limit the possible
		//places to check for a win condition, since you can assume that any win
		//condition that did not include the most recent play made would have
		//been caught earlier.
		//You may call other methods to complete this method

		if(checkDiagonalWin(lastPos, whatsAtPos(lastPos)) || checkHorizontalWin(lastPos, whatsAtPos(lastPos))
						|| checkVerticalWin(lastPos, whatsAtPos(lastPos))) {
			return true;
		}
		return false;
	}

	/**
	 * @param lastPos is the last position we placed a marker
	 * @param player is the character we are placing
	 * @return true if there is a horizontal win or false otherwise
	 * @pre
	 * player = [an uppercase single character] and lastPos != null and lastPos == valid
	 * @post
	 * checkHorizontalWin = true iff [there are 5 of the same player type in a row] or checkHorizontalWin = false otherwise
	 */
	default boolean checkHorizontalWin(BoardPosition lastPos, char player) {
		//checks to see if the last marker placed resulted in 5 in a row
		//horizontally. Returns true if it does, otherwise false
		int row = lastPos.getRow();
		int col = lastPos.getColumn();
		int flag = 0;
		BoardPosition pos;

		while(col > 0 && isPlayerAtPos(new BoardPosition(row, col-1), player)) {
			col--;
		}

		while(col < getNumColumns()) {
			pos = new BoardPosition(row, col);
			if (isPlayerAtPos(pos, player)) {
				flag++;
			}
			else{
				break;
			}
			if(flag == getNumToWin()) {
				return true;
			}
			col++;
		}
		return false;
	}

	/**
	 * @param lastPos is the last position we placed a marker
	 * @param player is the character we are placing
	 * @return true if there is a vertical win or false otherwise
	 * @pre
	 * player = [an uppercase single character] and lastPos != null and lastPos == valid
	 * @post
	 * checkVerticalWin = true iff [there are 5 of the same player type in a row] or checkVerticalWin = false otherwise
	 */
	default boolean checkVerticalWin(BoardPosition lastPos, char player) {
		//checks to see if the last marker placed resulted in 5 in a row
		//horizontally. Returns true if it does, otherwise false
		int row = lastPos.getRow();
		int col = lastPos.getColumn();
		int flag = 0;
		BoardPosition pos;

		while(row > 0 && isPlayerAtPos(new BoardPosition(row - 1, col), player)) {
			row--;
		}

		while(row < getNumRows()) {
			pos = new BoardPosition(row, col);
			if (isPlayerAtPos(pos, player)) {
				flag++;
			}
			else{
				break;
			}
			if(flag == getNumToWin()){
				return true;
			}
			row++;
		}
		return false;
	}

	/**
	 * @param lastPos is the last position we placed a marker
	 * @param player is the character we are placing
	 * @return true if there is a diagonal win or false otherwise
	 * @pre
	 * player = [an uppercase single character] and lastPos != null and lastPos == valid
	 * @post
	 * checkDiagonalWin = true iff [there are 5 of the same player type in a row] or checkDiagonalWin = false otherwise
	 */
	default boolean checkDiagonalWin(BoardPosition lastPos, char player) {
		//checks to see if the last marker placed resulted in 5 in a row
		//diagonally. Returns true if it does, otherwise false
		//Note: there are two diagonals to check
		int row = lastPos.getRow();
		int col = lastPos.getColumn();
		int row2 = row;
		int col2 = col;
		int flag = 0;
		BoardPosition pos;

		while(row != 0 && col != 0 && isPlayerAtPos(new BoardPosition(row - 1, col - 1), player)) {
			row--;
			col--;
		}

		while(row < getNumRows() && col < getNumColumns()) {
			pos = new BoardPosition(row, col);
			if(isPlayerAtPos(pos, player))
				flag++;
			else{
				break;
			}
			if(flag == getNumToWin()){
				return true;
			}
			row++;
			col++;
		}

		while(row2 < (getNumRows() - 1) && col2 > 0 && isPlayerAtPos(new BoardPosition(row2 + 1, col2 - 1), player)) {
			row2++;
			col2--;
		}

		flag = 0;

		while(row2 >= 0 && col2 < getNumColumns()) {
			pos = new BoardPosition(row2, col2);
			if(isPlayerAtPos(pos, player)) {
				flag++;
			}
			else{
				break;
			}
			if(flag == getNumToWin()){
				return true;
			}
			row2--;
			col2++;
		}

		return false;
	}

	/**
	 * @return true if there is a draw or false otherwise
	 * @pre
	 * none
	 * @post
	 * checkForDraw = true iff [board is full] or checkForDraw = false iff [board is not full]
	 */
	default boolean checkForDraw() {
		//this function will check to see if the game has resulted in a
		//tie. A game is tied if there are no free board positions remaining.
		//You do not need to check for any potential wins, because we can assume
		//that the players were checking for win conditions as they played the
		//game. It will return true if the game is tied, and false otherwise.
		int i, j;
		for(i = 0; i < getNumRows(); i++) {
			for(j = 0; j < getNumColumns(); j++) {
				BoardPosition pos = new BoardPosition(i, j);
				int position = whatsAtPos(pos);
				if(position == ' ') {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * @param marker is the position we are placing the marker
	 * @param player is the character we are placing
	 * @pre
	 * player = 'X' or player = 'O' and marker != null and marker == valid
	 * @post
	 * [player will have been placed into the matrix at position marker]
	 */
	void placeMarker(BoardPosition marker, char player);

	/**
	 * @param pos the position you are currently looking at
	 * @param player the character that we are checking
	 * @return true if the the player is at the position or false if the player is not at the position
	 * @pre
	 * pos == valid && player == valid_player
	 * @post
	 * isPlayerAtPos == true || isPlayerAtPos == false
	 */
	default boolean isPlayerAtPos(BoardPosition pos, char player){
		return whatsAtPos(pos) == player;
	}


}
