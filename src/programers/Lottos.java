package programers;

import java.util.Arrays;

public class Lottos {
    public static void main(String[] args) {

        int[] lottos = {45, 4, 35, 20, 3, 9};

        int[] win_nums = {20, 9, 3, 45, 4, 35};

        int[] arr = solution(lottos, win_nums);

        System.out.println(Arrays.toString(arr));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {

        //제한사항
        if (lottos.length > 6 || win_nums.length > 6) {
            System.out.println("로또는 6자리다.");
        }

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] > 45 || lottos[i] < 0) {
                System.out.println("lottos 0~45자리 까지다.");
            }
            if (win_nums[i] > 45 || win_nums[i] <= 0) {
                System.out.println("win_nums 1~45자리 까지다.");
            }
        }

        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if (lottos[i] == lottos[j] && lottos[i] != 0) {
                    System.out.println("민우야 번호가 중복된다.");
                    break;
                }
                if (win_nums[i] == win_nums[j]) {
                    System.out.println("당첨 번호가 중복된다.");
                    break;
                }
            }
        }
        //끝

        int sameNum = 0;
        int zeroCount = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++;
            } else {
                for (int win_num : win_nums) {
                    if (lotto == win_num) {
                        sameNum++;
                    }
                }
            }
        }

        //등수가 나와야함
        int best = sameNum + zeroCount;
        int worst = sameNum;

        int[] arr1 = {6,6,5,4,3,2,1};

        return new int[]{arr1[best],arr1[worst]};
    }
}
