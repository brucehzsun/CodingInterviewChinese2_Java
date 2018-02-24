package com.bruce.sun;

import com.bruce.sun.domain.BinaryTreeNode;
import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _07_ConstructBinaryTree {

    /**
     * 面试题7：重建二叉树
     * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输
     * 入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2, 4, 7, 3, 5, 6, 8}和中序遍历序列{4, 7, 2, 1, 5, 3, 8, 6}，
     * 则重建出 图2.6所示的二叉树并输出它的头结点。
     * 图2.6 普通二叉树
     * //              1
     * //           /     \
     * //          2       3
     * //         /       / \
     * //        4       5   6
     * //         \         /
     * //          7       8
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] preOrder = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode root = null;
        try {
            root = constructOrderTree(preOrder, inOrder);
            MyUtils.print("\n前序遍历: \t");
            BinaryTreeTraversal.preOrderTraversalRecursion(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static BinaryTreeNode constructOrderTree(int[] preOrder, int[] inOrder) throws Exception {
        if (preOrder == null || inOrder == null || preOrder.length != inOrder.length || preOrder.length == 0) {
            return null;
        }
        int preStarPos = 0;
        int preEndPos = inOrder.length - 1;
        int inStarPos = 0;
        int inEndPos = inOrder.length - 1;
        return constructCore(preOrder, inOrder, preStarPos, preEndPos, inStarPos, inEndPos);
    }

    private static BinaryTreeNode constructCore(int[] preData, int[] inData, int preStarPos, int preEndPos, int inStarPos, int inEndPos) throws Exception {


        //1.前序遍历第一个就是根节点；
        int rootValue = preData[preStarPos];
        BinaryTreeNode root = new BinaryTreeNode(rootValue);
        if (preStarPos == preEndPos) {
            if (inStarPos == inEndPos && preData[preStarPos] == inData[inStarPos]) {
                //只有一个节点了；
                return root;
            } else {
                throw new Exception("invalid input params!");
            }
        }

        //在中序遍历序列中找到根节点的值；
        int rootIndex = 0;
        for (int i = 0; i <= inData.length; i++) {
            if (inData[i] == rootValue) {
                break;
            }
            rootIndex++;
        }

        if (rootIndex == inEndPos && inData[rootIndex] != rootValue) {
            throw new Exception("invalid input params");
        }

        //确定左子节点的范围
        int leftLength = rootIndex - inStarPos;

        //构建左子树
        if (leftLength > 0) {
            int subPreStarPos = preStarPos + 1;
            int subPreEndPos = preStarPos + leftLength;
            int subInStarPos = inStarPos;
            int subInEndPos = rootIndex - 1;
            MyUtils.print("subPreStarPos = " + subPreStarPos + ",subPreEndPos = " + subPreEndPos + ",subInStarPos = " + subInStarPos + ",subInEndPos = " + subInEndPos + "\n");
            root.left = constructCore(preData, inData, subPreStarPos, subPreEndPos, subInStarPos, subInEndPos);
        }

        //构建右子树
        if (leftLength < preEndPos - preStarPos) {
            root.right = constructCore(preData, inData, preStarPos + leftLength + 1, preEndPos, rootIndex + 1, inEndPos);
        }

        return root;
    }

}
