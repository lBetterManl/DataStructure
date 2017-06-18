package com.seek.demo;

/**
 * Created by Hanson on 2017/6/17.
 *
 * 查找
 */
public class Find {

    /**
     * 顺序查找
     * @param s 数组
     * @param key 关键字
     * @return 查找下表，-1 表示不存在
     */
    public static int arraySearch(int[] s, int key){
        for (int i = 0; i < s.length; i++) {
            if (key == s[i]){
                return i;
            }
        }
        return -1;
    }

    /**
     * 折半查找非递归实现
     * @param s 已排序数组
     * @param low 最低点下标
     * @param high 最高点标
     * @param key 查找关键字
     * @return 查找到的下标
     */
    public static int binSearch(int[] s, int low, int high, int key){
        while (low < high){
            int mid = (low + high)/2;
            if (s[mid] == key)
                return mid;
            else if (s[mid] > key)
                high = mid -1;
            else
                low = mid + 1;
        }
        return -1;
    }
}
