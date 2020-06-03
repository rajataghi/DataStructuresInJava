public class QueueByLinkedList {
    public static void main(String[] args){

        MyQueue q = new MyQueue();
        System.out.println(q.isEmpty());
        //q.dequeue();
        q.enqueue(5);
        q.enqueue(10);
        q.printQueue();
        q.dequeue();
        //q.dequeue();
        q.enqueue(11);
        q.printQueue();
    }

}
