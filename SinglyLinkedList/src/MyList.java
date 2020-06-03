public class MyList {

    private ListNode head;
    private int size;
    public class ListNode {

        private int item;
        private ListNode next;

        public ListNode(int item, ListNode next){
            this.item = item;
            this.next = next;
        }

    }

    public MyList(){
        this.head = null;
        this.size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        if(size==0)
            return true;
        else
            return false;
    }

    public void push_front(int item){
         this.head = new ListNode(item,this.head);
         size++;

    }

    public int value_at(int index){
        if(index<0 || index>size-1)
            return -1;
        ListNode traverser = head;
        int i = 0;
        while(i!=index){
            traverser = traverser.next;
            i++;
        }
        return  traverser.item;
    }

    public int pop_front(){
        if(head==null)
            throw new IndexOutOfBoundsException();
        int val = this.head.item;
        this.head = this.head.next;
        size--;
        return val;
    }

    public void push_back(int value){
        if(size==0)
            push_front(value);
        //user insert after implementing it
    }

    public int front(){
        return value_at(0);
    }

    public int back(){
        return value_at(size-1);
    }

    public void insert(int index, int value) {
        if (index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException();
        if (index == 0)
            push_front(value);
        else {
            ListNode traverser = head;
            int i = 0;
            while (i != index - 1) {
                traverser = traverser.next;
                i++;
            }
            traverser.next = new ListNode(value, traverser.next);
            size++;
        }
    }

    public void erase(int index){
        if(index<0 || index>size-1)
            throw new IndexOutOfBoundsException();
        if(size==0)
            System.out.println("Cannot delete from empty list.");
        else if(index==0)
            pop_front();
        else{
            int i = 0;
            ListNode current = head;
            ListNode prev = null;
            while(i!=index){
                prev = current;
                current = current.next;
                i++;
            }
            prev.next = current.next;
            size--;
        }
    }

    public int value_n_from_end(int n){
        if(size==0) {
            System.out.println("List is empty.");
            return -1;
        }
        if(n<0 || n>size-1)
            throw new IndexOutOfBoundsException();
        return value_at(size-1-n);
    }

    public void reverse(){
        if(size==0)
            System.out.println("List is empty.");
        else{

            ListNode current = head;
            ListNode prev = null;
            ListNode next = null;
            int i = size-1;
            while(current!=null){
                next = current.next;
                current.next =  prev;
                prev = current;
                current = next;
            }
            head = prev;
        }
    }

    public void remove_value(int value) {
        if (size == 0)
            System.out.println("Cannot delete from empty list.");
        else {
            ListNode current = head;
            int index = 0;
            while (current != null) {
                if (current.item == value) {
                    erase(index);
                    break;
                }
                current = current.next;
                index++;
            }
            if (current == null)
                System.out.println("No item with this value found in list");

        }
    }


    public void printList(){
        ListNode current = head;
        System.out.println();
        while(current!=null){
            System.out.print(" " + current.item);
            current = current.next;
        }
        System.out.println();
    }


}
