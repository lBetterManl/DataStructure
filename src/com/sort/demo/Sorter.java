package com.sort.demo;

/**
 * Created by Hanson on 2017/6/17.
 *
 * 排序
 */
public class Sorter{

    /**
     * 直接插入排序
     * @param datas 待排序数组
     */
    public static void insertSort(int[] datas){
        for (int i = 1; i < datas.length; i++) {
            if (datas[i] < datas[i-1]){ //0~i-1位为有序，若第i位小于i-1位，继续寻位并插入，否则认为0~i位也是有序的，忽略此次循环，相当于continue
                int temp = datas[i];    //保留第i位的值
                int k = i - 1;
                for (int j=k;j>=0 && temp<datas[j];j--){  //从第i-1位向前遍历并移动位置，直至找到最小的第i位值停止
                    datas[j+1] = datas[j];
                    k--;
                }
                datas[k+1] = temp;  //插入第i位的值

            }
        }
    }


    /**
     * 折半排序
     * @param datas 待排序数组
     */
    public static void binInsertSort(int[] datas){
        for (int i = 1; i < datas.length; i++) {
            int temp = datas[i];    //保持待插入元素
            int low = 0;
            int high = i-1;
            while (low<=high){
                int mid = (low + high)/2;
                if (temp < datas[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            for (int j = i; j >= low; j--) {
                datas[i] = datas[i-1];
            }
            datas[low] = temp;
        }
    }

}
