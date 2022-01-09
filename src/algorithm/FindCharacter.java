package algorithm;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindCharacter {
    public int solution(String str, char t) {
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == t) {
                answer++;
            }
        }

        for (char x : str.toCharArray()
        ) {
            if (x == t) {
                answer++;
            }
        }

        Pattern pattern = Pattern.compile(String.valueOf(t));
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        FindCharacter t = new FindCharacter();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);

        System.out.println(t.solution(str, c));
    }

}
