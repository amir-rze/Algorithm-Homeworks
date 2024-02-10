import java.util.LinkedList;
import java.util.Scanner;


class Node {
    public LinkedList<Node> child = new LinkedList<>();
    public Node parent ;
    public int glory = 0;
    public int value;
    public Node(int value){
        this.value = value;
        parent = null;
    }
}

public class Q4 {

    public static void glory(Node root , int depth){
        if(root.child.size()==0) {
            root.glory = depth;
            return;
        }
        root.glory=depth;
        for (int i = 0; i <root.child.size() ; i++) {

            glory(root.child.get(i),depth+1);
            root.glory += root.child.get(i).glory ;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n  ; i++) {
            nodes[i]=new Node(i+1);
        }
        for (int i = 0; i < n ; i++) {
            int m = input.nextInt();
            for (int j = 0; j <m ; j++) {
                int x = input.nextInt();
                nodes[i].child.add(nodes[x-1]);
                nodes[x-1].parent=nodes[i];
            }
        }
        Node root = nodes[0];
//        while (root.parent!=null)
//            root = root.parent;
        for (int i = 0; i < n; i++) {
            if(nodes[i].parent==null)
                root = nodes[i];
        }
        glory(root,1);
        for (int i = 0; i <n ; i++) {
            System.out.print(nodes[i].glory);
            if(i!=n-1)
                System.out.print(" ");
        }

    }
}