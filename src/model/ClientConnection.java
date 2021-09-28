package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientConnection {
	private String IP;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private char[][] board;
	
	public ClientConnection(String IP) {
		this.IP = IP;
		try {
			socket = new Socket(IP,555);
			in = new BufferedReader( new InputStreamReader(socket.getInputStream()));
			OutputStream outStream = socket.getOutputStream();
			out= new PrintWriter(outStream);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writePair(Scanner sc) {
		int x = sc.nextInt();
		int y = sc.nextInt();
		//enviamos la x
		out.write(x);
		//enviamos la y
		out.write(y);
	}
	
	public void getBoardFromServer() {
		String s="";
		try {
			s = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		char[] sSplit = s.toCharArray();
		int k=0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				board[i][j]=sSplit[k];
				k++;
			}
		}
	}
	
	public char[][] getBoard(){
		return board;
	}
	
	public boolean checkCNX() {return socket!=null;}
	public boolean checkAlive() {
		try {
			return in.readLine().contentEquals("ok");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean
	
}
