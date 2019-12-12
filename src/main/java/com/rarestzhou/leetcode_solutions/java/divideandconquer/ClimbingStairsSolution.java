package com.rarestzhou.leetcode_solutions.java.divideandconquer;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * 70. 爬楼梯:https://leetcode-cn.com/problems/climbing-stairs/
 *
 * 本质上和 斐波那契数列 是一个问题，都是分治或者说是「找最近重复子问题」的题目
 *
 * @author: wuxiu
 * @date: 2019/12/8 22:05
 */
public class ClimbingStairsSolution {

    /**
     * 找最近 重复子问题
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int f1 = 1, f2 = 2, f3 = 3;
        // 思考：i 可不可以从 4 开始？
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}
