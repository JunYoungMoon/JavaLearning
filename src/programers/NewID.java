package programers;

public class NewID {
    public static void main(String[] args) {

        solution("...!@BaT#*..y.abcdefghijklm...");
    }

    public static StringBuilder solution(String new_id) {

        StringBuilder sb = new StringBuilder();

        //1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        for (int i = 0; i < new_id.length(); i++) {
            int a = new_id.charAt(i);

            if (a >= 65 && a <= 90) {
                sb.append((char) (a | 32));
            } else {
                sb.append((char) (a));
            }
        }

        System.out.println(sb);

        //2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        for (int i = 0; i < sb.length(); i++) {
            int a = sb.charAt(i);

            if (!((97 <= a && a <= 122) || (48 <= a && a <= 57) || (a == 45) || (a == 95) || (a == 46))) {
                sb.deleteCharAt(i);
            }
        }

        System.out.println(sb);

        //3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
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

        //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if (sb.charAt(0) == 46) {
            sb.deleteCharAt(0);
        }

        if (sb.length() != 0 && sb.charAt(sb.length() - 1) == 46) {
            sb.deleteCharAt(sb.length() - 1);
        }

        //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if (sb.length() == 0) {
            sb.append((char) 97);
        }

        System.out.println(sb);

        //6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //      만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        int index = 15;

        if (index <= sb.length()) {
            while (index < sb.length()) {
                sb.deleteCharAt(index);
            }

            if (sb.charAt(index - 1) == 46) {
                sb.deleteCharAt(index - 1);
            }
        }

        System.out.println(sb);

        return sb;
    }
}
