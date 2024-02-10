import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

    class Graph {
        private int v;
        private boolean[] visited;
        private int connectedComponents = 0;
        public ArrayList<Integer>[] connectedNodes ;
        public LinkedList<Integer>[] adjList;

        public Graph(int v) {
            this.v = v;
            connectedNodes  = new ArrayList[v];
            adjList = new LinkedList[v];
            visited = new boolean[v];
            for (int i = 0; i < v; i++) {
                adjList[i] = new LinkedList<Integer>();
                connectedNodes[i] = new ArrayList<Integer>();
                visited[i] = false;
            }
        }

    public void addEdge(int x, int y) {
        adjList[x - 1].add(y);
        adjList[y - 1].add(x);
    }

    public void dfsTraversal(int v, boolean[] visited) {
        visited[v - 1] = true;
        for (int x : adjList[v - 1]) {
            if (!visited[x - 1]) {
                dfsTraversal(x, visited);
                connectedNodes[connectedComponents].add(x);
            }

        }
    }

    public int connectedComponents() {
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                connectedNodes[connectedComponents].add(i+1);
                dfsTraversal(i + 1, visited);
                connectedComponents++;
            }
        }
        return connectedComponents;
    }
}


public class Q3 {
//    public static int edgeEliminate(Graph g , ArrayList<Integer> array){
//        int edges = 0 ;
//
//        for (int i = 0; i <array.size(); i++) {
//           edges+= g.adjList[array.get(i)-1].size();
//        }
//        edges/=2;
//        return (edges - array.size()+1) ;
//    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int removeEdges = 0;
        int edges = 0;
        ArrayList <Integer> temp ;
        Graph graph = new Graph(n);
        int m = input.nextInt();
        int x, y;
        for (int i = 0; i < m; i++) {
            x = input.nextInt();
            y = input.nextInt();
            graph.addEdge(x, y);
        }
//        for (int i = 0; i <graph.connectedComponents() ; i++) {
//            temp = graph.connectedNodes[i] ;
//            if(temp.size()>2) {
//                edges = 0 ;
//
//                for (int j = 0; j <temp.size(); j++) {
//                    edges+= graph.adjList[temp.get(j)-1].size();
//                }
//                edges/=2;
//                removeEdges += (edges - temp.size()+1) ;
//            }
//        }
        removeEdges = m - n + graph.connectedComponents();
        System.out.println(removeEdges);

    }
}
