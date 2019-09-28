package algorithm.hackerrank.java.array;

import java.util.Scanner;

public class Array1 {

	public static boolean canWin3(int leap, int[] game){
		return chkRoute3(0, leap, game);
	}
	
	public static boolean chkRoute3(int idx, int leap, int[] game){
		if(idx<0|| game[idx] ==1) return false;
		if((idx==game.length-1) || idx+leap> game.length-1 ) return true; 
		
		game[idx] = 1; // 이미 방문한 노드 
		System.out.print("idx:"+ idx+"|| ");
		printArray(game);
		return chkRoute3(idx+1, leap, game) || chkRoute3(idx+leap, leap, game) || chkRoute3(idx-1, leap, game);
	}
	
	public static void printArray(int [] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin3(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
    
}
