package com.stack.demo;

/**
 * Created by Hanson on 2017/6/6.
 * <p>
 * 栈接口
 * （1）清空(堆)栈
 * （2）判断是否为空
 * （3）元素的个数
 * （4）入栈
 * （5）出栈
 * （6）取栈顶元素
 */
public interface Stack {

    /**
     * 清空栈
     */
    public void clear();

    /**
     * 入栈
     *
     * @param e 入栈的元素
     */
    public void push(Object e);

    /**
     * 出栈
     *
     * @return 出栈的结果
     */
    public Object pop();

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty();

    /**
     * 取栈顶元素
     *
     * @return 栈顶元素
     */
    public Object peek();

    /**
     * 求元素个数
     *
     * @return 栈内元素
     */
    public int size();
}
