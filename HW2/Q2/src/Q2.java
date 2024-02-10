import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList <Integer> values = new ArrayList<>();
        String command ;
        String[] arr ;
        int value ;
        int n = input.nextInt();
        command = input.nextLine();
        for (int i = 0; i < n ; i++) {
            command = input.nextLine();
            arr = command.split("\\s+");

            if(arr[0].equals("Add")){
                value = Integer.parseInt(arr[2]);
                values.add(value);
            }
            else if(command.equals("Execute Best Process")){
                Collections.sort(values);
                System.out.println(values.get(0));
                values.remove(0);
            }

        }

    }
}
