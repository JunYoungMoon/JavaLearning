package algorithm;

import java.util.LinkedList;
import java.util.Queue;

class Person{
    int id;
    int priority;
    public Person(int id, int priority){
        this.id = id;
        this.priority = priority;
    }
}
class EmergencyRoom {
    public int solution(int n, int m, int[] arr){
        int answer=1;
        Queue<Person> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Q.add(new Person(i, arr[i]));
        }

        return answer;
    }
}
