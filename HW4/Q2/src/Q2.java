import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


class Node implements Comparable<Node> {
    int capacity;
    int lineIndex;
    int distanceToTop;

    public Node(int capacity, int lineIndex, int distanceToTop) {
        this.capacity = capacity;
        this.lineIndex = lineIndex;
        this.distanceToTop = distanceToTop;
    }

    @Override
    public int compareTo(Node node) {
        return capacity - node.capacity;
    }
}


public class Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Queue<Integer>[] queues = new Queue[n];
        int[] lastIndexOfQueues = new int[n];
        PriorityQueue<Node> heap = new PriorityQueue<>();
        for (int i = 0; i < queues.length; i++) {
            lastIndexOfQueues[i] = -1;
            queues[i] = new LinkedList<>();
            queues[i].poll();
            int l = input.nextInt();
            for (int j = 0; j < l; j++) {
                int capacity = input.nextInt();
                queues[i].add(capacity);
                heap.add(new Node(capacity, i, j));
            }
        }

        int counter = 0;
        while (!heap.isEmpty()){
            Node poll = heap.poll();
            queues[poll.lineIndex].poll();
            lastIndexOfQueues[poll.lineIndex]++;
            counter++;
            if ((poll.capacity < counter && poll.distanceToTop >= lastIndexOfQueues[poll.lineIndex])){
                counter = poll.capacity;
                break;
            }
            else if (poll.capacity <= counter && poll.distanceToTop > lastIndexOfQueues[poll.lineIndex]){
                break;
            }
            else if (poll.distanceToTop < lastIndexOfQueues[poll.lineIndex]){
                lastIndexOfQueues[poll.lineIndex]--;
                counter--;
            }
            else if (poll.distanceToTop != lastIndexOfQueues[poll.lineIndex]){
                heap.add(poll);
            }
        }
        System.out.println(counter);
    }
}
