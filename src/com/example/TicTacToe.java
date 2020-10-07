package com.example;
import java.util.*;
public class TicTacToe {
	
	static char[] BOARD=new char [10];
	static char player=' ';
	static char comp=' ';
	static void initBoard() {
		for (int i = 1; i < BOARD.length; i++) 
			 {
				BOARD[i] = ' ';
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
	
	static void showBoard()
	{
		System.out.println("Board is: ");
		for (int i = 1; i < BOARD.length; i++) 
		 {
			System.out.print(" Position "+i+" is: "+BOARD[i]);
			if (i%3==0)
			{
				System.out.println();
			}
		}
	}

	static void makeMove()
	{	
		showBoard();
		Scanner s1 = new Scanner(System.in);
		System.out.println("Choose your position to mark");
		int y=s1.nextInt();
		if(BOARD[y]==' ') {
		BOARD[y]=player;
		showBoard();
		makeMoveComp();
		
		}
		else {
			System.out.println("Choose other position");
		makeMove();
		}
	}
	static void makeMoveComp()
	{
		Random rand = new Random();
		int y1=(rand.nextInt(9))+1;		
		if(BOARD[y1]==' ')
		{
			BOARD[y1]=comp;
			makeMove();
		}
		else 
		makeMoveComp();
		
	}

	static void toss(String a) {
		Random rand = new Random();
		int t = rand.nextInt(1);
        int c = -1;
        if(a =="heads") c=0;
        if(a=="tails") c=1;
		if(t==c) {
			System.out.println("Player goes first");
			makeMove();
			}
		else {
		System.out.println("Computer goes first");
		makeMoveComp();
		}
		
		
	}

	public static void main(String[] args) {	
		System.out.println("Welcome to tic tac toe");
		initBoard();
		chooseVal();
		System.out.println("Enter heads or tails");
		Scanner s2 = new Scanner(System.in);
		String value = s2.next();
		toss(value);

	}
}
