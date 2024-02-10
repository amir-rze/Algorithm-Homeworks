import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] array = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
            sum += array[i];
        }
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i < sum + 1; i++) {
            dp[0][i] = false;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (array[i - 1] <= j)
                    dp[i][j] = dp[i][j] | dp[i - 1][j - array[i - 1]];
            }
        }
        for (int i = sum / 2; i > -1; i--) {
            if (dp[n][i]) {
                System.out.println(sum - 2 * i);
                break;
            }
        }
    }
}
