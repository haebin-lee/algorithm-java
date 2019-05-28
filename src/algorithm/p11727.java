package algorithm;

import java.util.Scanner;

public class p11727 {
	
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args){
		
		int num = keyboard.nextInt();
		Long [] d = new Long[num+1];
		
		if( num == 1){
			System.out.println(num);
			return; 
		}
		if( num == 2){
			System.out.println(2);
			return; 
		}
			
		d[1] = 1L; 
		d[2] = 3L;
		for(int i =3 ; i< d.length ; i++){
			d[i] = (d[i-1] + 2* d[i-2] ) % 10007;
		}
		System.out.println(d[num]);
	}
}
