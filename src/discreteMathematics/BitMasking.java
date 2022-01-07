package discreteMathematics;

import java.util.regex.Pattern;

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
        System.out.println(c);

        // 다른 방식의 비트마스킹 대문자에서 소문자로 변환 하는법
        char c1 = 'A';
        if(isAlphabet(c1)){
            c1 = (char) (c1 | mask1);
        }
        System.out.println(c1);

        // 다른 방식의 비트마스킹 소문자에서 대문자로 변환 하는법
        if(isAlphabet(c1)){
            c1 = (char) (c1 &~ mask1);
        }
        System.out.println(c1);
    }
    static boolean isAlphabet(char alphabet){
        return Pattern.matches("^[a-zA-Z]*$",Character.toString(alphabet));
    }
}
