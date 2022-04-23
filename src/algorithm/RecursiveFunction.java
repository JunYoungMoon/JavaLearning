package algorithm;

public class RecursiveFunction {
    static int[] fibo;
    public int DFS(int n) {
        if (n == 1) {
            return fibo[n]=1;
        } else if (n == 2) {
            return fibo[n]=1;
        } else {
            return fibo[n]=DFS(n - 2) + DFS(n - 1);
        }
    }

    public static void main(String[] args) {
        RecursiveFunction rf = new RecursiveFunction();
        int n = 7;
        fibo = new int[n+1];
        rf.DFS(n);
        for (int i = 1; i < n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }
}
