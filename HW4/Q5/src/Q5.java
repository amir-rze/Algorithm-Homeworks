import java.util.Scanner;

public class Q5 {
    public static int binay_search(int[] array , int l ,int r , int target){
        if(r<l)
            return -1;
        if(r==l)
            return r;
        int mid = (r+l)/2;
        if(array[mid]<target&&array[mid+1]>target)
            return mid+1;
        else if(array[mid]<target)
            return binay_search(array,mid+1,r,target);
        else
            return binay_search(array,l,mid,target);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int [] array = new int[n];
        int [] deploy = new int[n];
        int [] indexes = new int[n];
        for (int i = 0; i < n ; i++) {
            array[i] = input.nextInt();
        }
        deploy[0] = array[0];
        indexes[0] = 0;
        int lastIndex = 0;
        int maxIndex = 0;
        if(n<2){
            System.out.println("0");
            return;
        }
        if(n==2&& array[0]!=1){
            System.out.println(2);
            return;
        }
        for (int i = 1; i < n ; i++) {
            if(array[i]==1)
                continue;
            if(array[i]<deploy[0]){
                deploy[0]=array[i];
                indexes[i]=0;
            }
            else if(array[i]>deploy[lastIndex]){
                deploy[++lastIndex]=array[i];
                indexes[i]=lastIndex;
                maxIndex=i;
            }
            else{
                int k = binay_search(deploy,0,lastIndex,array[i]);
                deploy[k] = array[i];
                indexes[i]=k;
            }
        }
//        System.out.println(lastIndex);
        lastIndex++;
        if(deploy[0]==array[0]) {
            lastIndex--;
//            System.out.println("yes");
        }
//        for (int i = 0; i <n ; i++) {
//            System.out.print(deploy[i]);
//            System.out.print(" ");
//        }
//        System.out.println("");
        System.out.println((n * 2-2) - lastIndex);
    }
}
