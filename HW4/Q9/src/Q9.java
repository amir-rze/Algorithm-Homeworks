import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

class Node implements Comparable<Node>{
    double l;
    double r;
    public Node(double l , double r){
        this.l=l;
        this.r=r;
    }
    @Override
    public int compareTo(Node node){
        return r-node.r>0?1:-1;
    }

}
public class Q9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayList<Node> array = new ArrayList<>();
        int d = input.nextInt();
        Node node;
        for (int i = 0; i <n ; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            double pos = Math.sqrt(Math.pow(d,2)-Math.pow(y,2));
            double l = x-pos;
            double r = x+pos;
            array.add(new Node(l,r));
            if(y>d){
                System.out.println(-1);
                return;
            }
        }
        Collections.sort(array);
        int counter=1;
        int pre=0;
        for (int i = 1; i <array.size() ; i++) {
            if(array.get(i).l>array.get(pre).r){
                counter++;
                pre=i;
            }
        }
        System.out.println(counter);

    }
}
