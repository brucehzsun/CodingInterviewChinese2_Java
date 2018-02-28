package com.bruce.sun;

import com.bruce.sun.domain.BinaryTreeNode;
import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
//==================================================================
public class _28_SymmetricalBinaryTree {

    /**
     * 面试题28：对称的二叉树
     * 题目：请实现一个函数，用来判断一棵二叉树是不是对称的。
     * 如果一棵二叉树和它的镜像一样，那么它是对称的。
     */
    private static boolean isSymmetrical(BinaryTreeNode root) {
        return isSymmetrical(root, root);
    }

    private static boolean isSymmetrical(BinaryTreeNode n1, BinaryTreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        if (n1.value != n2.value) return false;

        return isSymmetrical(n1.left, n2.right) && isSymmetrical(n1.right, n2.left);
    }

    // ====================测试代码====================
    private static void Test(String testName, BinaryTreeNode pRoot, boolean expected) {
        if (testName != null)
            MyUtils.print(testName + "begins: ");

        if (isSymmetrical(pRoot) == expected)
            MyUtils.print("Passed.\n");
        else
            MyUtils.print("FAILED.\n");
    }

    //            8
//        6      6
//       5 7    7 5
    private static void Test1() {
        BinaryTreeNode pNode8 = MyUtils.createBinaryTreeNode(8);
        BinaryTreeNode pNode61 = MyUtils.createBinaryTreeNode(6);
        BinaryTreeNode pNode62 = MyUtils.createBinaryTreeNode(6);
        BinaryTreeNode pNode51 = MyUtils.createBinaryTreeNode(5);
        BinaryTreeNode pNode71 = MyUtils.createBinaryTreeNode(7);
        BinaryTreeNode pNode72 = MyUtils.createBinaryTreeNode(7);
        BinaryTreeNode pNode52 = MyUtils.createBinaryTreeNode(5);

        MyUtils.connectTreeNodes(pNode8, pNode61, pNode62);
        MyUtils.connectTreeNodes(pNode61, pNode51, pNode71);
        MyUtils.connectTreeNodes(pNode62, pNode72, pNode52);

        Test("Test1", pNode8, true);
    }

    //            8
//        6      9
//       5 7    7 5
    private static void Test2() {
        BinaryTreeNode pNode8 = MyUtils.createBinaryTreeNode(8);
        BinaryTreeNode pNode61 = MyUtils.createBinaryTreeNode(6);
        BinaryTreeNode pNode9 = MyUtils.createBinaryTreeNode(9);
        BinaryTreeNode pNode51 = MyUtils.createBinaryTreeNode(5);
        BinaryTreeNode pNode71 = MyUtils.createBinaryTreeNode(7);
        BinaryTreeNode pNode72 = MyUtils.createBinaryTreeNode(7);
        BinaryTreeNode pNode52 = MyUtils.createBinaryTreeNode(5);

        MyUtils.connectTreeNodes(pNode8, pNode61, pNode9);
        MyUtils.connectTreeNodes(pNode61, pNode51, pNode71);
        MyUtils.connectTreeNodes(pNode9, pNode72, pNode52);

        Test("Test2", pNode8, false);
    }

    //            8
//        6      6
//       5 7    7
    private static void Test3() {
        BinaryTreeNode pNode8 = MyUtils.createBinaryTreeNode(8);
        BinaryTreeNode pNode61 = MyUtils.createBinaryTreeNode(6);
        BinaryTreeNode pNode62 = MyUtils.createBinaryTreeNode(6);
        BinaryTreeNode pNode51 = MyUtils.createBinaryTreeNode(5);
        BinaryTreeNode pNode71 = MyUtils.createBinaryTreeNode(7);
        BinaryTreeNode pNode72 = MyUtils.createBinaryTreeNode(7);

        MyUtils.connectTreeNodes(pNode8, pNode61, pNode62);
        MyUtils.connectTreeNodes(pNode61, pNode51, pNode71);
        MyUtils.connectTreeNodes(pNode62, pNode72, null);

        Test("Test3", pNode8, false);
    }

