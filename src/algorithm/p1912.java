package algorithm;

import java.util.Scanner;

public class p1912 {
	
	/**
	 * n개의 정수로 이루어진 임의의 수열이 주어진다. 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다. 단, 수는 한 개 이상 선택해야 한다.
	 * 예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자. 여기서 정답은 12+21인 33이 정답이 된다.
	 * */
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String [] args){
		
		int num = keyboard.nextInt();
		keyboard.nextLine();
		
		int [] arr = new int[num+1];
		for (int i =1 ; i<arr.length ; i++){
			arr[i] = keyboard.nextInt();
		}
		
		int [] d = new int[num+1];
		arr[0] = 0;
		d[0] = 0; 
		for (int i = 1; i<arr.length ; i++){
			d[i] = Math.max(d[i-1]+arr[i], arr[i]);
		}
		
		int ans = findMax(d);
		System.out.println(ans);
	}

	private static int findMax(int[] d) {
		int max = d[1]; 
		
		for(int i = 2; i <d.length ; i++){
			if(max<d[i]) max = d[i];
		}
		return max;
	}
}
