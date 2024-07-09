package algorithm.inflearn;

/**
 * 5. 특정 문자 뒤집기
 */
public class Problem5 {
    public static void main(String[] args) {
//        String s = "a#b!GE*T@S";
        String s = "a#b!GE*Tb!";
        char[] c = s.toCharArray();

        int lt = 0, rt = c.length - 1;
        char tmp;

        while(lt < rt){
            if(!isLatinAlphabet(c[lt])){
                lt++;
            } else if (!isLatinAlphabet(c[rt])) {
                rt--;
            } else{
                tmp = c[lt];
                c[lt] = c[rt];
                c[rt] = tmp;
                lt++;
                rt--;
            }
        }

        System.out.println(c);
    }

    public static boolean isLatinAlphabet(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
}