import java.util.ArrayList;
import java.util.Scanner;

public class Q8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int [] array = new int[n];
        for (int i = 0; i <n ; i++) {
            array[i] = input.nextInt();
        }
        long [] dp = new long[n];
        if(n==0){
            System.out.println("0");
            System.out.println("0");
            return;
        }
        if(n==1){
            System.out.println(array[0]);
            System.out.println("1");
            System.out.println("1");
            return;
        }
        boolean [] isChecked =new boolean[n];
//        int[] index = new int[n];
//        for (int i = 0; i < n; i++) {
//            index[i]=-1;
//        }
        dp[0]=array[0];
        isChecked[0]=true;
        if(array[1]>array[0]) {
            dp[1] = array[1];
            isChecked[1]=true;
        }

        else {
            dp[1] = dp[0];
            isChecked[0]=true;
        }

        if(n==2){
            System.out.println(dp[1]);
            System.out.println("1");
            if(isChecked[1]==true)
                System.out.println("2");
            else
                System.out.println("1");
            return;
        }

            for (int i = 2; i <n ; i++) {
            if(dp[i-2] + array[i] > dp[i-1]) {
                dp[i] = dp[i - 2] + array[i];
                isChecked[i]=true;
            }

            else {
                dp[i] = dp[i - 1];
                isChecked[i]=false;
            }
        }
//        int last;
//        if(isChecked[n-1]==true)
//            last=n-1;
//        else
//            last=n-2;
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = n-1; i >=0 ; i--) {
            if(isChecked[i]==true) {
                numbers.add(i);
                i--;
            }
        }

        System.out.println(dp[n-1]);
        System.out.println(numbers.size());
        for (int i = numbers.size()-1; i >=0 ; i--) {
            System.out.print(numbers.get(i)+1);
            System.out.print(" ");
        }
    }
}