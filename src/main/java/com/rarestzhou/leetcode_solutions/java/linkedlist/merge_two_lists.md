## 21. 合并两个有序链表

---

题目详情见 [合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/) 或 [MergeTwoSortedLists](https://leetcode.com/problems/merge-two-sorted-lists/)

### 解题思路 1 - 递归
---
首先分析合并两个链表的过程。先从合并两个链表的头节点开始。我们假设链表 1 为：1->2->3->5->7,链表 2 为:2->4->6->8。合并链表的过程如下：

- 链表 1 的头节点的值小于链表 2 的头节点的值，因此链表 1 的头节点是合并后的链表的头节点；
- 在剩余的节点中，链表 2 的头节点的值小于链表 1 的头节点的值，因此链表 2 的头节点是剩余节点的头节点，把这个节点和之前已经合并好的链表的尾节点连接起来即可。

这就是典型的[递归](https://zh.wikipedia.org/zh-hans/%E9%80%92%E5%BD%92)思维。

通过分析可以得到该种解法的时间和空间复杂度为：

- 时间复杂度：O(m + n), 因为每次递归调用时都会去掉 l1 或 l2 的头元素（直到至少有一个链表为空），函数 mergeTwoList 中只会遍历每个元素一次。所以，时间复杂度与合并后的链表长度为线性关系。
- 空间复杂度：O(m + n)，调用 mergeTwoLists 退出时 l1 和 l2 中每个元素都一定已经被遍历过了，所以 m + n 个栈帧会消耗 O(m + n) 的空间。

代码如下：

```java
public class MergeTwoListsSolution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1 && null == l2) {
            return null;
        }

        if(null == l1) {
            return l2;
        } else if(null == l2) {
            return l1;
        }

        ListNode mergedHead;
        if(l1.val < l2.val) {
            mergedHead = l1;
            mergedHead.next = mergeTwoLists(l1.next, l2);
        } else {
            mergedHead = l2;
            mergedHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergedHead;
    }
}
```
LeetCode 提交结果：
![MergeTwoSortedLists1.png](https://i.loli.net/2019/11/29/Nog64L3DKPSVure.png)

### 解题思路 2 - 迭代
---
这种解法参考的[官方解法](https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode/)

#### 具体的算法如下：
首先，我们设定一个哨兵节点 "prehead" ，这可以在最后让我们比较容易地返回合并后的链表。我们维护一个 prev 指针，我们需要做的是调整它的 next 指针。然后，我们重复以下过程，直到 l1 或者 l2 指向了 null ：如果 l1 当前位置的值小于等于 l2 ，我们就把 l1 的值接在 prev 节点的后面同时将 l1 指针往后移一个。否则，我们对 l2 做同样的操作。不管我们将哪一个元素接在了后面，我们都把 prev 向后移一个元素。

在循环终止的时候， l1 和 l2 至多有一个是非空的。由于输入的两个链表都是有序的，所以不管哪个链表是非空的，它包含的所有元素都比前面已经合并链表中的所有元素都要大。这意味着我们只需要简单地将非空链表接在合并链表的后面，并返回合并链表。


该种解法的时间和空间复杂度为：

- 时间复杂度：O(m + n),因为每次循环迭代中，l1 和 l2 只有一个元素会被放进合并链表中，while 循环的次数等于两个链表的总长度。所有其他工作都是常数级别的，所以总的时间复杂度是线性的。
- 空间复杂度：O(1)，迭代的过程只会产生几个指针，所以它所需要的空间是常数级别的。

代码如下：

```java
public class MergeTwoListsSolution {

    /**
     * 解法二：迭代
     * 时间复杂度:O(m+n)
     * 空间复杂度:O(1)
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode preHead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
}
```

