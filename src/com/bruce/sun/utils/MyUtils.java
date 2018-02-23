package com.bruce.sun.utils;

import com.bruce.sun.domain.ListNode;

public class MyUtils {

    public static void print(int i) {
        System.out.print(i);
    }

    public static void print(String i) {
        System.out.print(i);
    }

    public static ListNode createListNode(int value) {
        ListNode pNode = new ListNode();
        pNode.value = value;
        return pNode;
    }

    public static void connectListNodes(ListNode pCurrent, ListNode pNext) {
        if (pCurrent == null) {
            MyUtils.print("Error to connect two nodes.\n");
            System.exit(1);
        }

        pCurrent.next = pNext;
    }

    public static void printList(ListNode pHead) {
        MyUtils.print("PrintList starts.\n");

        ListNode pNode = pHead;
        while (pNode != null) {
            MyUtils.print(pNode.value + "\t");
            pNode = pNode.next;
        }

        MyUtils.print("\nPrintList ends.\n");
    }
}
