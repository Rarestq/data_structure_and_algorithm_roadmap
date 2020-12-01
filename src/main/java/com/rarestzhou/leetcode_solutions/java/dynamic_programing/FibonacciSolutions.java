package com.rarestzhou.leetcode_solutions.java.dynamic_programing;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @author: wuxiu
 * @date: 2020/10/22 14:39
 * @description:
 */
public class FibonacciSolutions {

    public static int fibV0(int N) {
        if (N == 1 || N == 2) {
            return 1;
        }
        return fibV0(N - 1) + fibV0(N - 2);
    }

    public static int fibV1(int N) {
        if (N < 1) {
            return 0;
        }
        // 备忘录
        int[] arr = new int[N+1];
        // 进行带备忘录的递归
        return helper(arr, N);
    }

    public static int helper(int[] memo, int n) {
        // base case
        if (n == 1 || n == 2) {
            return 1;
        }
        // 已经计算过
        if (memo[n] != 0) {
            return memo[n];
        }
        int val = helper(memo, n - 1) + helper(memo, n - 2);
        memo[n] = val;
        return val;
    }

    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
        System.out.println(fibV0(20));
//        System.out.println("暴力递归耗时：" + (System.currentTimeMillis() - start) + " ms");
        long start1 = System.currentTimeMillis();
        int i = fibV1(20);
        System.out.println("备忘录优化后的递归耗时：" + (System.currentTimeMillis() - start1) + " ms");
        System.out.println(i);

        int result = 1 + (5-1+1) / 2;
        System.out.println(result);
        System.out.println(10/3);
        double d1 = 10.0d;
        double d2 = 3.0d;
        System.out.println(d1/d2);
    }
}
