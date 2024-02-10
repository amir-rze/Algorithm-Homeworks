import java.util.*;

/*
   created by Amir Rezaei on 2019/12/26
 */

class Node {
    int value;
    int groupId;

    public Node(int value, int groupId) {
        this.value = value;
        this.groupId = groupId;
    }
}

class CompareByValue implements Comparator<Node> {

    @Override
    public int compare(Node n1 ,Node n2) {
        return n1.value - n2.value;
    }

}

public class Q5LCS {

    public static int counter=0;

    public static int LCS(Node[] a, Node[] b, int size) {

        int[][] matrix = new int[size + 1][size + 1];
        for (int i = 0; i < a.length; i++) {
            matrix[0][i] = 0;
        }
        for (int i = 0; i < b.length; i++) {
            matrix[i][0] = 0;
        }
        for (int i = 1; i < size + 1; i++) {
            for (int j = 1; j < size + 1; j++) {
                if (a[i - 1].equals(b[j - 1]))
                    matrix[i][j] = matrix[i - 1][j - 1]+1;
                else {
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
                }
            }
        }
        int lcs = matrix[size][size];
        return 2*(size-lcs);
    }

    public static void swap(int [] input, int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    public static  void permutation(int n, int [] elements,int [][] permutations ) {

        if(n == 1) {
            for (int i = 0; i < elements.length; i++) {
                permutations[counter][i]=elements[i];
            }
            counter++;
        } else {
            for(int i = 0; i < n-1; i++) {
                permutation(n - 1, elements,permutations);
                if(n % 2 == 0) {
                    swap(elements, i, n-1);
                } else {
                    swap(elements, 0, n-1);
                }
            }
            permutation(n - 1, elements,permutations);
        }
        return;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        Node[] nodes = new Node[n * m];
        Node[] result;
        ArrayList<Node>[] matrix = new ArrayList[n];
        int [] groups = new int [n];
        for (int i = 0; i < n; i++) {
            matrix[i] = new ArrayList<>();
            groups[i] = i+1;
        }
        for (int i = 0; i < n * m; i++) {
            int groupId = input.nextInt();
            int value = input.nextInt();
            Node node = new Node(value, groupId);
            nodes[i] = node;
            matrix[groupId - 1].add(node);
        }
        for (int i = 0; i < n; i++) {
            Collections.sort(matrix[i],new CompareByValue());
        }
        int fact = 1;
        for (int i = 1; i < n + 1; i++) {
            fact *= i;
        }
        int answer=0,min = Integer.MAX_VALUE;
        int[][] permutations = new int[fact][n];
        permutation(n ,groups,permutations);
        for (int i = 0; i < fact; i++) {
            result = new Node[n * m];
            int k =0;
            for (int id:permutations[i]) {
                for (int j = 0; j <m ; j++) {
                    result[k]=matrix[id-1].get(j);
                    k++;
                }
            }
            answer = LCS(nodes,result,n*m);
            if(answer<min)
                min=answer;
        }
        System.out.println(min/2);
    }
}