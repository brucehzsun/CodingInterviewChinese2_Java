package com.bruce.sun;

import com.bruce.sun.domain.BinaryTreeNode;
import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _54_KthNodeInBST {

    /**
     * 面试题54：二叉搜索树的第k个结点
     * 题目：给定一棵二叉搜索树，请找出其中的第k大的结点。
     */
    private static BinaryTreeNode KthNode(BinaryTreeNode pRoot, int k) {
        if (pRoot == null || k < 0) {
            return null;
        }

        int[] count = new int[1];
        count[0] = k;
        return kthNodeCore(pRoot, count);
    }

    private static BinaryTreeNode kthNodeCore(BinaryTreeNode pRoot, int[] k) {


        BinaryTreeNode result = null;

        if (pRoot.left != null) {
            result = kthNodeCore(pRoot.left, k);
        }

        //中序遍历核心代码；
        if (result == null) {
            if (k[0] == 1) {
                result = pRoot;
            }
            k[0]--;
        }

        if (pRoot.right != null && result == null) {
            result = kthNodeCore(pRoot.right, k);
        }
        return result;
    }


    // ====================测试代码====================
    static void Test(String testName, BinaryTreeNode pRoot, int k, boolean isNull, int expected) {
        if (testName != null)
            MyUtils.print(testName + "  begins: ");

        BinaryTreeNode pTarget = KthNode(pRoot, k);
        if ((isNull && pTarget == null) || (!isNull && pTarget.value == expected))
            MyUtils.print("Passed.\n");
        else
            MyUtils.print("FAILED.\n");
    }


    //            8
//        6      10
//       5 7    9  11
    static void TestA() {
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

        Test("TestA0", pNode8, 0, true, -1);
        Test("TestA1", pNode8, 1, false, 5);
        Test("TestA2", pNode8, 2, false, 6);
        Test("TestA3", pNode8, 3, false, 7);
        Test("TestA4", pNode8, 4, false, 8);
        Test("TestA5", pNode8, 5, false, 9);
        Test("TestA6", pNode8, 6, false, 10);
        Test("TestA7", pNode8, 7, false, 11);
        Test("TestA8", pNode8, 8, true, -1);

        MyUtils.print("\n\n");
    }

    //               5
//              /
//             4
//            /
//           3
//          /
//         2
//        /
//       1
    static void TestB() {
        BinaryTreeNode pNode5 = MyUtils.createBinaryTreeNode(5);
        BinaryTreeNode pNode4 = MyUtils.createBinaryTreeNode(4);
        BinaryTreeNode pNode3 = MyUtils.createBinaryTreeNode(3);
        BinaryTreeNode pNode2 = MyUtils.createBinaryTreeNode(2);
        BinaryTreeNode pNode1 = MyUtils.createBinaryTreeNode(1);

        MyUtils.connectTreeNodes(pNode5, pNode4, null);
        MyUtils.connectTreeNodes(pNode4, pNode3, null);
        MyUtils.connectTreeNodes(pNode3, pNode2, null);
        MyUtils.connectTreeNodes(pNode2, pNode1, null);

        Test("TestB0", pNode5, 0, true, -1);
        Test("TestB1", pNode5, 1, false, 1);
        Test("TestB2", pNode5, 2, false, 2);
        Test("TestB3", pNode5, 3, false, 3);
        Test("TestB4", pNode5, 4, false, 4);
        Test("TestB5", pNode5, 5, false, 5);
        Test("TestB6", pNode5, 6, true, -1);

        MyUtils.print("\n\n");
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
    static void TestC() {
        BinaryTreeNode pNode1 = MyUtils.createBinaryTreeNode(1);
        BinaryTreeNode pNode2 = MyUtils.createBinaryTreeNode(2);
        BinaryTreeNode pNode3 = MyUtils.createBinaryTreeNode(3);
        BinaryTreeNode pNode4 = MyUtils.createBinaryTreeNode(4);
        BinaryTreeNode pNode5 = MyUtils.createBinaryTreeNode(5);

        MyUtils.connectTreeNodes(pNode1, null, pNode2);
        MyUtils.connectTreeNodes(pNode2, null, pNode3);
        MyUtils.connectTreeNodes(pNode3, null, pNode4);
        MyUtils.connectTreeNodes(pNode4, null, pNode5);

        Test("TestC0", pNode1, 0, true, -1);
        Test("TestC1", pNode1, 1, false, 1);
        Test("TestC2", pNode1, 2, false, 2);
        Test("TestC3", pNode1, 3, false, 3);
        Test("TestC4", pNode1, 4, false, 4);
        Test("TestC5", pNode1, 5, false, 5);
        Test("TestC6", pNode1, 6, true, -1);


        MyUtils.print("\n\n");
    }

    // There is only one node in a tree
    static void TestD() {
        BinaryTreeNode pNode1 = MyUtils.createBinaryTreeNode(1);

        Test("TestD0", pNode1, 0, true, -1);
        Test("TestD1", pNode1, 1, false, 1);
        Test("TestD2", pNode1, 2, true, -1);


        MyUtils.print("\n\n");
    }

    // empty tree
    static void TestE() {
        Test("TestE0", null, 0, true, -1);
        Test("TestE1", null, 1, true, -1);

        MyUtils.print("\n\n");
    }

    public static void main(String[] args) {
        TestA();
        TestB();
        TestC();
        TestD();
        TestE();
    }
}
