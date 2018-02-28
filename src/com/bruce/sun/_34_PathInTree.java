package com.bruce.sun;


import com.bruce.sun.domain.BinaryTreeNode;
import com.bruce.sun.utils.MyUtils;

import java.util.ArrayList;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _34_PathInTree {

    /**
     * 面试题34：二叉树中和为某一值的路径
     * 题目：输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     */
    public static void main(String[] args) {
        BinaryTreeNode n10 = MyUtils.createBinaryTreeNode(10);
        BinaryTreeNode n5 = MyUtils.createBinaryTreeNode(5);
        BinaryTreeNode n12 = MyUtils.createBinaryTreeNode(12);
        BinaryTreeNode n4 = MyUtils.createBinaryTreeNode(4);
        BinaryTreeNode n7 = MyUtils.createBinaryTreeNode(7);

        MyUtils.connectTreeNodes(n10, n5, n12);
        MyUtils.connectTreeNodes(n5, n4, n7);

        printPathInTree(n10, 22);
    }

    private static void printPathInTree(BinaryTreeNode root, int expectedSum) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] curSum = new int[1];
        printPathInTree(root, list, curSum, expectedSum);
    }

    private static void printPathInTree(BinaryTreeNode root, ArrayList<Integer> list, int[] curSum, int expectedSum) {
        if (root == null) return;

        list.add(root.value);
        curSum[0] += root.value;

        if (root.left == null && root.right == null) {
            if (curSum[0] == expectedSum) {
                printStack(list);
            }
        }

        if (root.left != null) {
            printPathInTree(root.left, list, curSum, expectedSum);
        }

        if (root.right != null) {
            printPathInTree(root.right, list, curSum, expectedSum);
        }

        list.remove(list.size() - 1);
        curSum[0] -= root.value;
    }

    private static void printStack(ArrayList<Integer> list) {
        for (Integer i : list) {
            MyUtils.print(i + "\t");
        }
        MyUtils.print("\n");
    }

}
