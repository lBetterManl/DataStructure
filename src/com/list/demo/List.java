package com.list.demo;

/**
 * Created by Hanson on 2017/6/6.
 *
 * 线性表的特征
 *
 * （1）计算表的长度n。
 （2）线性表是否为空
 （3）将元素添加到线性表的末尾
 （4）获取第i个元素，0≤i < n。
 （5）清除线性表
 （6）返回列表中首次出现指定元素的索引，如果列表不包含此元素，则返回 -1。
 （7）返回列表中最后一次出现指定元素的索引，如果列表不包含此元素，则返回 -1。
 （8）将新元素插入第i个位置，0≤i < n，使原来的第i，i+1，…，n–1个元素变为第i+1，i+2，…，n个元素。
 （9）更改第i个元素
 （10）删除第i个元素，0≤i < n，使原来的第i+1，i+2，…，n–1个元素变为第i，i+1，…，n–2个元素
 */
public interface List {

    /**
     * 将元素添加到线性表的末尾
     */
    public void add(Object e);

    /**
     * 清除线性表
     */
    public void clear();

    /**
     * 获取i位置元素
     * @param i
     * @return
     */
    public Object get(int i);

    /**
     * 返回线性表中指定元素首次出现的位置，不存在为-1
     * @param e
     * @return
     */
    public int indexOf(Object e);

    /**
     * 在i后面插入元素e
     * @param i
     * @param e
     */
    public void insert(int i, Object e);

    /**
     * 判断线性表是否为空
     * @return
     */
    public boolean isEmpty();

    /**
     * 获取线性表中最后出现指定元素的索引，不存在为-1
     * @param e
     * @return
     */
    public int lastIndexOf(Object e);

    /**
     * 移除指定位置元素
     * @param i
     */
    public void remove(int i);

    /**
     * 用指定元素替换i位置元素
     * @param i
     * @param e
     */
    public void set(int i, Object e);

    /**
     * 返回线性表大小
     * @return
     */
    public int size();
}
