package bookAlgorithms.examples.DataStructure;

import bookAlgorithms.DataModel.IntBinaryNode;

public class IntBinaryTree {
    public IntBinaryNode builtBinaryTree(int[] nums, int pos){
        if(pos >= nums.length || nums[pos]==-1){
            return null;
        }
        IntBinaryNode node = new IntBinaryNode(nums[pos]);
        node.setLeft(builtBinaryTree(nums, pos*2 + 1));
        node.setRight(builtBinaryTree(nums, pos*2 + 2));
        return node;
    }
}
