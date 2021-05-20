package com.rarestzhou.leetcode_solutions.java.string;

import cn.hutool.core.convert.Convert;

import java.util.ArrayList;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * 原题链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 *
 * @author: wuxiu
 * @date: 2021/3/12 08:42
 * @description: 删除字符串中的所有相邻重复项
 */
public class RemoveDuplicatesSolutions {

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
        System.out.println(removeDuplicatesV2(s));
        System.out.println(removeDuplicatesV3(s));
    }

    static String removeDuplicates(String s) {
        int length = s.length();
        if (length == 1) {
            return s;
        }

        char[] chars = s.toCharArray();
        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            characters.add(chars[i]);
        }

        // 设置两个指针，初始时，分别指向字符串第一个字符和第二个字符
        int prev = 0;
        int next = 1;
        for (int i = 0; i < length; i++) {
            if (characters.get(prev) == characters.get(next)) {
                characters.remove(prev);
                characters.remove(prev);
                if (characters.size() == 1) {
                    break;
                }
                // 从头开始
                prev = 0;
                next = 1;
            } else {
                next++;
                prev++;
                // 若指针已经到字符串尾部，直接 break
                if (next >= characters.size()) {
                    break;
                }
            }
        }
        return Convert.toStr(characters);
    }

    /**
     * 题目的关键在于 删除重复项，因此重点在于找到所有重复项，包含 因为删除而产生的重复项，因此可以使用栈实现。
     * 每次添加时比较是否与栈顶元素相同：
     *  - 若相同则删除栈顶元素且不插入
     *  - 若不相同则插入新元素
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param s
     * @return
     */
    static String removeDuplicatesV2(String s) {
        StringBuilder stack = new StringBuilder();
        int top = -1;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                top--;
            } else {
                stack.append(ch);
                top++;
            }
        }
        return stack.toString();
    }

    /**
     * 双指针（思路特别）,以字符串 "abbaca"为例
     *
     * left = 0,right = 0 -> abbaca
     * left = 1,right = 1 -> abbaca
     * left = 2,right = 2 -> abbaca（此时，ch[left]==ch[left-1] -> left-=2）
     * left = 1,right = 3(ch[1]=ch[3]) -> aabaca（此时，ch[left]==ch[left-1] -> left-=2）
     * left = 0,right = 4(ch[0]=ch[4]) -> cabaca
     * left = 1,right = 5 -> cabaca
     * left = 2,right = 6 -> cabaca（退出 while 循环）
     *
     * return new String(ch, 0, left)
     *
     * @param s
     * @return
     */
    static String removeDuplicatesV3(String s) {
        int length = s.length();
        if (length == 1) {
            return s;
        }
        char[] chs = s.toCharArray();
        int left = 0;
        int right = 0;
        while (right < length) {
            // 先把右边的字符赋值给左边
            chs[left] = chs[right];
            // 然后判断左边挨着的两个字符是否相同，如果相同，他两同时消失，也就是left往回退两步
            if (left > 0 && chs[left - 1] == chs[left]) {
                left -= 2;
            }
            right++;
            left++;
        }
        return new String(chs, 0, left);
    }
}
