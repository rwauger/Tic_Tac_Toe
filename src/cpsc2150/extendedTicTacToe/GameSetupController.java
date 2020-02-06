package cpsc2150.extendedTicTacToe;

/**
 * Created by kplis on 4/5/2018.
 */
public class GameSetupController {
	private GameSetupScreen view;
	private int max_size = 20;
	private final int MEM_CUTOFF = 64;


	public GameSetupController(GameSetupScreen v)
	{
		view = v;
	}

	public void processButtonClick(int rows, int cols, int players, int numWin )
	{
		String errorMsg = "";
		if(rows < IGameBoard.min_rows || rows > max_size)
		{
			errorMsg += "Rows must be between " +  IGameBoard.min_rows + " and " + max_size;
		}

		if(cols < IGameBoard.min_cols || cols > max_size)
		{
			errorMsg += "Columns must be between " +  IGameBoard.min_cols + " and " + max_size;
		}

		if (numWin > rows)
		{
			errorMsg += "Can't have more to win than the number of rows";
		}
		if (numWin > rows)
		{
			errorMsg += "Can't have more to win than the number of Columns";
		}

		if(numWin < IGameBoard.min_num_to_win)
		{
			errorMsg += "Number to win must be at least " + IGameBoard.min_num_to_win;
		}

		if(!errorMsg.equals(""))
		{
			view.displayError(errorMsg);

		}
		else
		{
			view.closeScreen();
			IGameBoard model;
			if(rows * cols <= MEM_CUTOFF) {
				model = new GameBoard(rows, cols, numWin);
			}
			else
			{
				model = new GameBoardMem(rows, cols, numWin);
			}
			TicTacToeView tview = new TicTacToeView(rows, cols);
			TicTacToeController tcontroller = new TicTacToeController(model, tview, players);

			tview.registerObserver(tcontroller);
		}
	}
}
