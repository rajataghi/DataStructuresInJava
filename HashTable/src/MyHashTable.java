public class MyHashTable {

    public static void main(String[] args){

        HashTable ht = new HashTable(5);
        ht.add("5","10");
        ht.getHashedValues();
        ht.add("10","11");
        ht.getHashedValues();
        ht.add("7","12");
        ht.add("8","13");
        ht.add("9","14");
        //ht.add("5","15");
        ht.remove("9");
        System.out.println(ht.get("11"));
        ht.getHashedValues();
    }

}
