package com.bruce.sun;

import com.bruce.sun.domain.ListNode;
import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _18_01_DeleteNodeInList {

    /**
     * 面试题18（一）：在O(1)时间删除链表结点
     * 题目：给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
     */
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();

    }

    /**
     * 面试题18（一）：在O(1)时间删除链表结点
     * 题目：给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
     */
    private static ListNode deleteNode(ListNode headNode, ListNode pNode) {
        if (headNode == null || pNode == null) {
            return null;
        }

        //要删除的节点不是尾节点：
        if (pNode.next != null) {
            ListNode nextNode = pNode.next;
            pNode.value = nextNode.value;
            pNode.next = nextNode.next;
        } else if (headNode == pNode) {//删除节点就是头节点
            return null;
        } else {
            //删除尾节点
            ListNode preNode = headNode;
            while (preNode.next != pNode) {
                preNode = preNode.next;
            }

            preNode.next = null;
        }
        return headNode;
    }

    // ====================测试代码====================
    static void test(ListNode pListHead, ListNode pNode) {
        MyUtils.print("The original list is: \t");
        MyUtils.printList(pListHead);

        MyUtils.print("The node to be deleted is: \t");
        if (pNode != null)
            MyUtils.print(pNode.value + "\n");

        pListHead = deleteNode(pListHead, pNode);

        MyUtils.print("The result list is: \t");
        MyUtils.printList(pListHead);
        MyUtils.print("\n");
    }


    // 链表中有多个结点，删除中间的结点
    static void test1() {
        ListNode pNode1 = MyUtils.createListNode(1);
        ListNode pNode2 = MyUtils.createListNode(2);
        ListNode pNode3 = MyUtils.createListNode(3);
        ListNode pNode4 = MyUtils.createListNode(4);
        ListNode pNode5 = MyUtils.createListNode(5);

        MyUtils.connectListNodes(pNode1, pNode2);
        MyUtils.connectListNodes(pNode2, pNode3);
        MyUtils.connectListNodes(pNode3, pNode4);
        MyUtils.connectListNodes(pNode4, pNode5);

        test(pNode1, pNode3);
    }

    // 链表中有多个结点，删除尾结点
    static void test2() {
        ListNode pNode1 = MyUtils.createListNode(1);
        ListNode pNode2 = MyUtils.createListNode(2);
        ListNode pNode3 = MyUtils.createListNode(3);
        ListNode pNode4 = MyUtils.createListNode(4);
        ListNode pNode5 = MyUtils.createListNode(5);

        MyUtils.connectListNodes(pNode1, pNode2);
        MyUtils.connectListNodes(pNode2, pNode3);
        MyUtils.connectListNodes(pNode3, pNode4);
        MyUtils.connectListNodes(pNode4, pNode5);

        test(pNode1, pNode5);
    }

    // 链表中有多个结点，删除头结点
    static void test3() {
        ListNode pNode1 = MyUtils.createListNode(1);
        ListNode pNode2 = MyUtils.createListNode(2);
        ListNode pNode3 = MyUtils.createListNode(3);
        ListNode pNode4 = MyUtils.createListNode(4);
        ListNode pNode5 = MyUtils.createListNode(5);

        MyUtils.connectListNodes(pNode1, pNode2);
        MyUtils.connectListNodes(pNode2, pNode3);
        MyUtils.connectListNodes(pNode3, pNode4);
        MyUtils.connectListNodes(pNode4, pNode5);

        test(pNode1, pNode1);
    }

    // 链表中只有一个结点，删除头结点
    static void test4() {
        ListNode pNode1 = MyUtils.createListNode(1);

        test(pNode1, pNode1);
    }

    // 链表为空
    static void test5() {
        test(null, null);
    }
}
