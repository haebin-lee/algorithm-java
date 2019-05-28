package programmers.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class test2 {

	public static void main(String[] args) {

//		int[] people={1, 100};
//		int[] tshirts={100, 1, 101};
		
		int[] people={1, 2, 3};
		int[] tshirts={1, 1};

		System.out.println("max: "+solution(people, tshirts));
	}
	
	public static int solution(int[] people, int[] tshirts) {
		int answer = 0;
		HashMap<Integer, Integer> p = new HashMap<>();
		for(int item: people){
			p.put(item, p.get(item)!=null? p.get(item)+1: 1);
		}
		HashMap<Integer, Integer> t = new HashMap<>();
		for(int item: tshirts){
			t.put(item, t.get(item)!=null? t.get(item)+1: 1);
		}
//		System.out.println(p.toString());
//		System.out.println(t.toString());

		Iterator<Integer> iter = t.keySet().iterator();
		while(iter.hasNext()){
			Integer key = iter.next();
			Integer availableShirt = t.get(key);
			Integer persons = p.get(key);
			if(persons!=null)
				answer+= availableShirt>=persons? persons: availableShirt;
		}
		return answer;
	}
	
	public static int solution3(int[] people, int[] tshirts) {
		int answer = 0;
		Arrays.sort(people);
		Arrays.sort(tshirts);

		int next = 0;
		for(int i=0; i<tshirts.length; i++){
			for(int j=next ; j< people.length ; j++){
				if(tshirts[i] == people[j]){
					next=j+1;
					answer+=1;
					continue;
				}
			}
		}

		return answer;
	}
	public static int solution2(int[] people, int[] tshirts) {
		int answer = 0;
		
		List<Integer> peopleList = Arrays.stream(people).boxed().collect(Collectors.toList());
		List<Integer> tshirtList = Arrays.stream(tshirts).boxed().collect(Collectors.toList());
		
		for(int index =0; index<tshirtList.size() ; index++){
			for(Integer person: peopleList){
				if (tshirtList.get(index).equals(person)){
					tshirtList.remove(index);
					answer+=1;
					continue;
				}
			}
		}
		
		
		return answer;
	}
}
