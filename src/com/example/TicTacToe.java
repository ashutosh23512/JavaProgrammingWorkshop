package com.example;

public class TicTacToe {
	
	static char[] BOARD=new char [10];
	
	static void initBoard() {
		for (int i = 1; i < BOARD.length; i++) 
			 {
				BOARD[i] = 'z';
			}
		
		}
		
	public static void main(String[] args) {
		
		System.out.println("Welcome to tic tac toe");
	}

}
