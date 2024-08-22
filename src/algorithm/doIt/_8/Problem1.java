package algorithm.doIt._8;

/**
 * 8-2 KMP법
 */

public class Problem1 {
    static int kmpMatch(String txt, String pat) {
        int pt = 1;
        int pp = 0;
        int[] skip = new int[pat.length() + 1];

        skip[pt] = 0;

        while (pt != pat.length()) {
            if (pat.charAt(pt) == pat.charAt(pp)) {
                skip[++pt] = ++pp;
            } else if (pp == 0) {
                skip[++pt] = pp;
            } else {
                pp = skip[pp];
            }
        }

        pt = pp = 0;
        while (pt != txt.length() && pp != pat.length()) {
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else if (pp == 0) {
                pt++;
            } else {
                pp = skip[pp];
            }
        }

        if (pp == pat.length()) {
            return pt - pp;
        }
        return -1;

    }

    public static void main(String[] args) {
        String txt = "ABCABCDABABCDABCDABDE";
        String pat = "ABCDABD";

        System.out.println(kmpMatch(txt, pat));
    }
}