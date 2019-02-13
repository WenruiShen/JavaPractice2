package Vedio51CTOAlgorithms;

import bookAlgorithms.DataModel.IntBinaryNode;
import bookAlgorithms.DataModel.StackElement;
import bookAlgorithms.examples.DataStructure.IntBinaryTree;
import bookAlgorithms.examples.Model.AlgorithmModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Created by shenwenrui on 20190212.
 * Description: 先根遍历(NLR);
 *
 *              采用栈方法实现，DFS
 *
 *              51CTO视频-高频算法面试题:7;
 */
public class PreorderTraversal extends AlgorithmModel {

    public List<Integer> PreorderTraverse(IntBinaryNode node){
        List<Integer> result = new ArrayList<>();
        Stack<StackElement<IntBinaryNode>> stack = new Stack<>();
        stack.push(new StackElement<IntBinaryNode>(0, node));

        while (!stack.isEmpty()){
            StackElement<IntBinaryNode> curr = stack.pop();
            if(curr.node == null){
                continue;
            }

            if(curr.type == 1){
                result.add(curr.node.getValue());
            }else {
                stack.push(new StackElement<IntBinaryNode>(0, curr.node.getRight()));
                stack.push(new StackElement<IntBinaryNode>(0, curr.node.getLeft()));
                stack.push(new StackElement<IntBinaryNode>(1, curr.node));
            }
        }

        return result;
    }

    @Override
    public void excute() {
        int nums[] = {1, 2, 3, -1, 4, 5, 6};
        printIntArray(nums);
        IntBinaryNode root = new IntBinaryTree().builtBinaryTree(nums, 0);
        List<Integer> result = PreorderTraverse(root);
        System.out.println("PreorderTraversal:" + result);
    }
}
