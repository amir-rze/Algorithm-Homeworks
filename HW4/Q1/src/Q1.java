import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }
        int[] indexes = new int[n];
        int[] deploy = new int[n];
        deploy[0] = array[0];
        indexes[0] = 0;
        int lastIndex = 0;
        for (int i = 1; i < n; i++) {
            if (lastIndex == 0) {
                if(deploy[0]< array[i]){
                    deploy[++lastIndex] = array[i];
                }
                else {
                    deploy[0] = array[i];
                    indexes[0] = 0;
                }
            } else {
                if(lastIndex%2==0){
                    if(deploy[lastIndex] < array[i]){
                        deploy[++lastIndex] = array[i];
                    }
                    else {
                        deploy[lastIndex] = array[i];
                    }
                }
                else {
                    if(deploy[lastIndex] > array[i]){
                        deploy[++lastIndex] = array[i];
                    }
                    else {
                        deploy[lastIndex] = array[i];
                    }
                }
            }
        }
        System.out.println(lastIndex + 1);
    }
}
