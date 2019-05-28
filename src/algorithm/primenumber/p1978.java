package algorithm.primenumber;

import java.util.Scanner;

public class p1978 {

	/**
	 * 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
	 * */
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args){
		
		int limit = keyboard.nextInt();
		keyboard.nextLine();
		
		int [] array = new int[limit];
		for(int i = 0 ; i< array.length ; i++){
			array[i] = keyboard.nextInt();
		}
		
		int result = 0;
		for(int i = 0 ; i<array.length ; i++){
			int num = array[i];
			if(isPrimeNumber(num)) result++;
			
		}
		System.out.println(result);
	}
	
	public static boolean isPrimeNumber(int num){
		if(num ==1) return false;
		
		int count = 0;
		for(int i = 1; i<=num; i++){
			if(num %i ==0) count++;	
		}
		if(count ==2) return true;
		return false;
	}
}
