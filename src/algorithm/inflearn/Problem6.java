package algorithm.inflearn;

/**
 * 6. 중복 문자 제거
 */
public class Problem6 {
    public static void main(String[] args) {
        String s = "ksekkset";

        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            if(i == s.indexOf(s.charAt(i))){
                answer += s.charAt(i);
            }
        }

        System.out.println(answer);
    }
}