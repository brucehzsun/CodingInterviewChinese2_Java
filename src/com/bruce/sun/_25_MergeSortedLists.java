package com.bruce.sun;


import com.bruce.sun.domain.ListNode;
import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _25_MergeSortedLists {

    /**
     * 面试题25：合并两个排序的链表
     * 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。
     * 例如输入图3.11中的链表1和链表2，则合并之后的升序链表如链表3所示。
     */
    public static void main(String[] args) {
        ListNode l1 = buildList1();
        ListNode l2 = buildList2();

        ListNode result = merge(l1, l2);
        MyUtils.printList(result);
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode mergedNode;
        if (l1.value <= l2.value) {
            mergedNode = l1;
            mergedNode.next = merge(l1.next, l2);
        } else {
            mergedNode = l2;
            mergedNode.next = merge(l1, l2.next);
        }
        return mergedNode;
    }

    private static ListNode buildList1() {
        ListNode pNode1 = MyUtils.createListNode(1);
        ListNode pNode3 = MyUtils.createListNode(3);
        ListNode pNode5 = MyUtils.createListNode(5);
        ListNode pNode7 = MyUtils.createListNode(7);

        MyUtils.connectListNodes(pNode1, pNode3);
        MyUtils.connectListNodes(pNode3, pNode5);
        MyUtils.connectListNodes(pNode5, pNode7);
        return pNode1;
    }

    private static ListNode buildList2() {
        ListNode pNode2 = MyUtils.createListNode(2);
        ListNode pNode4 = MyUtils.createListNode(4);
        ListNode pNode6 = MyUtils.createListNode(6);
        ListNode pNode8 = MyUtils.createListNode(8);

        MyUtils.connectListNodes(pNode2, pNode4);
        MyUtils.connectListNodes(pNode4, pNode6);
        MyUtils.connectListNodes(pNode6, pNode8);
        return pNode2;
    }
}
