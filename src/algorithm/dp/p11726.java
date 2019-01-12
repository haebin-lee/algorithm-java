package algorithm.dp;

import java.util.Scanner;

public class p11726 {
	
	/**
	 * 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
	 * 아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.
	 * */
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args){
		
		int num = keyboard.nextInt();
		
		Long [] d = new Long[num+1];
		
		if( num ==1 || num ==2){
			System.out.println(num);
			return;
		}
		d[1] = 1L;
		d[2] = 2L;
		for(int i = 3 ; i< d.length ; i++){
			d[i] = (d[i-1]+d[i-2])%10007;
		}
		System.out.println(d[num]);
	}
	
}
