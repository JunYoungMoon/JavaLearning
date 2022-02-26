package algorithm;

import java.util.HashMap;
import java.util.Scanner;

public class ClassPresident {
    public char solution(int n, String s) {
        char answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        // map.containsKey('E'); 키 포함여부
        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ClassPresident cp = new ClassPresident();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String str = kb.next();
        System.out.println(cp.solution(n, str));
    }
}
