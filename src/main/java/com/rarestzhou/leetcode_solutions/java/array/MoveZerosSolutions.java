package com.rarestzhou.leetcode_solutions.java.array;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 * <p>
 * 283.移动零：https://leetcode-cn.com/problems/move-zeroes/
 *
 * @author: wuxiu
 * @date: 2019/12/8 20:50
 */
public class MoveZerosSolutions {

    /**
     * 解法一：空间换时间
     *
     * 使用额外的一个数组，只要碰到非零元素就将其往里面放，最后再将零元素添加进来即可
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {

    }

    /**
     * 解法二：双指针法
     *
     * 思路：找到非零元素，将其放到数组的前面位置，将零元素往数组的后面放(和交换两个元素类似)
     * 这里使用两个指针，一个正常对数组 nums for 循环，另外一个指针 index 专门指向非零元素，
     * 只有 nums[i] 对应的元素非零，则 index++
     *
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int nonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // swap nonzero element
                int temp = nums[nonZeroIndex];
                nums[nonZeroIndex] = nums[i];
                nums[i] = temp;
                nonZeroIndex++;
            }
        }
    }
}
