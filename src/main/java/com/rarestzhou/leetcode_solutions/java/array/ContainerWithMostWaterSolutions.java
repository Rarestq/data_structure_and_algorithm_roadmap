package com.rarestzhou.leetcode_solutions.java.array;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * 11. 盛最多水的容器：
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * 思路：
 *  1、枚举：left bar x, right bar y, maxArea = (y - x) * max(x, y) -> o(n^2)
 *  2、双指针(左右边界)，往中间收敛 -> O(n)
 *
 * @author: wuxiu
 * @date: 2019/12/8 21:27
 */
public class ContainerWithMostWaterSolutions {

    /**
     * 解法一：枚举：left bar x, right bar y, maxArea = (y - x) * max(x, y) -> o(n^2)
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxAreaVal = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = calculateArea(height, i, j);
                maxAreaVal = Math.max(maxAreaVal, area);
            }
        }
        return maxAreaVal;
    }

    public int calculateArea(int[] nums, int i, int j) {
        return Math.abs(i - j) * Math.min(nums[i], nums[j]);
    }

    /**
     * 解法二：双指针(左右边界)，往中间收敛：左右夹逼 -> O(n)
     *
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int maxAreaVal = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            // calculate the container's height
            int containerHeight = height[i] < height[j] ? height[i++] : height[j--];
            // calculate area：上面算容器高度时，进行了 i++ 或 j-- 操作，所以计算面积时，宽度需要 +1
            int area = (j - i + 1) * containerHeight;
            maxAreaVal = Math.max(maxAreaVal, area);
        }
        return maxAreaVal;
    }
}
