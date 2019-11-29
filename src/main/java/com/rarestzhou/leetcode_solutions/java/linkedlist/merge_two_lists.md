## 21. 合并两个有序链表

---

题目详情见 [合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/) 或 [MergeTwoSortedLists](https://leetcode.com/problems/merge-two-sorted-lists/)

### 解题思路 1
---
最简单最粗暴的方法就是每向右移动一次，就对数组中的每个元素都往右移动一次，外层循环是向右移动的位置数，内层循环是对数组进行遍历，这里需要两个变量，一个变量保存当前数组下标所在的元素，另一个变量始终保存数组最后一个元素，这样只需交换当前下标所在的元素和最后一个元素即可。

通过分析可以得到该种解法的时间和空间复杂度为：

- 时间复杂度：O(n^k),取决于移动的位置数，每移动一次时间复杂度都需要乘以 n
- 空间复杂度：O(1)，不需要额外空间

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
