package com.bruce.sun;

import com.bruce.sun.domain.BinaryTreeNode;
import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _26_SubstructureInTree {

    /**
     * 面试题26：树的子结构
     * 题目：输入两棵二叉树A和B，判断B是不是A的子结构。
     */
    private static boolean hasSubtree(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2) {
        if (pRoot1 == null || pRoot2 == null) return false;

        boolean result = false;

        if (pRoot1.value == pRoot2.value) {
            result = doesTree1HaveTree2(pRoot1, pRoot2);
        }

        if (!result) {
            result = hasSubtree(pRoot1.left, pRoot2);
        }

        if (!result) {
            result = hasSubtree(pRoot1.right, pRoot2);
        }
        return result;
    }

    private static boolean doesTree1HaveTree2(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2) {
        if (pRoot2 == null) return true;
        if (pRoot1 == null) return false;

        if (pRoot1.value != pRoot2.value) {
            return false;
        }

        return doesTree1HaveTree2(pRoot1.left, pRoot2.left) &&
                doesTree1HaveTree2(pRoot1.right, pRoot2.right);
    }


    // ====================测试代码====================

    private static void Test(String testName, BinaryTreeNode pRoot1, BinaryTreeNode pRoot2, boolean expected) {
        if (hasSubtree(pRoot1, pRoot2) == expected)
            MyUtils.print(testName + " passed.\n");
        else
            MyUtils.print(testName + " failed.\n");
    }

    // 树中结点含有分叉，树B是树A的子结构
//                  8                8
//              /       \           / \
//             8         7         9   2
//           /   \
//          9     2
//               / \
//              4   7
    private static void Test1() {
        BinaryTreeNode pNodeA1 = MyUtils.createBinaryTreeNode(8);
        BinaryTreeNode pNodeA2 = MyUtils.createBinaryTreeNode(8);
        BinaryTreeNode pNodeA3 = MyUtils.createBinaryTreeNode(7);
        BinaryTreeNode pNodeA4 = MyUtils.createBinaryTreeNode(9);
        BinaryTreeNode pNodeA5 = MyUtils.createBinaryTreeNode(2);
        BinaryTreeNode pNodeA6 = MyUtils.createBinaryTreeNode(4);
        BinaryTreeNode pNodeA7 = MyUtils.createBinaryTreeNode(7);

        MyUtils.connectTreeNodes(pNodeA1, pNodeA2, pNodeA3);
        MyUtils.connectTreeNodes(pNodeA2, pNodeA4, pNodeA5);
        MyUtils.connectTreeNodes(pNodeA5, pNodeA6, pNodeA7);

        BinaryTreeNode pNodeB1 = MyUtils.createBinaryTreeNode(8);
        BinaryTreeNode pNodeB2 = MyUtils.createBinaryTreeNode(9);
        BinaryTreeNode pNodeB3 = MyUtils.createBinaryTreeNode(2);

        MyUtils.connectTreeNodes(pNodeB1, pNodeB2, pNodeB3);

        Test("Test1", pNodeA1, pNodeB1, true);

    }

    // 树中结点含有分叉，树B不是树A的子结构
//                  8                8
//              /       \           / \
//             8         7         9   2
//           /   \
//          9     3
//               / \
//              4   7
    private static void Test2() {
        BinaryTreeNode pNodeA1 = MyUtils.createBinaryTreeNode(8);
        BinaryTreeNode pNodeA2 = MyUtils.createBinaryTreeNode(8);
        BinaryTreeNode pNodeA3 = MyUtils.createBinaryTreeNode(7);
        BinaryTreeNode pNodeA4 = MyUtils.createBinaryTreeNode(9);
        BinaryTreeNode pNodeA5 = MyUtils.createBinaryTreeNode(3);
        BinaryTreeNode pNodeA6 = MyUtils.createBinaryTreeNode(4);
        BinaryTreeNode pNodeA7 = MyUtils.createBinaryTreeNode(7);

        MyUtils.connectTreeNodes(pNodeA1, pNodeA2, pNodeA3);
        MyUtils.connectTreeNodes(pNodeA2, pNodeA4, pNodeA5);
        MyUtils.connectTreeNodes(pNodeA5, pNodeA6, pNodeA7);

        BinaryTreeNode pNodeB1 = MyUtils.createBinaryTreeNode(8);
        BinaryTreeNode pNodeB2 = MyUtils.createBinaryTreeNode(9);
        BinaryTreeNode pNodeB3 = MyUtils.createBinaryTreeNode(2);

        MyUtils.connectTreeNodes(pNodeB1, pNodeB2, pNodeB3);

        Test("Test2", pNodeA1, pNodeB1, false);

    }

    // 树中结点只有左子结点，树B是树A的子结构
//                8                  8
//              /                   /
//             8                   9
//           /                    /
//          9                    2
//         /
//        2
//       /
//      5
    private static void Test3() {
        BinaryTreeNode pNodeA1 = MyUtils.createBinaryTreeNode(8);
        BinaryTreeNode pNodeA2 = MyUtils.createBinaryTreeNode(8);
        BinaryTreeNode pNodeA3 = MyUtils.createBinaryTreeNode(9);
        BinaryTreeNode pNodeA4 = MyUtils.createBinaryTreeNode(2);
        BinaryTreeNode pNodeA5 = MyUtils.createBinaryTreeNode(5);

        MyUtils.connectTreeNodes(pNodeA1, pNodeA2, null);
        MyUtils.connectTreeNodes(pNodeA2, pNodeA3, null);
        MyUtils.connectTreeNodes(pNodeA3, pNodeA4, null);
        MyUtils.connectTreeNodes(pNodeA4, pNodeA5, null);

        BinaryTreeNode pNodeB1 = MyUtils.createBinaryTreeNode(8);
        BinaryTreeNode pNodeB2 = MyUtils.createBinaryTreeNode(9);
        BinaryTreeNode pNodeB3 = MyUtils.createBinaryTreeNode(2);

        MyUtils.connectTreeNodes(pNodeB1, pNodeB2, null);
        MyUtils.connectTreeNodes(pNodeB2, pNodeB3, null);

        Test("Test3", pNodeA1, pNodeB1, true);
    }

    // 树中结点只有左子结点，树B不是树A的子结构
//                8                  8
//              /                   /
//             8                   9
//           /                    /
//          9                    3
//         /
//        2
//       /
//      5
    private static void Test4() {
        BinaryTreeNode pNodeA1 = MyUtils.createBinaryTreeNode(8);
        BinaryTreeNode pNodeA2 = MyUtils.createBinaryTreeNode(8);
        BinaryTreeNode pNodeA3 = MyUtils.createBinaryTreeNode(9);
        BinaryTreeNode pNodeA4 = MyUtils.createBinaryTreeNode(2);
        BinaryTreeNode pNodeA5 = MyUtils.createBinaryTreeNode(5);

        MyUtils.connectTreeNodes(pNodeA1, pNodeA2, null);
        MyUtils.connectTreeNodes(pNodeA2, pNodeA3, null);
        MyUtils.connectTreeNodes(pNodeA3, pNodeA4, null);
        MyUtils.connectTreeNodes(pNodeA4, pNodeA5, null);

        BinaryTreeNode pNodeB1 = MyUtils.createBinaryTreeNode(8);
        BinaryTreeNode pNodeB2 = MyUtils.createBinaryTreeNode(9);
        BinaryTreeNode pNodeB3 = MyUtils.createBinaryTreeNode(3);

        MyUtils.connectTreeNodes(pNodeB1, pNodeB2, null);
        MyUtils.connectTreeNodes(pNodeB2, pNodeB3, null);

        Test("Test4", pNodeA1, pNodeB1, false);
    }

    // 树中结点只有右子结点，树B是树A的子结构
//       8                   8
//        \                   \
//         8                   9
//          \                   \
//           9                   2
//            \
//             2
//              \
//               5
    private static void Test5() {
        BinaryTreeNode pNodeA1 = MyUtils.createBinaryTreeNode(8);
        BinaryTreeNode pNodeA2 = MyUtils.createBinaryTreeNode(8);
        BinaryTreeNode pNodeA3 = MyUtils.createBinaryTreeNode(9);
        BinaryTreeNode pNodeA4 = MyUtils.createBinaryTreeNode(2);
        BinaryTreeNode pNodeA5 = MyUtils.createBinaryTreeNode(5);

        MyUtils.connectTreeNodes(pNodeA1, null, pNodeA2);
        MyUtils.connectTreeNodes(pNodeA2, null, pNodeA3);
        MyUtils.connectTreeNodes(pNodeA3, null, pNodeA4);
        MyUtils.connectTreeNodes(pNodeA4, null, pNodeA5);

        BinaryTreeNode pNodeB1 = MyUtils.createBinaryTreeNode(8);
        BinaryTreeNode pNodeB2 = MyUtils.createBinaryTreeNode(9);
        BinaryTreeNode pNodeB3 = MyUtils.createBinaryTreeNode(2);

        MyUtils.connectTreeNodes(pNodeB1, null, pNodeB2);
        MyUtils.connectTreeNodes(pNodeB2, null, pNodeB3);

        Test("Test5", pNodeA1, pNodeB1, true);

    }

    // 树A中结点只有右子结点，树B不是树A的子结构
//       8                   8
//        \                   \
//         8                   9
//          \                 / \
//           9               3   2
//            \
//             2
//              \
//               5
    private static void Test6() {
        BinaryTreeNode pNodeA1 = MyUtils.createBinaryTreeNode(8);
        BinaryTreeNode pNodeA2 = MyUtils.createBinaryTreeNode(8);
        BinaryTreeNode pNodeA3 = MyUtils.createBinaryTreeNode(9);
        BinaryTreeNode pNodeA4 = MyUtils.createBinaryTreeNode(2);
        BinaryTreeNode pNodeA5 = MyUtils.createBinaryTreeNode(5);

        MyUtils.connectTreeNodes(pNodeA1, null, pNodeA2);
        MyUtils.connectTreeNodes(pNodeA2, null, pNodeA3);
        MyUtils.connectTreeNodes(pNodeA3, null, pNodeA4);
        MyUtils.connectTreeNodes(pNodeA4, null, pNodeA5);

        BinaryTreeNode pNodeB1 = MyUtils.createBinaryTreeNode(8);
        BinaryTreeNode pNodeB2 = MyUtils.createBinaryTreeNode(9);
        BinaryTreeNode pNodeB3 = MyUtils.createBinaryTreeNode(3);
        BinaryTreeNode pNodeB4 = MyUtils.createBinaryTreeNode(2);

        MyUtils.connectTreeNodes(pNodeB1, null, pNodeB2);
        MyUtils.connectTreeNodes(pNodeB2, pNodeB3, pNodeB4);

        Test("Test6", pNodeA1, pNodeB1, false);

    }

    // 树A为空树
    private static void Test7() {
        BinaryTreeNode pNodeB1 = MyUtils.createBinaryTreeNode(8);
        BinaryTreeNode pNodeB2 = MyUtils.createBinaryTreeNode(9);
        BinaryTreeNode pNodeB3 = MyUtils.createBinaryTreeNode(3);
        BinaryTreeNode pNodeB4 = MyUtils.createBinaryTreeNode(2);

        MyUtils.connectTreeNodes(pNodeB1, null, pNodeB2);
        MyUtils.connectTreeNodes(pNodeB2, pNodeB3, pNodeB4);

        Test("Test7", null, pNodeB1, false);
    }

    // 树B为空树
    private static void Test8() {
        BinaryTreeNode pNodeA1 = MyUtils.createBinaryTreeNode(8);
        BinaryTreeNode pNodeA2 = MyUtils.createBinaryTreeNode(9);
        BinaryTreeNode pNodeA3 = MyUtils.createBinaryTreeNode(3);
        BinaryTreeNode pNodeA4 = MyUtils.createBinaryTreeNode(2);

        MyUtils.connectTreeNodes(pNodeA1, null, pNodeA2);
        MyUtils.connectTreeNodes(pNodeA2, pNodeA3, pNodeA4);

        Test("Test8", pNodeA1, null, false);
    }

    // 树A和树B都为空
    private static void Test9() {
        Test("Test9", null, null, false);
    }

    public static void main(String[] argv) {
        Test1();
        Test2();
        Test3();
        Test4();
        Test5();
        Test6();
        Test7();
        Test8();
        Test9();
    }
}
