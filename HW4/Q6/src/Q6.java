
import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String code = input.next();
        String decode = input.next();
//        int max;
//        if(code.length()>decode.length())
//            max=code.length();
//        else
//            max=decode.length();
        int[][] matrix = new int[code.length()+1][decode.length()+1];
        for (int i = 0; i <decode.length() ; i++) {
            matrix[0][i]=i;
        }
        for (int i = 0; i <code.length() ; i++) {
            matrix[i][0]=i;
        }
        for (int i = 1; i <code.length()+1 ; i++) {
            for (int j = 1; j <decode.length()+1 ; j++) {
                if(code.charAt(i-1)==decode.charAt(j-1))
                    matrix[i][j] = matrix[i-1][j-1];
                else {
                    if(matrix[i-1][j] < matrix[i][j-1])
                        matrix[i][j]=Math.min(matrix[i-1][j],matrix[i-1][j-1])+1;
                    else
                        matrix[i][j]=Math.min(matrix[i][j-1],matrix[i-1][j-1])+1;
                }
            }
        }
        System.out.println(matrix[code.length()][decode.length()]);
    }
}



