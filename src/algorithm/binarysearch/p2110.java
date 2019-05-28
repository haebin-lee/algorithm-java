package algorithm.binarysearch;

import java.util.Scanner;

public class p2110 {
	
	/**
	 * 도현이의 집 N개가 수직선 위에 있다. 각각의 집의 좌표는 x1, ..., xN이고, 집 여러개가 같은 좌표를 가지는 일은 없다.
	 * 도현이는 언제 어디서나 와이파이를 즐기기 위해서 집에 공유기 C개를 설치하려고 한다. 
	 * 최대한 많은 곳에서 와이파이를 사용하려고 하기 때문에, 
	 * 한 집에는 공유기를 하나만 설치할 수 있고, 가장 인접한 두 공유기 사이의 거리를 가능한 크게 하여 설치하려고 한다.
	 * C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램을 작성하시오.
	 * */
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String [] args){
		int n = keyboard.nextInt(); // 집 
		int k = keyboard.nextInt(); // 공유기 
		
		int [] family = new int[n];
		for(int i = 0 ; i< n ; i++){
			family[i] = keyboard.nextInt();
			keyboard.nextLine();
		}
		
		int min = family[0];
		int max = family[n-1]- family[0];
		
		while(min<=max){
			int start = family[0];
			int cnt = 1; 

			int mid = (min+max)/2; // 이 간격 만큼 설치해본다. 
			
			for(int i = 0; i< n ; i++){
				
			}
			
		}
	}
}
