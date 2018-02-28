package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;

import java.util.Stack;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
//==================================================================
public class _31_StackPushPopOrder {

    /**
     * 面试题31：栈的压入、弹出序列
     * 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
     * 例如序列1、2、3、4、5是某栈的压栈序列，序列4、5、3、2、1是该压栈序列对应的一个弹出序列，
     * 但4、3、5、1、2就不可能是该压栈序列的弹出序列。
     */
    public static void main(String[] args) {

        int[] data = new int[]{1, 2, 3, 4, 5};
        int[] check1 = new int[]{4, 5, 3, 2, 1};
        int[] check2 = new int[]{4, 3, 5, 1, 2};

        boolean result1 = checkStackOrder(data, check1);
        boolean result2 = checkStackOrder(data, check2);
        if (result1 && !result2) {
            MyUtils.print("Pass!");
        } else {
            MyUtils.print("Failed! result1 = " + result1 + ", result2 = " + result2);
        }

    }

    private static boolean checkStackOrder(int[] pushs, int[] pops) {
        if (pushs == null || pushs.length == 0 || pops == null || pops.length == 0) {
            return false;
        }
        if (pushs.length != pops.length) return false;

        //两个指针
        int pushPos = 0;
        int popPos = 0;
        Stack<Integer> stack = new Stack<>();
        //核心条件
        while (popPos < pops.length) {
            //push条件
            while (stack.empty() || stack.peek() != pops[popPos]) {
                if (pushPos == pushs.length) {
                    break;
                }
                stack.push(pushs[pushPos]);
                pushPos++;
            }

            if (stack.peek() != pops[popPos]) {
                break;
            }

            stack.pop();
            popPos++;
        }

        if (stack.empty() && popPos == pushs.length) {
            return true;
        }
        return false;
    }
}
