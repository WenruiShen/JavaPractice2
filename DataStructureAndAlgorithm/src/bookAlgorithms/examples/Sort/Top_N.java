package bookAlgorithms.examples.Sort;

import bookAlgorithms.examples.Model.AlgorithmModel;

/*
 * Created by shenwenrui on 20181219.
 * Top N相关问题及解。
 * 编写算法，从10亿个浮点数当中，选出其中最大的10000个。
 * 思路：
 *      建10000个数的小顶堆，然后将10亿个数依次读取，大于堆顶，则替换堆顶，做一次堆调整。结束之后，小顶堆中存放的数即为所求。
 *      代码如下(为了方便，这里直接使用了STL容器)：
 * 参考：
 *      [1]:https://uule.iteye.com/blog/2413147;
 *      [2]:https://blog.csdn.net/v_JULY_v/article/details/6403777;
 */
public class Top_N extends AlgorithmModel {


    // select the nth biggest members of array.
    public int[] SelectMaxN(int[] array, int len, int n){
        if(n > len)
            return null;

        int[] selectedArray = new int[n];
        //

        return selectedArray;
    }

    @Override
    public void excute() {
        System.out.println("Top-N:");
        int[] arrary = {2, 6, 1, 7, 12, 32, 3233, 32, 44, 37, 44, 32, 32, 457, 32, 443, 32, 545, 32, 565, 32, 976, 3121};
        System.out.println("arrary:");
        printIntArray(arrary);

        //HeapSortDesc(arrary, arrary.length);
        System.out.println("Selected N:");
        printIntArray(arrary);
    }
}
