package discreteMathematics;

public class BitETC {
    public static void main(String[] args) {
        byte a = 0b1010;

        if (a == (a & -a)) {
            System.out.println("2의 거듭제곱이다.");
        } else {
            System.out.println("2의 거듭제곱이 아니다.");
        }

        if (isPower(a)) {
            System.out.println("2의 거듭제곱이다.");
        } else {
            System.out.println("2의 거듭제곱이 아니다.");
        }

        int b = 12;
        int c = 112;

        b = b ^ c;
        c = b ^ c;
        b = b ^ c;

        System.out.println("b:" + b + " c:" + c);
    }

    static boolean isPower(int n) {
        while (n != 1) {

            if (n % 2 != 0) {
                return false;
            }

            n = n / 2;

        }
        return true;
    }
}
