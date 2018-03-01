package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _53_01_NumberOfK {

    /**
     * 面试题53（一）：数字在排序数组中出现的次数
     * 题目：统计一个数字在排序数组中出现的次数。例如输入排序数组{1, 2, 3, 3,3, 3, 4, 5}和数字3，
     * 由于3在这个数组中出现了4次，因此输出4。
     */
    private static int GetNumberOfK(int[] data, int k) {
        if (data == null || data.length == 0) return 0;

        int firstKIndex = getFirstKIndex(data, k);
        int endKIndex = getEndKIndex(data, k);
        if (firstKIndex != -1 && endKIndex != -1) {
            return endKIndex - firstKIndex + 1;
        }
        return 0;
    }

    private static int getEndKIndex(int[] data, int k) {
        int startPos = 0;
        int endPos = data.length - 1;
        int middle = 0;
        while (startPos <= endPos) {
            middle = (endPos + startPos) >> 1;
            if (k == data[middle]) {
                if (middle == endPos || (middle > 0 && data[middle + 1] != k)) {
                    return middle;
                } else {
                    startPos = middle + 1;
                }
            } else if (k > data[middle]) {
                startPos = middle + 1;
            } else {
                endPos = middle - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找，需要第一个k
     * {1, 2, 3, 3, 3, 3, 4, 5}
     */
    private static int getFirstKIndex(int[] data, int k) {

        int startPos = 0;
        int endPos = data.length - 1;
        int middle = 0;
        while (startPos <= endPos) {
            middle = (endPos + startPos) >> 1;
            if (k == data[middle]) {
                if (middle == 0 || (middle > 0 && data[middle - 1] != k)) {
                    return middle;
                } else {
                    endPos = middle - 1;
                }
            } else if (k <= data[middle]) {
                endPos = middle - 1;
            } else {
                startPos = middle + 1;
            }
        }
        return -1;
    }


    // ====================测试代码====================
    private static void Test(String testName, int data[], int k, int expected) {
        if (testName != null)
            MyUtils.print(testName + " begins: ");

        int result = GetNumberOfK(data, k);
        if (result == expected)
            MyUtils.print("Passed.\n");
        else
            MyUtils.print("Failed. " + result + "\n");
    }

    // 查找的数字出现在数组的中间
    static void Test1() {
        int data[] = {1, 2, 3, 3, 3, 3, 4, 5};
        Test("Test1", data, 3, 4);
    }

    // 查找的数组出现在数组的开头
    static void Test2() {
        int data[] = {3, 3, 3, 3, 4, 5};
        Test("Test2", data, 3, 4);
    }

    // 查找的数组出现在数组的结尾
    static void Test3() {
        int data[] = {1, 2, 3, 3, 3, 3};
        Test("Test3", data, 3, 4);
    }

    // 查找的数字不存在
    static void Test4() {
        int data[] = {1, 3, 3, 3, 3, 4, 5};
        Test("Test4", data, 2, 0);
    }

    // 查找的数字比第一个数字还小，不存在
    static void Test5() {
        int data[] = {1, 3, 3, 3, 3, 4, 5};
        Test("Test5", data, 0, 0);
    }

    // 查找的数字比最后一个数字还大，不存在
    static void Test6() {
        int data[] = {1, 3, 3, 3, 3, 4, 5};
        Test("Test6", data, 6, 0);
    }

    // 数组中的数字从头到尾都是查找的数字
    static void Test7() {
        int data[] = {3, 3, 3, 3};
        Test("Test7", data, 3, 4);
    }

    // 数组中的数字从头到尾只有一个重复的数字，不是查找的数字
    static void Test8() {
        int data[] = {3, 3, 3, 3};
        Test("Test8", data, 4, 0);
    }

    // 数组中只有一个数字，是查找的数字
    static void Test9() {
        int data[] = {3};
        Test("Test9", data, 3, 1);
    }

    // 数组中只有一个数字，不是查找的数字
    static void Test10() {
        int data[] = {3};
        Test("Test10", data, 4, 0);
    }

    // 鲁棒性测试，数组空指针
    static void Test11() {
        Test("Test11", null, 0, 0);
    }

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
        Test11();
    }
}