    //               5
//              / \
//             3   3
//            /     \
//           4       4
//          /         \
//         2           2
//        /             \
//       1               1
    private static void Test4() {
        BinaryTreeNode pNode5 = MyUtils.createBinaryTreeNode(5);
        BinaryTreeNode pNode31 = MyUtils.createBinaryTreeNode(3);
        BinaryTreeNode pNode32 = MyUtils.createBinaryTreeNode(3);
        BinaryTreeNode pNode41 = MyUtils.createBinaryTreeNode(4);
        BinaryTreeNode pNode42 = MyUtils.createBinaryTreeNode(4);
        BinaryTreeNode pNode21 = MyUtils.createBinaryTreeNode(2);
        BinaryTreeNode pNode22 = MyUtils.createBinaryTreeNode(2);
        BinaryTreeNode pNode11 = MyUtils.createBinaryTreeNode(1);
        BinaryTreeNode pNode12 = MyUtils.createBinaryTreeNode(1);

        MyUtils.connectTreeNodes(pNode5, pNode31, pNode32);
        MyUtils.connectTreeNodes(pNode31, pNode41, null);
        MyUtils.connectTreeNodes(pNode32, null, pNode42);
        MyUtils.connectTreeNodes(pNode41, pNode21, null);
        MyUtils.connectTreeNodes(pNode42, null, pNode22);
        MyUtils.connectTreeNodes(pNode21, pNode11, null);
        MyUtils.connectTreeNodes(pNode22, null, pNode12);

        Test("Test4", pNode5, true);
    }


    //               5
//              / \
//             3   3
//            /     \
//           4       4
//          /         \
//         6           2
//        /             \
//       1               1
    private static void Test5() {
        BinaryTreeNode pNode5 = MyUtils.createBinaryTreeNode(5);
        BinaryTreeNode pNode31 = MyUtils.createBinaryTreeNode(3);
        BinaryTreeNode pNode32 = MyUtils.createBinaryTreeNode(3);
        BinaryTreeNode pNode41 = MyUtils.createBinaryTreeNode(4);
        BinaryTreeNode pNode42 = MyUtils.createBinaryTreeNode(4);
        BinaryTreeNode pNode6 = MyUtils.createBinaryTreeNode(6);
        BinaryTreeNode pNode22 = MyUtils.createBinaryTreeNode(2);
        BinaryTreeNode pNode11 = MyUtils.createBinaryTreeNode(1);
        BinaryTreeNode pNode12 = MyUtils.createBinaryTreeNode(1);

        MyUtils.connectTreeNodes(pNode5, pNode31, pNode32);
        MyUtils.connectTreeNodes(pNode31, pNode41, null);
        MyUtils.connectTreeNodes(pNode32, null, pNode42);
        MyUtils.connectTreeNodes(pNode41, pNode6, null);
        MyUtils.connectTreeNodes(pNode42, null, pNode22);
        MyUtils.connectTreeNodes(pNode6, pNode11, null);
        MyUtils.connectTreeNodes(pNode22, null, pNode12);

        Test("Test5", pNode5, false);
    }

