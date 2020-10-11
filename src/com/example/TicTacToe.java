package com.example;

import java.util.*;

public class TicTacToe {

	static char[] BOARD = new char[10];
	static char player = ' ';
	static char comp = ' ';
	static boolean empty = true;
	static int switchturn = 0;

	static void initBoard() {
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

	static void showBoard() {
		System.out.println("Board is: ");
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
			switchturn = 0;
		} else {
			switchturn = 1;
			System.out.println("Computer goes first");
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

	static void play() {
		initBoard();
		while (empty) {
			if (switchturn == 1) {
				System.out.println("Computer's turn");
				makeMoveComp();
				switchturn = 0;
				if (win()) {
					System.out.println("Computer has won the game!");
					return;
				}
			} else if (switchturn == 0) {
				showBoard();
				System.out.println("Players turn");
				makeMove();
				showBoard();
				switchturn = 1;
				if (win()) {
					System.out.println("You have won the game!");
					return;
				}
			}
		}
		if (!empty && !win()) {
			System.out.println("It's a Draw!");
		}
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
				initBoard();
				System.out.println("Enter heads or tails");
				Scanner s2 = new Scanner(System.in);
				String value = s2.next();
				toss(value);
				chooseVal();
				play();
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
