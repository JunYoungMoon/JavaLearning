package algorithm.inflearn;

import java.util.Scanner;

/**
 * 3. 문장 속 단어중 가장 긴것 찾기
 */
public class Problem3 {
    static <S extends CharSequence> S solution(S s) {
        if (s.length() > 100) {
            throw new IllegalArgumentException("String length exceeds 100 characters. Please enter a shorter string.");
        }

        int maxLength = 0;
        S maxWord = null;
        S[] words = (S[]) s.toString().split(" ");

        for (S word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
                maxWord = word;
            }
        }

        return maxWord;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

//        String str = kb.nextLine();

        StringBuilder sb = new StringBuilder(kb.nextLine());

        try {
            System.out.println(solution(sb));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}