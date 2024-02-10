import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class Graph {
    private int v;
    private boolean[] visited;
    private int connectedComponents = 0;
    private boolean flag ;
    private ArrayList<Integer>[] adjList;

    public Graph(int v) {
        this.v = v;
        adjList = new ArrayList[v];
        visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new ArrayList<>();
            visited[i] = false;
        }
    }

    public void addEdge(int x, int y) {
        adjList[x - 1].add(y);
        adjList[y - 1].add(x);
    }

    public void dfsTraversal(int v, boolean[] visited,int parent) {
        visited[v - 1] = true;
        for (int x : adjList[v - 1]) {
            if (!visited[x - 1])
                dfsTraversal(x, visited,v);
            else if(x!=parent)
                flag=true;
        }
    }

    public int connectedComponents() {
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                flag=false;
                dfsTraversal(i + 1, visited,0);
                if(!flag)
                    connectedComponents++;
            }
        }
        return connectedComponents;
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Graph graph = new Graph(n);
        int m = input.nextInt();
        int x, y;
        for (int i = 0; i < m; i++) {
            x = input.nextInt();
            y = input.nextInt();
            graph.addEdge(x, y);
        }
        System.out.println(graph.connectedComponents());

    }
}
