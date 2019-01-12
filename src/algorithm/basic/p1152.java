package algorithm.basic;

import java.util.Scanner;

public class p1152 {
	
	/**
	 * 영어 대소문자와 띄어쓰기만으로 이루어진 문자열이 주어진다. 
	 * 이 문자열에는 몇 개의 단어가 있을까? 이를 구하는 프로그램을 작성하시오. 단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.
	 * */
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args){
		
		String line = keyboard.nextLine();
		
		if(line.trim().length()==0){
			System.out.println(0);
			return;
		}
		if(line.startsWith(" ")){
			line = line.substring(1, line.length());
		}
		if(line.endsWith(" ")){
			line = line.substring(0, line.length()-1);
		}
		
		String [] chars  = line.split(" ");
		
		System.out.println(chars.length);
	}
}
