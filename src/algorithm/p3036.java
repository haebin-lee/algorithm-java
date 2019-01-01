package algorithm;

import java.util.Scanner;

public class p3036 {

	/**
	 * 상근이는 첫 번째 링을 돌리기 시작했고, 나머지 링도 같이 돌아간다는 사실을 발견했다. 나머지 링은 첫 번째 링 보다 빠르게 돌아가기도 했고, 느리게 돌아가기도 했다. 이렇게 링을 돌리다 보니 첫 번째 링을 한 바퀴 돌리면, 나머지 링은 몇 바퀴 도는지 궁금해졌다.
	 * 링의 반지름이 주어진다. 이때, 첫 번째 링을 한 바퀴 돌리면, 나머지 링은 몇 바퀴 돌아가는지 구하는 프로그램을 작성하시오.
	 * */
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args){
		
		int num = keyboard.nextInt();
		keyboard.nextLine();
		
		String temp = keyboard.nextLine();
		String [] rings = temp.split(" ");
		int bunmo = Integer.parseInt(rings[0]);
		
		for(int i = 1; i< rings.length ; i++){
			printFraction(reduceFraction(bunmo, Integer.parseInt(rings[i])));
		}
		
	}
	
	public static void printFraction(int[] fraction){
		System.out.format("%d/%d\n", fraction[0], fraction[1]);
	}
	
	public static int[] reduceFraction(int bunmo, int bunja){
		int [] result = new int[2];
		// 1. 분모와 분자의 최대공약수를 구한다 
		int gcd = gcd(bunmo, bunja);
		// 2. 분모와 분자의 최대 공약수로 나눈다. 
		int bunmo2 = bunmo/gcd;
		int bunja2 = bunja/gcd;
		result[0] = bunmo2;
		result[1] = bunja2;
		// 3. 리턴한다.
		return result;
	}
	
	public static int gcd(int a, int b){
		int rest = 1; 
		while(rest>0){
			rest = a % b; 
			a = b;
			b = rest;
		}
		return a; 
		
	}
}
