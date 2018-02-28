package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
//==================================================================
public class _29_PrintMatrix {

    /**
     * 面试题29：顺时针打印矩阵
     * 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     */
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int crows = matrix.length;
        int columns = matrix[0].length;
        printMatrixInCircle(matrix, 0, crows - 1, 0, columns - 1);
    }

    private static void printMatrixInCircle(int[][] matrix, int crowStart, int crowEnd, int columnStart, int columnEnd) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        if (crowStart > crowEnd) return;
        if (columnStart > columnEnd) return;

        //打印上面；
        for (int i = columnStart; i <= columnEnd; i++) {
            MyUtils.print(matrix[crowStart][i] + "\t");
        }
        //打印右侧
        for (int i = crowStart + 1; i <= crowEnd; i++) {
            MyUtils.print(matrix[i][columnEnd] + "\t");
        }
        //打印下侧
        for (int i = columnEnd - 1; i >= columnStart; i--) {
            MyUtils.print(matrix[crowEnd][i] + "\t");
        }
        //打印左侧
        for (int i = crowEnd - 1; i >= crowStart + 1; i--) {
            MyUtils.print(matrix[i][columnStart] + "\t");
        }

        printMatrixInCircle(matrix, ++crowStart, --crowEnd, ++columnStart, --columnEnd);
    }

}
