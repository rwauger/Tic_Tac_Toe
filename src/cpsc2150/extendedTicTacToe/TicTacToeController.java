package cpsc2150.extendedTicTacToe;

import java.util.ArrayList;
import java.util.List;


/**
 * The TicTacToe controller class will handle communication between our TicTacToeView and our Model (IGameBoard and BoardPosition)
 *
 * This is where you will write code
 *
 * You will need to include your BoardPosition class, the IGameBoard interface
 * and the implementations from previous homeworks
 * If your code was correct you will not need to make any changes to your IGameBoard classes
 */
public class TicTacToeController{
	//our current game that is being played
	private IGameBoard curGame;

	//The screen that provides our view
	private TicTacToeView screen;


	public static final int MAX_PLAYERS = 10;
	private int number_of_players;
	private List<Character> players = new ArrayList<>(MAX_PLAYERS);
	private int flag = 0;
	private int i = 0;




	/**
	 *
	 * @param model the board implementation
	 * @param view the screen that is shown
	 * @param np The number of players for the game
	 * @post the controller will respond to actions on the view using the model.
	 */
	TicTacToeController(IGameBoard model, TicTacToeView view, int np){
		this.curGame = model;
		this.screen = view;
		this.number_of_players = np;
		players.add('X');
		players.add('O');
		players.add('T');
		players.add('K');
		players.add('H');
		players.add('A');
		players.add('N');
		players.add('V');
		players.add('S');
		players.add('G');
	}

	/**
	 *
	 * @param row the row of the activated button
	 * @param col the column of the activated button
	 * @pre row and col are in the bounds of the game represented by the view
	 * @post The button pressed will show the right token and check if a player has won.
	 */
	public void processButtonClick(int row, int col){
		String message = "";
		screen.setMessage(message);
		if(flag == 1){
			newGame();
		}
		BoardPosition pos = new BoardPosition(row, col);
		if(curGame.checkSpace(pos)){
			curGame.placeMarker(pos, players.get(i));
			screen.setMarker(row, col, players.get(i));

			if(curGame.checkForWinner(pos)){
				message = "Player " + players.get(i) + " wins!! Press any button to start a new game.";
				screen.setMessage(message);
				flag = 1;
			}
			else if(curGame.checkForDraw()){
				message = "There is a draw. Press any button to start a new game.";
				screen.setMessage(message);
				flag = 1;
			}
			else{
				if(i == number_of_players - 1){
					i = 0;
				}
				else {
					i++;
				}

				message = "It is " + players.get(i) + "'s turn";
				screen.setMessage(message);
			}
		}
		else {
			message = "Space Unavailable. Player " + players.get(i) + " please select again.";
			screen.setMessage(message);
		}

	}

	private void newGame()
	{
		screen.dispose();
		GameSetupScreen screen = new GameSetupScreen();
		GameSetupController controller = new GameSetupController(screen);
		screen.registerObserver(controller);
	}
}
