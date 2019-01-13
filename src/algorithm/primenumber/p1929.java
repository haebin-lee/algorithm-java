package algorithm.primenumber;

import java.util.Scanner;

public class p1929 {
	
	/**
	 * 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000)
	 * */
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args){
		int min = keyboard.nextInt(), max = keyboard.nextInt();
		int [] arr = new int[max+1];
		
		for(int i = 0 ; i<= max ; i++){
			arr[i] = 0;
		}
		arr[1] = 1;
		
		for(int i = 2; i<=max ; i++)
			for(int j=2 ; i*j <=max ; j++)
				arr[i*j] = 1;
		for(int i=min ; i<= max ; i++)
			if(arr[i]!=1) System.out.println(i);
		
	}
}
