package com.rarestzhou.leetcode_solutions.java.tree;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * 二叉查找(排序)树：
 *  1、支持快速查找、插入、删除操作
 *  2、左子树的值 < 根节点的值 < 右子树的值
 *  3、中序遍历二叉查找树，可以输出**有序**的数据序列，时间复杂度是 O(N)
 *  4、插入时，当有重复数据时：
 *      4.1、通过链表和支持动态扩容的数据等数据结构，将值相同的数据都存储在同一个节点上
 *      4.2、把新插入的数据当作大于这个节点的值来处理（若该节点已经有左右子树，则放到右子树的左/右子树中），
 *      查找数据的时候，遇到值相同的节点，我们并不停止查找操作，而是继续在右子树中查找，直到遇到叶子节点，才停止
 *      删除的话，先查找到每个要删除的节点,再按 {@link BinarySearchTree#delete(int)}方法逻辑删除
 *  5、时间复杂度: 不管是插入、删除还是查找操作，时间复杂度都跟树的高度成正比，
 *   也就是 O(height) -> 求树的高度（需要注意完全二叉树，最后一层节点个数在1~2^(L-1)之间，假设最大层数是 L）
 *   两个极端情况的时间复杂度分别是 O(N) 和 O(logN)，分别对应二叉树退化成链表和完全二叉树的情况。
 *
 * 参考链接：https://time.geekbang.org/column/article/68334
 *
 * @author: wuxiu
 * @date: 2020/12/15 09:21
 * @description: 二叉查找(搜索)树
 */
public class BinarySearchTree {

    private Node tree;

    public Node find(int data) {
        Node root = tree;
        while (root != null) {
            if (data < root.data) {
                root = root.left;
            } else if (data > root.data) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

    /**
     * 二叉查找树的插入操作
     *
     * @param data
     */
    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node root = tree;
        while (root != null) {
            // 如果要插入的数据比节点的数据大，并且节点的右子树为空，就将新数据直接插到右子节点的位置；
            // 如果不为空，就再递归遍历右子树，查找插入位置
            if (data > root.data) {
                if (root.right == null) {
                    root.right = new Node(data);
                    return;
                }
                root = root.right;
            } else {
                // 同理，如果要插入的数据比节点数值小，并且节点的左子树为空，就将新数据插入到左子节点的位置；
                // 如果不为空，就再递归遍历左子树，查找插入位置。
                if (root.left == null) {
                    root.left = new Node(data);
                    return;
                }
                root = root.left;
            }
        }
    }

    /**
     * 二叉查找树的删除操作：
     *  1、如果要删除的节点没有子节点，我们只需要直接将父节点中，指向要删除节点的指针置为 null
     *  2、如果要删除的节点只有一个子节点（只有左子节点或者右子节点），我们只需要更新父节点中，指向要删除节点的指针，让它指向要删除节点的子节点就可以了
     *  3、如果要删除的节点有两个子节点，我们需要找到这个节点的右子树中的最小节点，把它替换到要删除的节点上。然后再删除掉这个最小节点，
     *      因为最小节点肯定没有左子节点（如果有左子结点，那就不是最小节点了），所以，我们可以应用上面两条规则来删除这个最小节点
     *
     * 二叉查找树的删除操作(取巧操作)：
     *  1、直接将要删除的数据标记为「已删除」，同数据库中的逻辑删除一样
     *  2、这种方式并不会影响查找和插入，只是会浪费内存空间
     *
     * @param data
     */
    public void delete(int data) {
        // root 指向要删除的节点，初始化指向根节点
        Node root = tree;
        // rootParent 记录的是 root 的父节点
        Node rootParent = null;
        while (root != null && root.data != data) {
            rootParent = root;
            if (data > root.data) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        // 未找到需要删除的数据
        if (root == null) {
            return;
        }

        // 要删除的节点有两个子节点
        if (root.left != null && root.right != null) {
            // 查找右子树中最小节点
            Node minRoot = root.right;
            // minRootParent 表示 minRoot 的父节点
            Node minRootParent = root;
            while (minRoot.left != null) {
                minRootParent = minRoot;
                minRoot = minRoot.left;
            }

            // TODO by 无朽 2021/1/5 这三行代码其实代表了三种情况：删除节点有2个子节点、1个子节点、无子节点
            // TODO by wuxiu 2021/1/5 迭代删除，右子树的左节点可能有右节点；再把minRoot当做要删除的节点进行删除，同理minRoot的右节点
            // 将 minRoot 的数据替换到 root 中
            root.data = minRoot.data;
            // 接下来就要删除 minRoot 了
            root = minRoot;
            rootParent = minRootParent;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        Node child; // root 的子节点
        if (root.left != null) {
            child = root.left;
        } else if (root.right != null) {
            child = root.right;
        } else {
            child = null;
        }

        if (rootParent == null) {
            // 删除的是根节点
            tree = child;
        } else if (rootParent.left == root) {
            rootParent.left = child;
        } else {
            rootParent.right = child;
        }

    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
