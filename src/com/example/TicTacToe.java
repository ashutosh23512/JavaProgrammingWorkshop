package com.example;
import java.util.*;
public class TicTacToe {
	
	static char[] BOARD=new char [10];
	static char player=' ';
	static char comp=' ';
	static void initBoard() {
		for (int i = 1; i < BOARD.length; i++) 
			 {
				BOARD[i] = 'z';
			}
		
		}
		
	static void chooseVal()
	{
		System.out.println("Choose x or o");
		Scanner s = new Scanner(System.in);

		char input=s.next().charAt(0);
		if(input=='x') {
			player='x';
			comp='o';
		System.out.println("Player is "+player+" and "+"Computer is "+comp);
		}
		else if (input=='o') {
			player='o';
			comp='x';
		System.out.println("Player is "+player+" and "+"Computer is "+comp);

		}
		else {
			System.out.println("Please enter x or o");
			chooseVal();
		}
		
	}
	public static void main(String[] args) {
		
		System.out.println("Welcome to tic tac toe");
		initBoard();
		chooseVal();
		
	}

}
