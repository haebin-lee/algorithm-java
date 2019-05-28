package algorithm.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Apple{
	int x; 
	int y; 
	public Apple(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class p7576 {
	
	/**
	 * https://www.acmicpc.net/problem/7576
	 * */
	static Scanner sc= new Scanner(System.in);
	static int [][] arr ;
	static int [][] day ;
	static int n; 
	static int m; 
	public static void main(String[] args){
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[m+1][n+1];
		day = new int[m+1][n+1];

		List<Apple> apples = new ArrayList<>();
		for(int i=1 ; i<=m; i++){
			for(int j =1 ; j<=n ; j++){
				int input = sc.nextInt();
				arr[i][j] = input; 
				if(input == 1)
					apples.add(new Apple(i,j));
				
			}
		}
		bfs(apples);
		int max = 0 ; 
		for(int i = 1 ; i<=m ; i++ ){
			for(int j =1 ; j<=n ; j++){
				if(arr[i][j]==0) {
					System.out.println("-1");
					return;
				}
				max = Integer.max(max, day[i][j]);
			}
		}
		System.out.println(max-1);
		
	}
	public static void bfs(List<Apple> apples){
		int x[] = {0, 0, 1, -1};
		int y[] = {1, -1, 0, 0};
		
		Queue<Apple> q = new LinkedList<>();
		for(Apple a : apples){
			q.add(a);
			day[a.x][a.y] = 1 ;
		}
		Apple cur ; 
		while(!q.isEmpty()){
			cur = q.poll();
			
			for(int i =0; i< 4 ; i++){
				int next_x = cur.x + x[i];
				int next_y = cur.y + y[i];
				
				if(next_x>=1 && next_y>=1 && next_x<= m && next_y<= n){
					if(arr[next_x][next_y]==0 && day[next_x][next_y]==0){
						arr[next_x][next_y] = 1;
						day[next_x][next_y] = day[cur.x][cur.y]+1;
						q.add(new Apple(next_x, next_y));
					}
				}
				
			}
		}
		
	}
}
