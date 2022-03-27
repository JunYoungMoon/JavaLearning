package algorithm;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person {
    int id;
    int priority;

    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

class EmergencyRoom {
    public int solution(int n, int m, int[] arr) {
        int answer = 1;
        Queue<Person> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Q.add(new Person(i, arr[i]));
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        EmergencyRoom er = new EmergencyRoom();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(er.solution(n, m, arr));
    }
}
