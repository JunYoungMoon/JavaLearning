package algorithm;

class Node{
    int data;
    Node lt, rt;
    public Node(int val){
        data = val;
        lt = rt = null;
    }
}
public class DepthFirstSearch {
    Node root;
    public void DFS(Node root){

    }
    public static void main(String[] args) {
        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.root=new Node(1);
        dfs.root.lt=new Node(2);
        dfs.root.rt=new Node(3);
        dfs.root.lt.lt=new Node(4);
        dfs.root.lt.rt=new Node(5);
        dfs.root.rt.lt=new Node(6);
        dfs.root.rt.rt=new Node(7);
        dfs.DFS(dfs.root);
    }
}
