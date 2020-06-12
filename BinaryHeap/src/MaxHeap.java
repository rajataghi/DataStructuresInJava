import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeap {

    public static void main(String[] args){

        BinaryHeap<Integer> numbers = new BinaryHeap<Integer>();
        System.out.println(numbers.getSize());
        System.out.println(numbers.isEmpty());
        //numbers.extractMax();
        numbers.insert(10);
        System.out.println(numbers.isEmpty());
        numbers.insert(19);
        numbers.insert(8);
        numbers.insert(7);
        numbers.insert(11);
        numbers.insert(21);
        numbers.insert(20);
       // System.out.println(numbers.getSize());
        numbers.printHeap();
        System.out.println(numbers.getMax());
        numbers.extractMax();
       // numbers.extractMax();
       // numbers.extractMax();
        //numbers.extractMax();
        numbers.printHeap();
        //numbers.extractMax();
//        numbers.remove(6);
  //      numbers.remove(3);
        numbers.printHeap();
        ArrayList<Integer> unsorted = new ArrayList<>();
        unsorted.add(5);
        unsorted.add(2);
        unsorted.add(11);
        unsorted.add(15);
        unsorted.add(10);
        unsorted.add(1);
        BinaryHeap<Integer> sortedHeap = new BinaryHeap<Integer>(unsorted);
        //sortedHeap.printHeap();

        while(!sortedHeap.isEmpty())
            System.out.println(sortedHeap.extractMax());
    int[] a = {2,7,4,1,8,1};
    System.out.println();
    System.out.println(lastStoneWeight(a));
    }

    public static int lastStoneWeight(int[] stones){
       // Arrays.sort(stones,Collections.reverseOrder());
    if(stones.length==0)
            return 0;
        if(stones.length==1)
            return stones[0];
        PriorityQueue<Integer> stoneQ = new PriorityQueue<>(Collections.reverseOrder());
        //Math.abs();
        for(int ele : stones)
            stoneQ.add(ele);

        while (stoneQ.size()>1){
            int x = stoneQ.poll();
            int y = stoneQ.poll();
            if(x==y)
                continue;
            else
                stoneQ.add(x-y);
        }

        return stoneQ.peek();
    }

}
