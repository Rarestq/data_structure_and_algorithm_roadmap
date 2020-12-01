package com.rarestzhou.leetcode_solutions.java.dynamic_programing;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @author: wuxiu
 * @date: 2020/10/15 16:36
 * @description: 背包问题题解
 */
public class KnapsackSolutions {

    /**
     * 背包问题动态规划解法
     * <p>
     * 时间复杂度：O(n*w)
     * 空间复杂度：O(n*(w+1))
     *
     * @param weight 物品重量
     * @param n      物品个数
     * @param w      背包可承载重量
     * @return 背包最大能承受的重量
     */
    public static int knapsackDpSolution(int[] weight, int n, int w) {
        // 默认值为 false
        boolean[][] states = new boolean[n][w + 1];
        // 第一行的数据需特殊处理，可以利用哨兵优化
        states[0][0] = true; // 这里表示第一个物品不放到背包里
        if (weight[0] <= w) {
            // 第一个物品放到背包里
            states[0][weight[0]] = true;
        }

        // 动态规划状态转移
        for (int i = 1; i < n; i++) {
            // 不把第一个物品放到背包里，已做特殊处理
            for (int j = 0; j <= w; j++) {
                if (states[i - 1][j]) {
                    states[i][j] = states[i - 1][j];
                }
            }

            // 把第 i 个物品放入背包
            for (int j = 0; j <= w - weight[i]; j++) {
                if (states[i - 1][j]) {
                    states[i][j + weight[i]] = true;
                }
            }
        }

        // 输出结果,从最后一层找到值为true的最接近w的值即可
        for (int i = w; i >= 0; i--) {
            if (states[n - 1][i]) {
                return i;
            }
        }

        return 0;
    }

    /**
     * 动态规划优化解决方案，之前是通过一个二维数组来辅助计算，用空间换时间，这里只需一个一维数组即可
     *
     * @param weight
     * @param n
     * @param w
     * @return
     */
    public static int knapsackOptimizeDpSolution(int[] weight, int n, int w) {
        boolean[] states = new boolean[w + 1]; // 默认值false
        states[0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        if (weight[0] <= w) {
            states[weight[0]] = true;
        }
        for (int i = 1; i < n; ++i) { // 动态规划
            // 把第i个物品放入背包
            for (int j = w - weight[i]; j >= 0; --j) {
                if (states[j]) states[j + weight[i]] = true;
            }
        }
        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[i]) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        // 物品重量
        int[] weight = {2, 2, 4, 6, 3};
        // 物品个数
        int n = 5;
        // 背包所能承受的最大重量
        int w = 9;
        // 9
        System.out.println(knapsackDpSolution(weight, n, w));
    }
}
