package com.rarestzhou.leetcode_solutions.java.array;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 * <p>
 * 原题链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 * <p>
 * 提示：
 * 1、2 <= A.length <= 20000
 * 2、A.length % 2 == 0
 * 3、0 <= A[i] <= 1000
 * <p>
 * 结果实例：
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。--> 即，不一定按大小顺序，只要奇偶分开即可
 *
 * @author: wuxiu
 * @date: 2020/12/7 14:15
 * @description: 按奇偶排序数组解法
 */
public class SortArrayByParitySolutions {

    /**
     * 按奇偶排序数组解法一：两次遍历
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param A 非负整数数组，一半是奇数，一半是偶数
     * @return 当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
     */
    public static int[] sortArrayByParityII(int[] A) {
        int arrLength = A.length;
        int[] result = new int[arrLength];

        int idx = 0;
        for (int ele : A) {
            if (ele % 2 == 0) {
                result[idx] = ele;
                idx += 2;
            }
        }

        idx = 1;
        for (int ele : A) {
            if (ele % 2 != 0) {
                result[idx] = ele;
                idx += 2;
            }
        }

        return result;
    }

    /**
     * 按奇偶排序数组解法一：双指针
     *
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * @param A
     * @return
     */
    public static int[] sortArrayByParityIIByDoublePointer(int[] A) {
        int arrLength = A.length;
        // 奇数下标
        int oddIndex = 1;
        for (int evenIndex = 0; evenIndex < arrLength; evenIndex += 2) {
            // 偶数下标的数字为奇数时，则找到奇数下标中为偶数的，然后交换（步长为2可以保证每次一定是奇数位和偶数位互换）
            // 与运算比模运算更快，故可以改成 (A[evenIndex] & 1) == 1
            if (A[evenIndex] % 2 == 1) {
                while (A[oddIndex] % 2 == 1) {
                    oddIndex += 2;
                }
                swap(A, evenIndex, oddIndex);
            }
        }
        return A;
    }

    /**
     * 交换元素
     *
     * @param A
     * @param evenIndex
     * @param oddIndex
     */
    private static void swap(int[] A, int evenIndex, int oddIndex) {
        int temp = A[evenIndex];
        A[evenIndex] = A[oddIndex];
        A[oddIndex] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6};
        int[] result1 = sortArrayByParityII(arr);
        for (int ele : result1) {
            System.out.println(ele);
        }

        int[] arr2 = {4, 2, 5, 7};
        int[] result2 = sortArrayByParityIIByDoublePointer(arr2);
        for (int ele : result2) {
            System.out.println(ele);
        }

    }
}
