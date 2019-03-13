package exam;

import java.util.*;

/*
 * 华为：牛客网。
 * 数据表记录包含表索引和数值，请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 *
 * 输入描述:
 *      先输入键值对的个数
 *      然后输入成对的index和value值，以空格隔开
 *
 * 输出描述:
 *      输出合并后的键值对（多行）
 *
 * input: 4
 *        0 1
 *        0 2
 *        1 2
 *        3 4
 *
 * output: 0 3
 *         1 2
 *         3 4
 *
 */
public class Huawei_train_20190313_06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /*String[] numList = input.nextLine().split(" ");
        int lineNum = Integer.valueOf(numList[0]);

        Map<Integer, Integer> map = new TreeMap<>();
        for(int i =1; i<1+2*lineNum; i+=2){
            int key = Integer.valueOf(numList[i]);
            int value = Integer.valueOf(numList[i+1]);
            if(map.containsKey(key)){
                map.put(key, map.get(key)+value);
            }else{
                map.put(key, value);
            }
        }*/
        int lineNum = Integer.valueOf(input.nextLine());
        Map<Integer, Integer> map = new TreeMap<>();
        while (lineNum-- > 0){
            String[] nString = input.nextLine().split(" ");
            int key = Integer.valueOf(nString[0]);
            int value = Integer.valueOf(nString[1]);
            if(map.containsKey(key)){
                map.put(key, map.get(key)+value);
            }else{
                map.put(key, value);
            }
        }


        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        input.close();
    }
}
