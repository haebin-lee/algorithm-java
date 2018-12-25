package algorithm;

public class Queue{
	
	String[] queue = new String[100000];
	int front = 0; 
	int back = -1;
	void push (String item){
		queue[++back] = item;
		
	}
	
	String pop(){
		if(front ==-1 || front>back)
			return null;
		String item = queue[front];
		queue[front++] = null;
		return item;
	}
	
	int size() {
		if(front>back) return 0;
		return back-front+1;
	}
	
	String front() { 
		String item = queue[front];
		return item;
		
	}
	
	String back() {
		if(back != -1){
			String item = queue[back];
			return item;
		}
		return null;
	}
	
	int empty(){
		if(size()==0) return 1;
		return 0;
	}
	
	
}
