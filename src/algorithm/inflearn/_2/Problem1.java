package algorithm.inflearn._2;

/**
 * 2-1. 큰 수 출력하기
 */
public class Problem1 {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 3, 9, 5, 6, 12};

        System.out.println(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                System.out.println(arr[i]);
            }
        }
    }
}