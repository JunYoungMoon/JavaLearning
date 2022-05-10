package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindCalf {
    int answer = 0;
    int[] dis = {1, -1, 5};
    int[] ch;
    Queue<Integer> Q = new LinkedList<>();

    public int BFS(int s, int e) {

    }

    public static void main(String[] args) {
        FindCalf fc = new FindCalf();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int e = kb.nextInt();
        System.out.println(fc.BFS(s, e));
    }
}
