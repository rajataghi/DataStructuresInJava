public class MyQueue {

    private QueueNode head;
    private QueueNode tail;
    private int size;


    class QueueNode{
        private int item;
        private QueueNode next;

        public QueueNode(int item, QueueNode next){
            this.item = item;
            this.next = next;
        }

    }

    public MyQueue(){
        head=null;
        tail=null;
        size=0;
    }

    public void enqueue(int value){
        QueueNode newNode = new QueueNode(value,null);
        if(this.head==null){
            this.tail=newNode;
            this.head=newNode;
            return;
        }
        this.tail.next = newNode;
        this.tail = newNode;
        size++;
    }

    public int dequeue(){
        if(head==null) {
            throw new NullPointerException();
        }
        int val = head.item;
        head = head.next;
        size--;
    return val;
    }

    public boolean isEmpty(){
        if(size==0)
            return true;
        else
            return false;
    }

    public void printQueue(){
        System.out.println();
        QueueNode current = head;
        if(current==null){
            System.out.println("Queue is empty.");
            return;
        }
        while(current!=null){
            System.out.print(" " + current.item);
            current = current.next;
        }
        System.out.println();
    }
}
