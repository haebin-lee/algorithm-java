package algorithm;

import java.util.Scanner;

public class p13241 {
	
	
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String []args){
		
		String temp = keyboard.nextLine();
		String [] numbers = temp.split(" ");
		long val1 = Long.parseLong(numbers[0]);
		long val2 = Long.parseLong(numbers[1]);
		long gcd = gcd(val1, val2);
		long lcm = lcm(val1, val2, gcd);
		System.out.println(String.valueOf(lcm));

	}
	private static long gcd(long val1, long val2) {
		long rest = 1; 
		while(rest>0){
			rest = val1 % val2;
			val1 = val2; 
			val2 = rest;
		}
		return val1;
	}
	private static long lcm(long val1, long val2, long gcd) {
		return (val1*val2)/gcd;
	}
}
