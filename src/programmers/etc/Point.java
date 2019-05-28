package programmers.etc;

import java.util.HashSet;
import java.util.Set;

public class Point {

	public static void main(String[] args) {
		int [][] v = {{1, 4}, {3, 4}, {3, 10}};
		int [] ans = solution(v);
	}

	public static int[] solution(int[][] v) {
		int[] answer = {};
		Set<Integer> x = new HashSet<>();
		Set<Integer> y = new HashSet<>();

		for(int i=0; i< v.length; i++){
			for(int j=0; j<v[i].length; j++){
				x.add(v[i][0]);
			}
		}
		System.out.println(x.toString());
		System.out.println(y.toString());

		return answer;
	}

}
