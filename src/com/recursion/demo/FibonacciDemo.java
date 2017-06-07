package com.recursion.demo;

/**
 * Created by Hanson on 2017/6/7.
 * <p>
 * 斐波纳契数列
 * <p>
 * 指的是这样一个数列：1、1、2、3、5、8、13、21、……
 * 在数学上，斐波纳契数列以如下被以递归的方法定义：
 * F0=0，F1=1，Fn=F(n-1)+F(n-2)（n>=2，n∈N*）
 */
public class FibonacciDemo {

    /**
     * 斐波纳契数列
     * @param n 数例中第n个
     * @return 第n个数
     */
    public static long fibonacci(int n) {
        if((0==n) || (1==n))
            return n;
        else
            return fibonacci(n-1)+fibonacci(n-2);
    }

}
