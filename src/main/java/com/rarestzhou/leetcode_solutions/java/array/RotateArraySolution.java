package com.rarestzhou.leetcode_solutions.array;

/**
 * 189. 旋转数组
 * <p>
 * https://leetcode-cn.com/problems/rotate-array/
 *
 * @author: wuxiu
 * @date: 2019/11/28 19:34
 */
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

    /**
     * 解法二：
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        if (nums.length < 2 || k == 0) {
            return;
        }

    }

    /**
     * 解法三：
     *
     * @param nums
     * @param k
     */
    public void rotat3(int[] nums, int k) {
        if (nums.length < 2 || k == 0) {
            return;
        }

    }
}
