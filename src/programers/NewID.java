package programers;

public class NewID {
    public static void main(String[] args) {

        solution("...!@BaT#*..y.abcdefghij123v12v312v3klm...,..,");
    }

    public static StringBuilder solution(String new_id) {

        StringBuilder sb = new StringBuilder();

        //1단계
        for (int i = 0; i < new_id.length(); i++) {
            int a = new_id.charAt(i);

            if (a >= 65 && a <= 90) {
                sb.append((char) (a | 32));
            } else {
                sb.append((char) (a));
            }
        }
        System.out.println(sb);

        //2단계
        for (int i = 0; i < sb.length(); i++) {
            int a = sb.charAt(i);

            if (!((97 <= a && a <= 122) || (48 <= a && a <= 57) || (a == 45) || (a == 95) || (a == 46))) {
                sb.deleteCharAt(i);
            }
        }

        System.out.println(sb);

        //3단계
        int count = 1;

        while (count > 0) {
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

        //4단계
        if (sb.charAt(0) == 46) {
            sb.deleteCharAt(0);
        }

        if (sb.length() == 0) {
            sb.append((char) 97);
        }

        if (sb.charAt(sb.length() - 1) == 46) {
            sb.deleteCharAt(sb.length() - 1);
        }

        System.out.println(sb);

        return sb;
    }
}
