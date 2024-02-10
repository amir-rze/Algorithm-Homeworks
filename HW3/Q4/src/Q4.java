import java.util.Scanner;

public class Q4 {
    public static int find(int[] set, int x) {
        if (set[x] == x)
            return x;
        else
            return find(set, set[x]);
    }

    public static void merge(int[] set, int[] h, int[] sumN, int x, int y) {
        if (h[x] > h[y]) {
            set[y] = x;
            sumN[x] += sumN[y];

        } else if (h[y] > h[x]) {
            set[x] = y;
            sumN[y] += sumN[x];
        } else {
            set[x] = y;
            h[y]++;
            sumN[y] += sumN[x];
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] set = new int[n];
        int[] h = new int[n];
        int[] sumN = new int[n];
        for (int i = 0; i < n; i++) {
            set[i] = i;
            h[i] = 0;
            sumN[i] = 1;
        }
        for (int i = 0; i < m; i++) {
            int operand = input.nextInt();
            if (operand == 1) {
                int x = input.nextInt() - 1;
                int y = input.nextInt() - 1;
                if (find(set, x) != find(set, y))
                    merge(set, h, sumN, find(set, x), find(set, y));
            }
            if (operand == 2) {
                int z = input.nextInt() - 1;
                System.out.println(sumN[find(set, z)] - 1);
            }
        }
    }
}

