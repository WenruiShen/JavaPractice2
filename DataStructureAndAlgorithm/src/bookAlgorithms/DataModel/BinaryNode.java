package bookAlgorithms.DataModel;

/*
 * 二叉树节点定义
 */
public class BinaryNode<E extends Object> {
    public E value;
    public BinaryNode<E> leftNode;
    public BinaryNode<E> rightNode;

    public void display(){
        System.out.println("{");
        System.out.println(value);
        System.out.println("}");
    }
}
