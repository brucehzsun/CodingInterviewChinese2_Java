package com.bruce.sun;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
//==================================================================

import com.bruce.sun.utils.MyUtils;

/**
 * 面试题4：二维数组中的查找
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按
 * 照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个
 * 整数，判断数组中是否含有该整数。
 */
public class _04_FindInPartiallySortedMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };

        boolean include = findInMatrix(matrix, 7);
        if (include) {
            MyUtils.print("Pass! \n");
        } else {
            MyUtils.print("Failed :( \n");
        }

        boolean include5 = findInMatrix(matrix, 5);
        if (!include5) {
            MyUtils.print("Pass! \n");
        } else {
            MyUtils.print("Failed :( \n");
        }
    }

    private static boolean findInMatrix(int[][] matrix, int num) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        boolean fond = false;

        int rows = matrix.length;
        int columns = matrix[0].length;

        int curRow = 0;
        int curCol = columns - 1;
        while (curRow < rows && curCol >= 0) {
            int curNum = matrix[curRow][curCol];
            if (curNum == num) {
                fond = true;
                break;
            } else if (curNum > num) {
                curCol--;
            } else if (curNum < num) {
                curRow++;
            }
        }

        return fond;
    }
}
