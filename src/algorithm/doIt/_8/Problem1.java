package algorithm.doIt._8;

/**
 * 8-2 KMP법
 * 문자열검색에서 패턴을 처음부터 다시 비교(브루트-포스법)하지 않고 패턴을 다시 재활용하는 알고리즘
 */

public class Problem1 {
    static int kmpMatch(String txt, String pat) {
        int pt = 1;
        int pp = 0;
        int[] skip = new int[pat.length() + 1];

        skip[pt] = 0;

        //txt : "ABCABCDABABCDABCABDE", pat : "ABCABD"

        //건너뛰기표(패턴중 중복이 되는 패턴을 체크하여 넘어갈 칸수를 설정)를 만든다.
        //패턴이 "ABCABD"니깐 AB가 중복되어 000120으로 기록된다.
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
        //텍스트 "ABCAB'C'.."에서 마지막이 "D"가 아닌 "C"라면 건너뛰기표를 통해
        //skip["D"앞의 "B"의 위치 4]의 값인 2를 pp로 넣어 "A"부터 다시 검사하는게 아니라 2단계를 건너뛰어 
        //"CABX"부터 다시 검사를 진행한다. 왜냐하면 앞의 "AB"는 건너뛰기표를 통해 이미 맞다고 검증이 되었기 때문이다.
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
        String txt = "ABCABCDABABCDABCABDE";
        String pat = "ABCABD";

        System.out.println(kmpMatch(txt, pat));
    }
}