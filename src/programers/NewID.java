package programers;

public class NewID {
    public static void main(String[] args) {

        solution("...!@BaT#*..y.abcdefghijklm");
    }

    public static StringBuilder solution(String new_id) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < new_id.length(); i++) {
            int a = new_id.charAt(i);

            if (a >= 65 && a <= 90) {
                sb.append((char) (a | 32));
            } else {
                sb.append((char) (a));
            }
        }
        System.out.println(sb);

        int k = 0;

        for (int i = 0; i < sb.length(); i++) {
            int a = sb.charAt(i);

            if (!((97 <= a && a <= 122) || (48 <= a && a <= 57) || (a == 45) || (a == 95) || (a == 46))) {
                sb.deleteCharAt(i + k);
                k--;
            }
        }

        System.out.println(sb);

        int count = 1;

        while(count > 0){
            count = 0;
            for (int i = 0; i < sb.length(); i++) {
                if (i + 1 == sb.length()) {
                    break;
                }
                if ((sb.charAt(i) == 46) && (sb.charAt(i + 1) == 46)) {
                    sb.deleteCharAt(i + 1);
                    count++;
                }
            }
        }

        System.out.println(sb);

        return sb;
    }
}
