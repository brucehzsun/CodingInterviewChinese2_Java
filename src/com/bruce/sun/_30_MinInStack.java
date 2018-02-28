package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;

import java.util.Stack;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
//==================================================================
public class _30_MinInStack<T> {

    /**
     * 面试题30：包含min函数的栈
     * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。在
     * 该栈中，调用min、push及pop的时间复杂度都是O(1)。
     */
    static class StackWithMin {
        private Stack<Integer> stackMain = new Stack<>();
        private Stack<Integer> stackMin = new Stack<>();

        public void push(int value) {
            stackMain.push(value);
            if (stackMin.empty()) {
                stackMin.push(value);
            } else {
                int min = stackMin.peek();
                stackMin.push(value < min ? value : min);
            }
        }

        public int pop() throws Exception {
            if (stackMain.empty()) {
                throw new Exception("stack is null");
            }
            stackMin.pop();
            return stackMain.pop();
        }

        public int min() throws Exception {
            if (stackMin.empty()) {
                throw new Exception("stack is null");
            }

            return stackMin.peek();
        }
    }

    //============================= test =========================================
    static void Test(String testName, StackWithMin stack, int expected) throws Exception {
        if (testName != null)
            MyUtils.print("\n" + testName + " begins: ");

        if (stack.min() == expected)
            MyUtils.print("Passed.\n");
        else
            MyUtils.print("Failed.\n");
    }

    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();

        try {
            stack.push(3);
            Test("Test1", stack, 3);
            stack.push(4);
            Test("Test2", stack, 3);

            stack.push(2);
            Test("Test3", stack, 2);

            stack.push(3);
            Test("Test4", stack, 2);

            stack.pop();
            Test("Test5", stack, 2);

            stack.pop();
            Test("Test6", stack, 3);

            stack.pop();
            Test("Test7", stack, 3);

            stack.push(0);
            Test("Test8", stack, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
