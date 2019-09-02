package kakao.q2019;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FailRate {
	
	public static void main(String[] args){
		
		int n = 4; 
		int [] stages = {5,5,5,5,5};
		
		solution(n, stages);
	}
	
	public static int[] solution(int N, int[] stages) {
		
		HashMap<Integer, Object> stageData = new HashMap<>();
		for(int i=1; i<=N ; i++){
			stageData.put(i, 0);
		}
		for(int miss: stages){
			Integer cnt = (Integer) stageData.getOrDefault(miss, 0);
			stageData.put(miss, cnt+1);
		}
		System.out.println(stageData);
		
		int size = stages.length;
		int exclude = 0; 
		Iterator<Integer> iter = stageData.keySet().iterator();
		while(iter.hasNext()){
			Integer key = iter.next();
			Integer nonClear = (Integer) stageData.get(key);
			double rate = nonClear.doubleValue()/((double)size-exclude);
			exclude = (exclude+nonClear.intValue());
			
			stageData.put(key, rate);
		}
	
		System.out.println(stageData);
	
        List<Map.Entry<Integer, Object>> list = new LinkedList<>(stageData.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Object>>(){

			@Override
			public int compare(Entry<Integer, Object> o1, Entry<Integer, Object> o2) {
				int comparison = 0; 
				if((double) o1.getValue()< (double)o2.getValue()){
					comparison = 1; 
				}else if((double) o1.getValue() >(double)o2.getValue()){
					comparison = -1;
				}else{
					comparison = o1.getKey().compareTo(o2.getKey());
				}				
				return comparison;
			}
        	
        });
		System.out.println(list);

        int[] answer = new int[N];
        int i=0;
		for(Map.Entry<Integer, Object> item : list){
			if(item.getKey()<=N){
				answer[i++] = item.getKey();
			}
		}
		for(int i1: answer){
			System.out.print(i1+" ");
		}
		System.out.println();
        return answer;
    }
}
