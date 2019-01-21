package bookAlgorithms.examples;

import bookAlgorithms.DataModel.BinaryNode;

import java.util.Stack;

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

    //删除
    public boolean delete(int key){
        BinaryNode<Integer> current = root;
        BinaryNode<Integer> parent = root;
        boolean isLeftChild = false;

        while (current.value != key){
            parent = current;
            if(key < current.value){    //向左子树进行查询
                isLeftChild = true;
                current = current.leftNode;
            }else{                      //向右子树进行查询
                isLeftChild = false;
                current = current.rightNode;
            }
            if(current == null){
                //到达叶节点，没有这个节点
                return false;
            }
        }

        //查找到的节点，进行删除
        if(current.leftNode==null && current.rightNode==null){
            //1.如果没有左右子树，直接删除
            if(current == root){
                root = null;
            }else if(isLeftChild){
                parent.leftNode = null;
            }else {
                parent.rightNode = null;
            }
        }else if(current.rightNode==null){
            //2. 没有右节点,只有左子树,直接用左节点代替当前节点
            if(current == root){
                root = current.leftNode;
            }else if(isLeftChild){
                //如果删除了当前节点，需要将当前节点的父节点的指向进行修改，这个指向就成了当前被删除节点的左子节点。
                parent.leftNode = current.leftNode;
            }else {
                parent.rightNode = current.leftNode;
            }
        }else if(current.leftNode==null){
            //3. 没有左节点,只有右子树,直接用右节点代替当前节点
            if(current == root){
                root = current.rightNode;
            }else if(isLeftChild){
                parent.leftNode = current.rightNode;
            }else {
                parent.rightNode = current.rightNode;
            }
        }else {
            //4. 有左右节点，右子树向左，寻找右子树最小值
            BinaryNode<Integer> successor = getSuccessor(current);   //寻找继承者
            if(current == root){
                root = successor;
            }else if(isLeftChild){
                parent.leftNode = successor;    //当前被删除节点的父类的一个赋值操作
            }else {
                parent.rightNode = successor;
            }
            successor.leftNode = current.leftNode;//给继承者的左节点进行一个赋值
        }

        return true;
    }

    //寻找继承者
    private BinaryNode<Integer> getSuccessor(BinaryNode<Integer> delNode){
        BinaryNode<Integer> successorParent = delNode;
        BinaryNode<Integer> successor = delNode;    //初始化
        BinaryNode<Integer> current = delNode.rightNode;    //先向右节点寻找一位
        while (current != null){
            successorParent = successor;
            successor = current;
            current = current.leftNode; //一直向左寻找
        }
        if(successor != delNode.rightNode){
            //如果继承者不是当前被删除节点的右子节点，则说明是右子树（不止一层）
            successorParent.leftNode = successor.rightNode; //继承者的右子树，成了父节点的左子树
            successor.rightNode = delNode.rightNode;        //右节点赋值
        }

        return successor;
    }

    public void displayTree(){
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks =32;getClass();
        boolean isRowEmpty = false;
        System.out.println("=========================================================================");
        while(isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for (int  j =0;j<nBlanks;j++) {
                System.out.print(" ");
            }

            while (globalStack.isEmpty() == false) {
                BinaryNode<Integer> temp = (BinaryNode<Integer>)globalStack.pop();
                if (temp!=null) {
                    System.out.print(temp.value);
                    localStack.push(temp.leftNode);
                    localStack.push(temp.rightNode);
                    if (temp.leftNode != null || temp.rightNode !=null) {
                        isRowEmpty = false;
                    }
                }
                else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0;j<nBlanks*2-2;j++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false) {
                globalStack.push(localStack.pop());
            }
        }
        System.out.println("=========================================================================");
    }

    @Override
    public void excute() {
        System.out.println("Binary Tree:");
        int[] array = {2, 6, 1, 7, 12, 32, 39, 32, 44, 37, 44, 32, 32, 47, 32, 43, 32, 45, 32, 55, 32, 26, 21};
        //System.out.println("arrary:");
        //printIntArray(array);

        //BinaryTree tree = new BinaryTree();
        for (Integer element: array){
            this.insert(element);
        }

        displayTree();
    }
}
