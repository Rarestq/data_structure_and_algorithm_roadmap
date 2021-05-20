package com.rarestzhou.leetcode_solutions.java.jzoffer;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 *
 * @author: wuxiu
 * @date: 2021/4/25 08:58
 * @description: 翻转单词顺序
 */
public class ReverseWordsSolutions {

    public static void main(String[] args) {
        String s1 = "the sky is blue";
        System.out.println(reverseWords(s1));
        String s2 = "  hello world!  ";
        System.out.println("===========");
        System.out.println(reverseWords(s2));
        String s3 = "a good   example";
        System.out.println("===========");
        System.out.println(reverseWords(s3));
        String s4 = "I am a student. ";
        System.out.println("===========");
        System.out.println(reverseWords(s4));
    }

    public static String reverseWords(String s) {
        // 先去除首尾空格
        s = s.trim();
        int i = s.length() - 1;
        int j = i;
        StringBuilder reverseWords = new StringBuilder();
        // 倒序遍历
        while (i >= 0) {
            // 找到首个空格
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            reverseWords.append(s, i + 1, j + 1);
            // 跳过单词间空格
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            // j指向下个单词的尾字符
            j = i;
        }
        return reverseWords.toString();
    }
}
