package bookAlgorithms.examples;

/*
 * 今日头条：求下雨最大水位解法
 */
public class Toutiao_shuiweixian extends AlgorithmModel {

    public boolean isPeak(int[] steps, int i){
        int len = steps.length;
        if(i==0){
            if(steps[i]>=steps[i+1])
                return true;
        }else if(i==len-1){
            if(steps[i-1]<=steps[i])
                return true;
        }else {
            if(steps[i-1]<=steps[i] && steps[i]>=steps[i+1])
                return true;
        }
        return false;
    }

    public int calculateOnePool(int[] steps, int leftP, int rightP){
        int volume = 0;
        int waterLine = steps[leftP]>steps[rightP] ? steps[rightP]:steps[leftP];//选取较矮的高峰
        for (int i = leftP+1; i<rightP; i++){
            volume+=(waterLine-steps[i]);
        }
        return volume;
    }

    public int calculateWaterVolume(int[] steps){
        int len = steps.length;
        int waterVolume = 0;
        if(len<=2)
            return waterVolume;

        for(int leftP=0; leftP<len-1; ){
            if(isPeak(steps, leftP)){
                //找到左侧高峰
                int maxRightPId = leftP; //初始化最高的右侧高峰Id
                for(int rightP=leftP+1; rightP<len; rightP++){
                    if(isPeak(steps, rightP)){
                        //找到右侧高峰
                        if(steps[rightP]>=steps[leftP]){
                            maxRightPId=rightP;
                            break;//右侧高峰高于左侧,找到一个水洼
                        }else {
                            //右侧高峰矮于左侧，选取最高的一个
                            if(maxRightPId==leftP){
                                maxRightPId=rightP; //找到的第一个右侧高峰
                            }else if(steps[maxRightPId]<steps[rightP]){
                                maxRightPId=rightP;
                            }
                        }
                    }
                }
                if(maxRightPId!=leftP){
                    //找到右侧高峰,计算该水洼
                    waterVolume += calculateOnePool(steps, leftP, maxRightPId);
                    leftP = maxRightPId;
                    continue;
                }
            }
            leftP++;
        }
        return waterVolume;
    }

    public int getMaxIndex(int[] steps){
        int id = 0, temp = steps[0];

        return id;
    }

    //解法2：先找中间最大的，再向两边扩散
    public int calculateWaterVolume2(int[] steps){
        int waterVolume = 0;
        return waterVolume;
    }

    @Override
    public void excute() {
        //int[] steps = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] steps = {2, 5, 1, 3, 1, 2, 1, 7, 7, 6};
        System.out.println("Steps:");
        printIntArray(steps);

        int waterVolume = calculateWaterVolume(steps);
        System.out.println("waterVolume: ");
        System.out.println(waterVolume);
    }
}
