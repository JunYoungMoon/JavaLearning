package discreteMathematics;

public class numberOfCases {
    public static void main(String[] args) {

        /**
         * 곱의 법칙
         */
        // 모든 조합의 코스메뉴를 먹는 경우의 수
        // 시간 복잡도 O(n^3)
        int appetizers = 5;
        int mainDishes = 3;
        int desserts = 9;
        int count = 0;

        for (int i = 0; i < appetizers; i++) {
            for (int j = 0; j < mainDishes; j++) {
                for (int k = 0; k < desserts; k++) {
                    count++;
                }
            }
        }
        System.out.println(count);
        count = 0;


        // 멱집합의 원소수
        // 부분 집합에 포함하는지, 하지 않는지 각 원소의 경우의 수는 2개
        int r = 2;
        // 각 원소수
        int n = 5;

        for (int i = 0; i < n; i++) {
            r *= r;
        }

        System.out.println(count);
        count = 0;

        /**
         * 합의 법칙
         */
        // 음료 마시기
        // 기프티콘 한장을 받음 커피 총 12종, 스무디 총4종 중에 하나 선택하기
        // 시간 복잡도 O(n)
        int coffees[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int smoothies[] = {13, 14, 15, 16};

        for (int i = 0; i < coffees.length; i++) {
            count++;
        }
        for (int i = 0; i < smoothies.length; i++) {
            count++;
        }
        System.out.println(count);
        count = 0;

        // 두 주사위의 합이 2또는 3이되는 경우의수
        int dice[] = {1, 2, 3, 4, 5, 6};
        int case1 = 0;
        int case2 = 0;

        for (int i = 0; i < dice.length; i++) {
            for (int j = 0; j < dice.length; j++) {
                if (dice[i] + dice[j] == 2) {
                    case1++;
                } else if (dice[i] + dice[j] == 3) {
                    case2++;
                }
            }
        }

        for (int i = 0; i < case1; i++) {
            count++;
        }
        for (int i = 0; i < case2; i++) {
            count++;
        }

        System.out.println(count);
        count = 0;

        /**
         * 복잡한 경우의 수 문제들
         */
        // 길이가 최대 두글자인 변수명 짓기
        // 변수명이 한글자 일때 경우의 수 a~z 26
        // 변수명이 두글자 일때 경우의 수 a~z + 0~9
        // 단 is,as,in 이름은 사용불가
        char[] arr1 = new char[26];
        char[] arr2 = new char[36];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (char) (97 + i);
        }
        for (int i = 0; i < arr2.length - 10; i++) {
            arr2[i] = (char) (97 + i);
        }

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                String s = String.valueOf(arr1[i]) + String.valueOf(arr2[j]);
                if (s.equals("is") || s.equals("as") || s.equals("in")) {

                }else{
                    count++;
                }
            }
        }

        System.out.println(count);
        count = 0;
    }
}
