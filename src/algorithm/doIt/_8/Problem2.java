package algorithm.doIt._8;

/**
 * 8-3 Boyer-Moore법
 * KMP법 보다 우수한 알고리즘
 * 패턴의 마지막 문자부터 앞쪽으로 검사를 진행하면서 일치하지 않는 문자가 있으면 미리 준비한 표에 따라 패턴을 옮길 크기를 정한다.
 */

public class Problem2 {
    static int bmMatch(String txt, String pat) {
        int pt;
        int pp;
        int txtLen = txt.length();
        int patLen = pat.length();
        int[] skip = new int[Character.MAX_VALUE + 1];

        //문자의 크기만큼의 skip 배열에 패턴 크기값을 넣는다.
        for (pt = 0; pt <= Character.MAX_VALUE; pt++) {
            skip[pt] = patLen;
        }
        //skip 배열에 패턴이 알파벳이면 아스키코드, 한글이라면 유니코드의 번호에 인덱스 값을 넣는다.
        //패턴 안에서도 중복문자열이 있다면 우측을 기준으로 인덱스를 잡는다.
        for (pt = 0; pt < patLen - 1; pt++) {
            skip[pat.charAt(pt)] = patLen - pt - 1;
        }

        while (pt < txtLen) {
            //마지막 문자부터 검색한다.
            pp = patLen - 1;
            while (txt.charAt(pt) == pat.charAt(pp)) {
                if (pp == 0) {
                    return pt;
                }
                pp--;
                pt--;
            }
            //문자가 인덱스인 skip 배열과 패턴에서 포인터가 이동한 값의 크기중 큰것으로 다음 건너뛰기의 값을 설정한다.
            //패턴에 해당하는 문자가 없을경우 skip에는 패턴이외의 문자가 모두 패턴길이만큼 저장되어 있으므로 단숨에 패턴 길이만큼 건너뛸수 있다.
            //이동후의 패턴이 텍스트와 일치하지 않을수도 있다는 사실을 알고도 이동한다.
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