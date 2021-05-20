package com.rarestzhou.leetcode_solutions.java.linkedlist;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * 链表中环的检测（LeetCode141）
 * 两个有序的链表合并（LeetCode21）
 * 删除链表倒数第n个结点（LeetCode19）
 * 求链表的中间结点（LeetCode876）
 *
 * 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * 变形题：https://leetcode-cn.com/problems/reverse-linked-list-ii/
 *
 * @author: wuxiu
 * @date: 2020/3/2 21:40
 */
public class ReverseLinkedListSolutions {

    /**
     * 方法一：双指针迭代
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            // 注：在 cur 指向 pre 之前一定要先保留 cur 的后继结点，不然如果 cur 先指向 pre，之后就再也找不到后继结点了
            // 记录当前节点的下一个节点
            ListNode next = cur.next;
            // 然后将当前节点指向 prev
            cur.next = prev;
            // prev 和 cur 节点都前进一位
            prev = cur;
            cur = next;
        }
        return prev;
    }

    /**
     * 方法二：递归（不太好理解）
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(N) -> 由于使用递归，将会使用隐式栈空间。递归深度可能会达到 n 层。
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        // 递归终止条件是只有一个节点，即下一个节点为空
        if (head.next == null) {
            return head;
        }
        // 步骤 1、先翻转 head 节点之后的链表（这里的 newHead 就是最后一个节点）
        ListNode newHead = reverseList2(head.next);
        /**
         * 步骤 2、把原 head 节点后继节点的后继节点指向 head，head 的后继节点设置为 null(避免形成环)
         *
         * 如果链表是 1->2->3->4->5，那么此时的cur就是5，而head是4，head的下一个是5，下下一个是空，所以head.next.next 就是5->4
         */
        head.next.next = head;
        // 防止链表循环，需要将head.next设置为空
        head.next = null;
        // 步骤 3、返回翻转后的头节点
        return newHead;
    }

    /**
     * 翻转以 head 为头节点的 n 个节点，返回新链表的头节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode reverseN(ListNode head, int n) {
        // 后驱节点
        ListNode successor = null;
        if (n == 1) {
            // 记录第 n+1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要翻转前 n-1 个节点
        ListNode newHead = reverseN(head.next, n - 1);
        head.next.next = head;
        // 让翻转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return newHead;
    }

    /**
     * 迭代法
     *
     * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
     * 请你反转从位置 left 到位置 right 的链表节点，返回反转后的链表。
     *
     * 思路：
     * 1、先找到 **left.pre**、left、**right**、right.next 四个节点(从前往后遍历先得到 left.pre 和 right，按步长遍历)
     * 2、断开 [left,right]前后链接
     * 3、反转 [left,right]区间链表（跟正常反转整个链表一个逻辑）
     * 4、把反转后的链表和 left.pre 和 right.next 连上，构成完整链表
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) throws Exception {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        // 第一步：从虚拟头节点走 left-1 步，来到 left 节点的前一个节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 第二步：从 pre 再走 right-left+1 步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 第三步：截取子链表(找到左节点和右节点的后驱节点)
        ListNode leftNode = pre.next;
        ListNode successorNode = rightNode.next;

        // 注：切断链接
        pre.next = null;
        rightNode.next = null;

        // 第四步：反转链表的子区间
        reverseList(leftNode);

        // 第五步：接回到原来的链表中
        pre.next = rightNode;
        leftNode.next = successorNode;
        return dummyNode.next;
    }

    /**
     * 递归法
     *
     * 反转[left,right]的链表节点
     *
     * @param head
     * @param left
     * @param right
     * @return
     * @throws Exception
     */
    public ListNode reverseBetweenV2(ListNode head, int left, int right) throws Exception {
        // base case
        if (left == 1) {
            // 相当于反转前 right 个元素
            return reverseN(head, right);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetweenV2(head.next, left - 1, right - 1);
        return head;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
