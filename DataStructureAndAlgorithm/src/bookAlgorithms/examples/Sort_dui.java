package bookAlgorithms.examples;

/*
 * Created by shenwenrui on 20181219.
 * 堆排序
 * 简介：不稳定
 *      最差时间复杂度O(n log n)
 *      最优时间复杂度O(n log n)
 *      平均时间复杂度O(n log n)
 *      最差空间复杂度 O(n)
 *
 * 堆一般都指的是二叉堆，它满足二个特性：
 *      1.父结点的键值总是大于或等于（小于或等于）任何一个子节点的键值;
 *      2.每个结点的左子树和右子树都是一个二叉堆（都是最大堆或最小堆）。
 *
 * 堆的存储:
 *      一般都用数组来表示堆，i结点的父结点下标就为(i – 1) / 2。
 *      它的左右子结点下标分别为2 * i + 1和2 * i + 2。
 *      如第0个结点左右子结点下标分别为1和2。
 *
 * *: 使用最小堆排序后是递减数组，要得到递增数组，可以使用最大堆。
 *
 * 参考：
 *  [1]:https://blog.csdn.net/u011384489/article/details/78300691#6-%E9%80%89%E6%8B%A9%E6%8E%92%E5%BA%8F%E5%A0%86%E6%8E%92%E5%BA%8Fheap-sort;
 *  [2]:https://blog.csdn.net/morewindows/article/details/6709644/;
 */
public class Sort_dui extends AlgorithmModel {

    // 插入新节点，进行堆调整

    // 进行堆调整：从i节点开始调整,len为节点总数 从0开始计算 i节点的子节点为 2*i+1, 2*i+2
    public void MinHeapAdjust(int[] array, int i, int len){
        int child = 2*i+1;  //左孩子结点的位置
        int temp = array[i];
        while (child < len){
            if(child+1 < len && array[child] > array[child+1]){
                //在左右孩子中找最小的
                child++;
            }
            if(array[child] < temp){
                array[i] = array[child];    //把较小的子结点往上移动,替换它的父结点
                i = child;
                child = 2*i + 1;
            }else {
                // 该节点子数已是最小堆
                break;
            }
        }
        array[i] = temp;
    }


    public void BuidMinHeap(int[] array, int len){
        for(int i = len/2 - 1;i>=0; i--){
            MinHeapAdjust(array, i, len);
        }
    }

    // 使用最小堆排序后是递减数组
    public void HeapSortDesc(int[] array, int len){
        // 初始建堆(最小堆)
        BuidMinHeap(array, len);

        // 在最小堆中删除数
        for (int i=len-1; i>0; i--){
            // 删除根结点,将根结点置换到未排序队列后面
            swap(array, 0, i);

            // 进行堆调整
            MinHeapAdjust(array, 0, i);
        }

    }

    // 使用最大堆排序后是递增数组
    public void HeapSortAsc(int[] array, int len){

    }

    @Override
    public void excute() {
        System.out.println("Heap Sort:");
        int[] arrary = {2, 6, 1, 7, 12, 32, 3233, 32, 44, 37, 44, 32, 32, 457, 32, 443, 32, 545, 32, 565, 32, 976, 3121};
        System.out.println("arrary:");
        printIntArray(arrary);

        HeapSortDesc(arrary, arrary.length);
        System.out.println("SortedArrary(Desc):");
        printIntArray(arrary);
    }
}
