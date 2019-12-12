package com.rarestzhou.leetcode_solutions.java.array;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * 15. 三数之和:https://leetcode-cn.com/problems/3sum/
 *
 *  a + b = -c
 *
 * @author: wuxiu
 * @date: 2019/12/9 20:30
 */
public class ThreeSumSolutions {

    /**
     * 解法一：暴力求解 --> O(n^3)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        return Collections.singletonList(Collections.emptyList());
    }

    /**
     * 解法二：hash 表记录原数组元素，两层 for 循环，看 a + b 是否能在 map 中找到 -c
     * 时间复杂度：O(n^2)
     * 空间复杂度:O(n)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        return Collections.singletonList(Collections.emptyList());
    }

    /**
     * 解法三：排序(O(nlogn))+双指针法(左右下标，往中间靠),一次 for 循环
     * 时间复杂度：O(n^2)
     * 空间复杂度:O(1)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum3(int[] nums) {
        return Collections.singletonList(Collections.emptyList());
    }

}
