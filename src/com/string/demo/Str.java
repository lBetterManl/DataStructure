package com.string.demo;

/**
 * Created by Hanson on 2017/6/7.
 * <p>
 * 串的接口定义
 * <p>
 * （1）求字符串的长度
 * （2）求指定索引处的 char 值
 * （3）指定字符在此字符串中第一次出现处的索引
 * （4）指定字符串在此字符串中第一次出现处的索引
 * （5）求子串
 * （6）插入字符串
 * （7）删除子串
 * （8）替换子串
 * （9）连接字符串
 * （10）字符串比较
 */
public interface Str extends Comparable {

    /**
     * 求字符串长度
     *
     * @return 字符串长度
     */
    public int length();

    /**
     * 返回指定索引处的char值
     *
     * @param index 指定索引，第一个为索引0
     * @return char值
     */
    public char charAt(int index);

    /**
     * 指定字符第一次出现位置
     *
     * @param c 指定字符
     * @return 首次出现位置，不存在为-1
     */
    public int indexOf(char c);

    /**
     * 从某处开始搜索字符
     *
     * @param c    指定字符
     * @param from 开始索引的位置
     * @return 从开始位置向后索引，不存在为-1
     */
    public int indexOf(char c, int from);

    /**
     * 返回第一次出现的指定子字符串在此字符串中的索引
     *
     * @param str 任意字符串
     * @return 返回第一次出现的指定子字符串在此字符串中的索引；如果它不作为一个子字符串出现，则返回 -1
     */
    public int indexOf(Str str);

    /**
     * 从指定的索引处开始，返回第一次出现的指定子字符串在此字符串中的索引
     *
     * @param str  要搜索的子字符串
     * @param from 开始搜索的索引位置
     * @return 从指定的索引处开始，返回第一次出现的指定子字符串在此字符串中的索引
     */
    public int indexOf(Str str, int from);

    /**
     * 求子串
     *
     * @param strartIndex 开始处的索引（包括）
     * @return 返回一个从beginIndex到末尾的新字符串，它是此字符串的一个子字符串
     */
    public Str substring(int strartIndex);

    /**
     * 求子串
     *
     * @param beginIndex 开始处的索引（包括）
     * @param endIndex   结束处的索引（不包括）
     * @return 返回一个从beginIndex到endIndex-1的新字符串，它是此字符串的一个子字符串
     */
    public Str substring(int beginIndex, int endIndex);

    /**
     * 插入字符串
     *
     * @param pos
     * @param str
     * @return
     */
    public Str insert(int pos, Str str);

    /**
     * 删除子串
     *
     * @return
     */
    public Str delete(int begin, int end);

    /**
     * 替换子串
     *
     * @param target      要被替换的子串
     * @param replacement 要替换的子串
     * @return
     */
    public Str replace(Str target, Str replacement);

    /**
     * 替换子串
     *
     * @param target      要被替换的子串
     * @param replacement 要替换的子串
     * @param from        开始查找的位置
     * @return
     */
    public Str replace(Str target, Str replacement, int from);

    /**
     * 连接字符串
     *
     * @param str
     * @return
     */
    public Str concat(Str str);

    /**
     * 转化成数组
     *
     * @return
     */
    public char[] toCharArray();
}
