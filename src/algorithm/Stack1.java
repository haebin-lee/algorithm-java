package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 기본 스택 구현하기
 * algorithm2
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
public class Stack1 {
	
	static Scanner keyboard = new Scanner(System.in);
	static List stack = new ArrayList<>();
	
	public static void main(String[] args){
		
		int n = keyboard.nextInt();
		
		keyboard.nextLine();
		for(int i = 0 ; i< n ; i++){
			String command = keyboard.nextLine();
			String [] temp = command.split(" ");
			
			switch(temp[0]){
				case "push":
					push(Integer.valueOf(temp[1]).intValue()); break;
				case "pop": 
					int pop = pop(); 
					System.out.println(pop);
					break;
				case "size":
					int size = size();
					System.out.println(size);
					break;
				case "empty":
					int empty = empty(); 
					System.out.println(empty);
					break;
				case"top":
					int top = top(); 
					System.out.println(top);
					break;
			}
			
		}
	}
	public static <T> void push(T num){
		stack.add(num);
	}
	
	public static <T> int pop(){
		if(top() == -1){
			return -1;
		}
		int index = stack.size()-1;
		int pop = (int) stack.get(index);
		stack.remove(index);
		return pop;
	}
	
	public static int size(){
		int size = stack.size();
		return size;
	}
	
	public static int empty(){
		int size = size();
		if(size == 0) return 1;
		else return 0;
	}
	
	public static int top(){
		int size = size();
		if(size <=0){
			return -1;
		}
		int top = (int) stack.get(size-1);
		return top;
	}
}
