package programers;

public class NewID {
    public static void main(String[] args) {

        solution("...!@BaT#*..y.abcdefghijklm");
    }

    public static StringBuilder solution(String new_id) {

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < new_id.length(); i++) {
            int a = new_id.charAt(i);

            if (a >= 65 && a <= 90) {
                output.append((char) (a | 32));
            } else {
                output.append((char) (a));
            }
        }

        System.out.println(output);

        return output;
    }
}
