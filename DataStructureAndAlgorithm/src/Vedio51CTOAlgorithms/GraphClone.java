package Vedio51CTOAlgorithms;

import bookAlgorithms.examples.DataStructure.GraphNode;
import bookAlgorithms.examples.Model.AlgorithmModel;

/*
 * Created by shenwenrui on 20190201.
 * Description: 克隆图;
 *              克隆一个无向图，输入：node = {{1, 2}, {0}, {0, 2}}
 *              解释：
 *                0
 *               / \
 *              1  2
 *                 /\
 *                 \/
 *              输入有三个节点，第0个节点和第1、第2个节点相连，第1个节点和第0个节点相连，第2个节点和第0个、第2个节点相连。
 *              输出{{1, 2}, {0}, {0, 2}}
 *              解释：输出的结构相同，但是节点不一样
 *
 *              有向图克隆;
 *              51CTO视频-高频算法面试题:8;
 */
public class GraphClone extends AlgorithmModel {

    public GraphNode buildGraph(int[][] relationships){
        GraphNode[] nodes = new GraphNode[relationships.length];
        for (int i=0; i<relationships.length; i++){
            nodes[i] = new GraphNode();
        }
        for (int i=0; i<relationships.length; i++){
            for (int neighbour: relationships[i]){
                nodes[i].neighbours.add(nodes[neighbour]);
            }
        }
        return nodes[0];
    }

    @Override
    public void excute() {
        int[][] relationships = {{1, 2}, {0}, {0, 2}};
        GraphNode node = buildGraph(relationships);
        System.out.println(node);

    }
}
