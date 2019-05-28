package algorithm.dfs;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 가중치 없는 방향 그래프 G가 주어졌을 때, 모든 정점 (i, j)에 대해서, i에서 j로 가는 경로가 있는지 없는지 구하는 프로그램을 작성하시오.
 * 첫째 줄에 정점의 개수 N (1 ≤ N ≤ 100)이 주어진다. 
 * 둘째 줄부터 N개 줄에는 그래프의 인접 행렬이 주어진다. i번째 줄의 j번째 숫자가 1인 경우에는 i에서 j로 가는 간선이 존재한다는 뜻이고, 0인 경우는 없다는 뜻이다. i번째 줄의 i번째 숫자는 항상 0이다.
 * */
public class p11403 {
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String [] args){
		
		int n = sc.nextInt();
		int [][] arr = new int[n+1][n+1];
		int [][] ans = new int[n+1][n+1];
		int [] check = new int[n+1];

		for(int i = 1 ; i<=n ; i++){
			for(int j =1; j<= n; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 1 ; i<= n; i++){
			dfs(arr, check, i);
			for(int j = 1; j<=n ; j++){
				ans[i][j] = check[j];
			}
			Arrays.fill(check, 0);
		}
		
		for(int i = 1 ; i<=n ; i++){
			for(int j =1; j<= n; j++){
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void dfs(int[][] arr, int []check, int v){
		
		for(int i = 1 ; i<= arr.length-1 ; i++){
			if(arr[v][i]== 1 && check[i]==0){
				check[i] = 1;
				dfs(arr, check, i);

			}
		}
	}
	
	
}
