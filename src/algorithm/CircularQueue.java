package algorithm;

import java.util.Arrays;

public class CircularQueue {
	
	String [] queue = null;
	int size = 0;
	int front = 0;
	int back = 0;
	
	public CircularQueue(int size){
		this.size = size+1;
		queue = new String[size+1];
	}
	
	void push (String item){
		if(isFull()) {
			System.out.println("queue is full");
			return;
		}
		back = (back+1) % size;
		queue[back] = item;
	}
	
	String pop(){
		if(isEmpty())
			return null; 
		front = (front+1) % size;
		String item = queue[front];
		queue[front] = null;
		return item;
	}
	
	int size() {
		return back-front;
	}
	
	String front() { 
		String item = queue[(front+1) % size];
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
	boolean isFull(){
		return (back+1)%size == front % size;
	}

	@Override
	public String toString() {
		return "CircularQueue [queue=" + Arrays.toString(queue) + "]";
	}
	
	
}
