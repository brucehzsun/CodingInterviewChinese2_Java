package com.bruce.sun;

import com.bruce.sun.domain.BinaryTreeNode;
import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _08_NextNodeInBinaryTrees {

    /**
     * 面试题8：二叉树的下一个结点
     * 题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
     * 树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
     *
     * @param args
     */
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode('a');
        BinaryTreeNode nb = new BinaryTreeNode('b');
        BinaryTreeNode nc = new BinaryTreeNode('c');
        BinaryTreeNode nd = new BinaryTreeNode('d');
        BinaryTreeNode ne = new BinaryTreeNode('e');
        BinaryTreeNode nf = new BinaryTreeNode('f');
        BinaryTreeNode ng = new BinaryTreeNode('g');
        BinaryTreeNode nh = new BinaryTreeNode('h');
        BinaryTreeNode ni = new BinaryTreeNode('i');

        MyUtils.connectTreeParent(root, nb, nc);
        MyUtils.connectTreeParent(nb, nd, ne);
        MyUtils.connectTreeParent(ne, nh, ni);
        MyUtils.connectTreeParent(nc, nf, ng);

        //中序排列：d b h e i a f c g
        BinaryTreeNode r1 = getNextNode(nh);
        if (r1.value == ne.value) {
            MyUtils.print("Pass 1! \n");
        }

        BinaryTreeNode r2 = getNextNode(ni);
        if (r2.value == root.value) {
            MyUtils.print("Pass 2! \n");
        }

        BinaryTreeNode r3 = getNextNode(root);
        if (r3.value == nf.value) {
            MyUtils.print("Pass 3! \n");
        }
    }

    private static BinaryTreeNode getNextNode(BinaryTreeNode currNode) {
        if (currNode == null) {
            return null;
        }

        if (currNode.right != null) {
            //1.如果一个节点有rightNode.那么下一个节点就是其右节点的最左子节点；b->h a->f
            currNode = currNode.right;
            while (currNode.left != null) {
                currNode = currNode.left;
            }
            return currNode;
        } else if (currNode.parent != null) {
            //2.如果一个节点没有rightNode；

            //2.1.它还是其父节点的右子节点：例如：i->a
            if (currNode == currNode.parent.right) {
                //向上遍历，直到找到一个节点。这个节点是其父节点的左子节点。则期父节点是我们要找的节点。
                while (currNode.parent != null && currNode == currNode.parent.right) {
                    currNode = currNode.parent;
                }
                return currNode.parent;
            } else if (currNode == currNode.parent.left) {
                //2.2 它还是其父节点的左子节点。其父节点就是下一个节点。d->b;
                return currNode.parent;
            }
        }
        return null;
    }


}
