package algorithm.inflearn._2;

/**
 * 2-2. 보이는 학생
 */
public class Problem2 {
    public static void main(String[] args) {
        int[] arr = new int[]{130, 135, 148, 140, 145, 150, 150, 153};

        int cnt = 1, max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                cnt++;
                max = arr[i];
            }
        }

        System.out.println(cnt);
    }
}