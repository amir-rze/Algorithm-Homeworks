import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int xPosition;
    int yPosition;
    char ch;
    int distance = 0;

    public Node(int xPosition, int yPosition, char ch, int d) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.ch = ch;
        this.distance = d;
    }
}

public class Q5 {
    public static int distanceBFS(char[][] graph, boolean[][] visited, int xPosition, int yPosition, int xLength, int yLength) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(xPosition, yPosition, graph[xPosition][yPosition], 0));
        while (queue.size() > 0) {
            Node peek = queue.poll();
            if (!visited[peek.xPosition][peek.yPosition]) {
                visited[peek.xPosition][peek.yPosition] = true;
                if (peek.ch == 'W') {
                    continue;
                }
                if (peek.ch == 'D') {
                    return peek.distance;
                }
                int x = peek.xPosition;
                int y = peek.yPosition;
                if (x - 1 >= 0 && (!visited[x - 1][y])) {
                    Node node = new Node(x - 1, y, graph[x - 1][y], peek.distance + 1);
                    queue.add(node);
                }
                if (x + 1 < xLength && (!visited[x + 1][y])) {
                    Node node = new Node(x + 1, y, graph[x + 1][y], peek.distance + 1);
                    queue.add(node);
                }
                if (y - 1 >= 0 && (!visited[x][y - 1])) {
                    Node node = new Node(x, y - 1, graph[x][y - 1], peek.distance + 1);
                    queue.add(node);
                }
                if (y + 1 < yLength && (!visited[x][y + 1])) {
                    Node node = new Node(x, y + 1, graph[x][y + 1], peek.distance + 1);
                    queue.add(node);
                }
                if (peek.ch == 'S') {
                    if (x - 1 >= 0 && y - 1 >= 0 && (!visited[x - 1][y - 1])) {
                        Node node = new Node(x - 1, y - 1, graph[x - 1][y - 1], peek.distance + 1);
                        queue.add(node);
                    }
                    if (x - 1 >= 0 && y + 1 < yLength && (!visited[x - 1][y + 1])) {
                        Node node = new Node(x - 1, y + 1, graph[x - 1][y + 1], peek.distance + 1);
                        queue.add(node);
                    }
                    if (x + 1 < xLength && y - 1 >= 0 && (!visited[x + 1][y - 1])) {
                        Node node = new Node(x + 1, y - 1, graph[x + 1][y - 1], peek.distance + 1);
                        queue.add(node);
                    }
                    if (x + 1 < xLength && y + 1 < yLength && (!visited[x + 1][y + 1])) {
                        Node node = new Node(x + 1, y + 1, graph[x + 1][y + 1], peek.distance + 1);
                        queue.add(node);
                    }
                }
                if (peek.ch == 'T') {
                    outer : for (int i = 0; i <xLength ; i++) {
                        for (int j = 0; j <yLength ; j++) {
                            if(graph[i][j] == 'T' && peek.xPosition != i && peek.yPosition != j){
                                peek.xPosition = i;
                                peek.yPosition = j;
                                break outer;
                            }
                        }
                    }
                    Node node = new Node(peek.xPosition,peek.yPosition,graph[peek.xPosition][peek.yPosition],peek.distance+1);
                    queue.add(node);

                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main (String[]args){
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int y = input.nextInt();
        int xPosition = 0;
        int yPosition = 0;
        int index;
        char[][] graph = new char[x][y];
        boolean[][] visited = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            String ch = input.next();
            graph[i] = ch.toCharArray();
            index = ch.indexOf('H');
            if (index > -1) {
                xPosition = i;
                yPosition = index;
            }

        }
        System.out.println(distanceBFS(graph, visited, xPosition, yPosition, x, y));
    }
}