import java.util.*;

class Node implements Comparable<Node> {
    int x;
    int y;
    int c;

    public Node(int x, int y, int c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    @Override
    public int compareTo(Node o) {
        return c - o.c < 0 ? 1 : -1;
    }
}

public class Q3 {
    public static int find(int[] parent, int n) {
        if (parent[n] == n)
            return n;
        return find(parent, parent[n]);
    }

    private static void merge(int[] parent, int[] h, int labelA, int labelB) {
        if (labelA != labelB) {
            if (h[labelA] > h[labelB]) {
                parent[labelB] = labelA;
            } else if (h[labelB] > h[labelA]) {
                parent[labelA] = labelB;
            } else {
                parent[labelA] = labelB;
                h[labelB]++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int s = input.nextInt();
        int sum = 0;
        int[] parent = new int[n];
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            h[i] = 1;
        }
        PriorityQueue<Node> heap = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            int c = input.nextInt();
            Node node = new Node(x, y, c);
            heap.add(node);
        }
        if (heap.size() < n - 1)
            System.out.println(-1);
        else {
            List<Node> list = new LinkedList<>();
            while (!heap.isEmpty() && list.size() < n - 1) {
                Node poll = heap.poll();
                if (find(parent, poll.x - 1) != find(parent, poll.y - 1)) {
                    list.add(poll);
                    merge(parent, h, find(parent, poll.x - 1), find(parent, poll.y - 1));
                }
            }
            for (Node node : list) {
                sum += node.c;
            }
            System.out.println(sum);
        }
    }
}
