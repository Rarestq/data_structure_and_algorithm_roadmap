package com.rarestzhou.leetcode_solutions.java.string;


/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * 125. 验证回文串：https://leetcode-cn.com/problems/valid-palindrome/
 *
 * @author: wuxiu
 * @date: 2019/12/10 20:51
 */
public class ValidPalindromeSolutions {

    /**
     * 解法一：常规思路
     *  1、将字符串中的非字母和数字字符过滤掉 -> 正则表达式
     *  2、反转字符串 -> new StringBuffer(s).reverse()
     *  3、比较字符串 -> equalsIgnoreCase
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        // 1、处理字符串 s，只保留数字和字母
        s = s.replaceAll("(?i)[^a-zA-Z0-9\u4E00-\u9FA5]", "");
        // 2、反转字符串s
        String reversedStr = new StringBuffer(s).reverse().toString();

        // 3、比较反转后的字符串和原字符串是不是相等的
        return s.equalsIgnoreCase(reversedStr);
    }

    public boolean isPalindrome2(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }

        return true;
    }
}
