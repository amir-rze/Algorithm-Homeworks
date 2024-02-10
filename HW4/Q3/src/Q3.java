import java.util.Scanner;

public class Q3 {
    private static long maxSum(long[][] dp, long[][] sum, int[] array, int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (i == j) {
            dp[i][j] = 0;
            return dp[i][j];
        } else if (j - i == 1) {
            dp[i][j] = array[i] + array[j];
            return array[i] + array[j];
        }
        long min = Long.MAX_VALUE;
        for (int k = i; k < j; k++) {
            if ((maxSum(dp, sum, array, i, k) + maxSum(dp, sum, array, k + 1, j) + sum(sum, array, i, j)) < min) {
                min = maxSum(dp, sum, array, i, k) + maxSum(dp, sum, array, k + 1, j) + sum(sum, array, i, j);
            }
        }
        dp[i][j] = min;
        return min;
    }

    private static long sum(long[][] sum, int[] arr, int i, int j) {
        if (sum[i][j] != 0) {
            return sum[i][j];
        } else if (i == j) {
            sum[i][j] = arr[i];
        } else {
            sum[i][j] = arr[i] + sum(sum, arr, i + 1, j);
        }
        return sum[i][j];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] array = new int[k];
        for (int i = 0; i < k; i++) {
            array[i] = input.nextInt();
        }
        long[][] sum = new long[k][k];
        long[][] dp = new long[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j] = 0;
                sum[i][j] = 0;
            }
        }
        System.out.println(maxSum(dp, sum, array, 0, k - 1));
    }
}