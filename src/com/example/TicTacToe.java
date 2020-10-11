package com.example;

import java.util.*;

public class TicTacToe {

	static char[] BOARD = new char[10];
	static char player = ' ';
	static char comp = ' ';
	static boolean empty = true;
	static int switchturn = 0;

	static void initBOARD() {
		for (int i = 1; i < BOARD.length; i++) {
			BOARD[i] = ' ';
		}
	}

	static void chooseVal() {
		System.out.println("Choose x or o");
		Scanner s = new Scanner(System.in);
		char input = s.next().charAt(0);
		if (input == 'x') {
			player = 'x';
			comp = 'o';
			System.out.println("Player is " + player + " and " + "Computer is " + comp);
		} else if (input == 'o') {
			player = 'o';
			comp = 'x';
			System.out.println("Player is " + player + " and " + "Computer is " + comp);

		} else {
			System.out.println("Please enter x or o");
			chooseVal();
		}
	}

	static void showBOARD() {
		System.out.println("BOARD is: ");
		for (int i = 1; i < BOARD.length; i++) {
			System.out.print(" Position " + i + " is: " + BOARD[i]);
			if (i % 3 == 0) {
				System.out.println();
			}
		}
	}

	static void isempty() {
		int count = 0;
		for (int i = 1; i < BOARD.length; i++) {
			if (BOARD[i] != ' ') {
				count++;
			}
		}
		if (count == 9)
			empty = false;
	}

	static void makeMove() {
		Scanner s1 = new Scanner(System.in);
		System.out.println("Choose your position to mark");
		int y = s1.nextInt();
		if (BOARD[y] == ' ') {
			BOARD[y] = player;
		} else {
			System.out.println("Choose other position");
			makeMove();
		}
	}

	static void makeMoveComp() {
		int position = 0;
		for (int i = 1; i < BOARD.length && BOARD[i] == ' '; i++) {
			if (i == 1) {
				if ((BOARD[2] == comp && BOARD[3] == comp) || (BOARD[4] == comp && BOARD[7] == comp)
						|| (BOARD[5] == comp && BOARD[9] == comp))
					position = i;
			}
			if (i == 2) {
				if ((BOARD[1] == comp && BOARD[3] == comp) || (BOARD[5] == comp && BOARD[8] == comp))
					position = i;
			}
			if (i == 3) {
				if ((BOARD[2] == comp && BOARD[1] == comp) || (BOARD[6] == comp && BOARD[9] == comp)
						|| (BOARD[5] == comp && BOARD[7] == comp))
					position = i;
			}
			if (i == 4) {
				if ((BOARD[1] == comp && BOARD[7] == comp) || (BOARD[5] == comp && BOARD[6] == comp))
					position = i;
			}
			if (i == 5) {
				if ((BOARD[1] == comp && BOARD[9] == comp) || (BOARD[3] == comp && BOARD[7] == comp)
						|| (BOARD[2] == comp && BOARD[8] == comp) || (BOARD[4] == comp && BOARD[6] == comp))
					position = i;
			}
			if (i == 6) {
				if ((BOARD[3] == comp && BOARD[9] == comp) || (BOARD[5] == comp && BOARD[4] == comp))
					position = i;
			}
			if (i == 7) {
				if ((BOARD[1] == comp && BOARD[4] == comp) || (BOARD[9] == comp && BOARD[8] == comp)
						|| (BOARD[5] == comp && BOARD[3] == comp))
					position = i;
			}
			if (i == 8) {
				if ((BOARD[2] == comp && BOARD[5] == comp) || (BOARD[7] == comp && BOARD[9] == comp))
					position = i;
			}
			if (i == 9) {
				if ((BOARD[7] == comp && BOARD[8] == comp) || (BOARD[3] == comp && BOARD[6] == comp)
						|| (BOARD[5] == comp && BOARD[1] == comp))
					position = i;
			} else
				position = 0;
		}
		if (position != 0) {
			BOARD[position] = comp;
		} else {
			System.out.println("Picking random value..");
			int alotted = 0;
			while (alotted == 0) {
				int rand = (int) (Math.random() * 10) % 9 + 1;
				if (BOARD[rand] == ' ') {
					BOARD[rand] = comp;
					alotted = 1;

				}

			}

		}
	}

	public static boolean isAvailable(int position) {
		if (BOARD[position] == ' ' && position >= 1 && position < 10)
			return true;
		else
			return false;
	}

	public static int ifPossibleToWin(char ch) {
		if (isAvailable(1) && ((BOARD[2] == ch && BOARD[3] == ch) || (BOARD[4] == ch && BOARD[7] == ch)
				|| (BOARD[5] == ch && BOARD[9] == ch)))
			return 1;

		if (isAvailable(2) && ((BOARD[1] == ch && BOARD[3] == ch) || (BOARD[5] == ch && BOARD[8] == ch)))
			return 2;

		if (isAvailable(3) && ((BOARD[2] == ch && BOARD[1] == ch) || (BOARD[6] == ch && BOARD[9] == ch)
				|| (BOARD[5] == ch && BOARD[7] == ch)))
			return 3;

		if (isAvailable(4) && ((BOARD[1] == ch && BOARD[7] == ch) || (BOARD[5] == ch && BOARD[6] == ch)))
			return 4;

		if (isAvailable(5) && ((BOARD[1] == ch && BOARD[9] == ch) || (BOARD[3] == ch && BOARD[7] == ch)
				|| (BOARD[2] == ch && BOARD[8] == ch) || (BOARD[4] == ch && BOARD[6] == ch)))
			return 5;

		if (isAvailable(6) && ((BOARD[3] == ch && BOARD[9] == ch) || (BOARD[5] == ch && BOARD[4] == ch)))
			return 6;

		if (isAvailable(7) && ((BOARD[1] == ch && BOARD[4] == ch) || (BOARD[9] == ch && BOARD[8] == ch)
				|| (BOARD[5] == ch && BOARD[3] == ch)))
			return 7;

		if (isAvailable(8) && ((BOARD[2] == ch && BOARD[5] == ch) || (BOARD[7] == ch && BOARD[9] == ch)))
			return 8;

		if (isAvailable(9) && ((BOARD[7] == ch && BOARD[8] == ch) || (BOARD[3] == ch && BOARD[6] == ch)
				|| (BOARD[5] == ch && BOARD[1] == ch)))
			return 9;

		else
			return 0;

	}

