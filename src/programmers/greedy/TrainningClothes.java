package programmers.greedy;

import java.util.Arrays;

public class TrainningClothes {

	/**
	 * https://programmers.co.kr/learn/courses/30/lessons/42862?language=java
	 * */
	public static void main(String[] args) {
		int n = 5; 
		int [] lost = {2,3,4};
		int [] reserve = {3,4,5};
		System.out.println("answer: "+solution(n, lost, reserve));
		
	}
	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = n - lost.length;
		
		int[] lostArr = new int[n+1];
		int[] reserveArr = new int[n+1];
		
		for(int i=1 ; i<lost.length ; i++){
			lostArr[lost[i]] = 1; 
		}
		for(int i=1 ; i<reserve.length ; i++){
			reserveArr[reserve[i]] = 1; 
		}
		for(int i=1 ; i<lostArr.length; i++){
			if(lostArr[i]!=0 && lostArr[i] == reserveArr[i]){
				++answer;
				lostArr[i]=0;
				reserveArr[i]=0;
			}
		}
		for(int i=1; i<lostArr.length; i++){
			if(lostArr[i]==0) continue;
						
			if( i-1 >reserveArr.length && lostArr[i] == reserveArr[i-1]) {
				++answer;
				lostArr[i] = 0; 
				
				
				reserveArr[i-1] = 0;
				continue;
			}
			
			if(i+1 < reserveArr.length && lostArr[i] == reserveArr[i+1]){
				++answer;
				lostArr[i] = 0; 
				reserveArr[i+1] = 0; 
				continue;
			}
		}
		
		
		return answer;
	}
}
