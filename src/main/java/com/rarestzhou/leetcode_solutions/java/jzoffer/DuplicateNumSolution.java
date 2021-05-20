package com.rarestzhou.leetcode_solutions.java.jzoffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @author: wuxiu
 * @date: 2021/4/1 09:05
 * @description: 数组中重复的数字
 */
public class DuplicateNumSolution {

    /**
     * 1、HashSet
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
        // 参数校验
        if (nums == null) {
            throw new IllegalArgumentException("invalid parameter!");
        }
        int length = nums.length;
        if (length == 0 || length == 1) {
            throw new IllegalArgumentException("invalid parameter!");
        }

        Set<Integer> repeatNums = new HashSet<>();
        int target = -1;
        for (int num : nums) {
            if (!repeatNums.add(num)) {
                target = num;
                break;
            }
        }
        return target;
    }

    /**
     * 2、原地交换
     *
     * @param nums
     */
    public static int findRepeatNumberV2(int[] nums) {
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
//        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        int repeatNumberV2 = findRepeatNumber(nums);
        System.out.println(repeatNumberV2);
    }

}
