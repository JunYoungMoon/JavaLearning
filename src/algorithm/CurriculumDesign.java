package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class CurriculumDesign {
    public String solution(String need, String plan) {
        String answer = "YES";
        Queue<Character> Q = new LinkedList<>();
        for (char x : need.toCharArray()) {
            Q.offer(x);
        }
        for (char x : plan.toCharArray()) {
            if (Q.contains(x)) {//contains 현재 찾고자 하는 요소가 큐에 들어 있는지 알려주는 메서드
                if (x != Q.poll()) {
                    return "NO";
                }
            }
        }
        if (!Q.isEmpty()) {
            return "NO";
        }
        return answer;
    }

    public static void main(String[] args) {
        CurriculumDesign cd = new CurriculumDesign();
        Scanner kb = new Scanner(System.in);
        String a = kb.next();
        String b = kb.next();
        System.out.println(cd.solution(a, b));
    }
}
