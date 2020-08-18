package algorithm.hackerrank.kakao2020;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Kakao2 {

    public static void main(String[] args) {
        System.out.println(Math.pow(2, 0));
        System.out.println(Math.pow(2, 1));
        System.out.println(Math.pow(2, 2));

        int[] a1 = {0,1,2};
        int[] a2 = {3,1,0};
        int[] a3 = {3,2,1};
        List<Integer> b1 = Arrays.stream(a1).boxed().collect(Collectors.toList());
        List<Integer> b2 = Arrays.stream(a2).boxed().collect(Collectors.toList());
        List<Integer> b3 = Arrays.stream(a3).boxed().collect(Collectors.toList());

        List<List<Integer>> input = new ArrayList<>();
        input.add(b1);
        input.add(b2);
        input.add(b3);

        System.out.println(solution(input));
    }

    /*
     * solution2로 제출
     * 각 비트 연산자의 합을 구해서 정렬 후 해당 인덱스의 값을 리턴
     * -> 큰 수의 경우에 범위를 벗어나서 모든 테스트케이스를 통과하지 못함 ㅠㅠ
     *  테스트케이스: 예외케이스 존재ㅠ
     * */
    public static List<Integer> solution2(List<List<Integer>>arr){

        AtomicInteger counter = new AtomicInteger();
        Map<Integer, BigDecimal> sum =
                arr.stream()
                        .map(m->m.stream().map(s-> new BigDecimal(Math.pow(2, s))).reduce(BigDecimal.ZERO, BigDecimal::add))
                        .collect(Collectors.toMap(p->counter.incrementAndGet()-1, q->q, (p,q)->q));

        System.out.println(sum);

        List<Integer> result =sum.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(m->m.getKey()).collect(Collectors.toList());

        return result;
    }

    /**
     * solution:
     * 내부에는 비트 연산자의 위치가 정의 되어 있음
     * 이진수들을 비교해서 내림 차순으로 인덱스 리턴
     *
     * @param arr
     * @return
     */
    public static List<Integer> solution(List<List<Integer>>arr){

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int idx = 0;
        for(List<Integer> item: arr) {
            Collections.sort(item, Collections.reverseOrder());
            map.put(idx++, item);
        }
        System.out.println(map);

        Map<Integer, List<Integer>> result = map.entrySet().stream().sorted(Map.Entry.comparingByValue(new Comparator<List<Integer>>(){

            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                for(int i = 0 ; i< o1.size() ; i++) {
                    System.out.println(o1.get(i)+", "+o2.get(i));
                    if(o1.get(i) == o2.get(i)) {
                        continue;
                    }else {
                        return -Integer.compare(o1.get(i), o2.get(i));
                    }
                }
                return 0;
            }})).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y)-> y, LinkedHashMap::new));

        return result.keySet().stream().collect(Collectors.toList());
    }


}
