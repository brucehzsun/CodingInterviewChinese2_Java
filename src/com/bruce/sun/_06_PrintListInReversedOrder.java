package com.bruce.sun;

import com.bruce.sun.domain.ListNode;
import com.bruce.sun.utils.MyUtils;

import java.util.Stack;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _06_PrintListInReversedOrder {

    /**
     * 面试题6：从尾到头打印链表
     * 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
     */
    public static void main(String[] args) {

        // 1->2->3->4->5
        MyUtils.print("\ntest1 begins.\n");

        ListNode pNode1 = MyUtils.createListNode(1);
        ListNode pNode2 = MyUtils.createListNode(2);
        ListNode pNode3 = MyUtils.createListNode(3);
        ListNode pNode4 = MyUtils.createListNode(4);
        ListNode pNode5 = MyUtils.createListNode(5);

        MyUtils.connectListNodes(pNode1, pNode2);
        MyUtils.connectListNodes(pNode2, pNode3);
        MyUtils.connectListNodes(pNode3, pNode4);
        MyUtils.connectListNodes(pNode4, pNode5);

        MyUtils.printList(pNode1);

        printReverseList(pNode1);
    }

    private static void printReverseList(ListNode root) {
        if (root == null) {
            MyUtils.print("Invalid input params");
            return;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        MyUtils.print("\nStart print reverse list\n");
        while (!stack.empty()) {
            MyUtils.print(stack.pop().value + "\t");
        }
    }
}
