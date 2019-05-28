package algorithm.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 3의배수의 특징 모든 수를 더하면 3의 배수
 * */
public class p10610 {
	
	/**
	 * https://www.acmicpc.net/problem/10610
	 * */
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String n = sc.nextLine();
		char[] temp =  n.toCharArray();
		
		int sum =0; 
		for(char c: temp){
			sum += c-'0';
		}
		
		Arrays.sort(temp);
		if(temp[0] =='0' && sum %3 ==0){
            for (int i=temp.length-1; i>=0; i--) {
				System.out.print(temp[i]);
			}				
			System.out.println();
		}else{
			System.out.println(-1);
		}
		
		sc.close();
	}
}
