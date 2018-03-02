package com.bruce.sun;

import com.bruce.sun.domain.BinaryTreeNode;
import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _55_02_BalancedBinaryTree {

    /**
     * 面试题55（二）：平衡二叉树
     * 题目：输入一棵二叉树的根结点，判断该树是不是平衡二叉树。
     * 如果某二叉树中任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
     *
     * @param pRoot
     * @return
     */
    private static boolean IsBalanced_Solution2(BinaryTreeNode pRoot) {
        return isBalanced(pRoot) != -1;
    }

    /**
     * 使用后序排列，判断是否是平衡二叉树。
     *
     * @param pRoot
     * @return
     */
    private static int isBalanced(BinaryTreeNode pRoot) {
        if (pRoot == null) {
            return 0;
        }

        int leftDepth = isBalanced(pRoot.left);
        int rightDepth = isBalanced(pRoot.right);

        if (leftDepth != -1 && rightDepth != -1) {
            int dif = leftDepth - rightDepth;
            if (dif <= 1 && dif >= -1) {
                return (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
            }
        }

        return -1;
    }

    private static boolean IsBalanced_Solution1(BinaryTreeNode pRoot) {
        if (pRoot == null) return true;

        int left = getDeep(pRoot.left);
        int right = getDeep(pRoot.right);
        if (left - right > 1 || left - right < -1) {
            return false;
        }
        return IsBalanced_Solution1(pRoot.left) && IsBalanced_Solution1(pRoot.right);
    }

    private static int getDeep(BinaryTreeNode root) {
        if (root == null) return 0;
        int left = getDeep(root.left);
        int right = getDeep(root.right);
        return left > right ? left + 1 : right + 1;
    }


    // ====================测试代码====================

    static void Test(String testName, BinaryTreeNode pRoot, boolean expected) {
        if (testName != null)
            MyUtils.print(testName + " begins:\n");

        MyUtils.print("Solution1 begins: ");
        if (IsBalanced_Solution1(pRoot) == expected)
            MyUtils.print("Passed.\n");
        else
            MyUtils.print("Failed.\n");

        MyUtils.print("Solution2 begins: ");
        if (IsBalanced_Solution2(pRoot) == expected)
            MyUtils.print("Passed.\n");
        else
            MyUtils.print("Failed.\n");
    }


    // 完全二叉树
//             1
//         /      \
//        2        3
//       /\       / \
//      4  5     6   7
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
        MyUtils.connectTreeNodes(pNode3, pNode6, pNode7);

        Test("Test1", pNode1, true);


    }

    // 不是完全二叉树，但是平衡二叉树
//             1
//         /      \
//        2        3
//       /\         \
//      4  5         6
//        /
//       7
    static void Test2() {
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

        Test("Test2", pNode1, true);


    }

    // 不是平衡二叉树
//             1
//         /      \
//        2        3
//       /\         
//      4  5        
//        /
//       6
    static void Test3() {
        BinaryTreeNode pNode1 = MyUtils.createBinaryTreeNode(1);
        BinaryTreeNode pNode2 = MyUtils.createBinaryTreeNode(2);
        BinaryTreeNode pNode3 = MyUtils.createBinaryTreeNode(3);
        BinaryTreeNode pNode4 = MyUtils.createBinaryTreeNode(4);
        BinaryTreeNode pNode5 = MyUtils.createBinaryTreeNode(5);
        BinaryTreeNode pNode6 = MyUtils.createBinaryTreeNode(6);

        MyUtils.connectTreeNodes(pNode1, pNode2, pNode3);
        MyUtils.connectTreeNodes(pNode2, pNode4, pNode5);
        MyUtils.connectTreeNodes(pNode5, pNode6, null);

        Test("Test3", pNode1, false);


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
    static void Test4() {
        BinaryTreeNode pNode1 = MyUtils.createBinaryTreeNode(1);
        BinaryTreeNode pNode2 = MyUtils.createBinaryTreeNode(2);
        BinaryTreeNode pNode3 = MyUtils.createBinaryTreeNode(3);
        BinaryTreeNode pNode4 = MyUtils.createBinaryTreeNode(4);
        BinaryTreeNode pNode5 = MyUtils.createBinaryTreeNode(5);

        MyUtils.connectTreeNodes(pNode1, pNode2, null);
        MyUtils.connectTreeNodes(pNode2, pNode3, null);
        MyUtils.connectTreeNodes(pNode3, pNode4, null);
        MyUtils.connectTreeNodes(pNode4, pNode5, null);

        Test("Test4", pNode1, false);


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
    static void Test5() {
        BinaryTreeNode pNode1 = MyUtils.createBinaryTreeNode(1);
        BinaryTreeNode pNode2 = MyUtils.createBinaryTreeNode(2);
        BinaryTreeNode pNode3 = MyUtils.createBinaryTreeNode(3);
        BinaryTreeNode pNode4 = MyUtils.createBinaryTreeNode(4);
        BinaryTreeNode pNode5 = MyUtils.createBinaryTreeNode(5);

        MyUtils.connectTreeNodes(pNode1, null, pNode2);
        MyUtils.connectTreeNodes(pNode2, null, pNode3);
        MyUtils.connectTreeNodes(pNode3, null, pNode4);
        MyUtils.connectTreeNodes(pNode4, null, pNode5);

        Test("Test5", pNode1, false);


    }

    // 树中只有1个结点
    static void Test6() {
        BinaryTreeNode pNode1 = MyUtils.createBinaryTreeNode(1);
        Test("Test6", pNode1, true);


    }

    // 树中没有结点
    static void Test7() {
        Test("Test7", null, true);
    }

    public static void main(String[] args) {
        Test1();
        Test2();
        Test3();
        Test4();
        Test5();
        Test6();
        Test7();
    }
}
