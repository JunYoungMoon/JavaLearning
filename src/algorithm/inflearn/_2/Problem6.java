package algorithm.inflearn._2;

import java.util.ArrayList;
import java.util.List;

/**
 * 2-6. 뒤집은 소수
 */
public class Problem6 {
    public static void main(String[] args) {
        int[] ints = new int[]{1123, 2332, 3010};

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < ints.length; i++) {

            int tmp = ints[i], res = 0;

            while (tmp > 0) {
                res = res * 10 + (tmp % 10);
                tmp = tmp / 10;
            }

            list.add(res);
        }

        System.out.println(list);
    }
}