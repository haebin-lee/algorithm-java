package programmers.bfs;

import java.util.LinkedList;
import java.util.Queue;

class Holder{
	int sum ; 
	int index ; 
	public Holder(int sum, int index){
		this.sum = sum; 
		this.index = index;
	}
}
public class TargetNumber {

	public static void main(String[] args) {
		
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		solution(numbers, target);
		System.out.println(ANSWER);
		
	}
	public static int ANSWER =0;
	// dfs로 접근
	public static int solution(int [] numbers, int target){		 
		makeArray(numbers, 0, target);
		return ANSWER;
	}
	
	public static void makeArray(int [] numbers, int index, int target){
		if(index == numbers.length){
			
			int sum = 0; 
        	for(int item : numbers){
        		sum+=item;
        	}
        	if(sum == target) 
        		 ++ANSWER;
		}
		else if( index< numbers.length){
            numbers[index] *=1;
            makeArray(numbers,index+1, target);

            numbers[index] *=-1;
            makeArray(numbers,index+1, target);
        }
		
	}
	
	// bfs로 접근 - 이것도 틀린 방법은 아닌 것 같은데 런타임 오류가 난다.
	public static int solution2(int[] numbers, int target) {
		int answer = 0;
		Queue<Holder> q = new LinkedList<>();
		
		q.add(new Holder(numbers[0],0));
		q.add(new Holder(-numbers[0],0));

		while(!q.isEmpty()){
			Holder v = q.poll();
			if(v.index<numbers.length-1){
				int [] next = {v.sum+1, v.sum-1}; 
				for(int i = 0; i< next.length ; i++){
					if(next[i] == target && v.index+1 == numbers.length-1){
						++answer;
						continue;
					}
					q.add(new Holder(next[i], v.index+1));
				}
			}			
		}
		return answer;
	}
}
