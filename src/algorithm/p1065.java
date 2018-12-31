package algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * p1065
 * @author haebinlee
 * @since 2018. 12. 28.
 * @history
 * <pre>
 * << 개정이력(Modification Information) >>
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *  
 *
 * </pre>
 */
public class p1065 {

	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args){
		
		int num = keyboard.nextInt();
		keyboard.nextLine();
		
		if(num <100){
			System.out.println(num);
		}
		else{
			
			// 100이상의 
			for(int i = 100; i<=num ; i++){
				int[] array = Arrays.asList(String.valueOf(i).split("")).stream().mapToInt(Integer::parseInt).toArray();
				boolean check = false;
				for(int j =0 ; j<array.length; j++){
					
				}

			}
			
			
		}
	}
}
