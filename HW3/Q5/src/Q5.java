import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node{
    int start;
    int end;
    int lenght;

    public Node(int start,int end , int lenght){
        this.start=start;
        this.end=end;
        this.lenght=lenght;
    }

    @Override
    public int compareTo(Node node) {
        if(end-node.end<0)
            return 1;
        else if(end-node.end==0)
            if(start-node.start<0)
                return 1;
            else
                return -1;
        else
            return -1;
//        return end - node.end < 0 &&start-node.start ? 1 : -1;
    }
}


public class Q5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int counter = 0;
        PriorityQueue<Node> nodes = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            int length = input.nextInt();
            Node node = new Node(start,end,length);
            nodes.add(node);
        }
    }
}
