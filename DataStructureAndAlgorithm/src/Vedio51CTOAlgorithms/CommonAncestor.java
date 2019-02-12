package Vedio51CTOAlgorithms;

import bookAlgorithms.DataModel.IntBinaryNode;
import bookAlgorithms.examples.DataStructure.IntBinaryTree;
import bookAlgorithms.examples.Model.AlgorithmModel;

/*
 * Created by shenwenrui on 20190212.
 * Description: 共同祖先;
 *              有个二叉树，还有两节点，如何找得到，最近的祖先。
 *              输入：
 *              root = {1, 2, 3, -1, 4, 5, 6}
 *              value1 = 5;
 *              value2 = 6;
 *              示意：
 *                     1
 *                   /   \
 *                 2       3
 *                /  \    / \
 *              null 4   5   6
 *              root对应的是一个树形结构，-1代表null，正整数代表这个节点的值，每个节点的值全局唯一。
 *
 *              输出：3
 *
 *              51CTO视频-高频算法面试题:6;
 */
public class CommonAncestor extends AlgorithmModel {
    int searchAncestor(IntBinaryNode root, int value1, int value2){
        if(root == null){
            return -1;
        }

        return root.getValue();
    }

    @Override
    public void excute() {
        int nums[] = {1, 2, 3, -1, 4, 5, 6};
        printIntArray(nums);
        int value1 = 5;
        int value2 = 6;

        IntBinaryNode root = new IntBinaryTree().builtBinaryTree(nums, 0);

        int result = searchAncestor(root, value1, value2);
        System.out.println("ancestor:" + result);
    }
}
