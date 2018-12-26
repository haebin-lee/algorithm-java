package algorithm;

public class Queue{
	
	String[] queue = new String[100000];
	int front = -1; 
	int back = -1;
	void push (String item){
		queue[++back] = item;
	}
	
	String pop(){
		if(front==back)
			return null; //queue is empty
		int index = ++front;
		String item = queue[index];
		queue[index] = null;
		return item;
	}
	
	int size() {
		return back-front;
	}
	
	String front() { 
		int index = front+1;
		String item = queue[index];
		return item;
		
	}
	
	String back() {
		if(front==back)
			return null;
		String item = queue[back];
		return item;
	}
	
	int empty(){
		if(front==back) return 1;
		return 0;
	}
	
	
}
