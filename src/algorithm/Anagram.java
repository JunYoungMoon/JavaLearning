package algorithm;

import java.util.HashMap;
import java.util.Scanner;

public class Anagram {
    public String solution(String s1, String s2) {
        String answer = "YES";
        HashMap<Character,Integer> map = new HashMap<>();


        return answer;
    }

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        Scanner kb = new Scanner(System.in);
        String a = kb.next();
        String b = kb.next();
        System.out.println(anagram.solution(a, b));
    }
}
