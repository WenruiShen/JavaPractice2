package bookAlgorithms.examples.DataStructure;

import bookAlgorithms.DataModel.BinaryNode;
import bookAlgorithms.examples.AlgorithmModel;

import java.util.Stack;

/*
 * 二叉树定义
 */
public class BinaryTree extends AlgorithmModel {
    private BinaryNode<Integer, Double> root;

    public BinaryTree(){
        root = null; //创建一个空树
    }

    // 查找
    public BinaryNode<Integer, Double> find(Integer key){
        BinaryNode<Integer, Double> node = root;  // 查询从root开始

        while (key != node.key){
            if(key < node.key){
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
    public void insert(int key){
        BinaryNode<Integer, Double> newNode = new BinaryNode<>();
        newNode.key = key;
        if(root == null){
            root = newNode;     // 如果root为空，则赋予根结点
        }else {
            BinaryNode<Integer, Double> currentNode = root;  // 从root开始查找
            BinaryNode<Integer, Double> parentNode;
            while (true){
                parentNode = currentNode;
                if(key < currentNode.key){
                    currentNode = currentNode.leftNode;
                    if(null == currentNode){
                        parentNode.leftNode = newNode;
                        return;
                    }
                }else if (key > currentNode.key){
                    currentNode = currentNode.rightNode;
                    if(null == currentNode){
                        parentNode.rightNode = newNode;
                        return;
                    }
                }else if (key == currentNode.key){
                    // 有相同值；
                    return;
                }
            }
        }
    }

    //删除
    public boolean delete(int key){
        BinaryNode<Integer, Double> current = root;
        BinaryNode<Integer, Double> parent = root;
        boolean isLeftChild = false;

        while (current.key != key){
            parent = current;
            if(key < current.key){    //向左子树进行查询
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
            BinaryNode<Integer, Double> successor = getSuccessor(current);   //寻找继承者
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
    private BinaryNode<Integer, Double> getSuccessor(BinaryNode<Integer, Double> delNode){
        BinaryNode<Integer, Double> successorParent = delNode;
        BinaryNode<Integer, Double> successor = delNode;    //初始化
        BinaryNode<Integer, Double> current = delNode.rightNode;    //先向右节点寻找一位
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

    //前序遍历
    public void preOrder(BinaryNode<Integer, Double> localNode){
        if(null != localNode){
            localNode.display();            //打印根结点
            preOrder(localNode.leftNode);   //遍历左子树
            preOrder(localNode.rightNode);  //遍历右子树
        }
    }

    //中序遍历
    public void inOrder(BinaryNode<Integer, Double> localNode){
        if(null != localNode){
            inOrder(localNode.leftNode);   //遍历左子树
            localNode.display();            //打印根结点
            inOrder(localNode.rightNode);  //遍历右子树
        }
    }

    //后序遍历
    public void postOrder(BinaryNode<Integer, Double> localNode){
        if(null != localNode){
            postOrder(localNode.leftNode);   //遍历左子树
            postOrder(localNode.rightNode);  //遍历右子树
            localNode.display();            //打印根结点
        }
    }

    public void traverse(int type){
        switch (type) {
            case 1:
                System.out.print("\npre order :");
                preOrder(root);
                break;
            case 2:
                System.out.print("\nin order :");
                inOrder(root);
                break;
            case 3:
                System.out.print("\npost order :");
                postOrder(root);
                break;
            default:
                break;
        }
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
                BinaryNode<Integer, Double> temp = (BinaryNode<Integer, Double>)globalStack.pop();
                if (temp!=null) {
                    System.out.print(temp.key);
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
        //int[] array = {45, 47, 32, 43, 32, 6, 1, 7, 12, 32, 39, 32, 44, 37, 44, 32, 32, 45, 32, 55, 32, 26, 21};
        int[] array = {50, 25, 75, 12, 37, 43, 87, 93, 97, 30, 19};
        //System.out.println("arrary:");
        //printIntArray(array);

        //BinaryTree tree = new BinaryTree();
        for (Integer element: array){
            this.insert(element);
        }
        displayTree();


        //this.find(39).display();
        this.traverse(2);
    }
}
