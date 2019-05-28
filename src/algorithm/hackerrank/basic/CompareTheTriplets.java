package algorithm.hackerrank.basic;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CompareTheTriplets {
	
	// Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
    	List<Integer> result = new ArrayList<>();
    	result.add(0);
    	result.add(0);
    	for(int i=0; i<a.size() ; i++){
    		if(a.get(i)>b.get(i)){
    			result.set(0, result.get(0)+1);
    		}else if(a.get(i) < b.get(i)){
    			result.set(1, result.get(1)+1);
    		}
    	}
		return result;
    }

    public static void main(String[] args) throws IOException {
  
        List<Integer> c = Stream.of(new String("5 6 7").split(" ")).map(Integer::parseInt).collect(toList());
        List<Integer> d = Stream.of(new String("3 6 10").split(" ")).map(Integer::parseInt).collect(toList());

        List<Integer> result = compareTriplets(c, d);
        System.out.println(result.toString());

    }
}
