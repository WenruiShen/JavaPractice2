package Vedio51CTOAlgorithms;

import bookAlgorithms.examples.Model.AlgorithmModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Created by shenwenrui on 20190201.
 * Description: 安排课程;
 *              有向图，环探测(逐个删除出度为0的点);
 *
 *              学校要上课，顺序优先后，能否排排课，把课都上完。
 *              输入：prerequisites = {{1}, {3}, {3}, {}};
 *              解释：一共四门课，编号分别为0，1，2，3，第0门课需要先完成第1门课，第1、2门课需要先完成第3门课，第3门课没有要求。
 *              输出：true
 *
 *              解释：一个可行的上课顺序是3，2，1，0；
 *
 *              51CTO视频-高频算法面试题:9;
 */
public class CourseArrangement extends AlgorithmModel {
    public boolean scheduleCourses(int[][] prerequisites){
        int[] degree = new int[prerequisites.length];
        List<Integer>[] neighbors = new List[prerequisites.length];
        Queue<Integer> avilable = new LinkedList<>();

        for(int id =0; id<prerequisites.length; id++){
            neighbors[id] = new ArrayList<>();
            degree[id] = prerequisites[id].length;
            if(degree[id]==0){
                avilable.offer(id);
            }
        }

        for (int from=0; from<prerequisites.length;from++){
            for (int to: prerequisites[from]){
                neighbors[to].add(from);
            }
        }

        int count=0;
        while (!avilable.isEmpty()){
            System.out.println(avilable.peek());
            for(int id: neighbors[avilable.poll()]){
                if(--degree[id]==0){
                    avilable.offer(id);
                }
            }
            count++;
        }
        return count==prerequisites.length;
    }

    @Override
    public void excute() {
        int[][] prerequisites = {{1}, {3}, {3}, {}};
        boolean result = scheduleCourses(prerequisites);
        System.out.println(result);
    }
}
