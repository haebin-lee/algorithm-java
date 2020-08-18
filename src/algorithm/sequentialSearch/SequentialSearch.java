package algorithm.sequentialSearch;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SequentialSearch {

    public static void main(String[] args) {

        List<Integer> data = IntStream.of(100, 52, 23, 1, 20, 76, 9, 88, 44, 3, 49).boxed().collect(Collectors.toList());
        System.out.println(data);

        System.out.printf("idx: %d", SequentialSearch.search(data, 20));
    }

    public static int search(List<Integer> data, int search) {

        for (int idx =0 ; idx<data.size(); idx++) {
            if (data.get(idx) == search) {
                return idx;
            }
        }

        return -1;
    }
}
