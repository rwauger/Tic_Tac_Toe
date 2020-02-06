package cpsc2150.extendedTicTacToe;

public class BoardPosition {
  /**
   * @invariant row >= 0 and row <= 7 and col >= 0 and col <= 7
   */
  private int row;
	private int col;

	/**
	 * @param row is the current row position
	 * @param col is the current column position
	 * @pre
	 * row >= 0 and row <= 7 and col >= 0 and col <= 7
	 * @post
	 * this.row = row and this.col = col
	 */
	public BoardPosition(int row, int col){
		this.row = row;
		this.col = col;
	}

  /**
   * @return row which is the current row position
   * @pre
   * none
   * @post
   * getRow = row
   */
  public int getRow(){
		//returns the row
    return this.row;
  }

	/**
	 * @return col which is the current column position
	 * @pre
	 * none
	 * @post
	 * getColumn = col
	 */
	public int getColumn(){
		//returns the column
		return this.col;
  }

  /**
   *
   * @param obj which is the object class we are trying to override the equals for
   * @return true if it equals what we are checking or false if it doesn't
   * @pre
   * obj != null
   * @post
   * we either return a true or false
   */
  @Override
  public boolean equals(Object obj) {
	  if(!(obj instanceof BoardPosition))
	    return false;
	  BoardPosition pos = (BoardPosition) obj;
	  return (pos.getRow() == row) && (pos.getColumn() == col);
  }

	/**
	 * @return answer which is the string we are going to print out.
	 * @pre
	 * none
	 * @post
	 * toString = the nicely printed matrix
	 */
	@Override
	public String toString(){
		return String.valueOf(row) + ',' + col;
	}
}
