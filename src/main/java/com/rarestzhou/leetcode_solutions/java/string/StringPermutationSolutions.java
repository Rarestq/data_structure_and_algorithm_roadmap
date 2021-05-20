package com.rarestzhou.leetcode_solutions.java.string;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 *
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * @author: wuxiu
 * @date: 2021/4/19 08:52
 * @description: 字符串排列
 */
public class StringPermutationSolutions {

    /**
     * 方法一：N 次循环(N=s.length())
     *
     * @param s
     * @return
     */
    public String[] permutation(String s) {
        if (s == null || s.isEmpty() || s.trim().isEmpty()) {
            return new String[]{};
        }

        int length = s.length();
        int idx = 0;
        for (int i = 0; i < length; i++) {

        }
        return null;
    }

    /**
     * 方法二：滑动窗口
     *
     * @param s
     * @return
     */
    public String[] permutationV2(String s) {
        return null;
    }
}
