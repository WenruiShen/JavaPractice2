package Vedio51CTOAlgorithms;

import bookAlgorithms.examples.Model.AlgorithmModel;

/*
 * Created by shenwenrui on 20190201.
 * Description: 安排航班;
 *              有向带权图，最短路径寻找;
 *
 *              从A飞到B，最多停k次，如何找路线，价格最便宜。
 *              输入：
 *              flights {{{1,1000}, {2,2000}}, {{2,500}}, {{1,500}}}
 *              from=0, to=2, k=1
 *
 *              解释：
 *              一共有3个机场，分别是0，1，2。
 *              第0个机场有2趟航班，从0到1的价格是1000，从0到2的价格是2000。
 *              第1个机场有1趟航班，从1到2的价格是500。
 *              第2个机场有1趟航班，从2到1的价格是500。
 *              我们的目标是从0号机场到2号机场，中间最多经停1次
 *
 *              输出：1500
 *
 *              解释：首先从0到1，价格1000；然后从1飞到2，价格500。
 *
 *              51CTO视频-高频算法面试题:10;
 */
public class AirlineArrangement extends AlgorithmModel {


    @Override
    public void excute() {

    }
}
