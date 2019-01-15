package bookAlgorithms.examples;

/*
 * Created by shenwenrui on 20181219.
 * 直接插入排序
 * 参考：
 *  [1].https://blog.csdn.net/morewindows/article/details/6665714;
 *  [2].https://blog.csdn.net/u011384489/article/details/78289576#2-%E7%9B%B4%E6%8E%A5%E6%8F%92%E5%85%A5%E6%8E%92%E5%BA%8F-straight-insertion-sort;
 *
 */
public class Sort_Insert extends AlgorithmModel {

    // 直接插入排序，由小到大
    public void InsertSortAsc(int[] array){
        for(int i=1; i<array.length; i++){
            int temp = array[i];
            int j= i;
            for(; j>0 && array[j-1]>temp; j--){ //必须是与temp进行比较
                array[j]=array[j-1];
            }
            array[j]=temp;
        }
    }

    // 二分插入排序，由小到大
    public void BinInsertSortAsc(int[] array){
        int len = array.length;
        int key ,left, right, middle;
        for(int i=1; i<len; i++){
            key = array[i];
            left = 0;
            right = i-1;
            while (left<=right){
                middle = (left+right)/2;
                if(array[middle]>key){
                    right= middle-1;
                }else {
                    left = middle+1;
                }
            }
            int j=i;
            for(;j>left;j--){
                array[j] = array[j-1];
            }
            array[j] = key;
        }
    }

    @Override
    public void excute() {
        System.out.println("Insert Sort:");
        int[] array = {2, 6, 1, 7, 12, 32, 3233, 32, 44, 37, 44, 32, 32, 457, 32, 443, 32, 545, 32, 565, 32, 976, 3121};
        System.out.println("arrary:");
        printIntArray(array);

        BinInsertSortAsc(array);
        System.out.println("SortedArrary:");
        printIntArray(array);
    }
}
