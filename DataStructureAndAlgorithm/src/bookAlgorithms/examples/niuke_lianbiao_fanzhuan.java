package bookAlgorithms.examples;

import bookAlgorithms.DataModel.ListNode;

/*
 * Created by shenwenrui on 20181219.
 * 牛客网：链表：单链表反转
 */
public class niuke_lianbiao_fanzhuan extends AlgorithmModel  {

    public ListNode<?> reverstList(ListNode<?> head){

        ListNode pre = null;
        ListNode next = null;

        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return head;
    }

    @Override
    public void excute(){
        ListNode<Integer> head = new ListNode<Integer>();
        head.init(1);
        head = (ListNode<Integer>) reverstList(head);
        System.out.println(head.toString());
    }
}
