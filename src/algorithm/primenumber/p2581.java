package algorithm.primenumber;

import java.util.Scanner;

public class p2581 {
	
	/**
	 * 자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.
	 * 예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 소수는 61, 67, 71, 73, 79, 83, 89, 97 총 8개가 있으므로, 이들 소수의 합은 620이고, 최솟값은 61이 된다.
	 * */
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args){
		
		int min = keyboard.nextInt();
		int max = keyboard.nextInt();
			
		int sum = 0 ; 
		int minResult = 0; 
		for (int i = min ; i<=max ; i++){
			boolean prime = isPrimeNumber(i);
			if(prime){
				if (minResult==0) minResult = i;
				sum+=i;
			}
		}
		
		if(sum==0){
			System.out.println(-1);

		}else{
			System.out.println(sum);
			System.out.println(minResult);
		}
	

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
