package bookAlgorithms.DataModel;

public class IntBinaryNode {
    int value;
    IntBinaryNode left;
    IntBinaryNode right;
    public IntBinaryNode(int value){
        this.value = value;
    }

    public int getValue(){return this.value;}

    public void setLeft(IntBinaryNode left){
        this.left = left;
    }

    public IntBinaryNode getLeft(){
        return this.left;
    }

    public void setRight(IntBinaryNode right){
        this.right = right;
    }

    public IntBinaryNode getRight(){
        return this.right;
    }
}
