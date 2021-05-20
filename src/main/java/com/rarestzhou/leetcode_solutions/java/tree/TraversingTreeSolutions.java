package com.rarestzhou.leetcode_solutions.java.tree;

import java.util.*;

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
     * 迭代法
     *
     * @param root
     */
    private void preOrderIteratively(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(root.value);
        while (!stack.isEmpty()) {
            Integer nodeVal = stack.pop();
            System.out.println(nodeVal);
            // 栈是先进后出，所以右子树先入栈
            if (root.right != null) {
                stack.push(root.right.value);
            }
            // 然后左子树再入栈
            if (root.left != null) {
                stack.push(root.left.value);
            }
        }
    }

    private List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.value);
                stack.push(node);
                // 队列是先进先出，所以左子树先入队
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.value);
            root = root.right;
        }
        return res;
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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        TreeNode prev = null;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            // TODO by 无朽 2021/3/15 ？？
            if (node.right == null || node.right == prev) {
                vals.add(node.value);
                prev = node;
                node = null;
            } else {
                stack.push(root);
                node =  node.right;
            }
        }
        return vals;
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
