package algorithm.doIt._8;

/**
 * 8-3 Boyer-Moore법
 * KMP법 보다 우수한 알고리즘
 */

public class Problem2 {
    static int bmMatch(String txt, String pat) {
        int pt;
        int pp;
        int txtLen = txt.length();
        int patLen = pat.length();
        int[] skip = new int[Character.MAX_VALUE + 1];

        //문자의 크기만큼의 배열에 패턴 크기 값을 일일이 넣는다.
        for (pt = 0; pt <= Character.MAX_VALUE; pt++) {
            skip[pt] = patLen;
        }
        //뛰어넘을값을 지정한다 만약 패턴에 중복값이 있다면 값은 더 줄어든다.
        //ABCABD라면 A:5 > B:4 > C:3 에서 A와B가 다시 한번더 나오므로 A:2 > B:1 > D:0 으로 값이 저장된다.
        for (pt = 0; pt < patLen; pt++) {
            skip[pat.charAt(pt)] = patLen - pt - 1;
        }

        while (pt < txtLen) {
            pp = patLen - 1;
            while (txt.charAt(pt) == pat.charAt(pp)) {
                if (pp == 0) {
                    return pt;
                }
                pp--;
                pt--;
            }
            //패턴이 일치하지 않을 때 텍스트에서 패턴을 얼마나 건너뛸지 결정하는 부분.
            //
            pt += (skip[txt.charAt(pt)] > patLen - pp) ? skip[txt.charAt(pt)] : patLen - pp;
        }
        return -1;
    }

    public static void main(String[] args) {
        String txt = "ABCABCDABABCDABCABDE";
        String pat = "ABCABD";

        System.out.println(bmMatch(txt, pat));
    }
}