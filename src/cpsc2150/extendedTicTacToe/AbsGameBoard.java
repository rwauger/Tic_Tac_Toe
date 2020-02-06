package cpsc2150.extendedTicTacToe;

public abstract class AbsGameBoard implements IGameBoard{
	/**
	 * @return answer which is the string we are going to print out.
	 * @pre
	 * none
	 * @post
	 * toString = the nicely printed matrix
	 */
	@Override
	public String toString(){
		int i = 0, j;
		StringBuilder gameboard = new StringBuilder();
		gameboard.append("   ");

		while(i < getNumColumns()){
			if(i <= 9)
				gameboard.append(" ").append(i).append("|");
			else
				gameboard.append(i).append("|");
			i++;
		}
		gameboard.append("\n");
		for(i = 0; i < getNumRows(); i++)
		{
			if(i <= 9)
				gameboard.append(" ").append(i).append("|");
			else
				gameboard.append(i).append("|");

			for(j = 0; j < getNumColumns(); j++)
			{
				BoardPosition pos = new BoardPosition(i, j);
				char player = whatsAtPos(pos);
				gameboard.append(player).append(" ").append("|");
			}
			gameboard.append("\n");
		}
		return gameboard.toString();
	}
}
