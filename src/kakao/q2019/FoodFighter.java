package kakao.q2019;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FoodFighter {
	
	static class Food{
		int id; 
		int time; 
		public Food(int id, int time){
			this.id = id; 
			this.time = time; 
		}
	}
	public static void main(String[] args){
		
		int [] food_times = {3, 1, 2};
		long k = 5; 
//		
//		int[] food_times = {10,4,2,7};
//		long k= 10; 
		int answer = solution2(food_times, k);
		System.out.println(answer);
	}
	
	public static int solution2(int[] food_times, long k){
		int answer = -1;
		List<Food> list = new ArrayList<>();
		int id=1; 
		for(int time: food_times){
			list.add(new Food(id++, time));
		}
		List<Food> sorted = sort(list);
		printList(list);
		printList(sorted);
		
		int eaten = 0; 
		int cycle = food_times.length; 
		int curId = 0;
	
		int total = list.stream().mapToInt(m->m.time).sum();
		if(total <= k){
			return answer;
		}
		
		for(Food f: sorted){
System.out.printf("k: %d, time: %d, eaten: %d, cycle: %d", k, f.time, eaten, cycle);
System.out.println();
			if(k >= (f.time -eaten) * cycle){
				k -= (f.time-eaten) * cycle;
				list.remove(f.id-1);
			}else{
				printList(list);
                answer = list.get((int) (k % cycle)).id;
				break;
			}
			curId++;
			cycle--;
		}
		return answer; 
	}
	
	public static List<Food> sort(List<Food> list){
		List<Food> result = new ArrayList<>();
		result.addAll(list);
		result.sort(new Comparator<Food>(){

			@Override
			public int compare(Food o1, Food o2) {
				return o1.time - o2.time;
			}
			
		});
		return result; 
	}
	
	
	public static void printList(List<Food>list){
		for(Food food: list){
			System.out.print(food.time +"/"+food.id+" ");
		}
		System.out.println();
	}
	
}
