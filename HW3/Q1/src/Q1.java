import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[10000000];
        int x = 0;
        int y = 0;
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int counter = 0;
        int[] prime = new int[1500000];
        prime[0] = -1;
        prime[1] = -1;
        for (int i = 2; i <= 15000; i++) {
            if (prime[i] == 0) {
                prime[i] = 1;
                for (int j = 2; j <= (15000 / i); j++) {
                    prime[i * j] = -1;
                }
            }
        }
        do {
            x = input.nextInt();
            if (x != 0) {
                numbers[counter] = x;
                counter++;
            }
        }
        while (x != 0);
        for (int i = 2; i <= (int) (Math.sqrt((double) counter)); i++) {
            if (prime[i] == 1 && prime[counter / i] == 1 && (counter / i) * i == counter) {
                x = i;
                y = counter / i;
                break;
            }
        }
        int[][] matrix = new int[x][y];
        int k = 0;
        int[] min = new int[x];
        int[] max = new int[x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = numbers[k];
                if (numbers[k] < minValue) {
                    minValue = numbers[k];
                    min[i] = j;
                }
                if (numbers[k] > maxValue) {
                    maxValue = numbers[k];
                    max[i] = j;
                }
                k++;
            }
            minValue = Integer.MAX_VALUE;
            maxValue = Integer.MIN_VALUE;
        }
        boolean minFlag;
        boolean maxFlag;
        boolean minFlag1;
        boolean maxFlag1;
        int index = 0;
        int[] answer = new int[4 * x];
        counter = 0;
        for (int j = 0; j < x; j++) {
            maxFlag = true;
            minFlag = true;
            maxFlag1 = true;
            minFlag1 = true;
            for (int i = 0; i < x; i++) {
                if (j != i) {
                    if (matrix[j][min[j]] > matrix[i][min[j]]) {
                        minFlag = false;
                    }
                    if (matrix[j][min[j]] < matrix[i][min[j]]) {
                        minFlag1 = false;
                    }
                    if (matrix[j][max[j]] < matrix[i][max[j]]) {
                        maxFlag = false;
                    }
                    if (matrix[j][max[j]] > matrix[i][max[j]]) {
                        maxFlag1 = false;
                    }
                }
            }
            if ((minFlag || minFlag1) == true && (maxFlag || maxFlag1) == true) {
                if (min[j] < max[j]) {
                    answer[index] = j;
                    answer[index + 1] = min[j];
                    answer[index + 2] = j;
                    answer[index + 3] = max[j];
                    index += 4;
                    counter += 2;
                }
                else if (min[j] > max[j]) {
                    answer[index] = j;
                    answer[index + 1] = max[j];
                    answer[index + 2] = j;
                    answer[index + 3] = min[j];
                    index += 4;
                    counter += 2;
                }
            } else if ((minFlag || minFlag1) == true && (maxFlag || maxFlag1) == false) {
                answer[index] = j;
                answer[index + 1] = min[j];
                index += 2;
                counter++;
            } else if ((minFlag || minFlag1) == false && (maxFlag || maxFlag1) == true) {
                answer[index] = j;
                answer[index + 1] = max[j];
                index += 2;
                counter++;
            }
        }
        System.out.println(counter);
        for (int i = 0; i < counter * 2; i += 2) {
            System.out.println((answer[i] + 1) + " " + (answer[i + 1] + 1));
        }
    }
}
