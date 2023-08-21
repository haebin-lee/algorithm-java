package algorithm.stack;

import java.util.ArrayList;
import java.util.List;

public class CustomStack<T> {
	
	
	private List<T> stack = new ArrayList<>();
	
	void push (T input){
		stack.add(input);
	}
	
	T pop(){
		if(isEmpty()){
			return null;
		}
		int index = stack.size()-1;
		T pop = stack.get(index);
		stack.remove(index);
		return pop;
	}
	
	T top(){
		if(isEmpty()){
			return null;
		}
		int index = stack.size()-1;
		T pop = stack.get(index);
		return pop;
	}
	
	boolean isEmpty(){
		if(stack.size()==0)
			return true;
		return false;
	}
		
}
