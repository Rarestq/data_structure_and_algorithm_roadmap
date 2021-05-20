package com.rarestzhou.leetcode_solutions.java.sorting;

import java.util.Arrays;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @author: wuxiu
 * @date: 2021/1/27 11:24
 * @description: 冒泡排序
 */
public class BubbleSortSolutions {

    /**
     * 冒泡排序
     *
     * @param arr       待排序数组
     * @param arrLength 数组大小
     */
    public static void bubbleSort(int[] arr, int arrLength) {
        // 数组长度小于等于 1，无需排序
        if (arrLength <= 1) {
            return;
        }

        for (int i = 0; i < arrLength; i++) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < arrLength - i - 1; j++) {
                // 交换
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    // 表示有数据交换
                    flag = true;
                }
            }
            // 没有数据交换，提前退出循环
            if (!flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 4, 1, 2, 6};
//        int[] arr = new int[]{4, 5, 6, 3, 2, 1};
        int arrLength = arr.length;
        System.out.println("排序前：" + Arrays.toString(arr));
        bubbleSort(arr, arrLength);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

}
