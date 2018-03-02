package com.bruce.sun;

import com.bruce.sun.domain.BinaryTreeNode;
import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _55_01_TreeDepth {

    /**
     * 面试题55（一）：二叉树的深度
     * 题目：输入一棵二叉树的根结点，求该树的深度。从根结点到叶结点依次经过的
     * 结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
     */
    private static int TreeDepth(BinaryTreeNode pRoot) {
        if (pRoot == null) return 0;

        int left = TreeDepth(pRoot.left);
        int right = TreeDepth(pRoot.right);
        return left > right ? left + 1 : right + 1;
    }


    // ====================测试代码====================
    static void Test(String testName, BinaryTreeNode pRoot, int expected) {
        int result = TreeDepth(pRoot);
        if (expected == result)
            MyUtils.print(testName + " passed.\n");
        else
            MyUtils.print(testName + " FAILED.\n");
    }


    //            1
//         /      \
//        2        3
//       /\         \
//      4  5         6
//        /
//       7
    static void Test1() {
        BinaryTreeNode pNode1 = MyUtils.createBinaryTreeNode(1);
        BinaryTreeNode pNode2 = MyUtils.createBinaryTreeNode(2);
        BinaryTreeNode pNode3 = MyUtils.createBinaryTreeNode(3);
        BinaryTreeNode pNode4 = MyUtils.createBinaryTreeNode(4);
        BinaryTreeNode pNode5 = MyUtils.createBinaryTreeNode(5);
        BinaryTreeNode pNode6 = MyUtils.createBinaryTreeNode(6);
        BinaryTreeNode pNode7 = MyUtils.createBinaryTreeNode(7);

        MyUtils.connectTreeNodes(pNode1, pNode2, pNode3);
        MyUtils.connectTreeNodes(pNode2, pNode4, pNode5);
        MyUtils.connectTreeNodes(pNode3, null, pNode6);
        MyUtils.connectTreeNodes(pNode5, pNode7, null);

        Test("Test1", pNode1, 4);


    }

    //               1
//              /
//             2
//            /
//           3
//          /
//         4
//        /
//       5
    static void Test2() {
        BinaryTreeNode pNode1 = MyUtils.createBinaryTreeNode(1);
        BinaryTreeNode pNode2 = MyUtils.createBinaryTreeNode(2);
        BinaryTreeNode pNode3 = MyUtils.createBinaryTreeNode(3);
        BinaryTreeNode pNode4 = MyUtils.createBinaryTreeNode(4);
        BinaryTreeNode pNode5 = MyUtils.createBinaryTreeNode(5);

        MyUtils.connectTreeNodes(pNode1, pNode2, null);
        MyUtils.connectTreeNodes(pNode2, pNode3, null);
        MyUtils.connectTreeNodes(pNode3, pNode4, null);
        MyUtils.connectTreeNodes(pNode4, pNode5, null);

        Test("Test2", pNode1, 5);


    }

    // 1
//  \
//   2
//    \
//     3
//      \
//       4
//        \
//         5
    static void Test3() {
        BinaryTreeNode pNode1 = MyUtils.createBinaryTreeNode(1);
        BinaryTreeNode pNode2 = MyUtils.createBinaryTreeNode(2);
        BinaryTreeNode pNode3 = MyUtils.createBinaryTreeNode(3);
        BinaryTreeNode pNode4 = MyUtils.createBinaryTreeNode(4);
        BinaryTreeNode pNode5 = MyUtils.createBinaryTreeNode(5);

        MyUtils.connectTreeNodes(pNode1, null, pNode2);
        MyUtils.connectTreeNodes(pNode2, null, pNode3);
        MyUtils.connectTreeNodes(pNode3, null, pNode4);
        MyUtils.connectTreeNodes(pNode4, null, pNode5);

        Test("Test3", pNode1, 5);


    }

    // 树中只有1个结点
    static void Test4() {
        BinaryTreeNode pNode1 = MyUtils.createBinaryTreeNode(1);
        Test("Test4", pNode1, 1);
    }

    // 树中没有结点
    static void Test5() {
        Test("Test5", null, 0);
    }

    public static void main(String[] args) {
        Test1();
        Test2();
        Test3();
        Test4();
        Test5();
    }
}
