package Vedio51CTOAlgorithms;

import bookAlgorithms.examples.Model.AlgorithmModel;

import java.util.Stack;

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

    boolean check3(String equation){
        while (equation.contains("()") || equation.contains("[]") || equation.contains("{}")){
            equation = equation.replace("()", "")
                                .replace("[]", "")
                                .replace("{}", "");
        }
        return equation.length()==0;
    }

    boolean check2(String equation){
        Stack<Character> stack = new Stack<>();
        for (char c: equation.toCharArray()){
            switch (c){
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    if(stack.isEmpty() || stack.pop()!=c){
                        return false;
                    }
                    break;
            }
        }
        return stack.size()==0;
    }

    //支持字符串中包含其他字符
    boolean check1(String equation){
        Stack<Character> stack = new Stack<>();
        for (char c: equation.toCharArray()){
            switch (c){
                case '(':
                    stack.push(c);
                    break;
                case '[':
                    stack.push(c);
                    break;
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop()!='('){
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop()!='['){
                        return false;
                    }
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop()!='{'){
                        return false;
                    }
                    break;
            }
        }
        return stack.size()==0;
    }

    @Override
    public void excute() {
        String equation = "([ffwq]vf[]e{})";
        System.out.println("equation: " + equation);
        boolean result = check1(equation);
        System.out.println("check result:" + result);
    }
}
