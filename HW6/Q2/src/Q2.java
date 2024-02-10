import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Q2 {
    private static int[][] graph;
    private static int[] array;
    private static int max = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int x, y;
        array = new int[n + 1];
        graph = new int[n + 1][n + 1];
        int counter = 0;
        for (int i = 0; i < m; i++) {
            x = input.nextInt();
            y = input.nextInt();
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        System.out.println(backTrack(array, 0, n, max));
    }

    private static int backTrack(int[] array, int idx, int n, int min) {
        if (!promising(array, idx)) {
            return max;
        }
        if (idx == n) {
            return maxOfArray();
        }
        int m = max;
        for (int i = 1; i < Math.min(m, min); i++) {
            array[idx + 1] = i;
            m = Math.min(m, backTrack(array, idx + 1, n, m));
        }
        return m;
    }

    private static int maxOfArray() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <array.length ; i++) {
            if(array[i]>max)
                max=array[i];
        }
        return max;
    }

    private static boolean promising(int[] array, int idx) {
        for (int i = 1; i < idx; i++) {
            if (graph[i][idx] == 1 && array[i] == array[idx]) {
                return false;
            }
        }
        return true;
    }
}
