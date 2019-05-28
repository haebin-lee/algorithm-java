package programmers.stack;

import java.util.Stack;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42585?language=java
 */
public class Bar {

	public static void main(String[] args) {
		String arrangement = "()(((()())(())()))(())";
		System.out.println(solution(arrangement));
	}

	public static int solution(String arrangement) {
		int answer = 0;
		Stack<String> stack = new Stack<>();
		
		for(String item : arrangement.split("")){
			if(item.equals("("))
				stack.push(item);
			else{
				stack.pop();
				++answer;
			}
		}
		return answer;
	}
}
