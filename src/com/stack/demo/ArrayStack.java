package com.stack.demo;

/**
 * Created by Hanson on 2017/6/6.
 * <p>
 * 顺序（堆）栈
 */
public class ArrayStack implements Stack {
    private static int DEFAULT_SIZE = 10;
    private int size;    //栈内元素个数
    Object[] array;

    public ArrayStack() {
        size = 0;
        array = new Object[DEFAULT_SIZE];
    }

    /**
     * 扩展栈空间
     */
    public void expand() {
        Object[] newArray = new Object[2 * DEFAULT_SIZE];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
            size = 0;
        }
    }

    @Override
    public void push(Object e) {
        if (size == array.length)
            expand();
        array[size] = e;
        size++;
    }

    @Override
    public Object pop() {
        if (0 == size)
            throw new IllegalStateException("栈已空");
        Object val = array[--size];
        array[size] = null;
        return val;
    }

    @Override
    public boolean isEmpty() {
        return 0 == size;
    }

    @Override
    public Object peek() {
        if (0 == size)
            throw new IllegalStateException("栈已空");
        return array[size - 1];
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * 从栈顶开始输出
     *
     * @return 栈字符串
     */
    @Override
    public String toString() {
        String s = "[";
        for (int i = size - 1; i >= 0; i--) {
            s = s + array[i];
            s = s + ",  ";
        }
        s = s + "]";
        return s;
    }
}
