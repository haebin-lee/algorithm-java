package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * algorithm3
 * @author haebinlee
 * @since 2018. 12. 24.
 * @history
 * <pre>
 * << 개정이력(Modification Information) >>
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *  
 *
 * </pre>
 */
public class Stack2 {
	
	static Scanner keyboard = new Scanner(System.in);
	static List<String> stack = new ArrayList<>();
	
	public static void main(String[] args){
		
		int n = keyboard.nextInt();
		keyboard.nextLine();
		
		for(int i = 0 ; i< n ; i++){
			String test = keyboard.nextLine();
			String result = checkVPS(test);
			System.out.println(result);
		}
	}
	
	public static String checkVPS(String check){
		Stack<String> fn = new Stack<>();
		String[] temp = check.split("");
		
		for(String i : temp){
			if(i.equals("(")){
				fn.push(i);
			}else if(i.equals(")")){
				String pop = fn.pop();
				if(pop == null || !pop.equals("(")) {
					return "NO";
				}
			}
			
		}
		if(! fn.isEmpty()) return "NO";
		return "YES";
	}
}
