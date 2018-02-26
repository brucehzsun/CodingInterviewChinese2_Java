package com.bruce.sun;

import com.bruce.sun.domain.ListNode;
import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _24_ReverseList {

    /**
     * 面试题24：反转链表
     * 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
     */
    public static void main(String[] args) {

        ListNode pNode1 = MyUtils.createListNode(1);
        ListNode pNode2 = MyUtils.createListNode(2);
        ListNode pNode3 = MyUtils.createListNode(3);
        ListNode pNode4 = MyUtils.createListNode(4);
        ListNode pNode5 = MyUtils.createListNode(5);
        ListNode pNode6 = MyUtils.createListNode(6);

        MyUtils.connectListNodes(pNode1, pNode2);
        MyUtils.connectListNodes(pNode2, pNode3);
        MyUtils.connectListNodes(pNode3, pNode4);
        MyUtils.connectListNodes(pNode4, pNode5);
        MyUtils.connectListNodes(pNode5, pNode6);

        ListNode result = reverseList(pNode1);
        MyUtils.printList(result);
    }

    private static ListNode reverseList(ListNode root) {
        if (root == null || root.next == null) {
            return null;
        }

        ListNode node = root;
        ListNode prevNode = null;
        ListNode newRootNode = null;
        while (node != null) {
            ListNode nextNode = node.next;
            if (nextNode == null) {
                //到结尾了。
                newRootNode = node;
            }

            node.next = prevNode;//指针改变方法

            //循环条件
            prevNode = node;
            node = nextNode;
        }

        return newRootNode;
    }
}
