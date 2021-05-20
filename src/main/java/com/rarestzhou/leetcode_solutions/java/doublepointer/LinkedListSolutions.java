package com.rarestzhou.leetcode_solutions.java.doublepointer;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @author: wuxiu
 * @date: 2021/4/19 15:25
 * @description: 链表中双指针相关问题
 */
public class LinkedListSolutions {

    /**
     * 判断链表是否有环:https://leetcode.com/problems/linked-list-cycle/
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow;
        ListNode fast;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            // fast 比 slow 多走了一倍
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null:
     * https://leetcode-cn.com/problems/linked-list-cycle-ii/
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow;
        ListNode fast;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            // fast 遇到 null 说明链表中没有环，则直接返回 null
            return null;
        }

        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
