package algorithm.string;

import java.util.Scanner;

public class p2502 {

	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args){
		
		String temp = keyboard.nextLine();
		String [] arr = temp.split("-");
		
		for(String i : arr){
			System.out.print(i.charAt(0));
		}
		System.out.println();
	}
}
