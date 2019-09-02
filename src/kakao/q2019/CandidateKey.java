package kakao.q2019;

import java.util.HashSet;
import java.util.Set;

public class CandidateKey {
	
	public static void main(String[] args){
		
		String [][] relation = {
				{"100","ryan","music","2"},
				{"200","apeach","math","2"},
				{"300","tube","computer","3"},
				{"400","con","computer","4"},
				{"500","muzi","music","3"},
				{"600","apeach","music","2"}
		};
		solution(relation);
	}
	
	public static int solution(String[][] relation) {
		int answer = 0;

		int column = relation[0].length;
		int row = relation.length;
		
		boolean [] checkColumn= new boolean[column];
System.out.println(checkColumn);

		for(int i = 0; i< column; i++){
			boolean unique= false; 
			Set<String> test = new HashSet<>(); 
			for(int j=0; j< row; j++){
				test.add(relation[j][i]);
			}
			if(test.size() == row){
				checkColumn[i] = true;
				++answer;
			}
		}
		
		

		
        return answer;
    }
}
