package algorithm.inflearn._2;

import java.util.ArrayList;
import java.util.List;

/**
 * 2-4. 피보나치 수열
 */
public class Problem4 {
    public static void main(String[] args) {
        int cnt = 5;

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(1);

        for (int i = 0; i < cnt; i++) {
            list.add(list.indexOf(i) + list.indexOf(i + 1));
            i = i + 2;
        }
    }
}