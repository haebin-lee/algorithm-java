package algorithm;

import java.util.Scanner;

public class p2579 {
	

	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args){
		int num = keyboard.nextInt();
		keyboard.nextLine();
		
		int [] arr = new int[num+1];
		for(int i = 1 ; i< arr.length ; i++){
			arr[i]  = keyboard.nextInt();
			keyboard.nextLine();
		}
		
		int result = solution(arr, num);
		System.out.println(result);
		
	}
	
	public static int solution(int [] arr, int num){
		int [] d = new int[num+1];
		d[1] = arr[1];
		if(num ==1){
			return d[num];
		}
		
		d[2] = arr[1]+arr[2];
		if(num ==2){
			return d[num];
		}
		
		d[3] = arr[1]+arr[3];
		if(num ==3){
			return d[num];
		}
		
		for(int i = 3 ; i< arr.length ; i++){
			int a = arr[i] + arr[i-1] + d[i-3];
			int b = arr[i] + d[i-2];
			d[i] = Math.max(a, b);
		}
		
		return d[num];
	}	
}
