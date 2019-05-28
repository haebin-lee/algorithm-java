package algorithm.greedy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1541
 * */
public class p1541 {
	
	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
		
		String line = sc.nextLine();
		
		int answer = 0 ; 
		String [] temp = line.split("");
		
		String mem ="";
		int value = 0; 
		List<Integer> total = new ArrayList<>();
		for(String item: temp){
//			System.out.println(item);
			//숫자인지 
			if(isNum(item)){
				mem += item;
			}else if(item.equals("+")){
				value +=Integer.parseInt(mem);
				mem="";
			}else if(item.equals("-")){
				value += Integer.parseInt(mem);
				total.add(value);
				total.add(-1);
				value = 0; 
				mem ="";
			}			
		}
		total.add(value+=Integer.parseInt(mem));
//		System.out.println(total.toString());
		
		Iterator<Integer> iter = total.iterator();
		while(iter.hasNext()){
			int check = iter.next();
			if(check==-1){
				answer -= iter.next();
			}else{
				answer+=check;
			}
		}
		System.out.println(answer);
		
		sc.close();
		
	}
	
	private static boolean isNum(String s){
		try{
			Double.parseDouble(s);
			return true;
		}catch (NumberFormatException e){
			return false;
		}
	}
}
