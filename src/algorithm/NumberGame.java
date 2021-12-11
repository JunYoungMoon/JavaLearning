package algorithm;

public class NumberGame {
    public static void main(String[] args) {

        System.out.println(solution("2three45sixseven"));
    }

    public static int solution(String s) {
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < words.length; i++) {
            s = s.replaceAll(words[i], Integer.toString(i));

        }

        return Integer.parseInt(s);
    }
}
