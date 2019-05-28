package programmers.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Point{
	int sum; 
	int cur;
	int index; 
	
	public Point(int sum, int cur, int index){
		this.sum = sum; 
		this.cur = cur;
		this.index = index;
	}
}
public class test1 {
	
	/**
	 * 어떤 수를 서로 다른 소수 3개의 합으로 표현하는 경우의 수를 구하려 합니다. 예를 들어 33은 총 4가지 방법으로 표현할 수 있습니다.
		3+7+23
		3+11+19
		3+13+17
		5+11+17
		자연수 n이 매개변수로 주어질 때, n을 서로 다른 소수 3개의 합으로 표현하는 경우의 수를 return 하는 solution 함수를 작성해주세요.
	 * */
	
	public static void main(String[] args){
		System.out.println(solution(33));	
	}
	
	public static int NUM = 3; 
	public static int COUNT= 0; 
	@SuppressWarnings("unchecked")
	public static int solution(int n) {
        List<Integer> temp = getPrimeNumber(n);
        int [] prime = temp.stream().mapToInt(m->m.intValue()).toArray();
       
    	for(int k=0; k<prime.length; k++){
    		List<Integer> values = new ArrayList<>();
			values.add(prime[k]);
			dfs(prime, values, k, n);
    	}
        return COUNT;
    }
	
	public static void dfs(int [] prime, List<Integer> values, int index, int target){
		
		if(values.size()==3){
			int sum=0; 
			for(Integer item: values){
				sum+=item;
			}
			
			if(sum==target){
				++COUNT;
			}
		}else if(values.size()<3){
			for(int i=index+1; i<prime.length; i++){
				values.add(prime[i]);
				dfs(prime, values, i, target);
			}
		}
	
		
	}
	
	public static void bfs(int []prime, int target){
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(prime[0], 1, 0));
		
		while(!q.isEmpty()){
			Point v = q.poll(); 
			System.out.println("pop: "+"("+v.sum+" "+ v.cur+" "+v.index+")");
			if(v.cur==3 && target == v.sum ){
				++COUNT;
			}else if (v.cur<3){
				for(int i= 0 ; i< prime.length ; i++){
					q.add(new Point(v.sum+ prime[i], v.cur+1, i));
				}
				System.out.println();
			}
			
		}
	}
	public static void dfs2(int[] prime, int sum, int index, int target){
		
		if(index == NUM && sum == target){
			++COUNT;
		}else{
			for(int i=index; i<prime.length; i++){
				System.out.println("sum: "+sum+" index: "+index+ " next: "+prime[index]);
				
				dfs2(prime, sum+prime[i], index+1, target);
			}
		}
		
	}
	
	public static List getPrimeNumber(int num){
		List<Integer> primeNumber = new ArrayList<>();
		
		for(int i=2; i<num; i++) {
            boolean isPrime = true; 

            for(int j=2; j*j<=i; j++) {
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                primeNumber.add(i);
            }
        }	
		return primeNumber;
	}
}
