package com.rarestzhou.leetcode_solutions.java.linkedlist;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 * <p>
 * LeetCode：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * @author: wuxiu
 * @date: 2021/4/8 15:01
 * @description: 相交链表
 */
public class IntersectionOf2LinkedListSolution {

    /**
     * 两个指针a,b分别从两个链表l1,l2头节点开始出发：
     *  - a走到l1尾节点后，下一个节点从l2头节点开始继续走
     *  - b走到l2尾节点后，下一个节点从l1头节点开始继续走
     * 最后如果有相同元素，则返回结果
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode2 getIntersectionNode(ListNode2 headA, ListNode2 headB) {
        ListNode2 a = headA;
        ListNode2 b = headB;
        while (a != b) {
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }
        return a;
    }

    /**
     * 分别计算两个链表的长度,链表长的指针先往后走，若长链表未查看长度等于短链表时，两两元素比较，遍历完未发现相同元素时，则不合并
     * 若两个链表长度相同，则两两比较...
     *
     * 时间复杂度：
     * 空间复杂度：
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode2 getIntersectionNodeV2(ListNode2 headA, ListNode2 headB) {
        int aLength = length(headA);
        int bLength = length(headB);
        if (aLength > bLength) {
            // headA 先走，直到 headA 所在链表剩余节点长度和 headB 链表一样时，两两比较元素
        } else if (aLength < bLength) {
            // headB 先走，直到 headB 所在链表剩余节点长度和 headA 链表一样时，两两比较元素
        } else {
            // 两两比较

        }

        return null;
    }

    int length(ListNode2 head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}

class ListNode2 {
    int val;
    ListNode2 next;

    ListNode2(int x) {
        val = x;
        next = null;
    }
}

