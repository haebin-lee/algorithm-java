package algorithm.queue;

import java.util.Scanner;

/**
 * 기본 circular queue 구현하기
 * CircularQueue1
 * @author haebinlee
 * @since 2018. 12. 26.
 * @history
 * <pre>
 * << 개정이력(Modification Information) >>
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *  
 *
 * </pre>
 */
public class CircularQueue1 {
	
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args){
		
		int queueSize = keyboard.nextInt();
		keyboard.nextLine();
		int commandNum = keyboard.nextInt();
		keyboard.nextLine();
		
		CircularQueue fn = new CircularQueue(queueSize);
		
		for(int i = 0 ; i<commandNum ; i++){
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
			case "now":
				System.out.println(fn.toString());
				break;
			}
		}
	}
}
