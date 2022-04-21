package algorithm;

public class RecursiveFunction {
    public int DFS(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n*DFS(n-1);
        }
    }

    public static void main(String[] args) {
        RecursiveFunction rf = new RecursiveFunction();

        System.out.print(rf.DFS(3));

    }
}
