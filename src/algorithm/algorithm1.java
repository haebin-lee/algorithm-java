package algorithm;
import java.util.Scanner;

public class algorithm1 {
	
	static Scanner keyboard = new Scanner(System.in);  // Reading from System.in

	public static void main(String[] args){
		int n = keyboard.nextInt();
		keyboard.nextLine();
		
		String [] inputs = new String[n];
		for(int i = 0 ; i< n ; i++){
			inputs[i] = keyboard.nextLine();
		}
		
		
	}
	
	public void makeTree(String [] inputs){
		Node root = new Node();
		
		for(String input: inputs){
			String [] list = input.split(" ");
			for(String item: list){
			
			}
		}
	}
	
	
	
	class Node<T> {
		
		T root;
		Node<T> left;
		Node<T> right;
		public T getRoot() {
			return root;
		}
		public void setRoot(T root) {
			this.root = root;
		}
		public Node<T> getLeft() {
			return left;
		}
		public void setLeft(Node<T> left) {
			this.left = left;
		}
		public Node<T> getRight() {
			return right;
		}
		public void setRight(Node<T> right) {
			this.right = right;
		}
		
		
		
	}
}
