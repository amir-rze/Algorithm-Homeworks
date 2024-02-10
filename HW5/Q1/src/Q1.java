import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        long mod = 1000000007;
        long[][]dp = new long[n+1][k+1];
        for (int i = 0; i < n+1 ; i++) {
            for (int j = 0; j <Math.min(i,k)+1 ; j++) {
                if(j==0 || j==i)
                    dp[i][j] = 1;
                else
                    dp[i][j]=((dp[i-1][j-1]%mod) + (dp[i-1][j]%mod))%mod;
            }
        }

        System.out.println(dp[n][k]);
    }
}
