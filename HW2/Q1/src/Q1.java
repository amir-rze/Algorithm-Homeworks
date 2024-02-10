import java.util.Scanner;

public class Q1 {
    static Long gcd(Long a, Long b)
    {
        Long temp;
        while(b != 0)
        {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Long [] array ;
        Long maxGcd;
        Long currentGcd ;
        int n = input.nextInt();
        for (int i = 0; i <n ; i++) {
            maxGcd = Long.MIN_VALUE;
            int m = input.nextInt();
            array = new Long[m];
            for (int j = 0; j <m ; j++) {
                array[j] = input.nextLong ();
            }
            if (m<2) {
                System.out.println("-1");
                continue;
            }
            else {
                for (int j = 0; j < array.length-1; j++) {
                    for (int k = j + 1; k <array.length; k++) {
                        currentGcd =  gcd(array[j],array[k]);
                        if (maxGcd < currentGcd){
                            maxGcd = currentGcd;
                        }
                    }
                }
            }
            System.out.println(maxGcd);
        }
    }
}
