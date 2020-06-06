public class MyBinaryTree {

    public static void main(String[] args){

        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        System.out.println(tree.getNodeCount());
        System.out.println(tree.insert(20));
        System.out.println(tree.insert(11));
        System.out.println(tree.insert(21));
        System.out.println(tree.insert(10));
        System.out.println(tree.insert(16));
        System.out.println(tree.insert(15));
        System.out.println(tree.insert(28));
        System.out.println(tree.getNodeCount());
        tree.printSortedValues();
        System.out.println();
        System.out.println(tree.isInTree(8));
        //tree.deleteTree();
        System.out.println(tree.getHeight());
        System.out.println(tree.getMin());
        System.out.println(tree.getMax());
        System.out.println(tree.isBinarySearchTree());
        tree.deleteValue(21);
        tree.deleteValue(11);
        tree.printSortedValues();
        System.out.println();
        System.out.println(tree.getSuccessor(26));
        int a = 1999999999;
        int b = 1;
        int c = a+b;
        System.out.println(c);
    }
}
