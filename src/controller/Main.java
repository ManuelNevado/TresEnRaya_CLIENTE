package controller;

import java.util.Scanner;

import model.*;

public class Main {
	public static void main(String args[]) {

		print("Cliente iniciado.\n Introduzca la ip del servidor: ");
		Scanner sc = new Scanner(System.in);
		String IP = sc.nextLine();
		ClientConnection cnx = new ClientConnection(IP);
		print(cnx.checkCNX());
		while(cnx.checkAlive()) {
			
		}
		
	}
	
	public static void print(String s) {System.out.println(s);}
	public static void print(boolean s) {System.out.println(s);}
	public static void printErr(String s) {System.err.println(s);}
	
}
