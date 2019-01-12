package algorithm;

import java.util.HashMap;
import java.util.Scanner;

public class p9375 {
	
	/**
	 * 해빈이는 패션에 매우 민감해서 한번 입었던 옷들의 조합을 절대 다시 입지 않는다. 
	 * 예를 들어 오늘 해빈이가 안경, 코트, 상의, 신발을 입었다면, 다음날은 바지를 추가로 입거나 안경대신 렌즈를 착용하거나 해야한다. 
	 * 해빈이가 가진 의상들이 주어졌을때 과연 해빈이는 알몸이 아닌 상태로 며칠동안 밖에 돌아다닐 수 있을까?
	 * */
	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args){
		
		int testcase = keyboard.nextInt();
		keyboard.nextLine();
		
		for(int i = 0 ; i< testcase ; i++){
			int num = keyboard.nextInt();
			keyboard.nextLine();

			HashMap<String, Long> clothes = new HashMap<>();
			for(int j = 0 ; j< num ; j++){
				String temp = keyboard.nextLine();
				String type = temp.split(" ")[1];
				clothes.put(type, clothes.get(type)==null? 1 : clothes.get(type).longValue()+1);
			}
			
			long [] values = clothes.entrySet().stream().mapToLong(m->m.getValue()).toArray();
			long ans =1 ;
			for(int v=0; v<values.length ; v++){
				ans = ans * (values[v] +1);
			}
			ans -= 1;
			System.out.println(ans);
			
		}
	}
}
