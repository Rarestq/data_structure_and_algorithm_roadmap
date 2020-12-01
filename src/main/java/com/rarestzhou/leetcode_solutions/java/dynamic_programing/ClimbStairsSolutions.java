package com.rarestzhou.leetcode_solutions.java.dynamic_programing;

import lombok.extern.slf4j.Slf4j;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * 爬楼梯原题链接：https://leetcode.com/problems/climbing-stairs/
 *
 * @author: wuxiu
 * @date: 2020/11/22 10:47
 * @description: 爬楼梯
 */
@Slf4j
public class ClimbStairsSolutions {

    /**
     * 爬楼梯解法1：
     *
     * @param n 楼梯数：[0,45]
     * @return
     */
    public int climbStairs(int n) throws Exception {
        rangeCheck(n);
        // 1、base case
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 3;
        }
        int result = 0;


        return result;
    }

    private void rangeCheck(int n) throws Exception {
        if (n < 0 || n > 45) {
            throw new Exception("out of range");
        }
    }

}
