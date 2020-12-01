package com.rarestzhou.leetcode_solutions.java.dynamic_programing;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 * <p>
 * https://leetcode.com/problems/super-egg-drop/solution/
 * https://leetcode-cn.com/problems/super-egg-drop/solution/
 * <p>
 * 官方解法：https://leetcode.com/problems/super-egg-drop/solution/
 *
 * @author: wuxiu
 * @date: 2020/10/20 15:03
 * @description: 高楼扔鸡蛋题解
 */
public class SuperEggDropSolutions {

    /**
     * 高楼扔鸡蛋: 线性搜索（leetcode 提交超时）
     * <p>
     * 时间复杂度：子问题个数 * 函数本身时间复杂度(忽略递归部分) ==> O(KN) * O(N)
     * 空间复杂度：O(KN)
     *
     * @param K 鸡蛋个数（1<=k<=100）
     * @param N 楼层数（1<=N<=10000）
     * @return 最坏情况下，至少要扔几次鸡蛋，才能鸡蛋刚好不会碎的楼层
     */
    public static int superEggDrop(int K, int N) {
        // 1、base case: 只有一个鸡蛋，线性遍历所有楼层；楼层数为0，不需要扔鸡蛋
        if (K == 1) {
            return N;
        }
        if (N == 0) {
            return 0;
        }

        // 备忘录(Map)消除重叠子问题
        Map<Integer, Integer> memo = Maps.newHashMap();
        if (memo.containsKey(N * 100 + K)) {
            return memo.get(N * 100 + K);
        }

        int result = Integer.MAX_VALUE;
        // 3、穷举所有可能的选择
        for (int i = 1; i <= N; i++) {
            /**
             * 在**最坏**情况下的最少扔鸡蛋次数(最坏情况 & 最少扔鸡蛋次数)
             *
             * 在第 i 层楼扔了鸡蛋之后，可能出现两种情况：鸡蛋碎了，鸡蛋没碎（状态转移）
             * 1、若鸡蛋没碎，则鸡蛋个数 K 不变，搜索楼层区间变为 [i+1, N] ==> 共 N-i 层楼
             * 2、若鸡蛋碎了，则鸡蛋个数 k - 1，搜索楼层的区间变为 [1, i-1] ==> i-1 层楼
             *
             * 注：Math.max()+1中的+1表示在第i层楼扔了一次，这里需要加上，
             * 例：100层楼，使用二分法时，先在第50层扔，若碎了，则最坏情况下，需从第一层试到第49层，一共 50 次
             */
            result = Math.min(result, Math.max(superEggDrop(K, N - i), superEggDrop(K - 1, i - 1)) + 1);
        }
        memo.put(N * 100 + K, result);
        return result;
    }

    /**
     * 二分搜索优化后的解法: 核心是因为状态转移方程的单调性（leetcode 提交超时）
     * <p>
     * 时间复杂度：子问题个数 * 函数本身时间复杂度(忽略递归部分) ==> O(KN) * O(logN)
     * 空间复杂度：O(N)
     * <p>
     * 题目要求最坏情况下至少需要扔几次鸡蛋才能测出鸡蛋恰好摔不碎的楼层F。首先简述一下原始动态规划的思路：
     * 1、暴力穷举尝试在所有楼层1 <= i <= N扔鸡蛋，每次选择尝试次数最少的那一层；
     * 2、每次扔鸡蛋有两种可能，要么碎，要么没碎；
     * 3、如果鸡蛋碎了，F应该在第i层下面，否则，F应该在第i层上面；
     * 4、鸡蛋是碎了还是没碎，取决于哪种情况下尝试次数更多，因为我们想求的是最坏情况下的结果。
     *
     * @param K
     * @param N
     * @return
     */
    public static int superEggDropBinarySearch(int K, int N) {
        // 1、base case: 只有一个鸡蛋，线性遍历所有楼层；楼层数为0，不需要扔鸡蛋
        if (K == 1) {
            return N;
        }
        if (N == 0) {
            return 0;
        }

        // 备忘录(数组)消除重叠子问题
        int[] arr = new int[K + N + 1];
        if (arr[K + N] != 0) {
            return arr[K + N];
        }

        int result = Integer.MAX_VALUE;
        // 二分搜索代替线性搜索
        int low = 1, high = N;
        // 二分搜索容易出错的三个地方:
        // 1、循环退出条件
        while (low <= high) {
            // 2、mid 的取值（Java官方的 JDK 实现，(low + high) >>> 1，无符号右移，即使总和溢出也没关系。）
            int mid = low + ((high - low) >> 1); // 这里还得注意下运算符优先级问题
            // 鸡蛋碎了
            int eggBrokenResult = superEggDropBinarySearch(K - 1, mid - 1);
            // 鸡蛋没碎
            int eggNotBrokenResult = superEggDropBinarySearch(K, N - mid);
            // 3、high 和 low 的更新
            if (eggBrokenResult > eggNotBrokenResult) {
                high = mid - 1;
                result = Math.min(result, eggBrokenResult + 1);
            } else {
                low = mid + 1;
                result = Math.min(result, eggNotBrokenResult + 1);
            }
        }

        arr[K + N] = result;
        return result;
    }

    /**
     * 重写状态转移
     *
     * @param K
     * @param N
     * @return
     */
    public static int superEggDropV3(int K, int N) {
        return -1;
    }

    public static void main(String[] args) {
        // expect:2, actual:2
        long start1 = System.currentTimeMillis();
//        System.out.println(superEggDrop(1, 2));
//        System.out.println("start1:" + (System.currentTimeMillis() - start1) + " ms");
        // expect:3, actual:3
        long start2 = System.currentTimeMillis();
//        System.out.println(superEggDrop(2, 6));
//        System.out.println("start2:" + (System.currentTimeMillis() - start2) + " ms");
        // expect:4, actual:4
        long start3 = System.currentTimeMillis();
//        System.out.println(superEggDrop(3, 14));
//        System.out.println("start3:" + (System.currentTimeMillis() - start3) + " ms");

        // expect:2, actual:2
        long start4 = System.currentTimeMillis();
//        System.out.println(superEggDropBinarySearch(1, 2));
//        System.out.println("start4:" + (System.currentTimeMillis() - start4) + " ms");

        // expect:3, actual:3
        long start5 = System.currentTimeMillis();
//        System.out.println(superEggDropBinarySearch(2, 6));
//        System.out.println("start5:" + (System.currentTimeMillis() - start5) + " ms");

        // expect:4, actual:4
        long start6 = System.currentTimeMillis();
//        System.out.println(superEggDropBinarySearch(3, 14));
//        System.out.println("start6:" + (System.currentTimeMillis() - start6) + " ms");

        // expect:14, actual:14
        long start7 = System.currentTimeMillis();
        System.out.println(superEggDropBinarySearch(2, 100));
//        System.out.println("start7:" + (System.currentTimeMillis() - start7) + " ms");
    }
}
