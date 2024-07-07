package algorithm.inflearn;

import java.util.Scanner;

/**
 * 2. 대소문자 변환
 */
public class Problem2 {
    // CharSequence를 상속받는 타입에 대한 제네릭 메서드
    static <S extends CharSequence> S solution(S s) {
        return (S) s.chars()
                .mapToObj(c -> {
                    char ch = (char) c;
                    if (Character.isUpperCase(ch)) {
                        return Character.toLowerCase(ch);
                    } else if (Character.isLowerCase(ch)) {
                        return Character.toUpperCase(ch);
                    } else {
                        return ch;
                    }
                })
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        String str = kb.nextLine();
        if (str.length() > 100) {
            System.out.println("String length exceeds 100 characters. Please enter a shorter string.");
            return;
        }

        System.out.println(solution(str));
    }
}