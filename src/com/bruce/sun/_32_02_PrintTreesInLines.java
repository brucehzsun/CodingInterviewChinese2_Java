package com.bruce.sun;

import com.bruce.sun.domain.BinaryTreeNode;
import com.bruce.sun.utils.MyUtils;

import java.util.LinkedList;
import java.util.Queue;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _32_02_PrintTreesInLines {

    /**
     * 面试题32（二）：分行从上到下打印二叉树
     * 题目：从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层打印到一行
     */
    public static void main(String[] args) {
        BinaryTreeNode n8 = MyUtils.createBinaryTreeNode(8);
        BinaryTreeNode n6 = MyUtils.createBinaryTreeNode(6);
        BinaryTreeNode n10 = MyUtils.createBinaryTreeNode(10);
        BinaryTreeNode n5 = MyUtils.createBinaryTreeNode(5);
        BinaryTreeNode n7 = MyUtils.createBinaryTreeNode(7);
        BinaryTreeNode n9 = MyUtils.createBinaryTreeNode(9);
        BinaryTreeNode n11 = MyUtils.createBinaryTreeNode(11);

        MyUtils.connectTreeNodes(n8, n6, n10);
        MyUtils.connectTreeNodes(n6, n5, n7);
        MyUtils.connectTreeNodes(n10, n9, n11);

        MyUtils.print("打印结果:\n");
        printQueue(n8);
        MyUtils.print("\n正确答案:\n");
        MyUtils.print("8\n");
        MyUtils.print("6 10\n");
        MyUtils.print("5 7 9 11\n");
    }

    private static void printQueue(BinaryTreeNode root) {
        if (root == null) return;

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        int toBePrinted = 1;
        int nextLevel = 0;
        while (!queue.isEmpty()) {
            BinaryTreeNode removed = queue.remove();
            toBePrinted--;
            MyUtils.print(removed.value + "\t");

            if (removed.left != null) {
                queue.add(removed.left);
                nextLevel++;
            }
            if (removed.right != null) {
                queue.add(removed.right);
                nextLevel++;
            }

            if (toBePrinted == 0) {
                toBePrinted = nextLevel;
                nextLevel = 0;
                MyUtils.print("\n");
            }
        }
    }
}
