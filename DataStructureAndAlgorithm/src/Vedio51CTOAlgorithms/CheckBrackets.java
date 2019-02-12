package Vedio51CTOAlgorithms;

import bookAlgorithms.examples.Model.AlgorithmModel;

/*
 * Created by shenwenrui on 20190212.
 * Description: 验证括号;
 *              给你一个包含括号的字符串，判断是否正确。
 *              输入1：equation = "([][]{})", 输出1：true
 *              输入2：equation = "([)]", 输出2：false
 *
 *              51CTO视频-高频算法面试题:4;
 */
public class CheckBrackets extends AlgorithmModel {

    boolean check(String equation){
        return false;
    }
    @Override
    public void excute() {
        String equation = "([][]{})";
        System.out.println("equation: " + equation);
        boolean result = check(equation);
        System.out.println("check result:" + result);
    }
}
