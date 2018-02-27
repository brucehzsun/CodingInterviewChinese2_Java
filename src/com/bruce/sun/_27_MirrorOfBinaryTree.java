package com.bruce.sun;

import com.bruce.sun.domain.BinaryTreeNode;
import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _27_MirrorOfBinaryTree {

    /**
     * 面试题27：二叉树的镜像
     * 题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     */

    private static void mirrorRecursively(BinaryTreeNode root) {
        if (root == null)
            return;

        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null) {
            mirrorRecursively(root.left);
        }
        if (root.right != null) {
            mirrorRecursively(root.right);
        }
    }

    // ====================测试代码====================
// 测试完全二叉树：除了叶子节点，其他节点都有两个子节点
//            8
//        6      10
//       5 7    9  11
    static void Test1() {
        MyUtils.print("=====Test1 starts:=====\n");
        BinaryTreeNode pNode8 = MyUtils.createBinaryTreeNode(8);
        BinaryTreeNode pNode6 = MyUtils.createBinaryTreeNode(6);
        BinaryTreeNode pNode10 = MyUtils.createBinaryTreeNode(10);
        BinaryTreeNode pNode5 = MyUtils.createBinaryTreeNode(5);
        BinaryTreeNode pNode7 = MyUtils.createBinaryTreeNode(7);
        BinaryTreeNode pNode9 = MyUtils.createBinaryTreeNode(9);
        BinaryTreeNode pNode11 = MyUtils.createBinaryTreeNode(11);

        MyUtils.connectTreeNodes(pNode8, pNode6, pNode10);
        MyUtils.connectTreeNodes(pNode6, pNode5, pNode7);
        MyUtils.connectTreeNodes(pNode10, pNode9, pNode11);

        MyUtils.printTree(pNode8);

        MyUtils.print("\n=====Test1: mirrorRecursively=====\n");
        mirrorRecursively(pNode8);
        MyUtils.printTree(pNode8);

//        MyUtils.print("=====Test1: MirrorIteratively=====\n");
//        mirrorRecursively(pNode8);
//        MyUtils.printTree(pNode8);
    }

    // 测试二叉树：出叶子结点之外，左右的结点都有且只有一个左子结点
//            8
//          7   
//        6 
//      5
//    4
    static void Test2() {
        MyUtils.print("=====Test2 starts:=====\n");
        BinaryTreeNode pNode8 = MyUtils.createBinaryTreeNode(8);
        BinaryTreeNode pNode7 = MyUtils.createBinaryTreeNode(7);
        BinaryTreeNode pNode6 = MyUtils.createBinaryTreeNode(6);
        BinaryTreeNode pNode5 = MyUtils.createBinaryTreeNode(5);
        BinaryTreeNode pNode4 = MyUtils.createBinaryTreeNode(4);

        MyUtils.connectTreeNodes(pNode8, pNode7, null);
        MyUtils.connectTreeNodes(pNode7, pNode6, null);
        MyUtils.connectTreeNodes(pNode6, pNode5, null);
        MyUtils.connectTreeNodes(pNode5, pNode4, null);

        MyUtils.printTree(pNode8);

        MyUtils.print("=====Test2: mirrorRecursively=====\n");
        mirrorRecursively(pNode8);
        MyUtils.printTree(pNode8);

//        MyUtils.print("=====Test2: MirrorIteratively=====\n");
//        mirrorRecursively(pNode8);
//        MyUtils.printTree(pNode8);

    }

    // 测试二叉树：出叶子结点之外，左右的结点都有且只有一个右子结点
//            8
//             7   
//              6 
//               5
//                4
    static void Test3() {
        MyUtils.print("=====Test3 starts:=====\n");
        BinaryTreeNode pNode8 = MyUtils.createBinaryTreeNode(8);
        BinaryTreeNode pNode7 = MyUtils.createBinaryTreeNode(7);
        BinaryTreeNode pNode6 = MyUtils.createBinaryTreeNode(6);
        BinaryTreeNode pNode5 = MyUtils.createBinaryTreeNode(5);
        BinaryTreeNode pNode4 = MyUtils.createBinaryTreeNode(4);

        MyUtils.connectTreeNodes(pNode8, null, pNode7);
        MyUtils.connectTreeNodes(pNode7, null, pNode6);
        MyUtils.connectTreeNodes(pNode6, null, pNode5);
        MyUtils.connectTreeNodes(pNode5, null, pNode4);

        MyUtils.printTree(pNode8);

        MyUtils.print("=====Test3: mirrorRecursively=====\n");
        mirrorRecursively(pNode8);
        MyUtils.printTree(pNode8);

//        MyUtils.print("=====Test3: MirrorIteratively=====\n");
//        mirrorRecursively(pNode8);
//        MyUtils.printTree(pNode8);

    }

    // 测试空二叉树：根结点为空指针
    static void Test4() {
        MyUtils.print("=====Test4 starts:=====\n");
        BinaryTreeNode pNode = null;

        MyUtils.printTree(pNode);

        MyUtils.print("=====Test4: mirrorRecursively=====\n");
        mirrorRecursively(pNode);
        MyUtils.printTree(pNode);

//        MyUtils.print("=====Test4: MirrorIteratively=====\n");
//        mirrorRecursively(pNode);
//        MyUtils.printTree(pNode);
    }

    // 测试只有一个结点的二叉树
    static void Test5() {
        MyUtils.print("=====Test5 starts:=====\n");
        BinaryTreeNode pNode8 = MyUtils.createBinaryTreeNode(8);

        MyUtils.printTree(pNode8);

        MyUtils.print("=====Test4: mirrorRecursively=====\n");
        mirrorRecursively(pNode8);
        MyUtils.printTree(pNode8);

//        MyUtils.print("=====Test4: MirrorIteratively=====\n");
//        mirrorRecursively(pNode8);
//        MyUtils.printTree(pNode8);
    }

    public static void main(String[] argv) {
        Test1();
//        Test2();
//        Test3();
//        Test4();
//        Test5();
    }
}
