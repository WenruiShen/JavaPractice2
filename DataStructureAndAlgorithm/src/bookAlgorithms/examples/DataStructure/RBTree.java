package bookAlgorithms.examples.DataStructure;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/*
 * 红黑树
 * 定义：平衡二叉搜索树
 * 红黑树特征：
 *      1.节点有颜色；
 *      2.在插入和删除的过程中，要遵循保持这些颜色的不同排列的规则。
 *          2.1 根总是黑色的；
 *          2.2 如果节点是红色的，则子节点一定是黑色的（反之，不一定）；
 *          2.3 从根到叶节点或空子节点的每条路径，必须包含相同数目的黑色节点。
 *
 * Note:    Java里TreMap就是以红黑树为底层的实现;
 *          TreeMap是非同步的;
 *          Key值不可为null;
 *
 */
public class RBTree extends BinaryTree {

    private Map synRBTreeMap;

    public void initRBTree(){
        TreeMap<Integer, Double> rbTreeMap = new TreeMap<Integer, Double>();
        synRBTreeMap = Collections.synchronizedMap(rbTreeMap);  //线程安全

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
