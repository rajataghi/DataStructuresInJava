import sun.reflect.generics.tree.Tree;

import java.util.Stack;


public class BinaryTree<E extends Comparable> {

    private TreeNode<E> root;

    public BinaryTree(TreeNode<E> root) {
        this.root = root;
    }

    public BinaryTree() {
        this(null);
    }

    public class TreeNode<E> {
        private E value;
        private TreeNode<E> left;
        private TreeNode<E> right;

        public TreeNode(E val, TreeNode<E> parent) {
            this.value = val;
            this.left = null;
            this.right = null;
        }

        public E getValue() {
            return this.value;
        }

        public TreeNode<E> getLeft() {
            return this.left;
        }

        public TreeNode<E> getRight() {
            return this.right;
        }

        public void setLeft(TreeNode<E> left) {
            this.left = left;
        }

        public void setRight(TreeNode<E> right) {
            this.right = right;
        }

    }

    public boolean insert(E toInsert) {
        if (root == null) {
            root = new TreeNode<E>(toInsert, null);
            return true;
        }

        TreeNode<E> curr = root;
        int comp = toInsert.compareTo(curr.getValue());
        while ((comp < 0 && curr.getLeft() != null) || (comp > 0 && curr.getRight() != null)) {
            if (comp < 0) {
                curr = curr.getLeft();
            } else if (comp > 0) {
                curr = curr.getRight();
            }
            comp = toInsert.compareTo(curr.getValue());
        }

        if (comp < 0) {
            TreeNode<E> child = new TreeNode<E>(toInsert, curr);
            curr.setLeft(child);
        } else if (comp > 0) {
            TreeNode<E> child = new TreeNode<E>(toInsert, curr);
            curr.setRight(child);
        } else {
            System.out.println("Value already present in tree");
            return false;
        }

        return true;
    }

    public int getNodeCount() {
        return getNodeCount(this.root);
    }

    public int getNodeCount(TreeNode<E> node) {
        int count = 0;
        if (node != null) {
            count++;
            count += getNodeCount(node.getLeft());
            count += getNodeCount(node.getRight());
        }
        return count;
    }

    public void printSortedValues() { //overloaded function so that BinaryTree object can be used to call this method.
        printSortedValues(this.root);
    }

    public void printSortedValues(TreeNode<E> node) {
        if (node == null)
            return;
        printSortedValues(node.getLeft());
        System.out.print(node.getValue() + " ");
        printSortedValues(node.getRight());
    }

    public void deleteTree() {   //setting root to null should work as GC will collect the child nodes,
        // but we can also use post order traversal to delete nodes individually.
        this.root = null;
    }

    public boolean isInTree(E value) {
        TreeNode<E> curr = this.root;
        int comp = value.compareTo(curr.getValue());
        while (curr != null) {
            if (comp < 0)
                curr = curr.getLeft();
            else if (comp > 0)
                curr = curr.getRight();
            else
                return true;
            if (curr != null)
                comp = value.compareTo(curr.getValue());
        }
        return false;
    }

    public int getHeight() {
        return getHeight(root);
    }


    public int getHeight(TreeNode<E> node) {
        if (node == null)
            return 0;
        int leftheight = getHeight(node.getLeft());
        int rightheight = getHeight(node.getRight());
        return Math.max(leftheight, rightheight) + 1;
    }

    public E getMin() {
        return getMin(root);
    }

    private E getMin(TreeNode<E> node){
        TreeNode<E> curr = node;
        while(curr.getLeft()!=null){
            curr = curr.getLeft();
        }
    return curr.getValue();
    }


    public E getMax() {
        TreeNode<E> curr = root;
        while (curr.getRight() != null) {
            curr = curr.getRight();
        }
        return curr.getValue();
    }


    public Stack<E> inOrder(TreeNode<E> node, Stack<E> stack) {

        if (node == null)
            return stack;
        inOrder(node.getLeft(), stack);
        stack.push(node.getValue());
        inOrder(node.getRight(), stack);
        return stack;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root);
    }

    public boolean isBinarySearchTree(TreeNode<E> node) {

        Stack<E> stack = new Stack<E>();
        stack = inOrder(node, stack);

        while (!stack.isEmpty()) {
            E top = stack.pop();
            if(stack.isEmpty())
                break;
            else {
                int comp = stack.peek().compareTo(top);
                if(comp>0)
                    return false;
            }

        }
        return true;
    }

    public void deleteValue(E val){
        this.root = deleteValue(root, val);
    }

    public TreeNode<E> deleteValue(TreeNode<E> root, E val){
        if(root == null)
            return null;

        if(val.compareTo(root.getValue())<0){
            root.left = deleteValue(root.getLeft(),val);
        }
        else if(val.compareTo(root.getValue())>0) {
            root.right = deleteValue(root.getRight(), val);
        }
        else{
            if(root.getLeft()==null && root.getRight()==null) {
                root = null;
            }
            else if(root.getLeft()==null){
                root = root.getRight();
            }
            else if(root.getRight()==null){
                root = root.getLeft();
            }
            else{
                root.value = getMin(root.getRight());
                root.right = deleteValue(root.getRight(),root.value);
            }
        }
    return root;
    }

    public int getSuccessor(E val){
       if(root==null)
           return -1;
       TreeNode<E> curr = root;
       TreeNode<E> lastLeft = null;
        int comp;
       while(curr!=null){
          comp = val.compareTo(curr.getValue());
           if(comp>=0)
               curr = curr.getRight();
           else {
               lastLeft = curr;
               curr = curr.getLeft();
           }
       }
       if(lastLeft==null)
           return -1;
       else
           return (Integer) lastLeft.getValue();
    }


}
