package algorithm;

import java.io.*;
import java.lang.*;

public class SaraminHR1 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine().trim());
        String input, output;
        for (int i = 0; i < n; i++) {
            input = reader.readLine().trim();

            output = SaraminHR1.stringBeautify(input);

            writer.write(output + "\n");
        }

        writer.flush();
        writer.close();
        reader.close();
    }

    public static String stringBeautify(String input) {
        input += "a";
        char[] s = input.toCharArray();
        char[] arr = {'a', 'e', 'i', 'o', 'u'};
        StringBuilder str = new StringBuilder("" + s[0]);
        int cnt = 0;

        for (int i = 1; i < s.length - 1; i++) {
            for (char c : arr) {
                if (s[i] == c) {
                    cnt++;
                }
            }
            for (char c : arr) {
                if (s[i + 1] == c) {
                    cnt++;
                }
            }
            if (cnt != 2) {
                str.append(s[i]);
            }
            cnt = 0;
        }

        return str.toString();
    }
}

