package com.bruce.sun;

import com.bruce.sun.domain.ListNode;
import com.bruce.sun.utils.MyUtils;

import java.util.Stack;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _52_FirstCommonNodesInLists {

    /**
     * 面试题52：两个链表的第一个公共结点
     * 题目：输入两个链表，找出它们的第一个公共结点。
     */

    /**
     * 不使用辅助栈
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    private static ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;

        //获得两个链表的长度
        int length1 = getLength(pHead1);
        int length2 = getLength(pHead2);

        //长链表多余的step
        ListNode longNode = pHead1;
        ListNode shortNode = pHead2;
        int step = length1 - length2;
        if (length1 < length2) {
            longNode = pHead2;
            shortNode = pHead1;
            step = length2 - length1;
        }
        //长链表先走
        for (int i = 0; i < step; i++) {
            longNode = longNode.next;
        }

        //两个链表同时走。第一个相等的节点就是公共节点
        while (longNode != null && shortNode != null) {
            if (longNode == shortNode) {
                return longNode;
            }
            longNode = longNode.next;
            shortNode = shortNode.next;
        }
        return null;
    }

    private static int getLength(ListNode root) {
        if (root == null) return 0;
        ListNode node = root;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    /**
     * 使用辅助栈
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    private static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;

        Stack<ListNode> stack1 = new Stack<>();
        ListNode node = pHead1;
        while (node != null) {
            stack1.push(node);
            node = node.next;
        }

        Stack<ListNode> stack2 = new Stack<>();
        node = pHead2;
        while (node != null) {
            stack2.push(node);
            node = node.next;
        }

        ListNode result = null;
        while (!stack1.empty() && !stack2.empty()) {
            ListNode pop1 = stack1.pop();
            ListNode pop2 = stack2.pop();
            if (pop1 == pop2) {
                result = pop1;
            }
        }

        return result;
    }


    // ====================测试代码====================

    static void Test(String testName, ListNode pHead1, ListNode pHead2, ListNode pExpected) {
        if (testName != null)
            MyUtils.print(testName + " begins: ");

        ListNode pResult = FindFirstCommonNode(pHead1, pHead2);
        ListNode pResult2 = FindFirstCommonNode2(pHead1, pHead2);
        if (pResult == pExpected && pResult2 == pExpected)
            MyUtils.print("Passed.\n");
        else
            MyUtils.print("Failed.\n");
    }


    // 第一个公共结点在链表中间
// 1 - 2 - 3 \
//            6 - 7
//     4 - 5 /
    static void Test1() {
        ListNode pNode1 = MyUtils.createListNode(1);
        ListNode pNode2 = MyUtils.createListNode(2);
        ListNode pNode3 = MyUtils.createListNode(3);
        ListNode pNode4 = MyUtils.createListNode(4);
        ListNode pNode5 = MyUtils.createListNode(5);
        ListNode pNode6 = MyUtils.createListNode(6);
        ListNode pNode7 = MyUtils.createListNode(7);

        MyUtils.connectListNodes(pNode1, pNode2);
        MyUtils.connectListNodes(pNode2, pNode3);
        MyUtils.connectListNodes(pNode3, pNode6);
        MyUtils.connectListNodes(pNode4, pNode5);
        MyUtils.connectListNodes(pNode5, pNode6);
        MyUtils.connectListNodes(pNode6, pNode7);

        Test("Test1", pNode1, pNode4, pNode6);

    }

    // 没有公共结点
// 1 - 2 - 3 - 4
//            
// 5 - 6 - 7
    static void Test2() {
        ListNode pNode1 = MyUtils.createListNode(1);
        ListNode pNode2 = MyUtils.createListNode(2);
        ListNode pNode3 = MyUtils.createListNode(3);
        ListNode pNode4 = MyUtils.createListNode(4);
        ListNode pNode5 = MyUtils.createListNode(5);
        ListNode pNode6 = MyUtils.createListNode(6);
        ListNode pNode7 = MyUtils.createListNode(7);

        MyUtils.connectListNodes(pNode1, pNode2);
        MyUtils.connectListNodes(pNode2, pNode3);
        MyUtils.connectListNodes(pNode3, pNode4);
        MyUtils.connectListNodes(pNode5, pNode6);
        MyUtils.connectListNodes(pNode6, pNode7);

        Test("Test2", pNode1, pNode5, null);

    }

    // 公共结点是最后一个结点
// 1 - 2 - 3 - 4 \
//                7
//         5 - 6 /
    static void Test3() {
        ListNode pNode1 = MyUtils.createListNode(1);
        ListNode pNode2 = MyUtils.createListNode(2);
        ListNode pNode3 = MyUtils.createListNode(3);
        ListNode pNode4 = MyUtils.createListNode(4);
        ListNode pNode5 = MyUtils.createListNode(5);
        ListNode pNode6 = MyUtils.createListNode(6);
        ListNode pNode7 = MyUtils.createListNode(7);

        MyUtils.connectListNodes(pNode1, pNode2);
        MyUtils.connectListNodes(pNode2, pNode3);
        MyUtils.connectListNodes(pNode3, pNode4);
        MyUtils.connectListNodes(pNode4, pNode7);
        MyUtils.connectListNodes(pNode5, pNode6);
        MyUtils.connectListNodes(pNode6, pNode7);

        Test("Test3", pNode1, pNode5, pNode7);

    }

    // 公共结点是第一个结点
// 1 - 2 - 3 - 4 - 5
// 两个链表完全重合   
    static void Test4() {
        ListNode pNode1 = MyUtils.createListNode(1);
        ListNode pNode2 = MyUtils.createListNode(2);
        ListNode pNode3 = MyUtils.createListNode(3);
        ListNode pNode4 = MyUtils.createListNode(4);
        ListNode pNode5 = MyUtils.createListNode(5);

        MyUtils.connectListNodes(pNode1, pNode2);
        MyUtils.connectListNodes(pNode2, pNode3);
        MyUtils.connectListNodes(pNode3, pNode4);
        MyUtils.connectListNodes(pNode4, pNode5);

        Test("Test4", pNode1, pNode1, pNode1);

    }

    // 输入的两个链表有一个空链表
    static void Test5() {
        ListNode pNode1 = MyUtils.createListNode(1);
        ListNode pNode2 = MyUtils.createListNode(2);
        ListNode pNode3 = MyUtils.createListNode(3);
        ListNode pNode4 = MyUtils.createListNode(4);
        ListNode pNode5 = MyUtils.createListNode(5);

        MyUtils.connectListNodes(pNode1, pNode2);
        MyUtils.connectListNodes(pNode2, pNode3);
        MyUtils.connectListNodes(pNode3, pNode4);
        MyUtils.connectListNodes(pNode4, pNode5);

        Test("Test5", null, pNode1, null);
    }

    // 输入的两个链表有一个空链表
    static void Test6() {
        Test("Test6", null, null, null);
    }


    public static void main(String[] args) {
        Test1();
        Test2();
        Test3();
        Test4();
        Test5();
        Test6();
    }
}
