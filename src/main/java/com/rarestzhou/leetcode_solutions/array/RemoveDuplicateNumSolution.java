package com.rarestzhou.leetcode_solutions.array;

/**
 * 26.删除排序数组中的重复项
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * @author: wuxiu
 * @date: 2019/11/27 21:58
 */
public class RemoveDuplicateNumSolution {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        // fast-slow pointer
        int pre = 0, cur = 0;
        while (cur < nums.length) {
            if (nums[pre] != nums[cur]) {
                ++pre;
                nums[pre] = nums[cur];
                cur++;
            } else {
                cur++;
            }
        }
        return pre + 1;
    }
}
