package algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class p2490 {

	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args){
		
		for(int i = 0 ; i <3 ; i ++){
			String temp = keyboard.nextLine();
			List<String> state = Arrays.asList(temp.split(" "));
			Long count = state.stream().filter(m->m.equals("0")).count();
			if(count == 1){
				System.out.println("A");
			}else if (count == 2){
				System.out.println("B");
			}else if (count == 3){
				System.out.println("C");
			}else if (count == 4){
				System.out.println("D");
			}else if (count == 0){
				System.out.println("E");
			}
		}
	}
}
