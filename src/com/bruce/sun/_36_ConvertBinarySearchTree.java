package com.bruce.sun;

import com.bruce.sun.domain.BinaryTreeNode;
import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _36_ConvertBinarySearchTree {

    /**
     * 面试题36：二叉搜索树与双向链表
     * 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     */
    public static void main(String[] args) {
        //            10
        //         /      \
        //        6        14
        //       /\        /\
        //      4  8     12  16

        // ==>4 6 8 10 14 12 16

        BinaryTreeNode root = buildTreeNodes();
        BinaryTreeNode head = convertTree(root);

        BinaryTreeNode node = head;
        while (node != null) {
            MyUtils.print(node.value + "\t");
            node = node.right;
        }
    }

    /**
     * @param root
     * @return
     */
    private static BinaryTreeNode convertTree(BinaryTreeNode root) {
        if (root == null) return null;

        BinaryTreeNode[] lastNodeInList = new BinaryTreeNode[1];
        convertNode(root, lastNodeInList);

        BinaryTreeNode head = lastNodeInList[0];
        while (head != null && head.left != null) {
            head = head.left;
        }

        return head;
    }

    /**
     * 中序遍历,中序遍历的特点是从小到大打印一个二叉搜索树。
     *
     * @param node
     * @param lastNodeInList
     */
    private static void convertNode(BinaryTreeNode node, BinaryTreeNode[] lastNodeInList) {
        if (node == null) return;

        if (node.left != null) {
            convertNode(node.left, lastNodeInList);
        }

        //中序遍历的核心步骤
        node.left = lastNodeInList[0];
        if (lastNodeInList[0] != null) {
            lastNodeInList[0].right = node;
        }
        lastNodeInList[0] = node;

        if (node.right != null) {
            convertNode(node.right, lastNodeInList);
        }
    }

    private static BinaryTreeNode buildTreeNodes() {

        BinaryTreeNode n10 = MyUtils.createBinaryTreeNode(10);
        BinaryTreeNode n6 = MyUtils.createBinaryTreeNode(6);
        BinaryTreeNode n14 = MyUtils.createBinaryTreeNode(14);
        BinaryTreeNode n4 = MyUtils.createBinaryTreeNode(4);
        BinaryTreeNode n8 = MyUtils.createBinaryTreeNode(8);
        BinaryTreeNode n12 = MyUtils.createBinaryTreeNode(12);
        BinaryTreeNode n16 = MyUtils.createBinaryTreeNode(16);

        MyUtils.connectTreeNodes(n10, n6, n14);

        MyUtils.connectTreeNodes(n6, n4, n8);
        MyUtils.connectTreeNodes(n14, n12, n16);
        return n10;
    }
}
