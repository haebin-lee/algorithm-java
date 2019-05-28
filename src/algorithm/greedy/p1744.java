package algorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 1. 양수,음수,1,0 분리하기 
 * 2. 양수는 큰수끼리 묶기(오름차순) - 홀수갯수이면 1을 추가하기(자기자신값)
 * 3. 음수는 작은수끼리 묶기(내림차순) - 홀수 갯수이면 0을 추가하기( -값보다 0을만드는게 낫다)
 * 4. 양수합 + 음수합 + 1의합
 * */
public class p1744 {

	/**
	 * https://www.acmicpc.net/problem/1744
	 * */
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];
		
		List<Integer> plus 	= new ArrayList<>();
		List<Integer> minus = new ArrayList<>();
		int one = 0; 
		int zero= 0;
		for(int i=0; i<n ; i++){
			arr[i] = sc.nextInt();
			if(arr[i]==1){
				one++;
			}else if(arr[i]>1){
				plus.add(arr[i]);
			}else if(arr[i]<0){
				minus.add(arr[i]);
			}else{
				zero++;
			}
		}
		Collections.sort(plus, Collections.reverseOrder());
		Collections.sort(minus);
		
		if(plus.size()%2==1){
			plus.add(1);
		}
		if(minus.size()%2 ==1){
			minus.add(zero>0? 0: 1);
		}
		int plusTotal=0;
		for(int i=0; i<plus.size(); i+=2){
			plusTotal +=(plus.get(i) * plus.get(i+1));
		}
		int minusTotal=0;
		for(int i=0; i<minus.size(); i+=2){
			minusTotal +=(minus.get(i) * minus.get(i+1));
		}
		System.out.println(plusTotal+minusTotal+one);
		sc.close();
	}
}
