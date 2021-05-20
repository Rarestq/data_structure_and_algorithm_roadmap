package com.rarestzhou.leetcode_solutions.java.recursion;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * 简单：https://leetcode-cn.com/problems/invert-binary-tree/submissions/
 *
 * @author: wuxiu
 * @date: 2021/4/19 14:37
 * @description: 翻转二叉树
 */
public class FlipTreeSolutions {

    /**
     * 递归
     *
     * 时间复杂度：O(N)
     * 空间复杂度：压栈次数，即（完全二叉）树的高度，O(logN)，最坏情况下所有节点都在树的一边，则复杂度是O(N)
     *
     * @param root
     * @return
     */
    public TreeNode flipTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 翻转左子树下的左右孩子
        TreeNode left = flipTree(root.left);
        // 翻转右子树下的左右孩子
        TreeNode right = flipTree(root.right);

        // 左右子树下的二叉树翻转后，再翻转根节点的左右孩子
        root.right = left;
        root.left = right;
        return root;
    }

}
