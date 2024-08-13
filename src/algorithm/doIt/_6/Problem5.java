package algorithm.doIt._6;

import java.util.Arrays;

/**
 * 6-5 셸정렬 (삽입정렬 개선)
 */

public class Problem5 {
    static void shellSort(int[] arr) {
        //4칸 띄운것에 대한 정렬
        //2칸 띄운것에 대한 정렬
        //마지막 삽입정렬

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 3, 4, 1, 3, 7, 1};
        shellSort(arr);
    }
}