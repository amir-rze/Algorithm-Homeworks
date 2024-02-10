import java.util.Scanner;

public class Q5 {
    public static int pow(int x, int y) {
        return (int) Math.pow(x, y);
    }

    public static int notZeros(int number) {
        return Integer.bitCount(number);
    }

    public static long bitmasking(long[][] dp, long[][] matrix, int n, int m, int currentIndex, int nextIndex) {
        int or_current;
        if (notZeros(currentIndex) == n) {
            dp[currentIndex][nextIndex] = 0;
            return 0;
        }
        int power;
        long greedyChosen;
        long sumOfValues = 0;
        if (dp[currentIndex][nextIndex] != -1)
            return dp[currentIndex][nextIndex];

        for (int i = 0; i < m; i++) {
            int counter = 0;
            greedyChosen = 0;
            power = pow(2, i);
            or_current = currentIndex | power;
            if (or_current != currentIndex) {
                if (currentIndex == 0) {
                    greedyChosen = bitmasking(dp, matrix, n, m, or_current, i);
                } else {
                    greedyChosen = bitmasking(dp, matrix, n, m, or_current, i) + matrix[nextIndex][i];
                }
                if (greedyChosen > dp[currentIndex][nextIndex]) {
                    dp[currentIndex][nextIndex] = greedyChosen;
                }
            }
        }
        return dp[currentIndex][nextIndex];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        long [][] matrix = new long[m][m];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
        long[][] dp = new long[65537][m];
        for (int i = 0; i < 65537; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(bitmasking(dp, matrix, n, m, 0, 0));
    }
}
