## 185.旋转数组

---

题目详情见 [旋转数组](https://leetcode-cn.com/problems/rotate-array/) 或 [RotateArray](https://leetcode.com/problems/rotate-array/)

### 解题思路 1
---
最简单最粗暴的方法就是每向右移动一次，就对数组中的每个元素都往右移动一次，外层循环是向右移动的位置数，内层循环是对数组进行遍历，这里需要两个变量，一个变量保存当前数组下标所在的元素，另一个变量始终保存数组最后一个元素，这样只需交换当前下标所在的元素和最后一个元素即可。

通过分析可以得到该种解法的时间和空间复杂度为：

- 时间复杂度：O(n^k),取决于移动的位置数，每移动一次时间复杂度都需要乘以 n
- 空间复杂度：O(1)，不需要额外空间

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
LeetCode 提交结果：
![RotateArray1.png](https://i.loli.net/2019/11/28/sYT7bF6rAKnwdIp.png)

可以看到该种解法的性能相对来说是比较差的，这就引出了第二种解法。

### 解题思路 2
---
基于第一种解法时间性能比较差的情况下，很自然的就想到减少循环的次数，也就需要避免遍历整个数组，这时想到，无论移动多少次，固定的 k%n 个数是需要移动到数组前面的，为了减少循环次数，先 reverse 整个数组，这样 k%n 个数就相当于移动到了数组前面，于是，只需要分别对前 k%n 个数和后 n-(k%n)个数进行 reverse 就行了。

具体思路如下：

- 获取要移动的元素个数(数组尾部) k % n
- reverse 整个数组元素
- reverse 前 k % n 个元素
- reverse 后 n - (k % n) 个元素

这样就能完成数组的旋转效果了。

通过分析可以得到该种解法的时间和空间复杂度为：

- 时间复杂度：O(n)
- 空间复杂度：O(1)，不需要额外空间

代码如下：
```java
public class RotateArraySolution {

    /**
     * 解法二：
     *  0、获取要移动的元素个数（数组尾部） k % n
     *  1、reverse 整个数组元素
     *  2、reverse 前 k % n 个元素
     *  3、reverse 后 n - (k % n) 个元素
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        if (nums.length < 2 || k == 0) {
            return;
        }

        // 获取要移动的元素个数（数组尾部）
        k %= nums.length;
        // reverse 整个数组元素
        reverse(nums, 0, nums.length - 1);
        // reverse 前 k % n 个元素
        reverse(nums, 0, k - 1);
        // reverse 后 n - (k % n) 个元素
        reverse(nums, k, nums.length - 1);
    }

    /**
     * 反转数组元素
     *
     * @param nums   要反转的数组
     * @param start  要反转的开始下标
     * @param end    要反转的结束下标
     */
    public void reverse(int[] nums, int start, int end) {
        // 循环结束条件：start >= end
        while (start < end) {
            // 交换元素
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            // 开始和结束下标位置更新
            start++;
            end--;
        }
    }
}

```

LeetCode 提交结果：
![RotateArray2.png](https://i.loli.net/2019/11/28/ThSvqDW6U2N1pLM.png)
