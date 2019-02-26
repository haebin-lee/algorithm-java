package programmers.hash;

import java.util.HashMap;
import java.util.Iterator;

public class Clothes {

	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
		
		System.out.println(solution(clothes));
		System.out.println(solution(clothes2));

	}
	

	public static int solution(String[][] clothes) {
		int answer = 0;
		HashMap<String, Integer> closet = new HashMap<>();
		for(int i=0; i<clothes.length; i++){
			closet.put(clothes[i][1], closet.getOrDefault(clothes[i][1], 0)+1);
		}
		Iterator<Integer> values = closet.values().iterator();
		int mul = 1; 
		int sum = 0; 
		if(closet.size()==1){
			answer = values.next();
		}else{
			while(values.hasNext()){
				int num = values.next();
				mul*= num;
				sum+= num;
			}
			answer = mul+sum;
		}
		return answer;
	}
}
