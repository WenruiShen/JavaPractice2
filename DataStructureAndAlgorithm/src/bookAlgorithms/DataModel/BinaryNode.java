package bookAlgorithms.DataModel;

/*
 * 二叉树节点定义
 */
public class BinaryNode<K extends Object, V extends Object> {
    public K key;
    public V value;
    public BinaryNode<K, V> leftNode;
    public BinaryNode<K, V> rightNode;

    public void display(){
        System.out.print("{");
        System.out.print(key);
        System.out.print("}");
    }

    public void displayValue(){
        System.out.print("{");
        System.out.print(key);
        System.out.print(":");
        System.out.print(value);
        System.out.print("}");
    }
}
