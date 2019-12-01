## 1. 两数之和

---

题目详情见 [两数之和](https://leetcode-cn.com/problems/two-sum/) 或 [twoSum](https://leetcode.com/problems/two-sum/)


### 解题思路 1 - 暴力破解法
---
显然，我们可以用最简单最粗暴的方式来解决这个问题，两层 for 循环就可以直接搞定了，当然，这种解法的缺点也很明显，就是性能上会比较差。

该种解法的时间和空间复杂度为：

- 时间复杂度：O(n^2), 进行了两次 for 循环。
- 空间复杂度：O(1)，没有额外的空间消耗。

代码如下：

```java
public class TwoSumSolutions {

    /**
     * 解法一：暴力破解法
     * <p>
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        // 暴力破解法：两层 for 循环
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // 存在这样的两个数和 = target，则返回他们的下标
                if (target - nums[i] == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("Oops,no two nums solution");
    }
}
```

LeetCode 提交记录：
![twoSum1.png](https://i.loli.net/2019/12/01/gOYFvJnuAoc67hK.png)
---

### 解题思路 2 - 利用 map 的特性
---
第一种解法固然简单，但是可以看到，我们进行了两次 for 循环，这种方法性能上是比较差的，所以，我们为了提升程序的性能，可以用空间换时间的方式，这里使用的是 HashMap，因为 HashMap 的查询会比较快。

通过分析可以得到该种解法的时间和空间复杂度为：

- 时间复杂度：O(n), 只进行了一次 for 循环。
- 空间复杂度：O(n), 用了 HashMap 来存储数组中的元素。

代码如下：

```java
public class TwoSumSolutions {

    /**
     * 解法一：利用 map 的特性
     *
     *  时间复杂度：O(n)
     *  空间复杂度：O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        // 数组中的值为key，下标index为value
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // 若 map 中包含 key 为 subtractVal，则说明数组中包含两个数加起来等于 target 的值
            // 返回他们的下标
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

```
LeetCode 提交结果：
![twoSum.png](https://i.loli.net/2019/12/01/gOYFvJnuAoc67hK.png)
