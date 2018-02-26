package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;

public class QuickSort {

    public static void main(String[] argv) {
        int[] data = new int[]{4, 5, 1, 2, 9, 8, 6, 7, 3, 0};
        try {
            quickSort(data, 0, data.length - 1);
            for (int i = 0; i < data.length; i++) {
                MyUtils.print(data[i] + "\t");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void quickSort(int[] data, int left, int right) throws Exception {
        if (data == null || data.length == 0 || left == right) {
            return;
        }

        int index = partition(data, left, right);
        if (index > left) {
            quickSort(data, left, index - 1);
        }
        if (index < right) {
            quickSort(data, index + 1, right);
        }

    }

    public static int partition(int[] data, int left, int right) throws Exception {
        if (data == null || data.length == 0 || left < 0) {
            throw new Exception("invalid params");
        }

        if (left >= right) {
            return left;
        }

        int temp = data[left];//哨兵的临时存储
        int i = left;//左哨兵；基准哨兵
        int j = right;//右哨兵；
        while (i < j) {
            //右哨兵移动
            while (data[j] >= temp && i < j) {
                j--;
            }
            //左哨兵移动
            while (data[i] <= temp && i < j) {
                i++;
            }

            if (i < j) {
                MyUtils.swap(data, i, j);
            }
        }

        //左右哨兵碰撞，基准哨兵换位
        data[left] = data[i];
        data[i] = temp;

        return i;
    }


}
