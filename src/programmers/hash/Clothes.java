package programmers.hash;

import java.util.HashMap;
import java.util.Iterator;

public class Clothes {

	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
		String[][] clothes3 ={{"1","head"},{"2","head"},{"3","head"},{"4","top"},{"5","top"},{"6","bottom"}};
		System.out.println(solution(clothes));
		System.out.println(solution(clothes2));
		System.out.println(solution(clothes3));

	}
	
	public static int solution(String[][] clothes) {
		int answer = 0;
		HashMap<String, Integer> closet = new HashMap<>();
		for(int i=0; i<clothes.length; i++){
			closet.put(clothes[i][1], closet.getOrDefault(clothes[i][1], 0)+1);
		}
		set = closet.values().stream().mapToInt(m->m).toArray();
		LEVEL = set.length;
		subSet = new int[LEVEL];
		
		answer = powerSet(0,0);
		
		return answer-1;
	}
	public static int[] set;
	public static int LEVEL = 0;
	public static int[] subSet;
	public static int powerSet(int level, int subSetLen){
		int sum = 0;
		if(level==LEVEL){
			int answer = 1; 
			for(int i=0; i<subSetLen; i++)
				answer *= subSet[i];
			return answer;
		}
		sum+=powerSet(level+1, subSetLen);
		subSet[subSetLen++] = set[level];
		sum+=powerSet(level+1, subSetLen);
		return sum;
	}
	
	// 다른사람 풀이
	public int solution3(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            String key = clothes[i][1];
            if(!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }
        Iterator<Integer> it = map.values().iterator();
        while(it.hasNext()) {
            answer *= it.next().intValue()+1;
        }
        return answer-1;
    }
}
