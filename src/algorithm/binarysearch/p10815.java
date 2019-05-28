package algorithm.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class p10815 {
	
	/**
	 * 첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이가 주어진다. 
	 * 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다. 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다. 
	 * 두 숫자 카드에 같은 수가 적혀있는 경우는 없다.
	 * 셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다. 
	 * 넷째 줄에는 상근이가 가지고 있는 숫자 카드인지 아닌지를 구해야 할 M개의 정수가 주어지며, 이 수는 공백으로 구분되어져 있다. 
	 * 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다
	 * */
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args){
		
		int n = keyboard.nextInt();
		keyboard.nextLine();
		
		int [] arr = new int[n];
		for(int i=0; i< n ; i++){
			arr[i] = keyboard.nextInt();
		}
		
		int m = keyboard.nextInt();
		keyboard.nextLine();
		int [] comp = new int[m];
		for(int i = 0; i< m ; i++){
			comp[i] = keyboard.nextInt();
		}
		
		Arrays.sort(arr);
		for (int i=0; i< comp.length ; i++){
			int sol = Arrays.binarySearch(arr, comp[i]);
			if(sol<0)
				System.out.print(0 +" ");
			else 
				System.out.print(1 +" ");
		}
	}
}
