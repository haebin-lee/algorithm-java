package algorithm.hackerrank.kakao2020;

import java.util.Arrays;
import java.util.List;

public class Kakao1 {

    public static void main(String[] args) {

        System.out.printf("result = %d", solution("ABZ"));
    }
    /*
     * 원판에 A~Z까지 입력되어 있음
     * 현재 바늘은 A를 가르키고 있으며 해당 위치에서 다음 양옆의 위치로 이동할때 마다 1씩 증가
     * 최단거리 구하기
     * 테스트케이스: 통과
     * */
    public static long solution(String s) {
        String[] charSet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        List<String> circular = Arrays.asList(charSet);

        long path = 0;

        String current = "A";
        int currentIdx = 0;
        int size = circular.size();
        for(String str: s.split("")) {
            if( !str.equals(current)) {
                int idx = circular.indexOf(str);

                int len = Math.min(Math.abs(idx - currentIdx), size - (Math.abs(idx - currentIdx)));

                current = str;
                currentIdx = circular.indexOf(str);
                path += len;
            }


        }
        return path;
    }
}
