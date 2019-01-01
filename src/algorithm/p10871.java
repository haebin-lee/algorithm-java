package algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p10871 {

	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args){
		
		String nums = keyboard.nextLine();
		int check = Integer.parseInt(nums.split(" ")[1]);
		
		String sequences = keyboard.nextLine();
		List<Integer> sequence = Arrays.asList(sequences.split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());
		
		sequence.stream().filter(m->m.intValue()<check).forEach(m->System.out.print(m +" "));
		System.out.println();
		
	}
}
