package com.rarestzhou.leetcode_solutions.java.binary_search;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @author: wuxiu
 * @date: 2020/10/27 17:23
 * @description: 求解平方根
 */
public class SqrtSolutions {

    public static int sqrt(int x) {
        int left = 0, right = x, ans = -1;
        while (left <= right) {
            int mid = left + (right - 1) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(10));
    }

}
