package bookAlgorithms.examples.DataStructure;

/*
 * 红黑树
 * 定义：
 *
 */
public class RBTree extends BinaryTree {

    public void initRBTree(){
        System.out.println("RBTree Tree:");
        //int[] array = {45, 47, 32, 43, 32, 6, 1, 7, 12, 32, 39, 32, 44, 37, 44, 32, 32, 45, 32, 55, 32, 26, 21};
        int[] array = {50, 25, 75, 12, 37, 43, 87, 93, 97, 30, 19};

        for (Integer element: array){
            this.insert(element);
        }
    }

    @Override
    public void excute() {
        initRBTree();
        displayTree();
        this.traverse(2);
    }
}
