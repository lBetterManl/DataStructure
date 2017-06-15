package com.graph.demo;

/**
 * Created by hp on 2017/6/15.
 *
 * 图-邻接链表示-顶点
 */
public class Vertex {
    private Object data;    //数据域-存储顶点名或其他信息
    private ArcEdge firstArc;   //链域-指向链表中的第一个结点

    public Vertex() {
        this.data = null;
        firstArc = null;
    }

    /**
     * 构造函数
     * @param data 顶点数据
     */
    public Vertex(Object data) {
        this.data = data;
        firstArc = null;
    }

    /**
     * 获得顶点的数据
     * @return data 顶点的数据
     */
    public Object getData(){
        return this.data;
    }

    /**
     * 设置顶点的数据
     * @param data
     */
    public void setData(Object data){
        this.data = data;
    }

    /**
     * 获得第一个弧结点
     * @return
     */
    public ArcEdge getFirstArc(){
        return firstArc;
    }

    /**
     * 设置第一个弧结点
     * @param firstArc
     */
    public void setFirstArc(ArcEdge firstArc){
        this.firstArc = firstArc;
    }

    @Override
    public boolean equals(Object obj) {
        Vertex v = (Vertex) obj;
        if (data.equals(v.getData()))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return data + " " + firstArc;
    }
}
