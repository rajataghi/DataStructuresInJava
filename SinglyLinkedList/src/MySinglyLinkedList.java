public class MySinglyLinkedList {
    public static void main(String[] args){

        MyList s = new MyList();
        System.out.println(s.isEmpty());
        s.push_front(5);
        s.push_front(7);
        s.push_front(1);
        System.out.println(s.isEmpty());
        System.out.println(s.getSize());
        System.out.println(s.value_at(0));
        //System.out.println("Value popped from front:"+s.pop_front());
        System.out.println(s.getSize());
        System.out.println(s.value_at(0));
        s.insert(2,10);
        s.printList();
        System.out.println(s.back());
        System.out.println(s.front());
        s.erase(1);
        //s.printList();
        //s.erase(0);
        //s.erase(0);
        //s.erase(0);
        s.printList();
        System.out.println(s.value_n_from_end(0));
        //s.reverse();
        s.printList();
        s.remove_value(11);
        s.printList();
    }
}
