package algorithm.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class p11047 {
	
	/**
	 * 준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
	 * 동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
	 * */
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args){
		
		int coinNum = keyboard.nextInt();
		int sum = keyboard.nextInt();
		
		Integer [] coinbox = new Integer[coinNum];
		for(int i = 0 ; i<coinbox.length ; i++){
			coinbox[i] = keyboard.nextInt();
		}
		Arrays.sort(coinbox, Collections.reverseOrder());
		
		int answer = greedy(coinbox, sum);
		System.out.println(answer);
		
	}
	private static int greedy(Integer[] coinbox, int sum) {

		int result = 0;
		for(int i = 0 ; i< coinbox.length ; i++){
			int coins = sum / coinbox[i].intValue();
			result+=coins;
			sum = sum % coinbox[i].intValue();
		}
		return result;
	}
}
