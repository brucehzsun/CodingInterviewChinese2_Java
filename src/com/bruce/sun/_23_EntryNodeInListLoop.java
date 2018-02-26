package com.bruce.sun;

import com.bruce.sun.domain.ListNode;
import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _23_EntryNodeInListLoop {

    /**
     * 面试题23：链表中环的入口结点
     * 题目：一个链表中包含环，如何找出环的入口结点？例如，在图3.8的链表中，环的入口结点是结点3。
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
        MyUtils.connectListNodes(pNode6, pNode3);

        ListNode meetNode = entryNodeOfLoop(pNode1);
        if (meetNode != null && meetNode.value == 3) {
            MyUtils.print("Passed !");
        } else {
            if (meetNode != null) {
                MyUtils.print("Failed! value = " + meetNode.value);
            } else {
                MyUtils.print("Failed !");
            }
        }
    }

    private static ListNode entryNodeOfLoop(ListNode root) {

        //获得相遇节点
        ListNode meetNode = getMeetingNode(root);
        if (meetNode == null) {
            return null;
        }

        //获得loop的长度
        int loopLength = 0;
        ListNode fasterNode = meetNode;
        while (fasterNode.next != meetNode) {
            fasterNode = fasterNode.next;
            loopLength++;
        }
        MyUtils.print("loop length = " + loopLength + "\n");

        //先移动fasterNode。多走一步，faster才能和slow碰撞.所以i<= loopLength;
        fasterNode = root;
        for (int i = 0; i <= loopLength; i++) {
            fasterNode = fasterNode.next;
        }

        MyUtils.print("先移动的faster = " + fasterNode.value + "\n");

        //再一起移动,碰撞到一起的点就是交汇点
        ListNode slowNode = root;
        while (slowNode != fasterNode) {
            slowNode = slowNode.next;
            fasterNode = fasterNode.next;
        }
        return slowNode;
    }

    /**
     * 获取到相遇的节点
     */
    private static ListNode getMeetingNode(ListNode pNode1) {
        if (pNode1 == null || pNode1.next == null) {
            return null;
        }

        ListNode slowNode = pNode1;
        ListNode fasterNode = pNode1.next;
        while (slowNode != null && fasterNode != null) {
            if (fasterNode == slowNode) {
                return slowNode;
            }
            slowNode = slowNode.next;
            if (fasterNode.next != null) {
                fasterNode = fasterNode.next.next;
            }
        }

        return null;
    }
}
