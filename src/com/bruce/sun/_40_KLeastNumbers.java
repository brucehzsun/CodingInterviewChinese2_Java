package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _40_KLeastNumbers {

    /**
     * 面试题40：最小的k个数
     * 题目：输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8 这8个数字，
     * 则最小的4个数字是1、2、3、4。
     */
    public static void main(String[] args) {
        int[] data = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        try {
            int[] kLastNumbers = getLastKNumbers(data, 4);
            for (Integer i : kLastNumbers) {
                MyUtils.print(i + "\t");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用快速排序方法找到前四个；
     *
     * @param data
     * @param k
     * @return
     * @throws Exception
     */
    private static int[] getLastKNumbers(int[] data, int k) throws Exception {
        if (data == null || data.length < 4) {
            return null;
        }

        int start = 0;
        int end = data.length - 1;
        int index = partition(data, start, end);
        while (index != k) {
            if (index > k) {
                end = index - 1;
                index = partition(data, start, end);
            } else {
                start = index + 1;
                index = partition(data, start, end);
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = data[i];
        }

        return result;
    }

    private static int partition(int[] data, int left, int right) {
        if (data == null || data.length == 0 || left > right) {
            return 0;
        }

//        if (left == right) return left;

        int temp = data[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (data[i] < temp && i < j) {
                i++;
            }

            while (data[j] > temp && i < j) {
                j--;
            }

            //交换
            if (i < j) {
                MyUtils.swap(data, i, j);
            }
        }

        //左右哨兵碰撞，交换基准哨兵
        data[left] = data[i];
        data[i] = temp;

        return i;
    }
}
