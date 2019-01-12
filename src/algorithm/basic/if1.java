package algorithm.basic;

import java.util.Scanner;

public class if1 {
	
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args){
		
		int score = keyboard.nextInt();
		keyboard.nextLine();
		
		String grade = "F";
		if (score >=90 && score <= 100){
			grade = "A";
		}else if (score >= 80 && score <= 89){
			grade = "B";
		}else if (score >=70 && score <= 79){
			grade = "C";
		}else if (score >=60 && score <= 69){
			grade = "D";
		}else {
			grade = "F";
		}
		
		System.out.println(grade);
	}
}
