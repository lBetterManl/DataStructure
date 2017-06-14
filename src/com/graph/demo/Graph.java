package com.graph.demo;

/**
 * Created by hp on 2017/6/14.
 *
 * 图的接口定义
 *
 * 图是一种数据结构，加上一组基本操作就构成了图的抽象数据类型。图的抽象数据类型定义如下：
 Graph{
 数据对象V：具有相同特性的数据元素的集合，称为顶点集。
 数据关系R：R={VR}
 VR={<v,w>|<v,w>| v,wÎV∧p(v,w) ，<v,w>表示从v到w的弧，P(v,w)定义了弧<v,w>的信息 }
 基本操作P：
 添加顶点
 添加边
 获得顶点的个数
 获得边的条数
 移除顶点
 移除边
 ……
 }
 */
public interface Graph {

    /**
     * 添加顶点
     * @param v
     */
    public void addVex(Object v);

    /**
     * 添加边
     * @param v1 第一个顶点
     * @param v2 第二个顶点
     * @param weight 权值
     */
    public void addEdge(Object v1, Object v2, double weight);

    /**
     * 添加边
     * @param v1 第一个顶点
     * @param v2 第二个顶点
     * @param info 边信息
     * @param weight 权值
     */
    public void addEdge(Object v1, Object v2, Object info, double weight);

    /**
     * 置空图
     */
    public void clear();

    /**
     * 获得顶点的第一个邻接结点
     * @param v 顶点
     * @return 顶点v的第一个邻接结点
     */
    public Object getFirstVertex(Object v);

    /**
     * 在图中寻找v1结点的邻接结点v2的下一个邻接结点
     * @param v1 顶点
     * @param v2 v1的一个邻接结点
     * @return 邻接v1的在v2后的一个结点
     */
    public Object getNextVertex(Object v1, Object v2);

    /**
     * 获得顶点个数
     * @return 顶点个数
     */
    public int getVertexSize();

    /**
     * 获得边的条数
     * @return 边的条数
     */
    public int getEdgeSize();

    /**
     * 移除顶点
     * @param v 顶点
     */
    public void removeVex(Object v);

    /**
     * 移除边
     * @param v1 顶点1
     * @param v2 顶点2
     */
    public void removeEdge(Object v1, Object v2);

    /**
     * 深度优先遍历
     * @param o 遍历的初始顶点
     * @return
     */
    public String deptFirst(Object o);

    /**
     * 打印图的各个顶点
     * @return
     */
    public String printGraph();
}
