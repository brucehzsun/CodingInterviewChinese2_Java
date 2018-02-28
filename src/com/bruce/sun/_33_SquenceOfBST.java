package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _33_SquenceOfBST {

    /**
     * 面试题33：二叉搜索树的后序遍历序列
     * 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true，否则返回false。
     * 假设输入的数组的任意两个数字都互不相同。
     */
    public static void main(String[] args) {
        int[] data1 = new int[]{5, 7, 6, 9, 11, 10, 8};
        int[] data2 = new int[]{7, 4, 6, 5};

        boolean result1 = isSqueceOfBST(data1, 0, data1.length - 1);
        MyUtils.print("================\n");
        boolean result2 = isSqueceOfBST(data2, 0, data2.length - 1);
        if (result1 && !result2) {
            MyUtils.print("Pass!");
        } else {
            MyUtils.print("failed! result1 = " + result1 + ",result2 = " + result2);
        }
    }

    private static boolean isSqueceOfBST(int[] data, int start, int end) {
        if (data == null || data.length == 0) return false;
        if (start == end) return true;


        int root = data[end];
        MyUtils.print(start + "," + end + ",root = " + root + "\n");

        //找到左子树
        int indexOfLeft = start;
        for (int i = start; i <= end; i++) {
            if (data[i] > root) {
                break;
            }
            indexOfLeft++;
        }

        //判断右子树
        for (int i = indexOfLeft; i <= end; i++) {
            if (data[i] < root) {
                return false;
            }
        }

        boolean left = true;
        if (indexOfLeft > 1) {
            left = isSqueceOfBST(data, start, indexOfLeft - 1);
        }

        boolean right = true;
        if (indexOfLeft < end - 1) {
            right = isSqueceOfBST(data, indexOfLeft + start, end - 1);
        }

        return left && right;
    }
}
