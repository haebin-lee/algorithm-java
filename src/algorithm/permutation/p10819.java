package algorithm.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/10819
 * */
public class p10819 {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Integer [] arr = new Integer[n]; 
		for(int i=0; i<n ; i++){
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		boolean [] isPick = {}; 
		permutation(Arrays.asList(arr), n, isPick);
		
		sc.close();
	}
	static void permutation(List<Integer> picked, int size, boolean isPick[] ){
	    // 기저사례 : 모든 개수를 뽑아냈다.
	    if( picked.size() == size ){
	        System.out.println(picked);
	        return ;
	    }
	     
	    for(int next = 0; next < size; next++){
	        if( isPick[next] ) continue;
	         
	        picked.add(next);
	        isPick[next] = true;
	        
	        permutation( new ArrayList<Integer>(picked), size, isPick );
	         
	        picked.remove(picked.size()-1);
	        isPick[next] = false;
	    }
	}
}
