package algorithm.powerset;

/**
 * 부분집합 구하기
 * */
public class BasicPowerSet {
	
	// if 부분집합에 원소를 포함할지의 여부를 모드 원소에 대해 적용했다면 
	// 		부분집합을 출력한다.
	//		return 
	// else 
	//	i) 현재 레벨의 원소를 포함하지 않고 다음 레벨로 넘어간다. 
	//  ii) 현재 레벨의 원소를 포함하고 다음 레벨로 넘어간다. 
	
	public static void main(String[] args){
		powerSet(0,0);
	}
	
	private static int[] set = {1,5,3};
	private static int LEVEL = set.length;
	private static int[] subSet = new int[LEVEL];
	
	public static void powerSet(int level, int subSetLen){
		if(level==LEVEL){
			for(int i=0; i<subSetLen; i++)
				System.out.print(subSet[i]+" ");
			System.out.println();
			return;
		}
		powerSet(level+1, subSetLen);
		subSet[subSetLen++] = set[level];
		powerSet(level+1, subSetLen);
	}
}
