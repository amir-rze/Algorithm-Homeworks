import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {

    int id;
    int submits;
    long penalties;

    public Node(int id) {
        this.id = id;
        penalties = 0;
        submits = 0;
    }

    @Override
    public int compareTo(Node node) {
        if (submits - node.submits < 0)
            return 1;
        else if (submits - node.submits == 0)
            if (penalties - node.penalties > 0)
                return 1;
            else if (penalties - node.penalties == 0)
                if (id - node.id > 0)
                    return 1;
                else
                    return -1;
            else
                return -1;
        return -1;
    }
}

public class Q3 {

    public static int partition(Node arr[], int low, int high) {
        Node pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].submits > pivot.submits) {
                i++;
                Node temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } else if (arr[j].submits == pivot.submits) {
                if (arr[j].penalties < pivot.penalties) {
                    i++;
                    Node temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                } else if (arr[j].penalties == pivot.penalties)
                    if (arr[j].id < pivot.id) {
                        i++;
                        Node temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
            }
        }
        Node temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void sort(Node arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int id, penalties;
        Node[] nodes = new Node[m];
        Node[] temp = new Node[m];
        for (int i = 0; i < m; i++) {
            nodes[i] = new Node(i + 1);
        }
        for (int i = 0; i < m; i++) {
            id = input.nextInt();
            penalties = input.nextInt();
            Node node = nodes[id - 1];
            node.submits++;
            node.penalties += penalties;
            for (int j = 0; j <m ; j++) {
                temp[j]=nodes[j];
            }
            sort(temp, 0, n - 1);
            for (int j = 0; j < m; j++) {
                if (temp[j].id == 1) {
                    System.out.println(j + 1);
                    break;
                }
            }
        }
    }
}
