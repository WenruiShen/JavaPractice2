package bookAlgorithms.examples.TouTiao;

import bookAlgorithms.DataModel.ListNode;
import bookAlgorithms.examples.AlgorithmModel;
import bookAlgorithms.examples.DataStructure.niuke_lianbiao_fanzhuan;

/*
 * 今日头条：用单向链表表示十进制整数，求两个正整数的和。如图：
 *  {1}->{2}->{3}->{4}
 * +          {3}->{4}
 * ={1}->{2}->{6}->{8}
 * !请注意单向链表的方向，不可以使用其他数据结构
 */
public class Toutiao_ListNumAdd extends AlgorithmModel {

    // 链表从高位指向低位
    public int sumListNode(ListNode<Integer> numNode){
        int sum = 0;
        while (numNode != null){
            sum *= 10;
            sum += numNode.value;
            numNode = numNode.next;
        }
        return sum;
    }

    public int addTwoListOfNum(ListNode<Integer> num1, ListNode<Integer> num2){
        return sumListNode(num1) + sumListNode(num2);
    }

    @Override
    public void excute(){
        ListNode<Integer> num1 = new ListNode<Integer>();
        num1.init(1).add(2).add(3).add(4);
        num1.display();
        System.out.println("+\n");

        ListNode<Integer> num2 = new ListNode<Integer>();
        num2.init(3).add(4);
        num2.display();
        System.out.println("=\n");

        System.out.println(addTwoListOfNum(num1, num2));
    }
}
