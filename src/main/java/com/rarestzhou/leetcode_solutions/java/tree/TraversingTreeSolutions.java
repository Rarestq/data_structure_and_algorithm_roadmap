package com.rarestzhou.leetcode_solutions.java.tree;

import java.util.LinkedList;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * 1、树的基础概念：
 *  节点高度：节点到叶子节点的最长路径(边数)
 *  节点深度：根节点到这个节点所经历的边的个数
 *  节点层数：节点的深度+1
 *  树的高度：根节点的高度
 *
 * 2、完全二叉树适合用数组存储，节省空间，因为是连续的，且数据都靠左
 *
 * 前序遍历：preOrder(r) = print r -> preOrder(r->left) -> preOrder(r->right)
 * 中序遍历：inOrder(r) = inOrder(r->left) -> print r -> inOrder(r->right)
 * 后序遍历：postOrder(r) = postOrder(r->left) -> postOrder(r->right) -> print r
 *
 * @author: wuxiu
 * @date: 2020/12/14 16:32
 * @description: 树的遍历
 */
public class TraversingTreeSolutions {

    /**
     * 前序遍历
     * 时间复杂度：O(N)
     *
     * @param root
     */
    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     * 时间复杂度：O(N)
     *
     * @param root
     */
    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
    }

    /**
     * 后序遍历
     * 时间复杂度：O(N)
     *
     * @param root
     */
    private void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);
    }

    /**
     * 层次遍历（广度优先遍历）
     *
     * @param root
     */
    private void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            System.out.println(treeNode.value);
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }

            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
        }

    }

    private static class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int value;
    }
}
