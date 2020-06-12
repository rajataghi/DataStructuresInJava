import java.util.ArrayList;

public class BinaryHeap<E extends Comparable> {
    ArrayList<E> heap;

    public BinaryHeap(){
        heap = new ArrayList<E>();
        heap.add(null); //adding null so that the parent child arithmetic works fine. Another way?
    }

    public BinaryHeap(ArrayList<E> arr){
        heap = new ArrayList<>();
        heap.add(null);
        for(E ele : arr)
            insert(ele);
    }

    private void siftUp(E item){
        int i  = heap.indexOf(item);
        while(i>1 &&(heap.get(i).compareTo(heap.get(i/2)))>0){ //i cannot equal 1 bec. if i is 1, we are already at root.
            //E temp = heap.get(i);
            heap.set(i,heap.get(i/2));
            heap.set(i/2,item);
            i /= 2;
        }
    }

    public void insert(E item){
        if(this.heap.size()==1) {
            heap.add(item);
            return;
        }
        heap.add(item);
        siftUp(item);
    }

    public E getMax(){
        return heap.get(1);
    }

    public int getSize(){
        if(heap.size()==0)
            return 0;
        return heap.size()-1;
    }

    public boolean isEmpty(){
        if(heap.size()==1)
            return true;
        else
            return false;
    }

    private void siftDown(E item){

        int maxIndex = heap.indexOf(item);
        if(maxIndex==heap.size()-1)
            return;
        //First, we determine which child is bigger.
        int leftIndex = 2*heap.indexOf(item);
        int rightIndex = 2*heap.indexOf(item)+1;

        if(leftIndex<=heap.size()-1 && (heap.get(leftIndex).compareTo(heap.get(maxIndex)))>0)
            maxIndex = leftIndex;

        if(rightIndex<=heap.size()-1 && (heap.get(rightIndex).compareTo(heap.get(maxIndex)))>0)
            maxIndex = rightIndex;

        if(maxIndex!=heap.indexOf(item)){
            heap.set(heap.indexOf(item),heap.get(maxIndex));
            heap.set(maxIndex, item);
            siftDown(heap.get(maxIndex));//try using siftDown(item)
        }
    }

    public E extractMax(){
        if(heap.size()==1)
            throw new NullPointerException("Cannot delete from empty heap.");

        E value = heap.get(1);
        if(heap.size()==2){
            heap.remove(1);
            return value;
       }

        E lastLeaf = heap.get(heap.size()-1);
        heap.set(1,lastLeaf);
        heap.remove(heap.size()-1);
        siftDown(lastLeaf);
        return value;
    }

    public E remove(int index){

        if(index<1 || index>heap.size()-1)
            throw new IndexOutOfBoundsException();

        E value = heap.get(index);

        if(index==heap.size()-1){
            heap.remove(index);
            return value;
        }

        E lastLeaf = heap.get(heap.size()-1);
        heap.set(index,lastLeaf);
        heap.remove(heap.size()-1);
        siftDown(lastLeaf);
        return value;
    }


    public void printHeap(){
        System.out.println();
        for(int i = 1; i<heap.size();i++){
            System.out.print(heap.get(i)+ " ");
        }
        System.out.println();
    }

    public void heapify(ArrayList<E> arr){
        for(int i =(arr.size()-1)/2;i>=1;i--){
            siftDown(heap.get(i));
       }

    }

    public void heapSort(ArrayList<E> arr){
        arr.add(0,null);
        BinaryHeap<E> sorter = new BinaryHeap<>(arr);
        //add sort logic here
        sorter.printHeap();

        int size = sorter.getSize();
        while(size>1){
            System.out.println(sorter.extractMax());
        }
        //System.out.println(sorter.getSize());


    }

}
