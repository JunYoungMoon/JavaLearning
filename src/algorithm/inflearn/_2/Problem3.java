package algorithm.inflearn._2;

/**
 * 2-3. 가위 바위 보
 */
public class Problem3 {
    public static void main(String[] args) {
        int cnt = 5;
        int[] A = new int[]{2, 3, 3, 1, 3};
        int[] B = new int[]{1, 1, 2, 2, 3};

        for (int i = 0; i < cnt; i++) {
            if (A[i] == B[i]) {
                System.out.println("D");
            } else if ((A[i] == 1 && B[i] == 3) ||
                    (A[i] == 2 && B[i] == 1) ||
                    (A[i] == 3 && B[i] == 2)) {
                System.out.println("A");
            } else {
                System.out.println("B");
            }
        }
    }
}