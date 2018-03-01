package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;

import static com.bruce.sun.QuickSort.partition;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _39_MoreThanHalfNumber {

    /**
     * 面试题39：数组中出现次数超过一半的数字
     * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 例如输入一个长度为9的数组{1, 2, 3, 2, 2, 2, 5, 4, 2}。
     * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
     */
    public static void main(String[] args) {

        int[] data = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};

        try {
            int result = moreThanHalfNum_Solution1(data);
            int result2 = moreThanHalfNum_Solution2(data);
            if (result == 2 && result2 == 2) {
                MyUtils.print("Pass !");
            } else {
                MyUtils.print("failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用两个变量。
     * 一个记录个数。
     * 一个记录数字
     *
     * @param data
     * @return
     */
    private static int moreThanHalfNum_Solution2(int[] data) {
        if (data == null || data.length == 0) {
            return 0;
        }

        int result = 0;
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (count == 0) {
                result = data[i];
                count = 1;
            } else if (data[i] == result) {
                count++;
            } else {
                count--;
            }
        }

        if (!CheckMoreThanHalf(data, result)) {
            return 0;
        }
        return result;
    }

    /**
     * 排序方式解决，找到中位数
     *
     * @param data
     * @return
     * @throws Exception
     */
    private static int moreThanHalfNum_Solution1(int[] data) throws Exception {
        if (data == null || data.length == 0) {
            throw new Exception("Invalid params");
        }

        int middle = data.length >> 1;
        int start = 0;
        int end = data.length - 1;
        int index = partition(data, start, end);
        while (index != middle) {
            if (index > middle) {
                end = index - 1;
                index = partition(data, start, end);
            } else {
                start = index + 1;
                index = partition(data, start, end);
            }
        }

        int result = data[middle];
        if (!CheckMoreThanHalf(data, result)) {
            return 0;
        }
        return result;
    }


    private static boolean CheckMoreThanHalf(int[] numbers, int number) {
        int times = 0;
        for (int i = 0; i < numbers.length; ++i) {
            if (numbers[i] == number)
                times++;
        }

        boolean isMoreThanHalf = true;
        if (times * 2 <= numbers.length) {
            isMoreThanHalf = false;
        }

        return isMoreThanHalf;
    }


}
