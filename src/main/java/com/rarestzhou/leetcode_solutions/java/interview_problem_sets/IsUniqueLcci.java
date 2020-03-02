package com.rarestzhou.leetcode_solutions.java.interview_problem_sets;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 * <p>
 * 面试题 01.01. 判定字符是否唯一
 * https://leetcode-cn.com/problems/is-unique-lcci/
 *
 * @author: wuxiu
 * @date: 2020/3/1 14:20
 */
public class IsUniqueLcci {

    public boolean isUnique(String astr) {
        if (astr.isEmpty() || astr.length() > 100) {
            return false;
        }
        int left = 0, right = astr.length() - 1;
        // 也可以使用 cHead = s.charAt(left)的方式
        char[] chars = astr.toCharArray();

        do {
            for (int i = left + 1; i < astr.length() - 1; i++) {
                if (Character.toLowerCase(chars[left]) == Character.toLowerCase(chars[right])) {
                    return false;
                }
            }
            left++;
        } while (left < right);
        return true;
    }
}
