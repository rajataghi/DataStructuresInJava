import java.util.ArrayList;

public class CheckArray {
    public static void main(String[] args){

        DynamicArray da = new DynamicArray(5);
        DynamicArray da2 = new DynamicArray(5);
        System.out.println(da.capacity());
        System.out.println(da.size());
        System.out.println(da.isEmpty());
        da.push(10);
        da.push(20);
        da.push(30);
        da.push(40);
        da.push(50);
        System.out.println(da.isEmpty());
        System.out.println(da.size());
        System.out.println(da.capacity());
        da.push(60);
        da.push(80);
        System.out.println(da.size());
        da.insert(7,25);
        da.insert(8,25);
        da.printda();
        da.pop();
        da.printda();
        da.delete(0);
        da.prepend(10);
        da.printda();
        da.remove(10);
        da.printda();
        System.out.println();
        System.out.println(da.find(5));
        //System.out.println(da.capacity());

    }
}
