package algorithm.inflearn._2;

/**
 * 2-7. 점수계산
 */
public class Problem7 {
    public static void main(String[] args) {
        int[] ints = new int[]{1,0,1,1,1,0,0,1,1,0};

        int cnt = 0;
        int sum = 0;

        for (int i = 0; i < ints.length; i++) {

            if(ints[i] == 1){
                cnt++;
                sum = cnt + sum;
            }

            if(ints[i] == 0){
                cnt = 0;
            }
        }

        System.out.println(sum);
    }
}