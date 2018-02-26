package com.bruce.sun;

import com.bruce.sun.domain.ListNode;
import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _22_KthNodeFromEnd {

    /**
     * 面试题22：链表中倒数第k个结点
     * 题目：输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，
     * 本题从1开始计数，即链表的尾结点是倒数第1个结点。
     * 例如一个链表有6个结点，从头结点开始它们的值依次是1、2、3、4、5、6。
     * 这个链表的倒数第3个结点是值为4的结点。
     */
    private static ListNode findKthToTail(ListNode n1, int k) {
        if (n1 == null || k <= 0) {
            return null;
        }

        ListNode leftNode = n1;
        ListNode rightNode = n1;
        //先检查是否越界
        for (int i = 0; i < k; i++) {
            if (rightNode == null) {
                return null;
            }
            rightNode = rightNode.next;
        }

        //再循环找到需要的值
        while (rightNode != null) {
            rightNode = rightNode.next;
            leftNode = leftNode.next;
        }

        return leftNode;
    }


    // ====================测试代码====================
// 测试要找的结点在链表中间
    private static void Test1() {
        MyUtils.print("=====Test1 starts:=====\n");
        ListNode pNode1 = MyUtils.createListNode(1);
        ListNode pNode2 = MyUtils.createListNode(2);
        ListNode pNode3 = MyUtils.createListNode(3);
        ListNode pNode4 = MyUtils.createListNode(4);
        ListNode pNode5 = MyUtils.createListNode(5);

        MyUtils.connectListNodes(pNode1, pNode2);
        MyUtils.connectListNodes(pNode2, pNode3);
        MyUtils.connectListNodes(pNode3, pNode4);
        MyUtils.connectListNodes(pNode4, pNode5);

        MyUtils.print("expected result: 4.\n");
        ListNode pNode = findKthToTail(pNode1, 2);
        if (pNode != null && pNode.value == 4) {
            MyUtils.print("Test1 is passed\n");
        } else {
            if (pNode != null) {
                MyUtils.print("Test1 is Failed " + pNode.value + "\n");
            } else {
                MyUtils.print("Test1 is Failed\n");
            }
        }
    }

    // 测试要找的结点是链表的尾结点
    private static void Test2() {
        MyUtils.print("=====Test2 starts:=====\n");
        ListNode pNode1 = MyUtils.createListNode(1);
        ListNode pNode2 = MyUtils.createListNode(2);
        ListNode pNode3 = MyUtils.createListNode(3);
        ListNode pNode4 = MyUtils.createListNode(4);
        ListNode pNode5 = MyUtils.createListNode(5);

        MyUtils.connectListNodes(pNode1, pNode2);
        MyUtils.connectListNodes(pNode2, pNode3);
        MyUtils.connectListNodes(pNode3, pNode4);
        MyUtils.connectListNodes(pNode4, pNode5);

        MyUtils.print("expected result: 5.\n");
        ListNode pNode = findKthToTail(pNode1, 1);
        if (pNode != null && pNode.value == 5) {
            MyUtils.print("Test2 is passed\n");
        }
    }

    // 测试要找的结点是链表的头结点
    private static void Test3() {
        MyUtils.print("=====Test3 starts:=====\n");
        ListNode pNode1 = MyUtils.createListNode(1);
        ListNode pNode2 = MyUtils.createListNode(2);
        ListNode pNode3 = MyUtils.createListNode(3);
        ListNode pNode4 = MyUtils.createListNode(4);
        ListNode pNode5 = MyUtils.createListNode(5);

        MyUtils.connectListNodes(pNode1, pNode2);
        MyUtils.connectListNodes(pNode2, pNode3);
        MyUtils.connectListNodes(pNode3, pNode4);
        MyUtils.connectListNodes(pNode4, pNode5);

        MyUtils.print("expected result: 1.\n");
        ListNode pNode = findKthToTail(pNode1, 5);
        if (pNode != null && pNode.value == 1) {
            MyUtils.print("Test3 is passed\n");
        } else {
            if (pNode != null) {
                MyUtils.print("Test3 is Failed " + pNode.value + "\n");
            } else {
                MyUtils.print("Test3 is Failed\n");
            }
        }
    }

    // 测试空链表
    private static void Test4() {
        MyUtils.print("=====Test4 starts:=====\n");
        MyUtils.print("expected result: nullptr.\n");
        ListNode pNode = findKthToTail(null, 100);
        if (pNode == null) {
            MyUtils.print("Test4 is passed\n");
        }
    }

    // 测试输入的第二个参数大于链表的结点总数
    private static void Test5() {
        MyUtils.print("=====Test5 starts:=====\n");
        ListNode pNode1 = MyUtils.createListNode(1);
        ListNode pNode2 = MyUtils.createListNode(2);
        ListNode pNode3 = MyUtils.createListNode(3);
        ListNode pNode4 = MyUtils.createListNode(4);
        ListNode pNode5 = MyUtils.createListNode(5);

        MyUtils.connectListNodes(pNode1, pNode2);
        MyUtils.connectListNodes(pNode2, pNode3);
        MyUtils.connectListNodes(pNode3, pNode4);
        MyUtils.connectListNodes(pNode4, pNode5);

        MyUtils.print("expected result: nullptr.\n");
        ListNode pNode = findKthToTail(pNode1, 6);
        if (pNode == null) {
            MyUtils.print("Test5 is passed\n");
        }
    }

    // 测试输入的第二个参数为0
    private static void Test6() {
        MyUtils.print("=====Test6 starts:=====\n");
        ListNode pNode1 = MyUtils.createListNode(1);
        ListNode pNode2 = MyUtils.createListNode(2);
        ListNode pNode3 = MyUtils.createListNode(3);
        ListNode pNode4 = MyUtils.createListNode(4);
        ListNode pNode5 = MyUtils.createListNode(5);

        MyUtils.connectListNodes(pNode1, pNode2);
        MyUtils.connectListNodes(pNode2, pNode3);
        MyUtils.connectListNodes(pNode3, pNode4);
        MyUtils.connectListNodes(pNode4, pNode5);

        MyUtils.print("expected result: nullptr.\n");
        ListNode pNode = findKthToTail(pNode1, 0);
        if (pNode == null) {
            MyUtils.print("test6 is passed\n");
        }
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
