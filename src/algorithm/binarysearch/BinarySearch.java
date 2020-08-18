package algorithm.binarysearch;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BinarySearch {

    /*
     * 반드시 정렬이 되어 있어야 한다.
     * O(logN)
     * */
    public static void main(String[] args) {

        List<Integer> data = IntStream.of(100, 52, 23, 1, 20, 76, 9, 88, 44, 3, 49).boxed().collect(Collectors.toList());

        // 랜덤 데이터 생성
        // List<Integer> data= IntStream.range(0, 10).mapToObj(m-> ThreadLocalRandom.current().nextInt(0,100)).collect(Collectors.toList());
        Collections.sort(data); // 정렬
        System.out.println(data);
        //System.out.println(data.subList(0, data.size()/2));
        //System.out.println(data.subList(data.size()/2, data.size()));
        System.out.printf("find: %s", BinarySearch.search(data, 51));

    }

    // TODO: 제너릭으로 변경해보기
    public static boolean search(List<Integer> list, int search) {
        System.out.println(list);
        if (list.size() == 1 && list.get(0) == search)
            return true;
        if (list.size() == 1 && list.get(0) != search)
            return false;
        if (list.size() == 0)
            return false;

        int medium = list.size() / 2;
        if (search >= list.get(medium)) {
            return search(list.subList(medium, list.size()), search);
        } else {
            return search(list.subList(0, medium), search);
        }
    }
}
