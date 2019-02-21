package algorithm.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class p1260 {
	
	/**
	 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
	 * 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 
	 * 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
	 * 
	 * 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
	 * 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 
	 * 입력으로 주어지는 간선은 양방향이다.
	 * */
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
	
		int v = sc.nextInt(), n = sc.nextInt(), start = sc.nextInt();
		
		int [][] arr = new int [v+1][v+1];
		for (int i = 0 ; i< n ; i++){
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			
			arr[v1][v2] = 1; 
			arr[v2][v1] = 1; 
		}
		
		boolean [] check = new boolean[v+1];
		Arrays.fill(check, false);
		dfs(arr, check, start);
		System.out.println();
//		dfs2(arr, check, start, false);
		Arrays.fill(check, false);
		bfs(arr, check, start);
	}
	
	// DFS - 재귀 
	public static void dfs(int[][] a, boolean[] c, int v){
		
		c[v] = true;
		System.out.print(v+" ");
		
		for(int i = 1; i<=a.length-1 ; i++){
			if(a[v][i]==1 && !c[i]){
				dfs(a,c,i);
			}
		}
	}
	
	// DFS - 
	public static void dfs2(int [][]a, boolean c[], int v, boolean flag){
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(v);
		c[v]= true;
		System.out.print(v+" ");
		
		while(!stack.isEmpty()){
			int vv = stack.peek();
			flag = false; 
			
			for(int i = 1 ; i<=a.length-1 ; i++){
				if(a[vv][i] == 1 && !c[i]){
					stack.push(i);
					System.out.print(i+ " ");
					
					c[i] = true; 
					flag = true; 
					break;
				}
			}
			if(!flag){
				stack.pop();
			}	
		}
	}
	
	public static void bfs(int[][] a, boolean c[], int v){
		Queue<Integer> q = new LinkedList<>();
		
		q.add(v);
		c[v] = true; 
		
		while(!q.isEmpty()){
			v = q.poll();
			System.out.print(v +" ");
			
			for(int i = 1; i<= a.length-1; i++){
				if(a[v][i] == 1 && !c[i]){
					q.add(i);
					c[i] = true;
				}
			}
		}
	}
}
