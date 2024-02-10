import java.util.Scanner;

public class Q4 {
    static long[] array;
    static long[] tempArray;

    public static long divide(int l , int r){
        long misplacedCount = 0 ;
        int mid = (l+r)/2;
        if(l < r){
            misplacedCount += divide(l , mid);
            misplacedCount += divide(mid + 1 , r);
            misplacedCount += merge(l ,mid+1,r);
        }
        return misplacedCount ;
    }

    public static long merge(int l , int mid , int r){

        int leftIndex = l;
        int rightIndex=mid;
        int mergedIndex = l;
        long misplacedCount=0;
        int counter = 0;
        while ((leftIndex <= mid - 1) && (rightIndex <= r))
        {
            if (array[leftIndex] > array[rightIndex]) {
                tempArray[mergedIndex] = array[rightIndex];
                mergedIndex++;
                rightIndex++;
                misplacedCount+= (mid - leftIndex);

            }
            else
            {
                tempArray[mergedIndex] = array[leftIndex];
                mergedIndex++;
                leftIndex++;
            }
        }
        while (leftIndex <= mid - 1)
            tempArray[mergedIndex++] = array[leftIndex++];
        while (rightIndex <= r)
            tempArray[mergedIndex++] = array[rightIndex++];
        for (leftIndex=l; leftIndex <= r; leftIndex++)
            array[leftIndex] = tempArray[leftIndex];

        return misplacedCount;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        int n = input.nextInt();
        array =new long[n];
        tempArray = new long[n];
        int counter = 0;
        for (int leftIndex = 0; leftIndex < n ; leftIndex++) {
            array[leftIndex] = input.nextLong();
        }
        System.out.println(divide( 0, n - 1));
    }
}
