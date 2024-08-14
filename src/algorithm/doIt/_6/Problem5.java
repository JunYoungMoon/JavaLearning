package algorithm.doIt._6;

import java.util.Arrays;

/**
 * 6-5 셸정렬 (삽입정렬 개선)
 */

public class Problem5 {
    static void shellSort(int[] arr) {
        //4칸 띄운것에 대한 삽입정렬
        //2칸 띄운것에 대한 삽입정렬
        //1킨 띄운것에 대한 삽입정렬
//        for (int h = arr.length / 2; h > 0; h = h / 2) {
//            // h : 4,2,1
//            for (int i = h; i < arr.length; i++) {
//                // h : 4 -> i : 4,5,6,7
//                // h : 2 -> i : 2,3,4,5,6,7
//                // h : 1 -> i : 1,2,3,4,5,6,7
//
//                //삽입정렬
//                int j;
//                int tmp = arr[i];
//                for (j = i - h; j >= 0 && arr[j] > tmp; j = j - h) {
//                    arr[j + h] = arr[j];
//                }
//                arr[j + h] = tmp;
//            }
//        }

        //위의 방식은 h의 간격이 너무 촘촘하고 중복이 많이 발생하여 Knuth 수열을 통해 큰 간격을 사용하고 숫자 간의 겹침 최소화한다.
        // h = .. 121,40,13,4,1 로 가장 큰값을 h로 가져온다.
        int h;
        for (h = 1; h < arr.length / 9; h = h * 3 + 1) ;

        // 큰값에서 / 3 을 하여 마지막 1을 수행하여 삽입정렬을 마무리한다.
        for (; h > 0; h = h / 3) {
            for (int i = h; i < arr.length; i++) {
                int j;
                int tmp = arr[i];
                for (j = i - h; j >= 0 && arr[j] > tmp; j = j - h) {
                    arr[j + h] = arr[j];
                }
                arr[j + h] = tmp;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 3, 4, 1, 3, 7, 1, 6, 2, 3, 4, 1};
        shellSort(arr);
    }
}