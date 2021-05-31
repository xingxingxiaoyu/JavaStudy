package common; 
 
public class BinaryTree<V> extends BaseNode<V> { 
 
    public BinaryTree<V> left; 
    public BinaryTree<V> right; 
 
    public BinaryTree(V value) { 
        super(value); 
    } 
 
    public BinaryTree(V value, BinaryTree<V> left, BinaryTree<V> right) { 
        super(value); 
        this.left = left; 
        this.right = right; 
        if (left != null) { 
            left.right = this; 
        } 
        if (right != null) { 
            right.left = this; 
        } 
    } 
 
 
    @Override 
    public String toString() { 
        return "BinaryTree{" + 
                "value=" + getValue() + 
                ", left=" + left + 
                ", right=" + right + 
                '}'; 
    } 
 
 
} 
