package algorithm.queue;

import java.util.Scanner;

/**
 * 기본 큐 구현하기
 * Queue1
 * @author haebinlee
 * @since 2018. 12. 25.
 * @history
 * <pre>
 * << 개정이력(Modification Information) >>
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *  
 *
 * </pre>
 */
public class Queue1 {
	
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args){
		
		Queue fn = new Queue();

		int num = keyboard.nextInt();
		keyboard.nextLine();

		for(int i = 0 ; i<num ; i++){
			String command = keyboard.nextLine();
			String[] temp = command.split(" ");
			
			switch(temp[0]){
			case "push":
				fn.push(temp[1]);
				break;
			case "pop":
				String pop = fn.pop();
				if(pop == null) pop = "-1";
				System.out.println(pop);
				break;
			case "size" :
				int size = fn.size();
				System.out.println(String.valueOf(size));
				break;
			case "empty":
				int empty = fn.empty();
				System.out.println(String.valueOf(empty));
				break;
			case "front": 
				String front = fn.front();
				if(front == null) front = "-1";
				System.out.println(front);
				break;
			case "back":
				String back = fn.back();
				if(back == null) back ="-1";
				System.out.println(back);
				break;
			
			}
		}
	}
}
