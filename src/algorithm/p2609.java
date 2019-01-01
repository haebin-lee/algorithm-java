package algorithm;

import java.util.Scanner;

/**
 * p2609
 * @author haebinlee
 * @since 2019. 1. 1.
 * @history
 * <pre>
 * << 개정이력(Modification Information) >>
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *  
 *
 * </pre>
 */
public class p2609 {

	/**
	 * 두 수를 입력 받아 최대공약수와 최소공배수를 구한다.
	 * */
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args){
		
		String temp = keyboard.nextLine();
		String[] numbers = temp.split(" ");
		
		int a = Integer.parseInt(numbers[0]);
		int b = Integer.parseInt(numbers[1]);
		int gcd = gcd(a,b);
		System.out.println(String.valueOf(gcd));
		int lcm = lcm(a,b,gcd);
		System.out.println(String.valueOf(lcm));

	}
	
	public static int gcd(int a, int b){
		int rest = 1; 
		while(rest >0){
			rest  = a % b;
			a = b;
			b = rest;
		}
		return a;
	}
	
	public static int lcm(int a, int b, int gcd){
		return (a * b) / gcd;
	}
}
