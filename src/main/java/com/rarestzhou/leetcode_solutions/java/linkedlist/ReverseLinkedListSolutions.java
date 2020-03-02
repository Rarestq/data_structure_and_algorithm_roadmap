package com.rarestzhou.leetcode_solutions.java.linkedlist;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
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
     * 方法二：递归
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(N) -> 由于使用递归，将会使用隐式栈空间。递归深度可能会达到 n 层。
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        // 递归终止条件是当前为空，或者下一个节点为空
        if (head == null || head.next == null) {
            return head;
        }
        // 这里的 temp 就是最后一个节点
        ListNode temp = reverseList2(head.next);
        // 如果链表是 1->2->3->4->5，那么此时的cur就是5
        // 而head是4，head的下一个是5，下下一个是空
        // 所以head.next.next 就是5->4
        head.next.next = head;
        // 防止链表循环，需要将head.next设置为空
        head.next = null;
        // 每层递归函数都返回cur，也就是最后一个节点
        return temp;
    }


    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
