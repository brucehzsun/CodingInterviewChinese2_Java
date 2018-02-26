package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;

import java.util.Stack;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _09_QueueWithTwoStacks {

    /**
     * 面试题9：用两个栈实现队列
     * 题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail
     * 和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。
     */
    static class Queue<T> {
        private Stack<T> stack1 = new Stack<>();
        private Stack<T> stack2 = new Stack<>();

        public void appendTail(T t) {
            stack1.push(t);
        }

        public T deleteHead() throws Exception {
            if (stack2.empty()) {
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
            }
            if (stack2.empty()) {
                throw new Exception("Queue is empty!");
            }
            return stack2.pop();
        }
    }

    // ====================测试代码====================
    private static void Test(String actual, String expected) {
        if (expected.equals(actual))
            MyUtils.print("test passed.\n");
        else
            MyUtils.print("test failed.\n");
    }

    public static void main(String[] argv) {
        try {
            Queue<String> queue = new Queue<String>();

            queue.appendTail("a");
            queue.appendTail("b");
            queue.appendTail("c");

            String head = queue.deleteHead();
            Test(head, "a");

            head = queue.deleteHead();
            Test(head, "b");

            queue.appendTail("d");
            head = queue.deleteHead();
            Test(head, "c");

            queue.appendTail("e");
            head = queue.deleteHead();
            Test(head, "d");

            head = queue.deleteHead();
            Test(head, "e");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
