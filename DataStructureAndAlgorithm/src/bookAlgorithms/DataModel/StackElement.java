package bookAlgorithms.DataModel;

public class StackElement<E> {
    public int type; // 0:visit, 1:output;
    public E node;
    public StackElement(int type, E node){
        this.type = type;
        this.node = node;
    }
}
