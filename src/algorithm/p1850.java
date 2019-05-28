package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1850 {
	/**
	 * 모든 자리가 1로만 이루어져있는 두 자연수 A와 B가 주어진다. 이때, A와 B의 최대 공약수를 구하는 프로그램을 작성하시오.
	 * 예를 들어, A가 111이고, B가 1111인 경우에 A와 B의 최대공약수는 1이고, A가 111이고, B가 111111인 경우에는 최대공약수가 111이다.
	 * */
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		
		String temp = bf.readLine();
		String [] numbers = temp.split(" ");
		
		long a = Long.parseLong(numbers[0]);
		long b = Long.parseLong(numbers[1]);
		long result = gcd(a, b);
		for(long i = 0 ; i< result ; i++){
			bw.write("1");
		}
		bw.write("\n");
		bw.flush();
		bw.close();
	}
	
	public static long gcd(long a, long b){
		long rest = 1; 
		while(rest>0){
			rest = a % b; 
			a = b;
			b = rest;
		}
		return a;
	}
}
