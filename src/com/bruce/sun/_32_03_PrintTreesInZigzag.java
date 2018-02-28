package com.bruce.sun;

import com.bruce.sun.domain.BinaryTreeNode;
import com.bruce.sun.utils.MyUtils;

import java.util.Stack;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _32_03_PrintTreesInZigzag {

    /**
     * 面试题32（三）：之字形打印二叉树
     * 题目：请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
     * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，
     * 其他行以此类推。
     */
    public static void main(String[] args) {
        BinaryTreeNode root = buildTrees();

        printZ(root);
    }

    private static void printZ(BinaryTreeNode root) {
        if (root == null) return;

        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();
        Stack<BinaryTreeNode>[] stacks = new Stack[]{stack1, stack2};
        int current = 0;
        int next = 1;
        stacks[0].push(root);
        while (!stacks[0].empty() || !stacks[1].empty()) {
            BinaryTreeNode node = stacks[current].pop();
            MyUtils.print(node.value + "\t");

            if (current == 1) {
                if (node.right != null)
                    stacks[next].push(node.right);
                if (node.left != null)
                    stacks[next].push(node.left);
            } else {
                if (node.left != null)
                    stacks[next].push(node.left);
                if (node.right != null)
                    stacks[next].push(node.right);
            }

            if (stacks[current].isEmpty()) {
                MyUtils.print("\n");
                int temp = current;
                current = next;
                next = temp;
            }
        }

    }

    private static BinaryTreeNode buildTrees() {
        BinaryTreeNode n1 = MyUtils.createBinaryTreeNode(1);
        BinaryTreeNode n2 = MyUtils.createBinaryTreeNode(2);
        BinaryTreeNode n3 = MyUtils.createBinaryTreeNode(3);
        BinaryTreeNode n4 = MyUtils.createBinaryTreeNode(4);
        BinaryTreeNode n5 = MyUtils.createBinaryTreeNode(5);
        BinaryTreeNode n6 = MyUtils.createBinaryTreeNode(6);
        BinaryTreeNode n7 = MyUtils.createBinaryTreeNode(7);
        BinaryTreeNode n8 = MyUtils.createBinaryTreeNode(8);
        BinaryTreeNode n9 = MyUtils.createBinaryTreeNode(9);
        BinaryTreeNode n10 = MyUtils.createBinaryTreeNode(10);
        BinaryTreeNode n11 = MyUtils.createBinaryTreeNode(11);
        BinaryTreeNode n12 = MyUtils.createBinaryTreeNode(12);
        BinaryTreeNode n13 = MyUtils.createBinaryTreeNode(13);
        BinaryTreeNode n14 = MyUtils.createBinaryTreeNode(14);
        BinaryTreeNode n15 = MyUtils.createBinaryTreeNode(15);

        MyUtils.connectTreeNodes(n1, n2, n3);
        MyUtils.connectTreeNodes(n2, n4, n5);
        MyUtils.connectTreeNodes(n3, n6, n7);

        MyUtils.connectTreeNodes(n4, n8, n9);
        MyUtils.connectTreeNodes(n5, n10, n11);

        MyUtils.connectTreeNodes(n6, n12, n13);
        MyUtils.connectTreeNodes(n7, n14, n15);

        return n1;
    }


}
