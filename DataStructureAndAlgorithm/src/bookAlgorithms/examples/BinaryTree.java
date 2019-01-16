package bookAlgorithms.examples;

import bookAlgorithms.DataModel.BinaryNode;

/*
 * 二叉树定义
 */
public class BinaryTree extends AlgorithmModel{
    private BinaryNode<Integer> root;

    public BinaryTree(){
        root = null; //创建一个空树
    }

    // 查找
    public BinaryNode<Integer> find(Integer value){
        BinaryNode<Integer> node = root;  // 查询从root开始

        while (value != node.value){
            if(value < node.value){
                node = node.leftNode;   // 如果小于当前节点，向左子树查找
            }else {
                node = node.rightNode;   // 如果大于当前节点，向右子树查找
            }
            if(node == null){
                return null;    //当前二叉树没有此值
            }
        }
        return node;
    }

    // 插入
    public void insert(int value){
        BinaryNode<Integer> newNode = new BinaryNode<>();
        newNode.value = value;
        if(root == null){
            root = newNode;     // 如果root为空，则赋予根结点
        }else {
            BinaryNode<Integer> currentNode = root;  // 从root开始查找
            BinaryNode<Integer> parentNode;
            while (true){
                parentNode = currentNode;
                if(value < currentNode.value){
                    currentNode = currentNode.leftNode;
                    if(null == currentNode){
                        parentNode.leftNode = newNode;
                        return;
                    }
                }else if (value > currentNode.value){
                    currentNode = currentNode.rightNode;
                    if(null == currentNode){
                        parentNode.rightNode = newNode;
                        return;
                    }
                }else if (value == currentNode.value){
                    // 有相同值；
                    return;
                }
            }
        }
    }

    @Override
    public void excute() {
        System.out.println("Binary Tree:");
        int[] array = {2, 6, 1, 7, 12, 32, 3233, 32, 44, 37, 44, 32, 32, 457, 32, 443, 32, 545, 32, 565, 32, 976, 3121};
        //System.out.println("arrary:");
        //printIntArray(array);

        BinaryTree tree = new BinaryTree();
        for (Integer element: array){
            tree.insert(element);
        }

        // display
    }
}
