package algorithm.inflearn;

/**
 * 11. 문자열 압축
 */
public class Problem11 {
    public static void main(String[] args) {
        String s = "KKHSSSSSSSEE";

        StringBuilder result = new StringBuilder();

        int count = 1;
        char currentChar = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            char nextChar = s.charAt(i);

            if (currentChar == nextChar) {
                count++;
            } else {
                result.append(currentChar).append(count);
                currentChar = nextChar;
                count = 1;
            }
        }

        // Append the last character and its count
        result.append(currentChar).append(count);

        System.out.println(result);
    }
}