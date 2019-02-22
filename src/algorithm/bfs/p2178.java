package algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
	public int x;
	public int y; 
	public Point(int x, int y){
		this.x = x; 
		this.y = y;
	}
}
public class p2178 {
	
	
	/**
	 * N×M크기의 배열로 표현되는 미로가 있다.
	 * 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 
	 * 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 
	 * 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
	 * 위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
	 * 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
	 * */
	static Scanner sc = new Scanner(System.in);
	static int [][] arr ;
	static int [][] dist ;
	public static void main(String[] args){
		int n = sc.nextInt(), m = sc.nextInt();
		sc.nextLine();
		arr = new int[n+1][m+1];
		dist = new int[n+1][m+1];
		for (int i = 1; i <= n; i++) {
			String word = sc.nextLine();
			for (int j = 1; j <= m; j++) {
				arr[i][j] = (word.charAt(j-1) - '0');
			}
		}
		
		bfs(n, m, new Point(1,1));
		System.out.println(dist[n][m]);
	}
	
	public static void bfs(int n, int m, Point v){
		
		Queue<Point> q = new LinkedList<>();
		q.add(v);
		dist[v.x][v.y] = 1;
		
		int x[] = {1,0,-1,0}; // 두 칸 중에서 한칸만 이동한다. 
		int y[] = {0,1,0,-1}; // 두 칸 중에서 한칸만 이동한다. 
		while(!q.isEmpty()){
			 v = q.poll();
			 for(int i=0 ; i<4 ; i++){
				 int next_x = v.x + x[i];
				 int next_y = v.y + y[i];
				 if(next_x>=0 && next_y>=0 && next_x<=n && next_y<=m){
					 if(arr[next_x][next_y] == 1 && dist[next_x][next_y]==0){
						 q.add(new Point(next_x, next_y));
						 dist[next_x][next_y] = dist[v.x][v.y]+1;
					 }
				 }
			 }
		}
		
	}
}
