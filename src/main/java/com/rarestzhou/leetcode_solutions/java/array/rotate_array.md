## 185.旋转数组

---

题目详情见 [旋转数组](https://leetcode-cn.com/problems/rotate-array/) 或 [RotateArray](https://leetcode.com/problems/rotate-array/)

### 解题思路 1
---
最简单最粗暴的方法就是每向右移动一次，就对数组中的每个元素都往右移动一次，外层循环是向右移动的位置数，内层循环是对数组进行遍历，这里需要两个变量，一个变量保存当前数组下标所在的元素，另一个变量始终保存数组最后一个元素，这样只需交换当前下标所在的元素和最后一个元素即可。

通过分析可以得到该种解法的时间和空间复杂度为：

- 时间复杂度：O(n^k),取决于移动的位置数，每移动一次时间复杂度都需要乘以 n
- 空间复杂度：O(1)，没有用到多余的空间存储元素

代码如下：

```java
public class RotateArraySolution {

    /**
     * 解法一：两层 for 循环，每移动一次，就循环一次数组，移动每一个元素
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (nums.length < 2 || k == 0) {
            return;
        }

        int temp = 0, tail = 0;
        for (int i = 0; i < k; i++) {
            // 记下数组最后一个元素
            tail = nums[nums.length - 1];
            // 每次移动的时候，遍历整个数组元素，并将当前元素和数组最后一个元素交换位置
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = tail;
                tail = temp;
            }
        }
    }
}
```

### 解题思路 2
---


通过分析可以得到该种解法的时间和空间复杂度为：

- 时间复杂度：O(n*k),取决于移动的位置数，即 T(n) = O(n) * O(k)
- 空间复杂度：O(1)，没有用到多余的空间存储元素

代码如下：
```java

```