	public static void playerMove() {
		int flag = 0;
		while (flag == 0) {
			System.out.println("Enter position : ");
			Scanner in = new Scanner(System.in);
			int position = in.nextInt();
			if (isAvailable(position)) {
				System.out.println("Your Mark has been placed at position " + position);
				BOARD[position] = player;
				flag = 1;
			} else
				System.out.println("This Position is not vacant");
		}
	}

	public static int blockPlayer() {
		int position = ifPossibleToWin(player);
		if (position == 0)
			position = takeCorner();
		return position;
	}

	public static int takeCorner() {
		if (isAvailable(1))
			return 1;
		else if (isAvailable(3))
			return 3;
		else if (isAvailable(7))
			return 7;
		else if (isAvailable(9))
			return 9;
		else
			return midOrSidePosition();
	}

	public static int midOrSidePosition() {
		if (isAvailable(5))
			return 5;
		else {
			int flag = 0, position = 0;
			while (flag == 0) {
				position = ((int) Math.floor(Math.random() * 10) % 9) + 1;
				if (isAvailable(position))
					flag = 1;
			}
			return position;
		}
	}

	public static void computerMove() {
		int position = ifPossibleToWin(comp);
		if (position == 0) {
			position = blockPlayer();
		}
		System.out.println("Computer Mark has been placed at position " + position);
		BOARD[position] = comp;
	}

	static void toss(String a) {
		Random rand = new Random();
		int t = rand.nextInt(1);
		int chance = -1;
		if (a.equalsIgnoreCase("heads"))
			chance = 0;
		if (a.equalsIgnoreCase("tails"))
			chance = 1;
		if (t == chance) {
			System.out.println("Player goes first");
			playerTurn();
		} else {
			System.out.println("Computer goes first");
			computerTurn();
		}

	}

	static boolean win() {
		return (((BOARD[1] == BOARD[2]) && (BOARD[2] == BOARD[3]) && BOARD[1] != ' ')
				|| ((BOARD[4] == BOARD[5]) && (BOARD[5] == BOARD[6]) && BOARD[4] != ' ')
				|| ((BOARD[7] == BOARD[8]) && (BOARD[8] == BOARD[9]) && BOARD[7] != ' ')
				|| ((BOARD[1] == BOARD[5]) && (BOARD[5] == BOARD[9]) && BOARD[1] != ' ')
				|| ((BOARD[3] == BOARD[5]) && (BOARD[5] == BOARD[7]) && BOARD[3] != ' ')
				|| ((BOARD[1] == BOARD[4]) && (BOARD[4] == BOARD[7]) && BOARD[1] != ' ')
				|| ((BOARD[2] == BOARD[5]) && (BOARD[5] == BOARD[8]) && BOARD[2] != ' ')
				|| ((BOARD[3] == BOARD[6]) && (BOARD[6] == BOARD[9]) && BOARD[3] != ' '));
	}

	public static boolean winCondition(char ch) {
		if ((BOARD[1] == ch && BOARD[2] == ch && BOARD[3] == ch) || (BOARD[4] == ch && BOARD[5] == ch && BOARD[6] == ch)
				|| (BOARD[7] == ch && BOARD[8] == ch && BOARD[9] == ch)
				|| (BOARD[1] == ch && BOARD[5] == ch && BOARD[9] == ch)
				|| (BOARD[3] == ch && BOARD[5] == ch && BOARD[7] == ch)
				|| (BOARD[1] == ch && BOARD[4] == ch && BOARD[7] == ch)
				|| (BOARD[2] == ch && BOARD[5] == ch && BOARD[8] == ch)
				|| (BOARD[3] == ch && BOARD[6] == ch && BOARD[9] == ch)) {
			System.out.println("congrats");
			return true;
		} else
			return false;
	}

	public static boolean drawCondition() {
		for (int i = 1; i < 10; i++) {
			if (BOARD[i] == ' ') {
				return false;
			}
		}
		return true;
	}

	public static void playerTurn() {
		playerMove();
		showBOARD();
		if (winCondition(player)) {
			System.out.println("Player has won");
		} else if (drawCondition())
			System.out.println("Its a draw.");
		else
			computerTurn();
	}

	public static void computerTurn() {
		computerMove();
		showBOARD();
		if (winCondition(comp)) {
			System.out.println("Computer has won");
		} else if (drawCondition())
			System.out.println("Its a draw.");
		else
			playerTurn();
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe");
		while (true) {
			System.out.println("Press 1 to Play");
			System.out.println("Press 2 to Exit");
			Scanner sc = new Scanner(System.in);
			int sc3 = sc.nextInt();
			switch (sc3) {
			case 1:
				initBOARD();
				System.out.println("Enter heads or tails");
				Scanner s2 = new Scanner(System.in);
				String value = s2.next();
				chooseVal();
				toss(value);
				break;
			case 2:
				System.out.println("Good Bye!");
				return;
			default:
				System.out.println("Press either 1 or 2");
			}
		}

	}
}
