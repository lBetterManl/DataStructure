package com.recursion.demo;

/**
 * Created by Hanson on 2017/6/7.
 * <p>
 * 求数组中的最大值
 */
public class MaxDemo {

    /**
     * 用递归算法求数组中的最大值(二分查找)。
     *
     * @param a     数组
     * @param low   数组下标
     * @param heigh 数组上标
     * @return 最大值
     */
    public static int Max(int[] a, int low, int heigh) {
        int max;
        if (low > heigh - 2) {
            if (a[low] > a[heigh])
                max = a[low];
            else
                max = a[heigh];
        } else {
            int mid = (low + heigh) / 2;
            int max1 = Max(a, low, mid);
            int max2 = Max(a, mid, heigh);
            max = max1 > max2 ? max1 : max2;
        }
        return max;
    }
}
