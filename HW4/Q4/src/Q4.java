import java.util.PriorityQueue;
import java.util.Scanner;


class Node implements Comparable<Node> {
    int l;
    int r;
    int sub;

    public Node(int l, int r) {
        this.l = l;
        this.r = r;
        sub = r - l;
    }

    @Override
    public int compareTo(Node node) {
        if (l - node.l > 0)
            return 1;
        else if (l - node.l == 0)
            if (r - node.r > 0)
                return 1;
            else
                return -1;
        return -1;
    }
}


public class Q4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        Node[] array = new Node[n];
        PriorityQueue<Node> heap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int l = input.nextInt();
            int r = input.nextInt();
            Node node = new Node(l, r);
            array[i] = node;
            heap.add(node);
        }
        boolean flag = true;
        int counter = 1;
        outer:while (heap.size() > 0) {
            if (counter >= heap.peek().l && counter <= heap.peek().r) {
                for (int i = 0; i < k; i++) {
                    heap.poll();
                    if (heap.size() < 1)
                        break outer;
                    if (counter < heap.peek().l) {
                        counter = heap.peek().l;
                        continue outer;
                    }
                }
                counter++;
                Node temp = heap.peek();
                if (temp.r < counter) {
                    flag = false;
                    break;
                }
            } else {
                counter = heap.peek().l;
            }
        }
        if (flag == true)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
