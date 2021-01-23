package com.rarestzhou.leetcode_solutions.java.array;

import com.google.common.collect.Lists;
import com.rarestzhou.leetcode_solutions.java.binary_search.GetSpecifiedNumSolutions;

import java.util.List;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 * <p>
 * 原题链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * @author: wuxiu
 * @date: 2020/12/8 13:42
 * @description: 在排序数组中查找元素的第一个和最后一个位置
 */
public class SearchRangeSolutions {

    /**
     * 在排序数组中查找元素的第一个和最后一个位置解法之：二分法(单调有序数组)
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * @see GetSpecifiedNumSolutions#getFirstEqualGivenNum(int[], int, int) 查找第一个值等于给定值的元素
     * @see GetSpecifiedNumSolutions#getLastEqualGivenNum(int[], int, int)  查找最后一个值等于给定值的元素
     * @param nums   升序排列的整数数组
     * @param target 目标值
     * @return 超出时间限制...
     */
    public static int[] searchRangeV1(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums.length == 0) {
            return result;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            // 右半区
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                /**
                 * 第一个位置
                 *
                 * 相等时，则需再判断左区间第一个数是否等于给定值，或者 mid 是否为 0，若是，则直接返回；
                 * 否则，继续往左边缩小范围查找最小的下标
                 */
                if ((mid == 0) || (nums[mid - 1] != target)) {
                    result[0] = mid;
                } else {
                    right = mid - 1;
                }

                /**
                 * 最后一个位置
                 *
                 * 相等时，则需再判断右区间第一个数是否等于给定值，或者 mid 是否为 n-1，若是，则直接返回；
                 * 否则，继续往右边缩小范围查找最小的下标
                 */
                if ((mid == nums.length - 1) || (nums[mid + 1] != target)) {
                    result[1] = mid;
                } else {
                    left = mid + 1;
                }
            }
        }

        return result;
    }

    public static int[] searchRangeV2(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums.length == 0) {
            return result;
        }

        return result;
    }

    public static void main(String[] args) {
        // 示例 1：nums = [5,7,7,8,8,10], target = 8 --> 输出：[3,4]
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int[] result1 = searchRangeV1(nums1, 8);
        System.out.println(convert2List(result1));

        // 示例 2：nums = [5,7,7,8,8,10], target = 6 --> 输出：[-1,-1]
        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int[] result2 = searchRangeV1(nums2, 6);
        System.out.println(convert2List(result2));

        // 示例 2：nums = [], target = 0 --> 输出：[-1,-1]
        int[] nums3 = {};
        int[] result3 = searchRangeV1(nums3, 0);
        System.out.println(convert2List(result3));
    }

    private static List<Integer> convert2List(int[] arrays) {
        List<Integer> list = Lists.newArrayListWithCapacity(arrays.length);
        for (Integer num : arrays) {
            list.add(num);
        }
        return list;
    }
}
