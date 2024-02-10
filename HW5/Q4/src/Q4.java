import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] array = new int[n + 1];
        int[] lineCount = new int[n + 1];
        long counter = 0L;
        for (int i = 1; i <= n; i++)
            array[i] = input.nextInt();
        for (int i = 1; i <= n; i++)
            lineCount[i] = Math.max(array[i] + 1, lineCount[i - 1]);
        for (int i = n - 1; i >= 0; i--)
            lineCount[i] = Math.max(lineCount[i + 1] - 1, lineCount[i]);
        for (int i = 1; i <= n; i++)
            counter += (lineCount[i] - array[i] - 1);
        System.out.println(counter);
    }
}