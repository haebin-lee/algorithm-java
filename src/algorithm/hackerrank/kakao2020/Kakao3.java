package algorithm.hackerrank.kakao2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Kakao3 {
    /*
    * 테스트케이스 : 통과
    * */
    public static void main(String[] args) {

        int k = 3;

        int[] a = {1,2,12,5,6,30,32};
        List<Integer> arrival = Arrays.stream(a).boxed().collect(Collectors.toList());

        int[] l = {15,10,10,10,10,15,10};
        List<Integer> load = Arrays.stream(l).boxed().collect(Collectors.toList());


        System.out.println(solution(k, arrival, load));
    }

    /**
     * solution: 라운드 로빈을 구현
     * 도착한 순서만큼 처리 함.
     * 도착했을 때 서버가 남아 있지 않으면 해당 로드는 폐기
     * 가장 많이 처리한 서버으 인덱스를 오름차순으로 정의
     *
     * @param k 처리할 수 있는 서버의 갯수
     * @param arrival 도착 순서(초)
     * @param load 처리해야할 양
     * @return
     */
    public static List<Integer> solution(int k, List<Integer> arrival, List<Integer> load) {
        HashMap<Integer, Integer> data = new HashMap<>();

        int[] total = new int[k];	// 처리양
        int[] end = new int[k]; 	// 종료시간

        for(int i=0; i<arrival.size(); i++) {
            data.put(arrival.get(i), load.get(i));
        }
        data = data.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        Iterator<Integer> iter = data.keySet().iterator();
        while(iter.hasNext()) {
            Integer key = iter.next();
            Integer value = data.get(key);

            int i = getMinIdx(end);
            if(end[i]< key) {
                total[i] += value;
                end[i] = key + value -1;
                System.out.printf("%d번째 서버, time=%d load=%d %d초에 끝남", i+1, key, value, end[i]);
                System.out.println();
            }
        }

        OptionalInt opt = Arrays.stream(total).max();
        int max = 0;
        if(opt.isPresent()) {
            max = opt.getAsInt();
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0; i< total.length; i++) {
            if(total[i] == max) {
                result.add(i+1);
            }
        }

        return result;
    }
    public static int getMinIdx(int[] arr) {
        int min = arr[0];
        int idx = 0;
        for(int i=0 ; i< arr.length; i++) {
            if(min > arr[i]) {
                idx = i;
                min = arr[i];
            }
        }
        return idx;
    }


}

