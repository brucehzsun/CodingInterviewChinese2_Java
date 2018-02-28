package com.bruce.sun;

import com.bruce.sun.domain.BinaryTreeNode;
import com.bruce.sun.domain.ListNode;
import com.bruce.sun.utils.MyUtils;

import java.util.ArrayList;
import java.util.List;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _37_SerializeBinaryTrees {

    /**
     * 面试题37：序列化二叉树
     * 题目：请实现两个函数，分别用来序列化和反序列化二叉树。
     */
    public static void main(String[] args) {
        //     1
        //    /\
        //   2  3
        //  /  /\
        // 4  5  6
        BinaryTreeNode n1 = buildTree();
        MyUtils.print("原始数据\n");
        MyUtils.printTree(n1);
        MyUtils.print("\n");

        List<Character> list = new ArrayList();
        serializeTree(n1, list);
        MyUtils.print("序列化后的数据：\n");
        for (Character c : list) {
            MyUtils.print((int) c + "\t");
        }
        MyUtils.print("\n");


        BinaryTreeNode node = deserializeTree(list);
        MyUtils.print("反序列化后的数据：\n");
        MyUtils.printTree(node);
    }

    private static BinaryTreeNode deserializeTree(List<Character> list) {
        if (list == null || list.size() == 0) return null;

        char c = list.remove(0);
        if (c == '$') {
            return null;
        }

        BinaryTreeNode node = MyUtils.createBinaryTreeNode(c);

        node.left = deserializeTree(list);
        node.right = deserializeTree(list);
        return node;
    }

    /**
     * 序列化
     *
     * @param root
     * @param list
     */
    private static void serializeTree(BinaryTreeNode root, List<Character> list) {
        if (root == null || list == null) return;

        list.add((char) root.value);

        if (root.left == null) {
            list.add('$');
        } else {
            serializeTree(root.left, list);
        }

        if (root.right == null) {
            list.add('$');
        } else {
            serializeTree(root.right, list);
        }
    }

    private static BinaryTreeNode buildTree() {
        BinaryTreeNode n1 = MyUtils.createBinaryTreeNode(1);
        BinaryTreeNode n2 = MyUtils.createBinaryTreeNode(2);
        BinaryTreeNode n3 = MyUtils.createBinaryTreeNode(3);
        BinaryTreeNode n4 = MyUtils.createBinaryTreeNode(4);
        BinaryTreeNode n5 = MyUtils.createBinaryTreeNode(5);
        BinaryTreeNode n6 = MyUtils.createBinaryTreeNode(6);

        MyUtils.connectTreeNodes(n1, n2, n3);
        MyUtils.connectTreeNodes(n2, n4, null);
        MyUtils.connectTreeNodes(n3, n5, n6);
        return n1;
    }
}
