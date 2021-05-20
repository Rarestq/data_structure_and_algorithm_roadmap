package com.rarestzhou.leetcode_solutions.java.string;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * https://leetcode-cn.com/problems/is-subsequence/
 *
 * @author: wuxiu
 * @date: 2021/4/29 16:54
 * @description: 判断子序列
 */
public class SubsequenceSolutions {

    /**
     * 双指针
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        // 两个指针，分别遍历字符串的每个字符
        while (i < s.length() && j < t.length()) {
            // 相等则 i 和 j 指针同时往前移
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            // 不相等，则 j 指针往前移即可
            j++;
        }
        return i == s.length();
    }

    /**
     * 二分法
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequenceV2(String s, String t) {
        return false;
    }

    /**
     * 二分法求「给你一系列字符串 s1,s2,... 和字符串 t，你需要判定每个串 s 是否是 t 的子序列（可以假定 s 较短，t 很长）」
     * 二分思路主要是对 t 进行预处理，用一个字典 index 将每个字符出现的索引位置按顺序存储下来
     *
     * @param sn
     * @param t
     * @return
     */
    public boolean isSubsequenceV3(String[] sn, String t) {
        return false;
    }
}
