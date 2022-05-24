package algorithm;

public class LastNodeDFS {
    Node root;
    public int DFS(int L, Node root){

    }

    public static void main(String[] args) {
        LastNodeDFS lnd = new LastNodeDFS();
        lnd.root = new Node(1);
        lnd.root.lt = new Node(2);
        lnd.root.rt = new Node(3);
        lnd.root.lt.lt = new Node(4);
        lnd.root.rt.rt = new Node(5);
        System.out.println(lnd.DFS(0,lnd.root));
    }
}
