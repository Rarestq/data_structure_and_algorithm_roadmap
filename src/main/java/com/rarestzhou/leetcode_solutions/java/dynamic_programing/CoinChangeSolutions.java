package com.rarestzhou.leetcode_solutions.java.dynamic_programing;

import java.util.Arrays;
import java.util.List;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 * <p>
 * https://leetcode-cn.com/problems/coin-change/
 * <p>
 * https://leetcode-cn.com/problems/coin-change-2/
 *
 * @author: wuxiu
 * @date: 2020/9/27 22:28
 * @description: 硬币兑换
 */
public class CoinChangeSolutions {

    /**
     * 思路：
     * 1、求解所有满足条件的组合
     * 2、从组合中选出总和最小的组合。如果找不到满足条件的组合则返回-1即可
     *
     * @param targetCoinVal  目标金额
     * @param coins          硬币面值数组
     * @return 给定若干面值硬币，为了得到目标金额，所需硬币数量的最小值
     */
    private static int getMinCountHelperRecursively(int targetCoinVal, int[] coins) {
        // 若金额为0，说明当前组合成立，将组合添加到待选数组中
        if (0 == targetCoinVal) {
            return 0;
        }

        // 初始化所需最少硬币数量
        int minCount = Integer.MAX_VALUE;
        // 遍历所有硬币面值
        for (int currentCoinVal : coins) {
            // 若当前面值大于当前总额，则跳过
            if (currentCoinVal > targetCoinVal) {
                continue;
            }

            // 使用当前面值的硬币，得到目标硬币剩余总额
            int rest = targetCoinVal - currentCoinVal;
            int restCount = getMinCountHelperRecursively(rest, coins);
            // 若返回 -1，说明组合不可信，跳过
            if (restCount == -1) {
                continue;
            }
            // 保留最小总额
            int totalCount = 1 + restCount;
            if (totalCount < minCount) {
                minCount = totalCount;
            }
        }

        // 若没有可用组合，则返回-1
        if (minCount == Integer.MAX_VALUE) {
            return -1;
        }

        // 返回所需的最少硬币数量
        return minCount;
    }

    static int getMinCountsOfCoinsAdvance() {
        // 硬币面值数组
        int[] coins = { 3, 5 };
        // 目标金额总值
        int targetCoinVal = 25;
        // 输出答案
        return getMinCountHelperRecursively(targetCoinVal, coins);
    }

    /**
     * 过于贪心的「贪心算法」
     *
     * @param target 目标金额
     * @param coins  硬币面值数组，按从大到小排序
     * @return 返回为了得到目标金额使用的硬币数，-1 表示无解
     */
    private static int getMinCoinCountHelper(int target, int[] coins) {
        int valueCount = coins.length;
        if (valueCount == 0) {
            return -1;
        }
        int rest = target;
        int count = 0;

        // 从大到小遍历所有硬币的面值
        for (int i = 0; i < valueCount; i++) {
            // 计算当前面值最多能用多少个
            int currentCount = rest / coins[i];
            // 得到用完当前面值后剩下的余额
            rest -= currentCount * coins[i];
            // 增加硬币使用数量
            count += currentCount;

            if (rest == 0) {
                return count;
            }
        }
        // 表示凑不出指定金额
        return -1;
    }

    private static int getMinCoinCountHelperPremium(int total, int[] values, int valueIndex) {
        int valueCount = values.length;
        if (valueIndex == valueCount) {
            return Integer.MAX_VALUE;
        }

        int minResult = Integer.MAX_VALUE;
        int currentValue = values[valueIndex];
        int maxCount = total / currentValue;

        for (int count = maxCount; count >= 0; count--) {
            int rest = total - count * currentValue;
            // 如果 rest = 0，表示余额已经除尽，硬币兑换完成
            if (rest == 0) {
                minResult = Math.min(minResult, count);
                break;
            }

            // 否则尝试用剩下面值求当前余额的硬币总数
            int restCount = getMinCoinCountHelperPremium(rest, values, valueIndex + 1);
            // 如果后续没有可用组合
            if (restCount == Integer.MAX_VALUE) {
                // 如果当前面值已经为0，返回-1表示尝试失败
                if (count == 0) {
                    break;
                }
                // 否则尝试把当前面值-1
                continue;
            }
            minResult = Math.min(minResult, count + restCount);
        }
        return minResult;
    }

