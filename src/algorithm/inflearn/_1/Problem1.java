package algorithm.inflearn._1;

import java.util.Scanner;

/**
 * 1. 문자 찾기
 */
public class Problem1 {
    // CharSequence를 상속받는 타입에 대한 제네릭 메서드
    static <T extends CharSequence> long solution(T s, char c) {
        // 대문자로 변환
        String upperCaseStr = s.toString().toUpperCase();
        char upperCaseChar = Character.toUpperCase(c);

        // 스트림을 사용하여 특정 문자의 개수를 계산
        return upperCaseStr.chars()
                .filter(ch -> ch == upperCaseChar)
                .count();
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        // 예제 1: String
        System.out.print("Enter a string (max 100 characters): ");
        String str = kb.next();
        if (str.length() > 100) {
            System.out.println("String length exceeds 100 characters. Please enter a shorter string.");
            return;
        }

        System.out.print("Enter a character: ");
        char c = kb.next().charAt(0);
        System.out.println("Count in String: " + solution(str, c));

        // 예제 2: StringBuilder
        System.out.print("Enter another string (max 100 characters): ");
        StringBuilder sb = new StringBuilder(kb.next());
        if (sb.length() > 100) {
            System.out.println("String length exceeds 100 characters. Please enter a shorter string.");
            return;
        }

        System.out.print("Enter a character: ");
        c = kb.next().charAt(0);
        System.out.println("Count in StringBuilder: " + solution(sb, c));

        // 예제 3: StringBuffer
        System.out.print("Enter another string (max 100 characters): ");
        StringBuffer sf = new StringBuffer(kb.next());
        if (sf.length() > 100) {
            System.out.println("String length exceeds 100 characters. Please enter a shorter string.");
            return;
        }

        System.out.print("Enter a character: ");
        c = kb.next().charAt(0);
        System.out.println("Count in StringBuffer: " + solution(sf, c));
    }
}