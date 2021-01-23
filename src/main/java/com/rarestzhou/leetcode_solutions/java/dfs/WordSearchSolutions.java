package com.rarestzhou.leetcode_solutions.java.dfs;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 * <p>
 * 原题链接：https://leetcode-cn.com/problems/word-search/
 * <p>
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例：
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 *
 * 整体思路：使用深度优先搜索(DFS) 和回溯的思想实现，关于判断元素是否使用过，可以用一个二维数组 mark 对使用过的元素做标记(这类问题常见技巧)。
 * 类似问题：
 *  1、https://leetcode-cn.com/problems/surrounded-regions/
 *  2、https://leetcode-cn.com/problems/number-of-islands/
 *
 * @author: wuxiu
 * @date: 2020/12/7 17:16
 * @description: 单词搜索题解
 */
public class WordSearchSolutions {

    /**
     * 解法一：递归/回溯
     *
     * 外层：遍历，内层：递归
     *
     * @param board
     * @param word
     * @return
     */
    public static boolean existV1(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {

            }
        }
        return false;
    }

    /**
     * 解法二：双指针（行、列）
     *
     * @param board
     * @param word
     * @return
     */
    public static boolean existV2(char[][] board, String word) {
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word1 = "ABCCED";
        System.out.println(existV1(board, word1));
        String word2 = "SEE";
        System.out.println(existV1(board, word2));
        String word3 = "ABCB";
        System.out.println(existV1(board, word3));
    }
}
