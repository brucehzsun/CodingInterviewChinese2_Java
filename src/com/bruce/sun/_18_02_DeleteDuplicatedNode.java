package com.bruce.sun;

import com.bruce.sun.domain.ListNode;
import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _18_02_DeleteDuplicatedNode {

    /**
     * 面试题18（二）：删除链表中重复的结点
     * 题目：在一个排序的链表中，如何删除重复的结点？例如，在图3.4（a）中重复结点被删除之后，链表如图3.4（b）所示。
     */
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

    private static ListNode DeleteDuplication(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode preNode = null;
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;

            boolean needDelete = false;
            if (next != null && node.value == next.value) {
                needDelete = true;
            }

            if (!needDelete) {
                //节点不需要删除。继续迭代
                preNode = node;
                node = node.next;
            } else {
                //节点需要删除

                //找到需要删除的节点。和下一个节点
                int value = node.value;
                ListNode toBeDelete = node;
                while (toBeDelete != null && toBeDelete.value == value) {
                    next = toBeDelete.next;
                    toBeDelete = next;
                }

                if (preNode == null) {
                    //第一个就需要删除
                    head = next;
                } else {
                    preNode.next = next;
                }
                //迭代
                node = next;
            }
        }
        return head;
    }


    // ====================测试代码====================
    private static void Test(String testName, ListNode pHead, int[] expectedValues) {
        if (testName != null)
            MyUtils.print(testName + " begins: ");

        pHead = DeleteDuplication(pHead);

        int length = 0;
        if (expectedValues == null) {
            length = 0;
        } else {
            length = expectedValues.length;
        }

        int index = 0;
        ListNode pNode = pHead;
        while (pNode != null & index < length) {
            if (pNode.value != expectedValues[index])
                break;

            pNode = pNode.next;
            index++;
        }

        if (pNode == null & index == length)
            MyUtils.print("Passed.\n");
        else
            MyUtils.print("FAILED.\n");
    }

    // 某些结点是重复的
    static void Test1() {
        ListNode pNode1 = MyUtils.createListNode(1);
        ListNode pNode2 = MyUtils.createListNode(2);
        ListNode pNode3 = MyUtils.createListNode(3);
        ListNode pNode4 = MyUtils.createListNode(3);
        ListNode pNode5 = MyUtils.createListNode(4);
        ListNode pNode6 = MyUtils.createListNode(4);
        ListNode pNode7 = MyUtils.createListNode(5);

        MyUtils.connectListNodes(pNode1, pNode2);
        MyUtils.connectListNodes(pNode2, pNode3);
        MyUtils.connectListNodes(pNode3, pNode4);
        MyUtils.connectListNodes(pNode4, pNode5);
        MyUtils.connectListNodes(pNode5, pNode6);
        MyUtils.connectListNodes(pNode6, pNode7);

        ListNode pHead = pNode1;

        int expectedValues[] = {1, 2, 5};
        Test("Test1", pHead, expectedValues);
    }

    // 没有重复的结点
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
        MyUtils.connectListNodes(pNode4, pNode5);
        MyUtils.connectListNodes(pNode5, pNode6);
        MyUtils.connectListNodes(pNode6, pNode7);

        ListNode pHead = pNode1;

        int expectedValues[] = {1, 2, 3, 4, 5, 6, 7};
        Test("Test2", pHead, expectedValues);
    }

    // 除了一个结点之外其他所有结点的值都相同
    static void Test3() {
        ListNode pNode1 = MyUtils.createListNode(1);
        ListNode pNode2 = MyUtils.createListNode(1);
        ListNode pNode3 = MyUtils.createListNode(1);
        ListNode pNode4 = MyUtils.createListNode(1);
        ListNode pNode5 = MyUtils.createListNode(1);
        ListNode pNode6 = MyUtils.createListNode(1);
        ListNode pNode7 = MyUtils.createListNode(2);

        MyUtils.connectListNodes(pNode1, pNode2);
        MyUtils.connectListNodes(pNode2, pNode3);
        MyUtils.connectListNodes(pNode3, pNode4);
        MyUtils.connectListNodes(pNode4, pNode5);
        MyUtils.connectListNodes(pNode5, pNode6);
        MyUtils.connectListNodes(pNode6, pNode7);

        ListNode pHead = pNode1;

        int expectedValues[] = {2};
        Test("Test3", pHead, expectedValues);

    }

    // 所有结点的值都相同
    static void Test4() {
        ListNode pNode1 = MyUtils.createListNode(1);
        ListNode pNode2 = MyUtils.createListNode(1);
        ListNode pNode3 = MyUtils.createListNode(1);
        ListNode pNode4 = MyUtils.createListNode(1);
        ListNode pNode5 = MyUtils.createListNode(1);
        ListNode pNode6 = MyUtils.createListNode(1);
        ListNode pNode7 = MyUtils.createListNode(1);

        MyUtils.connectListNodes(pNode1, pNode2);
        MyUtils.connectListNodes(pNode2, pNode3);
        MyUtils.connectListNodes(pNode3, pNode4);
        MyUtils.connectListNodes(pNode4, pNode5);
        MyUtils.connectListNodes(pNode5, pNode6);
        MyUtils.connectListNodes(pNode6, pNode7);

        ListNode pHead = pNode1;

        Test("Test4", pHead, null);


    }

    // 所有结点都成对出现
    static void Test5() {
        ListNode pNode1 = MyUtils.createListNode(1);
        ListNode pNode2 = MyUtils.createListNode(1);
        ListNode pNode3 = MyUtils.createListNode(2);
        ListNode pNode4 = MyUtils.createListNode(2);
        ListNode pNode5 = MyUtils.createListNode(3);
        ListNode pNode6 = MyUtils.createListNode(3);
        ListNode pNode7 = MyUtils.createListNode(4);
        ListNode pNode8 = MyUtils.createListNode(4);

        MyUtils.connectListNodes(pNode1, pNode2);
        MyUtils.connectListNodes(pNode2, pNode3);
        MyUtils.connectListNodes(pNode3, pNode4);
        MyUtils.connectListNodes(pNode4, pNode5);
        MyUtils.connectListNodes(pNode5, pNode6);
        MyUtils.connectListNodes(pNode6, pNode7);
        MyUtils.connectListNodes(pNode7, pNode8);

        ListNode pHead = pNode1;

        Test("Test5", pHead, null);


    }

    // 除了两个结点之外其他结点都成对出现
    static void Test6() {
        ListNode pNode1 = MyUtils.createListNode(1);
        ListNode pNode2 = MyUtils.createListNode(1);
        ListNode pNode3 = MyUtils.createListNode(2);
        ListNode pNode4 = MyUtils.createListNode(3);
        ListNode pNode5 = MyUtils.createListNode(3);
        ListNode pNode6 = MyUtils.createListNode(4);
        ListNode pNode7 = MyUtils.createListNode(5);
        ListNode pNode8 = MyUtils.createListNode(5);

        MyUtils.connectListNodes(pNode1, pNode2);
        MyUtils.connectListNodes(pNode2, pNode3);
        MyUtils.connectListNodes(pNode3, pNode4);
        MyUtils.connectListNodes(pNode4, pNode5);
        MyUtils.connectListNodes(pNode5, pNode6);
        MyUtils.connectListNodes(pNode6, pNode7);
        MyUtils.connectListNodes(pNode7, pNode8);

        ListNode pHead = pNode1;

        int expectedValues[] = {2, 4};
        Test("Test6", pHead, expectedValues);


    }

    // 链表中只有两个不重复的结点
    static void Test7() {
        ListNode pNode1 = MyUtils.createListNode(1);
        ListNode pNode2 = MyUtils.createListNode(2);

        MyUtils.connectListNodes(pNode1, pNode2);

        ListNode pHead = pNode1;

        int expectedValues[] = {1, 2};
        Test("Test7", pHead, expectedValues);


    }

    // 结点中只有一个结点
    static void Test8() {
        ListNode pNode1 = MyUtils.createListNode(1);

        MyUtils.connectListNodes(pNode1, null);

        ListNode pHead = pNode1;

        int expectedValues[] = {1};
        Test("Test8", pHead, expectedValues);


    }

    // 结点中只有两个重复的结点
    static void Test9() {
        ListNode pNode1 = MyUtils.createListNode(1);
        ListNode pNode2 = MyUtils.createListNode(1);

        MyUtils.connectListNodes(pNode1, pNode2);

        ListNode pHead = pNode1;

        Test("Test9", pHead, null);


    }

    // 空链表
    static void Test10() {
        ListNode pHead = null;

        Test("Test10", pHead, null);
    }

}
