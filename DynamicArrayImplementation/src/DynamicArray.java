public class DynamicArray  {

    public int length;
    private int capacity;
    private int[] a;

    public DynamicArray(int capacity){
        this.capacity = capacity;
        a = new int[this.capacity];
        length = -1;
    }

    public int size(){
        return this.length+1;
    }

    public int capacity(){
        return this.capacity;
    }

    public boolean isEmpty(){
        if(this.length ==-1)
            return true;
        else
            return false;
    }

    public int atIndex(int i){
        if(i<0 || i>capacity-1){
            throw new IndexOutOfBoundsException("Index greater than capacity of the array.");
        }
        return a[i];
    }

    public void push(int item){
        if(length==capacity-1){
            resize(this.capacity*2);
            //System.out.println("Push failed. Array is full"); //replace this with call to resize later.
        }
        a[length+1]=item;
        length++;
    }

    public void insert(int index, int item){
        if(index<0 || index>length+1)
            throw new IndexOutOfBoundsException("Index not within capacity of the array");
        else {
            if(length==capacity-1)
                resize(this.capacity*2);
            for (int j = length; j >= index; j--) {
                a[j + 1] = a[j];
            }
            a[index]=item;
            length++;
        }
    }

    public void prepend(int item){
        insert(0,item);
    }

    public void pop(){
        if(length==-1){
            System.out.println("Cannot pop empty array.");
            throw new IndexOutOfBoundsException();
        }
        else{
            a[length]=0;
            length--;
        }
    }

    public void delete(int index){
        if(index<0 || index>length){
            throw new IndexOutOfBoundsException();
        }
        else{
            for(int j=index; j<=length;j++){
                a[j]=a[j+1];
            }
         length--;
        }
    }

    public void remove(int item){
        if(length==-1){
            throw new IndexOutOfBoundsException();
        }
        for(int i = 0; i<=length;i++){
            if(a[i]==item){
                delete(i);
                i--;
            }
        }
    }

    public int find(int item){
        if(length==-1){
            throw new IndexOutOfBoundsException("Cannot search in empty array.");
        }
        else{
            for(int i = 0; i<=length;i++){
                if(a[i]==item)
                    return i;
            }
            return -1;
        }
    }




    private void resize(int newCapacity){
        int[] b = new int[newCapacity];
        for (int i = 0;i<this.capacity;i++){
            b[i]=a[i];
        }
        this.a = b;
        this.capacity = newCapacity;
    }

    public void printda(){
        System.out.println();
        for(int i = 0; i<=length;i++){
            System.out.print(" " + this.a[i]);
        }
    }


}
