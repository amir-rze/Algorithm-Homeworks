import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int counter=0;
        int[] xPosition = new int[k];
        int[] yPosition = new int[k];
        System.out.println(backTrack(xPosition, yPosition, -1, n));
    }
    
    private static int backTrack(int[] xPosition, int[] yPosition, int index, int n){
        int counter = 0;
        int start;
        if (!isPromise(xPosition, yPosition, index)){
            return 0;
        }
        if (index == xPosition.length -1 ){
            return 1;
        }
        if (index < 0){
            start = 0;
        }
        else {
            start = xPosition[index];
        }
        for (int i = start; i < n; i++) {
            for (int j = 0; j < n; j++) {
                xPosition[index + 1] = i;
                yPosition[index + 1] = j;
                counter += backTrack(xPosition, yPosition, index + 1, n);
            }
        }
        return counter;
    }

    private static boolean isPromise(int[] xPosition, int[] yPosition, int index){
        boolean result = true;
        for (int i = 0; i < index; i++) {
            int xDiffrence = Math.abs(xPosition[i] - xPosition[index]);
            int yDiffrence = Math.abs(yPosition[i] - yPosition[index]);
            if (yDiffrence == 1 && xDiffrence == 2){
                result = false;
            }
            else if (yDiffrence == 2 && xDiffrence == 1){
                result = false;
            }
            else if (yDiffrence == 0 && xDiffrence == 0){
                result = false;
            }
            else if (xDiffrence == 0 && yPosition[index] < yPosition[i]){
                result = false;
            }
            if(!result)
                return false;
        }
        return true;
    }
}
