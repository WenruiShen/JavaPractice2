package bookAlgorithms.examples;

/*
 * Created by shenwenrui on 20190115.
 * 希尔插入排序
 *
 * 参考：
 *  [1].https://blog.csdn.net/u011384489/article/details/78289576;
 *
 */
public class Sort_ShellInsert extends AlgorithmModel {

    // 希尔插入排序，由小到大
    public void ShellInsertSortAsc(int[] array){

    }

    @Override
    public void excute() {
        System.out.println("Shell Insert Sort:");
        int[] array = {2, 6, 1, 7, 12, 32, 3233, 32, 44, 37, 44, 32, 32, 457, 32, 443, 32, 545, 32, 565, 32, 976, 3121};
        System.out.println("arrary:");
        printIntArray(array);

        ShellInsertSortAsc(array);
        System.out.println("SortedArrary:");
        printIntArray(array);
    }
}
