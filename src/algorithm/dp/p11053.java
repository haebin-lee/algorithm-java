package algorithm.dp;

import java.util.Scanner;

public class p11053 {
	
	/**
	 * 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
	 * 예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.
	 * */
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args){
		
		int num = keyboard.nextInt();
		keyboard.nextLine();
		
		String temp = keyboard.nextLine();
		String [] list = temp.split(" ");
		
		int[] arr = new int[num+1];
		for(int i = 1; i <= num ; i++){
			arr[i] = Integer.valueOf(list[i-1]);
		}
		int len = solution(arr);
		System.out.println(len);
		
	}
	
	public static int solution (int []arr){
		int d[] = new int [arr.length];
		
		d[0] = 0; 
		for(int i = 1 ; i< arr.length ; i++){
			int index = find(arr, i);
			d[i] = d[index]+1;
		}
		
		int max = findMax(d);
		return max;
				
	}

	public static int find(int arr[], int limit){
		int max = arr[0];
		int maxIndex = 0;
		for(int i=1 ; i<=limit; i++){
			if(arr[i]<arr[limit]){
				if(max < arr[i]){
					max = arr[i];
					maxIndex = i;
				}
			}
		}
		return maxIndex;
	}
	
	private static int findMax(int[] arr) {
	
		int max = arr[0];
		for(int i = 0 ; i<arr.length ; i++){
			if(max< arr[i])
				max = arr[i];
		}
		return max;
	}

}
