package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class algorithm2 {
	
	static Scanner keyboard = new Scanner(System.in);
	static List<Integer> stack = new ArrayList<>();
	
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
	public static void push(int num){
		stack.add(num);
	}
	
	public static int pop(){
		if(top() == -1){
			return -1;
		}
		int index = stack.size()-1;
		int pop = stack.get(index);
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
		int top = stack.get(size-1);
		return top;
	}
}
