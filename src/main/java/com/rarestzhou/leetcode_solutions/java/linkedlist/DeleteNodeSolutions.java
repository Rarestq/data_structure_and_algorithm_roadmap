package com.rarestzhou.leetcode_solutions.java.linkedlist;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 * <p>
 * LeetCode：https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 *
 * @author: wuxiu
 * @date: 2021/4/8 14:14
 * @description: 删除链表中的指定节点
 */
public class DeleteNodeSolutions {

    public void deleteNode(ListNode node) {
        // find node's next node
        ListNode nextNode = node.next;
        // copy nextNode's val to node
        node.val = nextNode.val;
        // delete nextNode instead of node
        node.next = nextNode.next;
        nextNode.next = null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
