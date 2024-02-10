import java.util.Scanner;

public class Q7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int sum=0;
        double [] possibility = new double[n+1];
        int [] numberOfCandidates = new int[n+1];
        for (int i = 0; i <n ; i++) {
            possibility[i]=input.nextDouble();
            numberOfCandidates[i]=input.nextInt();
            sum=sum+numberOfCandidates[i];
        }
//        System.out.println(sum);
        double [][] dp = new double[n+1][sum+1];
        for (int i = 0; i <sum+1 ; i++) {
            dp[0][i]=0;
        }
        dp[0][0]=1;
        for (int i = 1; i < n+1 ; i++) {
                dp[i][0] = dp[i-1][0] * (1-possibility[i-1]);
        }
        for (int i = 1; i <n+1 ; i++) {
            for (int j = 1; j <sum+1 ; j++) {
                if(j<numberOfCandidates[i-1])
                    dp[i][j] = (1-possibility[i-1]) * dp[i-1][j];
                else
                    dp[i][j]=((1-possibility[i-1]) * dp[i-1][j]) + (possibility[i-1] *dp[i-1][j-numberOfCandidates[i-1]]);
            }
        }
        int index = sum/2+1;
        double result=0 ;
        for (int i = index; i <sum+1 ; i++) {
            result = result + dp[n][i];
        }
        String ans = String.format("%.4f",result);
        System.out.println(ans);

//        System.out.println("");
//        for (int i = 0; i <n+1 ; i++) {
//            for (int j = 0; j <sum+1 ; j++) {
//                System.out.print(dp[i][j]);
//                System.out.print(" ");
//            }
//            System.out.println("");
//        }
    }
}
