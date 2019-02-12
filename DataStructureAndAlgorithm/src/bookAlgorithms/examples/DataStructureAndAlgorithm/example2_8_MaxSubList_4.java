package bookAlgorithms.examples.DataStructureAndAlgorithm;

import bookAlgorithms.examples.Model.AlgorithmModel;

/*
 * Created by shenwenrui on 20181219.
 * Description: Linear-time maximum contiguous subsequence sum algorithm.
 *              O(n)复杂度求取最大子序列之和。
 */
public class example2_8_MaxSubList_4 extends AlgorithmModel {

    public int run(int[] a){
        int maxSum = 0, thisSum = 0;
        for(int i = 0; i < a.length; i++){
            thisSum += a[i];
            if(thisSum > maxSum){
                maxSum = thisSum;
            } else if(thisSum < 0){
                thisSum = 0;
            }
        }
        return maxSum;
    }

    @Override
    public void excute(){

        int[] arrary = new int[]{2, -1, 1, 2, 3, 4, 0, -1, -2, -3, 1, 2};
        //Integer[] arrary = new Integer[]{1, 2, 3, 4};
        //List<Integer> list = new ArrayList<Integer>(Arrays.asList(arrary));
        int result = run(arrary);
        System.out.println(String.format("result:%d", result));

        System.out.println("example2_8_最大子序列_4 excuted!");
    }
}
