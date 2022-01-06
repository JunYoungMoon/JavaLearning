package discreteMathematics;

public class BitMasking {
    public static void main(String[] args) {
        // 일반적인 짝수,홀수 구하는법
        int num = 0;
        if (num % 2 == 0) {
            //짝수
        }
        if (num % 2 == 1) {
            //홀수
        }
        if (num % 2 != 0) {
            //홀수 조금더 나은방법
        }

        // 비트 마스킹으로 짝수,홀수 구하는법
        if ((num & 0x1) == 0) {
            //짝수
        }
        if ((num & 0x1) != 0) {
            //홀수
        }

        // 비트 마스킹으로 양수,음수 구하는법
        if ((num & 0x80000000) == 0) {
            //양수
        }
        if ((num & 0x80000000) != 0) {
            //음수
        }

        // 비트 마스킹으로 대문자, 소문자 변환 하는법
        char c = 98;
        char mask1 = 0x20;
        if (c >= 'a' && c <= 'z') {
            c = (char) (c ^ mask1);
        }
    }
}
