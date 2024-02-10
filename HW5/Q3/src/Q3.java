import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] benefits =new int[n];
        long [] sum = new long[n];
        long [] dp = new long[n];
        boolean hasNegative = false;
        for (int i = 0; i <n ; i++) {
            int value=input.nextInt();
            benefits[i]=value;
            if(value<0)
                hasNegative=true;
            if(i==0){
                sum[i]=value;
                dp[i]=value;
            }
            else
                sum[i]=value+sum[i-1];
        }
        long result = Long.MIN_VALUE;
        long max = sum[0];
        long min = sum[0];
        long sub = 0;
        if(hasNegative) {
            for (int i = 1; i < n; i++) {
                sub = sum[i] - min;
                if (sub > max)
                    max = sub;
                if (sum[i] < min)
                    min = sum[i];
            }
            System.out.println(max);
        }
        else
            System.out.println(sum[n - 1]);
    }
}