    private static int getMinCoinCountLoop(int total, int[] values, int k) {
        int minCount = Integer.MAX_VALUE;
        int valueCount = values.length;
        if (k == valueCount) {
            return Math.min(minCount, getMinCoinCountHelperPremium(total, values, 0));
        }

        for (int i = k; i <= valueCount - 1; i++) {
            // k 位置已经排列好
            int t = values[k];
            values[k] = values[i];
            values[i] = t;
            minCount = Math.min(minCount, getMinCoinCountHelperPremium(total, values, 0));
            // 考虑后一位
            minCount = Math.min(minCount, getMinCoinCountLoop(total, values, k + 1));

            // 回溯
            t = values[k];
            values[k] = values[i];
            values[i] = t;
        }
        return minCount;
    }

    private static int getMinCoinCountOfValueHelper(int total, int[] coins) {
        if (coins.length == 0) {
            return -1;
        }

        // 当前币值
        int currentCoin = coins[0];

        // 当前面币值使用数量
        int currentCoinMaxCount = total / currentCoin;

        int rest = total - currentCoinMaxCount * currentCoin;
        // 若 rest = 0，表示余额已除尽，组合完成
        if (rest == 0) {
            return currentCoinMaxCount;
        }

        // 最少币数
        int minCoinCount = Integer.MAX_VALUE;
        // 其他币种数量
        int coinCount = 0;
        // 剩余的币种
        int[] restCoins = Arrays.copyOfRange(coins, 1, coins.length);
        while (currentCoinMaxCount >= 0) {
            // 否则尝试用剩余面值求当前余额的硬币总数
            coinCount = getMinCoinCountOfValueHelper(rest, restCoins);

            // 取最少的值
            if (coinCount > 0) {
                minCoinCount = Math.min(minCoinCount, currentCoinMaxCount + coinCount);
            }

            // 如果后续没有可用组合,退一步，当前面值使用币数(currentCoinMaxCount)减 1 否则尝试把当前面值数 -1
            currentCoinMaxCount--;
            // 重新计算 rest
            rest = total - currentCoinMaxCount * currentCoin;
        }

        return (minCoinCount == Integer.MAX_VALUE) ? -1 : minCoinCount;
    }

    private static void getMinCountsHelper(int total, int[] coins, List<Integer> currentCounts, List<List<Integer>> combinations) {
        // 如果余额为 0，说明当前组合成立，将组合加入到待选数组中
        if (total == 0) {
            combinations.add(currentCounts);
        }
    }

    public static void main(String[] args) {
        // 硬币面值
        int[] coins = {10, 7, 1};
        // 总价
        int total = 14;
        int minCoinCount = getMinCoinCountHelper(total, coins);
        // 返回 -1
//        System.out.println("有面值 5 和 3 的硬币各一枚，凑出总金额为 11 最少需要硬币个数：" + minCoinCount);
//
//        int minCoinCount2 = getMinCoinCountLoop(total, coins, 0);
//        minCoinCount2 = (minCoinCount2 == Integer.MAX_VALUE) ? -1 : minCoinCount2;
//        System.out.println("[解决过于贪心后的贪心算法]有面值 5 和 3 的硬币各一枚，凑出总金额为 11 最少需要硬币个数：" + minCoinCount2);
//
//        System.out.println(getMinCoinCountOfValueHelper(total, coins));

        System.out.println(getMinCountsOfCoinsAdvance());
    }

}
