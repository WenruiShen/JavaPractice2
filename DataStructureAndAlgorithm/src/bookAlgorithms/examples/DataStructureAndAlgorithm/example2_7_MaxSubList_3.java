package bookAlgorithms.examples.DataStructureAndAlgorithm;

import bookAlgorithms.examples.Model.AlgorithmModel;

/*
 * Created by shenwenrui on 20181219.
 * Description: Recursive maximum contiguous subsequence sum algorithm.
 *              Find maximum sum in subarrayapanning a[left...right].
 *              Does not attempt to maintain actual best sequence.
 *              递归法求取最大子序列之和。
 */
public class example2_7_MaxSubList_3 extends AlgorithmModel {

    public int maxSumRec(int[] a, int left, int right){
        if(left == right){  // Base case
            if(a[left] >= 0){
                return a[left];
            } else {
                return 0;
            }

        }

        int center = (left + right) / 2;
        int maxLeftSum = maxSumRec(a, left, center);
        int maxRightSum = maxSumRec(a, center+1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for(int i = center; i >= left; i--){
            leftBorderSum += a[i];
            if(leftBorderSum > maxLeftBorderSum){
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center+1; i<=right; i++){
            rightBorderSum += a[i];
            if(rightBorderSum > maxRightBorderSum){
                maxRightBorderSum = rightBorderSum;
            }
        }

        return max3(maxLeftSum, maxRightSum, maxLeftBorderSum+maxRightBorderSum);

    }


    public int run(int[] a){
        return maxSumRec(a, 0, a.length-1);
    }

    @Override
    public void excute(){

        int[] arrary = new int[]{2, -1, 1, 2, 3, 4, 0, -1, -2, -3, 1, 2};
        //Integer[] arrary = new Integer[]{1, 2, 3, 4};
        //List<Integer> list = new ArrayList<Integer>(Arrays.asList(arrary));
        int result = run(arrary);
        System.out.println(String.format("result:%d", result));

        System.out.println("example2_7_最大子序列_3 excuted!");
    }
}
