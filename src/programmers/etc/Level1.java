package programmers.etc;

import java.util.regex.Pattern;

public class Level1 {

	public static void main(String[] args) {

		// String [] seoul = {"Jane", "Kim"};
		// System.out.println(solution1(seoul));

//		int[][] arr1 = { { 1, 2 }, { 2, 3 } };
//		int[][] arr2 = { { 3, 4 }, { 5, 6 } };
//		solution3(arr1, arr2);

		System.out.println(solution4("0234"));
	}

	public static String solution1(String[] seoul) {
		String answer = "";
		int idx = 0;
		for (int i = 0; i < seoul.length; i++) {
			if ("Kim".equals(seoul[i])) {
				idx = i;
				break;
			}
		}
		answer = String.format("김서방은 %d에 있다.", idx);
		return answer;
	}

	public static int[] solution2(int[] answers) {
		int[] answer = {};

		int a1[] = { 1, 2, 3, 4, 5 };
		int a2[] = { 2, 1, 2, 3, 2, 4, 2, 5, 2 };
		int a3[] = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		return answer;
	}

	public static int[][] solution3(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr1[0].length];

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				answer[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		return answer;
	}

	public static boolean solution4(String s) {
		boolean answer = false;
		if(s.length()==4 || s.length()==6){
			answer = Pattern.matches("^[0-9]*$", s);
		}
		return answer;
	}
	
	public static boolean solution5(String s) {
		boolean answer = true;
		try {
	        Integer num = Integer.parseInt(s);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        answer= false;
	    }
		return answer;
	}
}
