package com.bruce.sun.utils;

import com.bruce.sun.domain.BinaryTreeNode;
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

    public static void connectTree(BinaryTreeNode root, BinaryTreeNode left, BinaryTreeNode right) {
        root.left = left;
        root.right = right;
    }

    public static void connectTreeParent(BinaryTreeNode root, BinaryTreeNode left, BinaryTreeNode right) {
        root.left = left;
        root.right = right;
        left.parent = root;
        right.parent = root;
    }

    public static boolean equalDouble(double num1, double num2) {
        if ((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001))
            return true;
        else
            return false;
    }

    public static void swap(int[] data, int startPos, int endPos) {
        int temp = data[startPos];
        data[startPos] = data[endPos];
        data[endPos] = temp;
    }

    public static BinaryTreeNode createBinaryTreeNode(int dbValue) {
        BinaryTreeNode pNode = new BinaryTreeNode(dbValue);
        return pNode;
    }

    public static void connectTreeNodes(BinaryTreeNode pParent, BinaryTreeNode pLeft, BinaryTreeNode pRight) {
        if (pParent != null) {
            pParent.left = pLeft;
            pParent.right = pRight;
        }
    }

    public static void printTree(BinaryTreeNode pRoot) {
        if (pRoot == null) {
            return;
        }

        MyUtils.print(pRoot.value + "\t");
        printTree(pRoot.left);
        printTree(pRoot.right);
    }
}
