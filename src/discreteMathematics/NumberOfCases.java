package discreteMathematics;

public class NumberOfCases {
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
        System.out.println("모든 코스메뉴 먹기 " + count);
        count = 0;


        // 멱집합의 원소수
        // 부분 집합에 포함하는지, 하지 않는지 각 원소의 경우의 수는 2개
        int r = 2;
        // 각 원소수
        int n = 5;

//        for (int i = 0; i < n; i++) {
//            r = r * 2;
//        }

        r = r << n;

        System.out.println("멱집합 원소수 : " + r);

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
        System.out.println("음료 마시기 : " + count);
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

        System.out.println("두주사위 합 : " + count);
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
                String s = String.valueOf(arr1[i]) + (arr2[j]);
                if (s.equals("is") || s.equals("as") || s.equals("in")) {

                } else {
                    count++;
                }
            }
        }

        System.out.println("변수명 짓기 : " + count);
        count = 0;

        /**
         * 포함 배제 원리
         */
        // 경품 추천권 번호는 총 4자리 (모두숫자)
        // 경품 당첨 조건은 두가지중 하나
        // 1. 시작 번호가 3 (3□□□)
        // 2. 뒤로 부터 두자리 숫자가 77 (□□77)
        int decimalCase1 = 10,
                decimalCase2 = 10,
                exclusion = 10;
        long result;

        for (int i = 0; i < 2; i++) {
            decimalCase1 *= decimalCase1;
        }
        for (int i = 0; i < 1; i++) {
            decimalCase2 *= decimalCase2;
        }

        result = decimalCase1 + decimalCase2 - exclusion;

        System.out.println("경품 당첨 경우의 수 : " + result);

        /**
         * 트리 이용하기
         */
        //가위바위보 삼세판 모든 경우의 수
        char[] target = {'A', 'P'};

        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target.length; j++) {
                if (target[i] == target[j]) {
                    count++;
                    continue;
                }
                for (int k = 0; k < target.length; k++) {
                    count++;
                }
            }
        }

        System.out.println("가위바위보 삼세판 경우의 수 : " + count);
        count = 0;

        /**
         * 순열 공식과 다양한 예
         * 순열(permutation) : 순서를 따진다. (1,2,3)과 (2,1,3)은 다르다.
         * 공식 : P(n,r) = n!/(n-r)! 혹은 nPr = n!/(n-r)!
         */
        // 6가지 펜중 2가지를 뽑는 경우의 수

        // 재귀함수 방식
        System.out.println("순열 재귀함수 방식 : " + permutation(6, 2));

        // 순열 공식 6P2 6!/4!
        long a = 1, b = 1;
        n = 6;
        r = 2;
        for (int i = 1; i < n; i++) {
            a = a * (i + 1);
        }
        for (int i = 1; i < n - r; i++) {
            b = b * (i + 1);
        }
        result = a / b;
        System.out.println("순열 공식 방식 : " + result);

        /**
         * 중복 순열
         * 중복 : 하나를 뽑고 다시 넣는 방식 (예 주사위를 n번 던진다. 횟수가 무한대로 증가 가능)
         * 공식 : (n^r)
         */
        // 8자리 패스워드의 경우의수
        // 각자리는 알파벳 대소문자 52개
        long password = 1;

        for (int i = 0; i < 8; i++) {
            password = password * 52;
        }

        System.out.println("패스워드 중복 순열 : " + password);

        /**
         * 조합 공식과 다양한 예
         * 조합(combination) : 순서를 안따진다. (1,2,3)과 (2,1,3)은 같다.
         * 공식 : C(n,r) = n!/(r!*(n-r)!) 혹은 nCr = n!/(r!*(n-r)!)
         * 설명 : 전체 경우의수(순열)에서 선택한 갯수의 경우의 수만큼 나눠(순서를 따지지 않기 때문에 (1,2),(2,1)이라는 경우에는 하나로 보기위해)준다.
         */
        // 로또 당첨 모든 경우의수
        // 조합 공식 45C6 45!/6!39!
        a = 1;
        b = 1;
        n = 45;
        r = 6;

        //45!/39! 45x44x43x42x41x40
        for (int i = n; i > n - r; i--) {
            a = a * i;
        }

        //6! 6x5x3x2x1
        for (int i = r; i > 0; i--) {
            b = b * i;
        }

        result = a / b;

        System.out.println("조합 공식 방식 : " + result);

        /**
         * 중복 조합
         * 중복 : 하나를 뽑고 다시 넣는 방식
         * 공식 : (n+r-1)Cr = (n+r-1)!/(r!*(n-r)!)
         * 설명 : 무한대로 증가 할 수 있는 뽑는 횟수에 따라서 순서를 따지지 않으려면,
         *       칸막이(r-1)를 둠으로써 데이터간의 이동을 막아버리면 된다.
         */

        //색이 다른 3종류 공에서 4개를 선택하는 경우의 수
        a = 1;
        b = 1;
        n = 3;
        r = 4;

        n = n + r - 1;

        //6!/2! 6x5x4x3
        for (int i = n; i > n - r; i--) {
            a = a * i;
        }

        //4! 4x3x2x1
        for (int i = r; i > 0; i--) {
            b = b * i;
        }

        result = a / b;

        System.out.println("중복 조합 공식 방식 : " + result);

    }

    // 순열 재귀함수
    public static int permutation(int n, int r) {

        int count = 0;
        if (r == 0) {
            return 1;
        } else {
            for (int i = 0; i < n; i++) {
                count++;
            }
            return count * permutation(n - 1, r - 1);
        }
    }
}
