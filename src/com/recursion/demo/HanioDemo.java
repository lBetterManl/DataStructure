package com.recursion.demo;

/**
 * Created by Hanson on 2017/6/7.
 * <p>
 * 汉诺塔问题
 * <p>
 * 汉诺塔问题是指有三根杆子A,B,C。C杆上有若干碟子，
 * 把所有碟子从A杆上移到C杆上，每次只能移动一个碟子，
 * 大的碟子不能叠在小的碟子上面。求最少要移动多少次？
 */
public class HanioDemo {
    static StringBuffer str = new StringBuffer();

    /**
     * 汉诺塔问题
     *
     * @param n 盘子个数
     * @param x 将要移动盘子柱子
     * @param y 要借用的柱子
     * @param z 样移动到的柱子
     * @return
     */
    public static String hanio(int n, Object x, Object y, Object z) {
        if (1 == n) {
            str.append(move(x, n, z) + "\n");
        } else {
            hanio(n - 1, x, z, y);
            str.append(move(x, n, z) + "\n");
            hanio(n - 1, y, x, z);
        }
        return str.toString();
    }

    private static String move(Object x, int n, Object y) {
        return "Move " + n + " from " + x + " to " + y;
    }
}
