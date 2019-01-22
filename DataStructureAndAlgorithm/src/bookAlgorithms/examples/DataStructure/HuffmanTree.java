package bookAlgorithms.examples.DataStructure;

/*
 * 哈夫曼树
 * 定义：带权路径长度WPL最小的二叉树成为哈夫曼树(最优二叉树)。
 * 构建方法：选取两个权值最小的根节点优先结合。
 * 原则：哈夫曼树中权越大的节点离根越近。
 *
 */
public class HuffmanTree extends BinaryTree {

    public void initHuffman(){
        System.out.println("Huffman Tree:");
        //int[] array = {45, 47, 32, 43, 32, 6, 1, 7, 12, 32, 39, 32, 44, 37, 44, 32, 32, 45, 32, 55, 32, 26, 21};
        int[] array = {50, 25, 75, 12, 37, 43, 87, 93, 97, 30, 19};

        for (Integer element: array){
            this.insert(element);
        }
    }

    @Override
    public void excute() {
        initHuffman();
        displayTree();
        //this.find(39).display();
        this.traverse(2);
    }
}
