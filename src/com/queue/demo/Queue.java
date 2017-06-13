package com.queue.demo;

/**
 * Created by Hanson on 2017/6/6.
 * <p>
 * 队列接口
 */
public interface Queue {

    /**
     * 清空队列
     */
    public void clear();

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty();

    /**
     * 出队
     *
     * @return
     */
    public Object deQueue();

    /**
     * 取队首元素
     *
     * @return
     */
    public Object peek();

    /**
     * 入队
     */
    public void push(Object e);

    /**
     * 元素个数
     *
     * @return
     */
    public int size();
}
