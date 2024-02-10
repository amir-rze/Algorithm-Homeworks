import java.util.*;

class Node {
    int value;
    int groupId;
    int index;

    public Node(int value, int groupId,int index) {
        this.value = value;
        this.groupId = groupId;
        this.index=index;
    }
}

public class Q5 {

    public static int binay_search(int[] array, int l, int r, int target) {
        if (r < l)
            return -1;
        if (r == l)
            return r;
        int mid = (r + l) / 2;
        if (array[mid] < target && array[mid + 1] > target)
            return mid + 1;
        else if (array[mid] < target)
            return binay_search(array, mid + 1, r, target);
        else
            return binay_search(array, l, mid, target);
    }

    public static int LIS(Node[] array, int n) {
        int[] deploy = new int[n];
        int[] indexes = new int[n];
        deploy[0] = array[0].value;
        indexes[0] = 0;
        int lastIndex = 0;
        for (int i = 1; i < n; i++) {
            if (array[i].value < deploy[0]) {
                deploy[0] = array[i].value;
                indexes[i] = 0;
            } else if (array[i].value > deploy[lastIndex]) {
                deploy[++lastIndex] = array[i].value;
                indexes[i] = lastIndex;
            } else {
                int k = binay_search(deploy, 0, lastIndex, array[i].value);
                deploy[k] = array[i].value;
                indexes[i] = k;
            }
        }
        return lastIndex + 1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
//        ArrayList<Node> nodes = new ArrayList<>();
        Node[] nodes = new Node[n * m];
        Set<Integer> set = new HashSet<>();
        ArrayList<Node>[] matrix = new ArrayList[n];
        int [] groups = new int [n];
        for (int i = 0; i < n; i++) {
            matrix[i] = new ArrayList<>();
            groups[i] = i+1;
        }
        for (int i = 0; i < n * m; i++) {
            int groupId = input.nextInt();
            int value = input.nextInt();
            Node node = new Node(value, groupId,i);
            nodes[i] = node;
            matrix[groupId - 1].add(node);
        }
        int size = n * m;
        int result = 0;
        int counter = 0;
        int index = -1;
        int groupId;
        int start = 0;
        int last=-1;
        int max = Integer.MIN_VALUE;
        int lastGroupId = 0;
        Node [] array;
        if(n==1){
            System.out.println((m - LIS(nodes, m)));
            return;
        }
        for (int i = 1; i < n + 1; i++) {
//            max = Integer.MIN_VALUE;
//            counter = 0;
//            lastGroupId = 0;
//            for (int j = 0; j < size; j++) {
//                if(lastGroupId==0 && set.contains(nodes[j].groupId))
//                    continue;
//                if (nodes[j].groupId == -1)
//                    continue;
//                if (lastGroupId == 0) {
//                    lastGroupId = nodes[j].groupId;
//                    start = j;
//                    counter++;
//                    continue;
//                }
//                if (nodes[j].groupId == lastGroupId) {
//                    counter++;
//                } else {
//                    if (counter > max) {
//                        max = counter;
//                        index = start;
//                        last=j;
//                    }
//                    start = j;
//                    counter = 1;
//                    lastGroupId = nodes[j].groupId;
//                }
//            }
//            if (counter > max) {
//                max = counter;
//                index = start;
//                last= size;
//            }

//            groupId = nodes[index].groupId;
//            set.add(groupId);
//            int number =0;
//            for (int j = index; j < last; j++) {
//                if(nodes[j].groupId!= -1){
//                    number++;
//                }
//            }
//            array=new Node[number];
            array=new Node[m];
//            int k =0;
//            for (int j = index; j <last ; j++) {
//                if(nodes[j].groupId!=-1){
//                    array[k++] = nodes[j];
//                }
//            }
            for (int j = 0; j <m ; j++) {
                array[j]=matrix[i-1].get(j);
            }
            int ans=LIS(array,m);
            System.out.println(ans);
//            System.out.println(LIS(array, number));
            if(ans>max){
                max=ans;
                System.out.println("ok");
                result=matrix[i-1].get(m-1).index-matrix[i-1].get(m-1).index;
            }
//            result += (m - LIS(array, m));
//            for (int j = 0; j < size; j++) {
//                if (j >= index && j < last)
//                    continue;
//                if (nodes[j].groupId == groupId) {
//                    nodes[j].groupId = -1;
//                    nodes[j].value = -1;
//                }
//            }
        }
        System.out.println(result);
    }
}