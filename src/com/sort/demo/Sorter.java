package com.sort.demo;

/**
 * Created by Hanson on 2017/6/17.
 * <p>
 * 排序
 */
public class Sorter {

    /**
     * 直接插入排序
     *
     * @param datas 待排序数组
     */
    public static void insertSort(int[] datas) {
        for (int i = 1; i < datas.length; i++) {
            if (datas[i] < datas[i - 1]) { //0~i-1位为有序，若第i位小于i-1位，继续寻位并插入，否则认为0~i位也是有序的，忽略此次循环，相当于continue
                int temp = datas[i];    //保留第i位的值
                int k = i - 1;
                for (int j = k; j >= 0 && temp < datas[j]; j--) {  //从第i-1位向前遍历并移动位置，直至找到最小的第i位值停止
                    datas[j + 1] = datas[j];
                    k--;
                }
                datas[k + 1] = temp;  //插入第i位的值

            }
        }
    }


    /**
     * 折半排序
     *
     * @param datas 待排序数组
     */
    public static void binInsertSort(int[] datas) {
        for (int i = 1; i < datas.length; i++) {
            int temp = datas[i];    //保持待插入元素
            int low = 0;
            int high = i - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (temp < datas[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            for (int j = i; j >= low; j--) {
                datas[i] = datas[i - 1];
            }
            datas[low] = temp;
        }
    }

    /**
     * 希尔排序
     *
     * @param datas
     */
    public void shellInsertSort(int[] datas) {
        int d = datas.length;   //排序增量
        while (true) {
            d = d / 2;
            for (int i = 0; i < d; i++) {
                for (int j = i + d; j < datas.length; j += d) {
                    int temp = datas[j];
                    int k;
                    for (k = j - d; k >= 0 && datas[k] > temp; k -= d) {
                        datas[k + d] = datas[k];
                    }
                    datas[k + d] = temp;
                }
            }
            if (d == 1) {
                break;
            }
        }
    }

    /**
     * 冒泡排序
     *
     * @param datas
     */
    public void bubbleSort(int[] datas) {
        int temp = 0;
        for (int i = datas.length; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (datas[j + 1] < datas[j]) {
                    temp = datas[j];
                    datas[j] = datas[j + 1];
                    datas[j + 1] = temp;
                }
            }
        }
    }


    /**
     * 快速排序
     *
     * @param datas
     * @param low
     * @param high
     */
    public void quickSort(int[] datas, int low, int high) {
        if (low < high) {
            int nlow = low;
            int nhigh = high;
            int x = datas[low];

            while (nlow < nhigh) {
                while (nlow < nhigh && datas[nhigh] >= x)
                    nhigh--;
                if (nlow < nhigh)
                    datas[nlow++] = datas[nhigh];
                while (nlow < nhigh && datas[nlow] < x)
                    nlow++;
                if (nlow < nhigh)
                    datas[nhigh--] = datas[nlow];
            }
            datas[nlow] = x;
            quickSort(datas, low, nlow - 1);
            quickSort(datas, nlow + 1, high);
        }
    }

    /**
     * 简单选择排序
     *
     * @param datas
     */
    public void selectSort(int[] datas) {
        for (int i = 0; i < datas.length; i++) {
            int min = i;
            for (int j = min + 1; j < datas.length; j++) {
                if (datas[min] > datas[j])
                    min = j;
            }
            int temp = datas[i];
            datas[i] = datas[min];
            datas[min] = temp;
        }
    }


    /**
     * 归并排序
     *
     * @param datas
     * @param low
     * @param high
     */
    public void mergeSort(int datas[], int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(datas, low, mid);
            mergeSort(datas, mid + 1, high);
        }
    }

    private void mergeArray(int[] datas, int low, int mid, int high) {
        int i = low;    //第1段序列的下标
        int j = mid + 1;    //第2段序列的下标
        int k = 0;  //临时存放序列的下标
        int[] array2 = new int[high - low + 1]; //临时合并序列

        // 扫描第1段和第2段序列，直到有一个扫描结束
        while (i <= mid && j <= high) {
            // 判断第一段和第二段取出的数哪个更小，将其存入合并序列，并继续向下扫描
            if (datas[i] <= datas[j]) {
                array2[k] = datas[i];
                i++;
                k++;
            } else {
                array2[k] = datas[j];
                j++;
                k++;
            }
        }

        // 若第一段序列还没扫描完，将其全部复制到合并序列
        while (i <= mid) {
            array2[k] = datas[i];
            i++;
            k++;
        }

        // 若第二段序列还没扫描完，将其全部复制到合并序列
        while (j <= high) {
            array2[k] = datas[j];
            j++;
            k++;
        }

        // 将合并序列复制到原始序列中
        for (k = 0, i = low; i <= high; i++, k++) {
            datas[i] = array2[k];
        }
    }


    /**
     * 堆排序
     *
     * @param datas
     */
    public void heapSort(int[] datas) {
        int arrayLength = datas.length;
        //循环建堆
        for (int i = 0; i < arrayLength - 1; i++) {
            //建堆
            buildMaxHeap(datas, arrayLength - 1 - i);
            //交换堆顶和最后一个元素
            swap(datas, 0, arrayLength - 1 - i);
        }
    }

    // 对datas数组从0到lastIndex建堆
    private void buildMaxHeap(int[] datas, int lastIndex) {
        //从lastIndex处结点（最后一个结点）的父结点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            //保存正在判断的结点
            int k = i;
            // 如果当前k结点的子结点存在
            while (k * 2 + 1 <= lastIndex) {
                //k结点的左子结点的索引
                int biggerIndex = 2 * k + 1;
                //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k结点的右子结点存在
                if (biggerIndex < lastIndex) {
                    //若果右子结点的值较大
                    if (datas[biggerIndex] < datas[biggerIndex + 1]) {
                        //biggerIndex总是记录较大子结点的索引
                        biggerIndex++;
                    }
                }
                //如果k结点的值小于其较大的子结点的值
                if (datas[k] < datas[biggerIndex]) {
                    //交换他们
                    swap(datas, k, biggerIndex);
                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k结点的值大于其左右子结点的值
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    //交换
    private void swap(int[] datas, int i, int j) {
        int tmp = datas[i];
        datas[i] = datas[j];
        datas[j] = tmp;
    }


}
