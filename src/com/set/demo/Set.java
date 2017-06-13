package com.set.demo;

/**
 * Created by Hanson on 2017/6/7.
 * <p>
 * 集合接口
 * <p>
 * （1）   构造一个集合
 * （2）   添加元素
 * （3）   删除元素
 * （4）   返回第i个元素
 * （5）   判断是否包含元素 o
 * （6）   是否包某个含集set
 * （7）   求并集
 * （8）   求交集
 * （9）   求差集
 * （10） 求元素的个数
 */
public interface Set {

    /**
     * 求元素个数
     *
     * @return 元素个数
     */
    public int size();

    /**
     * 添加元素
     *
     * @param o 元素
     */
    public void add(Object o);

    /**
     * 返回第i个元素
     *
     * @param i 从0开始
     * @return
     */
    public Object get(int i);

    /**
     * 删除元素
     *
     * @param o
     */
    public void remove(Object o);

    /**
     * 是否包含元素 o
     *
     * @param o
     * @return
     */
    public boolean contain(Object o);

    /**
     * 是否包含集合 set
     *
     * @param set
     * @return
     */
    public boolean include(Set set);

    /**
     * 求并集
     *
     * @param set
     * @return
     */
    public Set unionSet(Set set);

    /**
     * 求交集
     *
     * @param set
     * @return
     */
    public Set intersectionSet(Set set);

    /**
     * 求差集
     *
     * @param set
     * @return
     */
    public Set differenceSet(Set set);

    /**
     * 是否为空
     *
     * @return
     */
    public boolean isEmpty();
}
