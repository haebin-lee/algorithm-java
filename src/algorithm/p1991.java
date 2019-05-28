package algorithm;

import java.util.Scanner;

/**
 * p1991
 * @author haebinlee
 * @since 2019. 1. 3.
 * @history
 * <pre>
 * 이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.
 * << 개정이력(Modification Information) >>
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *  
 *
 * </pre>
 */
public class p1991 {
	
	
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
		
		int nodeCount = keyboard.nextInt();
		keyboard.nextLine();
		
		Tree tree = new Tree();
		for(int i = 0 ; i<nodeCount ; i++){
			String temp = keyboard.nextLine();
			String [] nodes = temp.split(" ");
			tree.add(nodes[0], nodes[1], nodes[2]);
		}
		
		tree.preorder(tree.root);
		System.out.println();
		tree.inorder(tree.root);
		System.out.println();
		tree.postorder(tree.root);
		System.out.println();
		
	}
}

class Node {
	String data;
	Node left, right;
	
	public Node(String data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
}

class Tree {
	Node root; 
	
	public void add(String data, String leftData, String rightData){
		// 최초에 등록할 때
		if(root == null){
			root = new Node(data);
			if(!leftData.equals(".")) root.setLeft(new Node(leftData));
			if(!rightData.equals(".")) root.setRight(new Node(rightData));
		}else{
			// 찾아서 add한다.
			search(root, data, leftData, rightData);
		}
	}
	
	public void search(Node node, String data, String leftData, String rightData){
		
		if(node == null)
			return ;
		else if(node !=null && node.data.equals(data)){
			// 찾았다 
			if(!leftData.equals(".")) node.setLeft(new Node(leftData));
			if(!rightData.equals(".")) node.setRight(new Node(rightData));
		}else{
			// 못찾았다.
			search(node.left, data, leftData, rightData);
			search(node.right, data, leftData, rightData);
		}
	}
	
	public void preorder(Node node){
		System.out.print(node.data);
		if (node.left !=null) preorder(node.left);
		if (node.right !=null) preorder(node.right);

	}
	
	public void inorder(Node node){
		if (node.left !=null) inorder(node.left);
		System.out.print(node.data);
		if (node.right !=null) inorder(node.right);
	}
	
	public void postorder(Node node){
		if (node.left !=null) postorder(node.left);
		if (node.right !=null) postorder(node.right);
		System.out.print(node.data);

	}
	
	
}