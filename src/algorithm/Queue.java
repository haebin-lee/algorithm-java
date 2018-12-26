package algorithm;

public class Queue{
	
	String[] queue = new String[100000];
	int front = -1; 
	int back = -1;
	void push (String item){
		queue[++back] = item;
	}
	
	String pop(){
		if(isEmpty())
			return null; 
		return queue[++front];
	}
	
	int size() {
		return back-front;
	}
	
	String front() { 
		String item = queue[front+1];
		return item;
		
	}
	
	String back() {
		if(isEmpty())
			return null;
		String item = queue[back];
		return item;
	}
	
	int empty(){
		if(isEmpty()) return 1;
		return 0;
	}
	
	boolean isEmpty(){
		if(front==back) return true;
		return false;
	}
	
}
