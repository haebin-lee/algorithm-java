package algorithm;

import java.util.Scanner;

/**
 * p1934
 * @author haebinlee
 * @since 2018. 12. 31.
 * @history
 * <pre>
 * << 개정이력(Modification Information) >>
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *  
 *
 * </pre>
 */
public class p1934 {

	/**
	 * 1. 테스트케이스 수를 입력 받는다. ex) 3
	 * 2. 두 수를 입력한다. 1 45000 / 6 10 / 13  17
	 * */
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args){
		
		int num = keyboard.nextInt();
		keyboard.nextLine();
		
		for(int i= 0 ; i< num ; i++){
			String temp = keyboard.nextLine();
			String [] numbers = temp.split(" ");
				int a = Integer.parseInt(numbers[0]);
				int b = Integer.parseInt(numbers[1]);
				int gcd = gcd(a,b);
				int lcm = lcm(a,b,gcd);
				System.out.println(lcm);
			
		}
	}
	
	
	/**
	 * 최대공약수: gcd
	 * Greatest Common Division
	 * @author haebinlee
	 * @param a
	 * @param b
	 * @return 
	 */
	public static int gcd(int val1, int val2){
		int rest=1; 
		while(rest>0){
			rest =  val1 % val2;
			val1 = val2; 
			val2 = rest;
		}
		return val1;
	}
	
	/**
	 * 최소공배수:lcm
	 * LCM(Lowest Common Multiple)
	 * @author haebinlee
	 * @param a
	 * @param b
	 * @param gcd
	 * @return 
	 */
	public static int lcm(int a, int b, int gcd){
		int result = (a*b) /gcd;
		return result; 
	}
	
}

