package cpsc2150.extendedTicTacToe;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestGameBoard{

	private IGameBoard MakeBoard(int row, int col) {
		return new GameBoard(row, col, 3);
	}

	private String expectedBoard(char[][] gameBoard){
		int i, j = 0;
		StringBuilder gameboard = new StringBuilder();
		gameboard.append("   ");

		for(i = 0; i < gameBoard[j].length; i++){
			if(i <= 9)
				gameboard.append(" ").append(i).append("|");
			else
				gameboard.append(i).append("|");
		}
		gameboard.append("\n");
		for(i = 0; i < gameBoard.length; i++)
		{
			if(i <= 9)
				gameboard.append(" ").append(i).append("|");
			else
				gameboard.append(i).append("|");

			for(j = 0; j < gameBoard[i].length; j++)
			{
				gameboard.append(gameBoard[i][j]).append(" ").append("|");
			}
			gameboard.append("\n");
		}
		return gameboard.toString();
	}

	@Test
	public void test_Constructor_min_game_board_size() {
		IGameBoard gameboard = MakeBoard(3, 3);
		char[][] expected_board = new char[3][3];
		int i, j;

		for(i = 0; i < 3; i++){
			for(j = 0; j < 3; j++){
				expected_board[i][j] = ' ';
			}
		}

		String egameboard = expectedBoard(expected_board);

		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_Constructor_max_game_board_size() {
		IGameBoard gameboard = MakeBoard(100, 100);
		char[][] expected_board = new char[100][100];
		int i, j;

		for(i = 0; i < 100; i++){
			for(j = 0; j < 100; j++){
				expected_board[i][j] = ' ';
			}
		}

		String egameboard = expectedBoard(expected_board);

		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_Constructor_uneven_game_board_size() {
		IGameBoard gameboard = MakeBoard(3, 5);
		char[][] expected_board = new char[3][5];
		int i, j;

		for(i = 0; i < 3; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		String egameboard = expectedBoard(expected_board);

		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_checkSpace_empty_space() {
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		String egameboard = expectedBoard(expected_board);

		BoardPosition pos = new BoardPosition(3,4);
		assertTrue(gameboard.checkSpace(pos));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_checkSpace_space_already_has_character_in_it() {
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos = new BoardPosition(3,4);
		gameboard.placeMarker(pos, 'X');
		expected_board[3][4] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertFalse(gameboard.checkSpace(pos));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_checkSpace_space_out_of_bounds() {
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos = new BoardPosition(6,5);

		String egameboard = expectedBoard(expected_board);
		assertFalse(gameboard.checkSpace(pos));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_checkHorizontalWin_top_left_corner() {
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos1 = new BoardPosition(0,0);
		BoardPosition pos2 = new BoardPosition(0,1);
		BoardPosition pos3 = new BoardPosition(0,2);

		gameboard.placeMarker(pos1, 'X');
		gameboard.placeMarker(pos2, 'X');
		gameboard.placeMarker(pos3, 'X');

		expected_board[0][0] = 'X';
		expected_board[0][1] = 'X';
		expected_board[0][2] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertTrue(gameboard.checkHorizontalWin(pos3, 'X'));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_checkHorizontalWin_middle_of_board() {
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos1 = new BoardPosition(2,1);
		BoardPosition pos2 = new BoardPosition(2,2);
		BoardPosition pos3 = new BoardPosition(2,3);

		gameboard.placeMarker(pos1, 'X');
		gameboard.placeMarker(pos2, 'X');
		gameboard.placeMarker(pos3, 'X');

		expected_board[2][1] = 'X';
		expected_board[2][2] = 'X';
		expected_board[2][3] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertTrue(gameboard.checkHorizontalWin(pos3, 'X'));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_checkHorizontalWin_bottom_right_of_board() {
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos1 = new BoardPosition(4,2);
		BoardPosition pos2 = new BoardPosition(4,3);
		BoardPosition pos3 = new BoardPosition(4,4);

		gameboard.placeMarker(pos1, 'X');
		gameboard.placeMarker(pos2, 'X');
		gameboard.placeMarker(pos3, 'X');

		expected_board[4][2] = 'X';
		expected_board[4][3] = 'X';
		expected_board[4][4] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertTrue(gameboard.checkHorizontalWin(pos3, 'X'));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_checkHorizontalWin_place_at_beginning_of_2markers() {
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos1 = new BoardPosition(2,2);
		BoardPosition pos2 = new BoardPosition(2,3);
		BoardPosition pos3 = new BoardPosition(2,1);

		gameboard.placeMarker(pos1, 'X');
		gameboard.placeMarker(pos2, 'X');
		gameboard.placeMarker(pos3, 'X');

		expected_board[2][1] = 'X';
		expected_board[2][2] = 'X';
		expected_board[2][3] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertTrue(gameboard.checkHorizontalWin(pos3, 'X'));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_checkHorizontalWin_place_middle_of_2markers() {
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos1 = new BoardPosition(2,1);
		BoardPosition pos2 = new BoardPosition(2,3);
		BoardPosition pos3 = new BoardPosition(2,2);

		gameboard.placeMarker(pos1, 'X');
		gameboard.placeMarker(pos2, 'X');
		gameboard.placeMarker(pos3, 'X');

		expected_board[2][1] = 'X';
		expected_board[2][2] = 'X';
		expected_board[2][3] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertTrue(gameboard.checkHorizontalWin(pos3, 'X'));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_checkVerticalWin_top_left_corner() {
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos1 = new BoardPosition(0,0);
		BoardPosition pos2 = new BoardPosition(1,0);
		BoardPosition pos3 = new BoardPosition(2,0);

		gameboard.placeMarker(pos1, 'X');
		gameboard.placeMarker(pos2, 'X');
		gameboard.placeMarker(pos3, 'X');

		expected_board[0][0] = 'X';
		expected_board[1][0] = 'X';
		expected_board[2][0] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertTrue(gameboard.checkVerticalWin(pos3, 'X'));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_checkVerticalWin_middle_of_board() {
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos1 = new BoardPosition(1,2);
		BoardPosition pos2 = new BoardPosition(2,2);
		BoardPosition pos3 = new BoardPosition(3,2);

		gameboard.placeMarker(pos1, 'X');
		gameboard.placeMarker(pos2, 'X');
		gameboard.placeMarker(pos3, 'X');

		expected_board[1][2] = 'X';
		expected_board[2][2] = 'X';
		expected_board[3][2] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertTrue(gameboard.checkVerticalWin(pos3, 'X'));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_checkVerticalWin_bottom_right_of_board() {
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos1 = new BoardPosition(2,4);
		BoardPosition pos2 = new BoardPosition(3,4);
		BoardPosition pos3 = new BoardPosition(4,4);

		gameboard.placeMarker(pos1, 'X');
		gameboard.placeMarker(pos2, 'X');
		gameboard.placeMarker(pos3, 'X');

		expected_board[2][4] = 'X';
		expected_board[3][4] = 'X';
		expected_board[4][4] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertTrue(gameboard.checkVerticalWin(pos3, 'X'));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_checkVerticalWin_place_at_beginning_of_2markers() {
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos1 = new BoardPosition(2,1);
		BoardPosition pos2 = new BoardPosition(3,1);
		BoardPosition pos3 = new BoardPosition(1,1);

		gameboard.placeMarker(pos1, 'X');
		gameboard.placeMarker(pos2, 'X');
		gameboard.placeMarker(pos3, 'X');

		expected_board[1][1] = 'X';
		expected_board[2][1] = 'X';
		expected_board[3][1] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertTrue(gameboard.checkVerticalWin(pos3, 'X'));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_checkVerticalWin_place_middle_of_2markers() {
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos1 = new BoardPosition(1,1);
		BoardPosition pos2 = new BoardPosition(3,1);
		BoardPosition pos3 = new BoardPosition(2,1);

		gameboard.placeMarker(pos1, 'X');
		gameboard.placeMarker(pos2, 'X');
		gameboard.placeMarker(pos3, 'X');

		expected_board[1][1] = 'X';
		expected_board[2][1] = 'X';
		expected_board[3][1] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertTrue(gameboard.checkVerticalWin(pos3, 'X'));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_checkDiagonalWin_bottomleft_to_topright_at_bottom_left() {
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos1 = new BoardPosition(4,0);
		BoardPosition pos2 = new BoardPosition(3,1);
		BoardPosition pos3 = new BoardPosition(2,2);

		gameboard.placeMarker(pos1, 'X');
		gameboard.placeMarker(pos2, 'X');
		gameboard.placeMarker(pos3, 'X');

		expected_board[4][0] = 'X';
		expected_board[3][1] = 'X';
		expected_board[2][2] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertTrue(gameboard.checkDiagonalWin(pos3, 'X'));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_checkDiagonalWin_bottomleft_to_topright_at_top_right() {
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos1 = new BoardPosition(2,2);
		BoardPosition pos2 = new BoardPosition(1,3);
		BoardPosition pos3 = new BoardPosition(0,4);

		gameboard.placeMarker(pos1, 'X');
		gameboard.placeMarker(pos2, 'X');
		gameboard.placeMarker(pos3, 'X');

		expected_board[2][2] = 'X';
		expected_board[1][3] = 'X';
		expected_board[0][4] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertTrue(gameboard.checkDiagonalWin(pos3, 'X'));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_checkDiagonalWin_topleft_to_bottomright_top_left() {
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos1 = new BoardPosition(0,0);
		BoardPosition pos2 = new BoardPosition(1,1);
		BoardPosition pos3 = new BoardPosition(2,2);

		gameboard.placeMarker(pos1, 'X');
		gameboard.placeMarker(pos2, 'X');
		gameboard.placeMarker(pos3, 'X');

		expected_board[0][0] = 'X';
		expected_board[1][1] = 'X';
		expected_board[2][2] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertTrue(gameboard.checkDiagonalWin(pos3, 'X'));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_checkDiagonalWin_topleft_to_bottomright_bottom_right() {
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos1 = new BoardPosition(2,2);
		BoardPosition pos2 = new BoardPosition(3,3);
		BoardPosition pos3 = new BoardPosition(4,4);

		gameboard.placeMarker(pos1, 'X');
		gameboard.placeMarker(pos2, 'X');
		gameboard.placeMarker(pos3, 'X');

		expected_board[2][2] = 'X';
		expected_board[3][3] = 'X';
		expected_board[4][4] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertTrue(gameboard.checkDiagonalWin(pos3, 'X'));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_checkDiagonalWin_bottom_left_small_diagonal() {
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos1 = new BoardPosition(2,0);
		BoardPosition pos2 = new BoardPosition(3,1);
		BoardPosition pos3 = new BoardPosition(4,2);

		gameboard.placeMarker(pos1, 'X');
		gameboard.placeMarker(pos2, 'X');
		gameboard.placeMarker(pos3, 'X');

		expected_board[2][0] = 'X';
		expected_board[3][1] = 'X';
		expected_board[4][2] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertTrue(gameboard.checkDiagonalWin(pos3, 'X'));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_checkDiagonalWin_bottom_right_small_diagonal() {
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos1 = new BoardPosition(4,2);
		BoardPosition pos2 = new BoardPosition(3,3);
		BoardPosition pos3 = new BoardPosition(2,4);

		gameboard.placeMarker(pos1, 'X');
		gameboard.placeMarker(pos2, 'X');
		gameboard.placeMarker(pos3, 'X');

		expected_board[2][4] = 'X';
		expected_board[3][3] = 'X';
		expected_board[4][2] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertTrue(gameboard.checkDiagonalWin(pos3, 'X'));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_checkDiagonalWin_top_left_place_marker_in_middle() {
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos1 = new BoardPosition(0,0);
		BoardPosition pos2 = new BoardPosition(2,2);
		BoardPosition pos3 = new BoardPosition(1,1);

		gameboard.placeMarker(pos1, 'X');
		gameboard.placeMarker(pos2, 'X');
		gameboard.placeMarker(pos3, 'X');

		expected_board[2][2] = 'X';
		expected_board[1][1] = 'X';
		expected_board[0][0] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertTrue(gameboard.checkDiagonalWin(pos3, 'X'));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_checkDiagonalWin_top_right_place_marker_in_middle() {
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos1 = new BoardPosition(0,4);
		BoardPosition pos2 = new BoardPosition(2,2);
		BoardPosition pos3 = new BoardPosition(1,3);

		gameboard.placeMarker(pos1, 'X');
		gameboard.placeMarker(pos2, 'X');
		gameboard.placeMarker(pos3, 'X');

		expected_board[0][4] = 'X';
		expected_board[2][2] = 'X';
		expected_board[1][3] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertTrue(gameboard.checkDiagonalWin(pos3, 'X'));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_checkForDraw_board_is_full_without_win() {
		IGameBoard gameboard = MakeBoard(3, 3);
		char[][] expected_board = new char[3][3];
		int i, j;

		for(i = 0; i < 3; i++){
			for(j = 0; j < 3; j++){
				expected_board[i][j] = ' ';
			}
		}


		BoardPosition pos1 = new BoardPosition(0,0);
		BoardPosition pos2 = new BoardPosition(0,1);
		BoardPosition pos3 = new BoardPosition(0,2);
		BoardPosition pos4 = new BoardPosition(1,0);
		BoardPosition pos5 = new BoardPosition(1,1);
		BoardPosition pos6 = new BoardPosition(1,2);
		BoardPosition pos7 = new BoardPosition(2,0);
		BoardPosition pos8 = new BoardPosition(2,1);
		BoardPosition pos9 = new BoardPosition(2,2);

		gameboard.placeMarker(pos1,'X');
		gameboard.placeMarker(pos2,'O');
		gameboard.placeMarker(pos3,'X');
		gameboard.placeMarker(pos4,'O');
		gameboard.placeMarker(pos5,'X');
		gameboard.placeMarker(pos6,'O');
		gameboard.placeMarker(pos7,'O');
		gameboard.placeMarker(pos8,'X');
		gameboard.placeMarker(pos9,'O');


		expected_board[0][0] = 'X';
		expected_board[0][1] = 'O';
		expected_board[0][2] = 'X';
		expected_board[1][0] = 'O';
		expected_board[1][1] = 'X';
		expected_board[1][2] = 'O';
		expected_board[2][0] = 'O';
		expected_board[2][1] = 'X';
		expected_board[2][2] = 'O';

		String egameboard = expectedBoard(expected_board);
		assertTrue(gameboard.checkForDraw());
		assertEquals(egameboard, gameboard.toString());
	}
	@Test
	public void test_checkForDraw_place_only_one_marker() {
		IGameBoard gameboard = MakeBoard(3, 3);
		char[][] expected_board = new char[3][3];
		int i, j;

		for(i = 0; i < 3; i++){
			for(j = 0; j < 3; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos1 = new BoardPosition(0,0);

		gameboard.placeMarker(pos1,'X');

		expected_board[0][0] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertFalse(gameboard.checkForDraw());
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_checkForDraw_board_is_almost_full() {
		IGameBoard gameboard = MakeBoard(3, 3);
		char[][] expected_board = new char[3][3];
		int i, j;

		for(i = 0; i < 3; i++){
			for(j = 0; j < 3; j++){
				expected_board[i][j] = ' ';
			}
		}


		BoardPosition pos1 = new BoardPosition(0,0);
		BoardPosition pos2 = new BoardPosition(0,1);
		BoardPosition pos3 = new BoardPosition(0,2);
		BoardPosition pos4 = new BoardPosition(1,0);
		BoardPosition pos5 = new BoardPosition(1,1);
		BoardPosition pos6 = new BoardPosition(1,2);
		BoardPosition pos7 = new BoardPosition(2,0);
		BoardPosition pos8 = new BoardPosition(2,1);

		gameboard.placeMarker(pos1,'X');
		gameboard.placeMarker(pos2,'O');
		gameboard.placeMarker(pos3,'X');
		gameboard.placeMarker(pos4,'O');
		gameboard.placeMarker(pos5,'X');
		gameboard.placeMarker(pos6,'O');
		gameboard.placeMarker(pos7,'O');
		gameboard.placeMarker(pos8,'X');


		expected_board[0][0] = 'X';
		expected_board[0][1] = 'O';
		expected_board[0][2] = 'X';
		expected_board[1][0] = 'O';
		expected_board[1][1] = 'X';
		expected_board[1][2] = 'O';
		expected_board[2][0] = 'O';
		expected_board[2][1] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertFalse(gameboard.checkForDraw());
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_checkForDraw_board_is_half_full() {
		IGameBoard gameboard = MakeBoard(3, 3);
		char[][] expected_board = new char[3][3];
		int i, j;

		for(i = 0; i < 3; i++){
			for(j = 0; j < 3; j++){
				expected_board[i][j] = ' ';
			}
		}


		BoardPosition pos1 = new BoardPosition(0,0);
		BoardPosition pos2 = new BoardPosition(0,1);
		BoardPosition pos3 = new BoardPosition(0,2);
		BoardPosition pos4 = new BoardPosition(1,0);
		BoardPosition pos5 = new BoardPosition(1,1);


		gameboard.placeMarker(pos1,'X');
		gameboard.placeMarker(pos2,'O');
		gameboard.placeMarker(pos3,'X');
		gameboard.placeMarker(pos4,'O');
		gameboard.placeMarker(pos5,'X');



		expected_board[0][0] = 'X';
		expected_board[0][1] = 'O';
		expected_board[0][2] = 'X';
		expected_board[1][0] = 'O';
		expected_board[1][1] = 'X';


		String egameboard = expectedBoard(expected_board);
		assertFalse(gameboard.checkForDraw());
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_whatsAtPos_empty_space() {
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos = new BoardPosition(2,2);

		String egameboard = expectedBoard(expected_board);
		assertEquals(' ', gameboard.whatsAtPos(pos));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_whatsAtPos_marker_in_middle_of_board() {
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos = new BoardPosition(2,2);

		gameboard.placeMarker(pos, 'X');

		expected_board[2][2] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertEquals('X', gameboard.whatsAtPos(pos));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_whatsAtPos_marker_top_left_corner(){
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos = new BoardPosition(0,0);

		gameboard.placeMarker(pos, 'X');

		expected_board[0][0] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertEquals('X', gameboard.whatsAtPos(pos));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_whatsAtPos_marker_top_right_corner(){
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos = new BoardPosition(0,4);

		gameboard.placeMarker(pos, 'X');

		expected_board[0][4] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertEquals('X', gameboard.whatsAtPos(pos));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_whatsAtPos_marker_bottom_left_corner(){
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos = new BoardPosition(4,0);

		gameboard.placeMarker(pos, 'X');

		expected_board[4][0] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertEquals('X', gameboard.whatsAtPos(pos));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_whatsAtPos_marker_bottom_right_corner(){
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos = new BoardPosition(4,4);

		gameboard.placeMarker(pos, 'X');

		expected_board[4][4] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertEquals('X', gameboard.whatsAtPos(pos));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_whatsAtPos_O_Marker(){
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos = new BoardPosition(0,2);
		BoardPosition pos1 = new BoardPosition(3,1);


		gameboard.placeMarker(pos, 'O');
		gameboard.placeMarker(pos1, 'X');

		expected_board[0][2] = 'O';
		expected_board[3][1] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertEquals('O', gameboard.whatsAtPos(pos));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_placeMarker_place_new_player(){
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos1 = new BoardPosition(2,0);
		BoardPosition pos2 = new BoardPosition(4,0);
		BoardPosition pos3 = new BoardPosition(4,4);
		BoardPosition pos4 = new BoardPosition(2,2);


		gameboard.placeMarker(pos1, 'X');
		gameboard.placeMarker(pos2, 'X');
		gameboard.placeMarker(pos3, 'X');
		gameboard.placeMarker(pos4, 'O');

		expected_board[2][0] = 'X';
		expected_board[4][0] = 'X';
		expected_board[4][4] = 'X';
		expected_board[2][2] = 'O';


		String egameboard = expectedBoard(expected_board);
		assertEquals('O', gameboard.whatsAtPos(pos4));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_placeMarker_place_top_left_corner(){
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos1 = new BoardPosition(0,0);


		gameboard.placeMarker(pos1, 'X');

		expected_board[0][0] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertEquals('X', gameboard.whatsAtPos(pos1));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_placeMarker_place_bottom_left_corner(){
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos1 = new BoardPosition(4,0);


		gameboard.placeMarker(pos1, 'X');

		expected_board[4][0] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertEquals('X', gameboard.whatsAtPos(pos1));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_placeMarker_place_bottom_right_corner(){
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos1 = new BoardPosition(4,4);


		gameboard.placeMarker(pos1, 'X');

		expected_board[4][4] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertEquals('X', gameboard.whatsAtPos(pos1));
		assertEquals(egameboard, gameboard.toString());
	}

	@Test
	public void test_placeMarker_place_top_right_corner(){
		IGameBoard gameboard = MakeBoard(5, 5);
		char[][] expected_board = new char[5][5];
		int i, j;

		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				expected_board[i][j] = ' ';
			}
		}

		BoardPosition pos1 = new BoardPosition(0,4);


		gameboard.placeMarker(pos1, 'X');

		expected_board[0][4] = 'X';

		String egameboard = expectedBoard(expected_board);
		assertEquals('X', gameboard.whatsAtPos(pos1));
		assertEquals(egameboard, gameboard.toString());
	}

}
