package com.bruce.sun;

import com.bruce.sun.domain.BinaryTreeNode;
import com.bruce.sun.utils.MyUtils;

import java.util.Stack;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class BinaryTreeTraversal {


    /**
     * 二叉树的前序，中序，后续遍历
     *
     * @param args
     */
    public static void main(String[] args) {
        //     10
        //  6      14
        // 4 8    12 16

        BinaryTreeNode root = buildTree();
        //前序遍历： 10 -> 6,4,8 -> 14,12,16
        MyUtils.print("\n前序遍历递归: \t");
        preOrderTraversalRecursion(root);//递归方法
        MyUtils.print("\n前序遍历循环: \t");
        preOrderTraversalLoop(root);//递归方法

        //中序遍历： 4,6,8 -> 10 -> 12,14,16
        MyUtils.print("\n中序遍历递归: \t");
        midOrderTraversalRecursion(root);//递归方法
        MyUtils.print("\n中序遍历循环: \t");
        midOrderTraversalLoop(root);//循环方法

        //后序遍历： 4,8,6 -> 12,16,14 -> 10
        MyUtils.print("\n后序遍历递归: \t");
        postOrderTraversalRecursion(root);//递归方法
        MyUtils.print("\n后序遍历循环: \t");
        postOrderTraversalLoop(root);//循环方法

    }

    /**
     * 后序循环遍历
     * -------10
     * ----6      14
     * --4 8    12 16
     * 后序遍历： 4,8,6 -> 12,16,14 -> 10
     *
     * @param root
     */
    private static void postOrderTraversalLoop(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode node = root;
        BinaryTreeNode lastVisit = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            //查看当前栈顶元素
            node = stack.peek();
            //如果其右子树也为空，或者右子树已经访问
            //则可以直接输出当前节点的值
            if (node.right == null || node.right == lastVisit) {
                System.out.print(node.value + "\t");
                stack.pop();
                lastVisit = node;
                node = null;
            } else {
                //否则，继续遍历右子树
                node = node.right;
            }
        }
    }


    private static void postOrderTraversalRecursion(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        postOrderTraversalRecursion(root.left);
        postOrderTraversalRecursion(root.right);
        MyUtils.print(root.value + " \t");
    }

    /**
     * 中序循环遍历
     * -------10
     * ----6      14
     * --4 8    12 16
     * 中序遍历： 4,6,8 -> 10 -> 12,14,16
     *
     * @param root
     */
    private static void midOrderTraversalLoop(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode node = root;
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            if (!stack.empty()) {
                node = stack.pop();
                MyUtils.print(node.value + " \t");
                node = node.right;
            }
        }
    }

    /**
     * 中序遍历
     * -------10
     * ----6      14
     * --4 8    12 16
     * 输出： 4,6,8 -> 10 -> 12,14,16
     *
     * @param root
     */
    private static void midOrderTraversalRecursion(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        midOrderTraversalRecursion(root.left);
        MyUtils.print(root.value + " \t");
        midOrderTraversalRecursion(root.right);
    }

    /**
     * 前序遍历循环
     * 前序遍历： 10 -> 6,4,8 -> 14,12,16
     *
     * @param root
     */
    private static void preOrderTraversalLoop(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        Stack<BinaryTreeNode> stack = new Stack<>();

        BinaryTreeNode curNod = root;
        while (curNod != null || !stack.empty()) {

            //先遍历左子树
            while (curNod != null) {
                MyUtils.print(curNod.value + " \t");
                stack.push(curNod);
                curNod = curNod.left;
            }

            //左子树遍历完毕后，遍历右子树
            if (!stack.isEmpty()) {
                curNod = stack.pop();//得到每个根节点
                curNod = curNod.right;//遍历右节点
            }
        }
    }

    /**
     * 前序遍历递归
     * 前序遍历： 10 -> 6,4,8 -> 14,12,16
     *
     * @param root
     */
    private static void preOrderTraversalRecursion(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        MyUtils.print(root.value + " \t");
        preOrderTraversalRecursion(root.left);
        preOrderTraversalRecursion(root.right);
    }

    private static BinaryTreeNode buildTree() {
        BinaryTreeNode root = new BinaryTreeNode(10);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n14 = new BinaryTreeNode(14);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n8 = new BinaryTreeNode(8);
        BinaryTreeNode n12 = new BinaryTreeNode(12);
        BinaryTreeNode n16 = new BinaryTreeNode(16);

        root.left = n6;
        root.right = n14;

        n6.left = n4;
        n6.right = n8;

        n14.left = n12;
        n14.right = n16;
        return root;
    }
}