    //               5
//              / \
//             3   3
//            /     \
//           4       4
//          /         \
//         2           2
//                      \
//                       1
    private static void Test6() {
        BinaryTreeNode pNode5 = MyUtils.createBinaryTreeNode(5);
        BinaryTreeNode pNode31 = MyUtils.createBinaryTreeNode(3);
        BinaryTreeNode pNode32 = MyUtils.createBinaryTreeNode(3);
        BinaryTreeNode pNode41 = MyUtils.createBinaryTreeNode(4);
        BinaryTreeNode pNode42 = MyUtils.createBinaryTreeNode(4);
        BinaryTreeNode pNode21 = MyUtils.createBinaryTreeNode(2);
        BinaryTreeNode pNode22 = MyUtils.createBinaryTreeNode(2);
        BinaryTreeNode pNode12 = MyUtils.createBinaryTreeNode(1);

        MyUtils.connectTreeNodes(pNode5, pNode31, pNode32);
        MyUtils.connectTreeNodes(pNode31, pNode41, null);
        MyUtils.connectTreeNodes(pNode32, null, pNode42);
        MyUtils.connectTreeNodes(pNode41, pNode21, null);
        MyUtils.connectTreeNodes(pNode42, null, pNode22);
        MyUtils.connectTreeNodes(pNode21, null, null);
        MyUtils.connectTreeNodes(pNode22, null, pNode12);

        Test("Test6", pNode5, false);
    }

    // 只有一个结点
    private static void Test7() {
        BinaryTreeNode pNode1 = MyUtils.createBinaryTreeNode(1);
        Test("Test7", pNode1, true);
    }

    // 没有结点
    private static void Test8() {
        Test("Test8", null, true);
    }

    // 所有结点都有相同的值，树对称
//               5
//              / \
//             5   5
//            /     \
//           5       5
//          /         \
//         5           5
    private static void Test9() {
        BinaryTreeNode pNode1 = MyUtils.createBinaryTreeNode(5);
        BinaryTreeNode pNode21 = MyUtils.createBinaryTreeNode(5);
        BinaryTreeNode pNode22 = MyUtils.createBinaryTreeNode(5);
        BinaryTreeNode pNode31 = MyUtils.createBinaryTreeNode(5);
        BinaryTreeNode pNode32 = MyUtils.createBinaryTreeNode(5);
        BinaryTreeNode pNode41 = MyUtils.createBinaryTreeNode(5);
        BinaryTreeNode pNode42 = MyUtils.createBinaryTreeNode(5);

        MyUtils.connectTreeNodes(pNode1, pNode21, pNode22);
        MyUtils.connectTreeNodes(pNode21, pNode31, null);
        MyUtils.connectTreeNodes(pNode22, null, pNode32);
        MyUtils.connectTreeNodes(pNode31, pNode41, null);
        MyUtils.connectTreeNodes(pNode32, null, pNode42);
        MyUtils.connectTreeNodes(pNode41, null, null);
        MyUtils.connectTreeNodes(pNode42, null, null);

        Test("Test9", pNode1, true);
    }

    // 所有结点都有相同的值，树不对称
//               5
//              / \
//             5   5
//            /     \
//           5       5
//          /       /
//         5       5
    private static void Test10() {
        BinaryTreeNode pNode1 = MyUtils.createBinaryTreeNode(5);
        BinaryTreeNode pNode21 = MyUtils.createBinaryTreeNode(5);
        BinaryTreeNode pNode22 = MyUtils.createBinaryTreeNode(5);
        BinaryTreeNode pNode31 = MyUtils.createBinaryTreeNode(5);
        BinaryTreeNode pNode32 = MyUtils.createBinaryTreeNode(5);
        BinaryTreeNode pNode41 = MyUtils.createBinaryTreeNode(5);
        BinaryTreeNode pNode42 = MyUtils.createBinaryTreeNode(5);

        MyUtils.connectTreeNodes(pNode1, pNode21, pNode22);
        MyUtils.connectTreeNodes(pNode21, pNode31, null);
        MyUtils.connectTreeNodes(pNode22, null, pNode32);
        MyUtils.connectTreeNodes(pNode31, pNode41, null);
        MyUtils.connectTreeNodes(pNode32, pNode42, null);
        MyUtils.connectTreeNodes(pNode41, null, null);
        MyUtils.connectTreeNodes(pNode42, null, null);

        Test("Test10", pNode1, false);


    }

    public static void main(String[] args) {
        Test1();
        Test2();
        Test3();
        Test4();
        Test5();
        Test6();
        Test7();
        Test8();
        Test9();
        Test10();
    }
}
