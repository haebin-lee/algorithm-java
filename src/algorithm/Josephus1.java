package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * #11866
 * 1,2,3,4,5,6,7 -> 3,6,2,7,5,1,4
 * Josephus1
 * @author haebinlee
 * @since 2018. 12. 27.
 * @history
 * <pre>
 * << 개정이력(Modification Information) >>
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *  
 *
 * </pre>
 */
public class Josephus1 {
	
	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args){
		
		String temp = keyboard.nextLine();
		String [] input = temp.split(" ");
		
		int size = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);
		
		Queue queue = new LinkedList();
		List result = new ArrayList();
		for(int i = 1 ; i<= size ; i++){
			queue.offer(i);
		}


		for(int i = 1 ; ;i++){
			int num = i % n; 
			
			if(num == 0){
				int item = (int) queue.poll();
				result.add(item);
			}else{
				int item = (int) queue.poll();
				queue.add(item);
			}
			
			if(queue.isEmpty()) break;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<").append(result.stream().map(m->String.valueOf(m)).collect(Collectors.joining(", "))).append(">");
		System.out.println(sb.toString());
	}
}
