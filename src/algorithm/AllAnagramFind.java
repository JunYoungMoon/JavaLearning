package algorithm;

import java.util.HashMap;
import java.util.Scanner;

public class AllAnagramFind {
    public int solution(String a, String b) {
        int answer = 0;
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();
        return answer;

    }

    public static void main(String[] args) {
        AllAnagramFind aaf = new AllAnagramFind();
        Scanner kb = new Scanner(System.in);
        String a = kb.next();
        String b = kb.next();
        System.out.print(aaf.solution(a, b));
    }
}
