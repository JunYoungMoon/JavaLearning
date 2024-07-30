package algorithm.doIt._3;

/**
 * 3-3. 이진 검색
 */
public class Problem3 {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 5, 9};
        int s = 9, ps = 0, pe = ints.length - 1, center;

        while (true) {
            center = (ps + pe) / 2;

            if (s < ints[center]) {
                pe = center - 1;
            } else if (s > ints[center]) {
                ps = center + 1;
            } else {
                System.out.println("찾음 " + (center + 1) + "번째에 있음");
                break;
            }

            if (pe < ps || ps > pe) {
                System.out.println("못찾음");
                break;
            }
        }
    }
}