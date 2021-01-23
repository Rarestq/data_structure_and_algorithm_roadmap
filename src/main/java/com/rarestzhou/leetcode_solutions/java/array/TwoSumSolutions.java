package com.rarestzhou.leetcode_solutions.java.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * <p>
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author: wuxiu
 * @date: 2019/12/1 15:42
 */
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
        // 参数校验
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        // 暴力破解法：两层 for 循环
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // 存在这样的两个数和 = target，则返回他们的下标
                if (target - nums[i] == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        // 找不到解为正常业务逻辑，返回空数组即可
        return new int[]{};
    }

    /**
     * 解法二：利用 map 的特性
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        // 参数校验
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        // 数组中的值为key，下标index为value
        Map<Integer, Integer> ansMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int subtractVal = target - nums[i];
            // 若 map 中包含 key 为 subtractVal，则说明数组中包含两个数加起来等于 target 的值
            // 返回他们的下标
            if (ansMap.containsKey(subtractVal)) {
                return new int[]{ansMap.get(subtractVal), i};
            }
            ansMap.put(nums[i], i);
        }
        return new int[]{};
    }
}
