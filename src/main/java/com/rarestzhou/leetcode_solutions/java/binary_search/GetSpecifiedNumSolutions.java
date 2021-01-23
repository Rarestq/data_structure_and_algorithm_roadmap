package com.rarestzhou.leetcode_solutions.java.binary_search;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 * <p>
 * 在有序数组中(从小到大排序)获取满足指定条件的数字:
 * 1、查找第一个值等于给定值的元素
 * 2、查找最后一个值等于给定值的元素
 * 3、查找第一个大于等于给定值的元素
 * 4、查找最后一个小于等于给定值的元素
 *
 * @author: wuxiu
 * @date: 2020/10/28 10:43
 * @description: 在有序数组中(从小到大排序)获取满足指定条件的数字
 */
public class GetSpecifiedNumSolutions {

    /**
     * 查找第一个值等于给定值的元素
     *
     * @param sortedNumArr 从小到大排序的数组
     * @param arrLength    给定数组的长度
     * @param target       给定数字
     * @return 原数组下标, 找不到则返回 -1
     */
    public static int getFirstEqualGivenNum(int[] sortedNumArr, int arrLength, int target) {
        if (arrLength <= 0) {
            return -1;
        }
        if (arrLength == 1) {
            return sortedNumArr[0] == target ? 0 : -1;
        }

        int low = 0;
        int high = arrLength - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (sortedNumArr[mid] < target) {
                low = mid + 1;
            } else if (sortedNumArr[mid] > target) {
                high = mid - 1;
            } else {
                // 相等时，则需再判断左区间第一个数是否等于给定值，或者 mid 是否为 0，若是，则直接返回；否则，继续往左边缩小范围查找最小的下标
                if ((mid == 0) || (sortedNumArr[mid - 1] != target)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     *
     * @param sortedNumArr 从小到大排序的数组
     * @param arrLength    给定数组的长度
     * @param target       给定数字
     * @return 原数组下标, 找不到则返回 -1
     */
    public static int getLastEqualGivenNum(int[] sortedNumArr, int arrLength, int target) {
        if (arrLength <= 0) {
            return -1;
        }
        if (arrLength == 1) {
            return sortedNumArr[0] == target ? 0 : -1;
        }

        int low = 0;
        int high = arrLength - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (sortedNumArr[mid] < target) {
                low = mid + 1;
            } else if (sortedNumArr[mid] > target) {
                high = mid - 1;
            } else {
                // 相等时，则需再判断右区间第一个数是否等于给定值，或者 mid 是否为 n-1，若是，则直接返回；否则，继续往右边缩小范围查找最小的下标
                if ((mid == arrLength - 1) || (sortedNumArr[mid + 1] != target)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     *
     * @param sortedNumArr 从小到大排序的数组
     * @param arrLength    给定数组的长度
     * @param target       给定数字
     * @return 原数组下标, 找不到则返回 -1
     */
    public static int getFirstGreaterThanGivenNum(int[] sortedNumArr, int arrLength, int target) {
        if (arrLength <= 0) {
            return -1;
        }
        if (arrLength == 1) {
            return sortedNumArr[0] == target ? 0 : -1;
        }

        int low = 0;
        int high = arrLength - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (sortedNumArr[mid] < target) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (sortedNumArr[mid - 1] < target)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     *
     * @param sortedNumArr 从小到大排序的数组
     * @param arrLength    给定数组的长度
     * @param target       给定数字
     * @return 原数组下标, 找不到则返回 -1
     */
    public static int getLastLessThanGivenNum(int[] sortedNumArr, int arrLength, int target) {
        if (arrLength <= 0) {
            return -1;
        }
        if (arrLength == 1) {
            return sortedNumArr[0] == target ? 0 : -1;
        }

        int low = 0;
        int high = arrLength - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (sortedNumArr[mid] > target) {
                high = mid - 1;
            } else {
                if ((mid == arrLength - 1) || (sortedNumArr[mid + 1] > target)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 设按照升序排序的数组在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
     * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     * <p>
     * {https://leetcode-cn.com/problems/search-in-rotated-sorted-array/}
     * <p>
     * 提示：
     * 1、1 <= nums.length <= 5000
     * 2、-10^4 <= nums[i] <= 10^4
     * 3、nums 中的每个值都 独一无二
     * 4、nums 肯定会在某个点上旋转
     * 5、-10^4 <= target <= 10^4
     * <p>
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     *
     * @param rotatedSortedArr 循环有序数组，例：4, 5, 6, 1, 2, 3
     * @param arrLength        数组长度
     * @param target           给定值
     * @return 原数组下标, 找不到则返回 -1
     */
    private static int searchGivenNumFromRotatedSortedArr(int[] rotatedSortedArr, int arrLength, int target) {
        if (arrLength <= 0) {
            return -1;
        }
        if (arrLength == 1) {
            return rotatedSortedArr[0] == target ? 0 : -1;
        }

        int low = 0;
        int high = arrLength - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            // 先根据 mid 将数组分成两部分，这个时候会得到两个新的数组，且必然是：一个有序数组+一个循环有序数组
            if (rotatedSortedArr[mid] == target) {
                return mid;
            }

            // 若 mid 左边是有序数组,
            if (rotatedSortedArr[0] <= rotatedSortedArr[mid]) {
                // 且目标值也在该范围内, 则继续缩小范围到 [low, mid - 1]
                if (rotatedSortedArr[0] <= target && target < rotatedSortedArr[mid]) {
                    high = mid - 1;
                } else {
                    // 否则，缩小范围到 [mid + 1, high]
                    low = mid + 1;
                }
            } else {
                if (rotatedSortedArr[mid] < target && target <= rotatedSortedArr[arrLength - 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 3, 4, 6, 7};
        int givenNum = 5;
        System.out.println("查找第一个值等于给定值的元素的下标：" + getFirstEqualGivenNum(nums, nums.length, givenNum));
        System.out.println("查找最后一个值等于给定值的元素的下标：" + getLastEqualGivenNum(nums, nums.length, givenNum));
        System.out.println("查找第一个大于等于给定值的元素的下标：" + getFirstGreaterThanGivenNum(nums, nums.length, givenNum));
        System.out.println("查找最后一个小于等于给定值的元素的下标：" + getLastLessThanGivenNum(nums, nums.length, givenNum));

        int[] rotatedSortedArr = {5, 6, 7, 0, 1, 2, 3};
        int target = 1;
        System.out.println("旋转有序数组中查找给定值的元素下标：" +
                searchGivenNumFromRotatedSortedArr(rotatedSortedArr, rotatedSortedArr.length, target));
    }
}
