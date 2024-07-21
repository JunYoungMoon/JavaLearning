package algorithm.inflearn._2;

/**
 * 2-5. 소수(에라토스테네스 체)
 */
public class Problem5 {
    public static void main(String[] args) {
        int c = 21;
        int[] ints = new int[c + 1];
        int answer = 0;

        for (int i = 2; i < ints.length; i++) {

            if (ints[i] == 0) {
                answer++;

                for (int j = i; j < ints.length; j++) {
                    if (j % i == 0) {
                        ints[j] = 1;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}