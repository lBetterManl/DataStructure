package com.queue.demo;

/**
 * Created by Hanson on 2017/6/6.
 * <p>
 * 顺序循环队列
 */
public class ArrayQueue implements Queue {
    private static int DEFAULT_SIZE = 2;
    private Object[] array = null;
    private int front, rear, count; //队首、队尾标注和队列大小

    public ArrayQueue() {
        array = new Object[DEFAULT_SIZE];
        front = rear = count = 0;
    }

    /**
     * 扩展队空间
     */
    private void expand() {
        Object[] newArray = new Object[2 * DEFAULT_SIZE];
        for (int i = 0; i < count; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        front = 0;
        rear = count;
        DEFAULT_SIZE = 2 * DEFAULT_SIZE;
    }

    @Override
    public void clear() {
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            array[i] = null;
        }
        front = rear = count = 0;
    }

    @Override
    public boolean isEmpty() {
        if ((rear == front) && (0 == count))
            return true;
        else
            return false;
    }

    @Override
    public Object deQueue() {
        if (0 == count) {
            throw new IllegalStateException("队列已空，无数据元素可出队列！");
        } else {
            Object obj = array[front];
            System.out.println("front1：" + (front + 1));
            front = (front + 1) % DEFAULT_SIZE;
            System.out.println("front2：" + front);
            count--;
            return obj;
        }
    }

    @Override
    public Object peek() {
        if (0 == count) {
            throw new IllegalStateException("队列已空，无数据元素可出队列！");
        } else {
            return array[front];
        }
    }

    @Override
    public void push(Object e) {
        if ((rear == front) && (count > 0)) {
            expand();
        }
        array[rear] = e;
        System.out.println("rear1：" + (rear + 1));
        rear = (rear + 1) % DEFAULT_SIZE;   //整除时队尾指向队首
        System.out.println("DEFAULT_SIZE：" + DEFAULT_SIZE);
        System.out.println("rear2：" + rear);
        count++;
    }

    @Override
    public int size() {
        return count;
    }

    public String toString() {
        String str = "[";
        for (int i = 0; i < count; i++) {
            str += array[(front + i) % DEFAULT_SIZE];   //整除时队尾指向队首
            str += ", ";
        }
        str += "]";
        return str;
    }
}
