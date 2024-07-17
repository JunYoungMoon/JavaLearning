package algorithm.inflearn._1;

import static java.lang.Integer.parseInt;

/**
 * 12. 암호
 */
public class Problem12 {
    private static final int CHUNK_SIZE = 7;
    private static final char ONE = '#';
    private static final char ZERO = '*';

    public static void main(String[] args) {
        int numOfChars = 4;
        String encodedString = "#****###**#####**#####**##**";

        decodeString(numOfChars, encodedString);
    }

    private static void decodeString(int numOfChars, String encodedString) {
        for (int i = 0; i < numOfChars; i++) {
            String binaryString = encodedString.substring(0, CHUNK_SIZE)
                    .replace(ONE, '1')
                    .replace(ZERO, '0');

            char decodedChar = (char) parseInt(binaryString, 2);
            System.out.print(decodedChar);

            encodedString = encodedString.substring(CHUNK_SIZE);
        }
    }
}