package algorithm;
import java.util.Scanner;

public class algorithm1 {
	
	static Scanner keyboard = new Scanner(System.in);  // Reading from System.in

	public static void main(String[] args){
		int n = keyboard.nextInt();
		keyboard.nextLine();
		
		String [] inputs = new String[n];
		for(int i = 0 ; i< n ; i++){
			inputs[i] = keyboard.nextLine();
		}
		
		
	}
}
