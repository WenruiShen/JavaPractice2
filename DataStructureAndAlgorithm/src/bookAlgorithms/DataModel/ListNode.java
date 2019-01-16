package bookAlgorithms.DataModel;

public class ListNode<E extends Object> {
    public E value;
    public ListNode<E> next = null;

    public ListNode<E> init(E value){
        this.value = value;
        return this;
    }

    public ListNode<E> add(E value){
        ListNode<E> newNode = new ListNode<E>();
        newNode.init(value);
        this.next = newNode;
        return this.next;
    }

    public String toString(){
        return String.valueOf(this.value);
    }

    public void display(){
        System.out.print(this.toString());
        System.out.print(", ");
        if (null != this.next){
            this.next.display();
        }
    }
}
