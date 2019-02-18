package algorithm.matrix;

import java.util.Scanner;

public class p2740 {
	
	/**
	 * N*M크기의 행렬 A와 M*K크기의 행렬 B가 주어졌을 때, 두 행렬을 곱하는 프로그램을 작성하시오.
	 * */
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args){
		
		int n1 = keyboard.nextInt(), m1=keyboard.nextInt();
		int [][] matrix1 = new int[n1][m1];
		for(int i = 0 ; i<n1 ; i++){
			for(int j = 0; j<m1 ; j++){
				matrix1[i][j] = keyboard.nextInt();
			}
		}
		
		
		int n2 = keyboard.nextInt(), m2=keyboard.nextInt();
		int [][] matrix2 = new int[n2][m2];
		for(int i = 0 ; i<n2 ; i++){
			for(int j = 0; j<m2 ; j++){
				matrix2[i][j] = keyboard.nextInt();
			}
		}
		
	
		for(int i=0 ; i<n1 ; i++){
			for(int j =0 ; j < m2; j++){
				int sum = 0; 
				for(int k = 0 ; k< m1 ; k++){
					sum += matrix1[i][k] * matrix2[k][j];
				}
				System.out.print(sum+" ");
			}
			System.out.println();
		}
	}
}
