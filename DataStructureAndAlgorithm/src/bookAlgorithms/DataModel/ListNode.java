package bookAlgorithms.DataModel;

public class ListNode<E extends Object> {
    public E value;
    public ListNode<E> next;

    public void init(E value){
        this.value = value;
    }
    public String toString(){
        return String.valueOf(this.value);
    }
}
