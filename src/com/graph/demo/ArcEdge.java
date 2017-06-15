package com.graph.demo;

/**
 * Created by hp on 2017/6/15.
 *
 * 图-邻接链表示-弧结点
 */
public class ArcEdge extends Edge {
    private Vertex vertex;
    private ArcEdge prior;
    private ArcEdge next;

    /**
     * 构造函数
     */
    public ArcEdge() {
        super();
    }

    /**
     * 构造函数
     * @param weight 权值
     */
    public ArcEdge(double weight) {
        super(weight);
        prior = null;
        next = null;
    }

    /**
     * 构造函数
     * @param weight 权值
     * @param info 边的信息
     */
    public ArcEdge(double weight, Object info) {
        super(weight, info);
        prior = null;
        next = null;
    }

    /**
     * 构造函数
     * @param weight 权值
     * @param info 边的信息
     * @param vertex 顶点
     */
    public ArcEdge(double weight, Object info, Vertex vertex) {
        super(weight, info);
        this.vertex = vertex;
    }

    /**
     * 获得顶点
     * @return 顶点
     */
    public Vertex getVertex(){
        return vertex;
    }

    /**
     * 设置顶点
     * @param vertex 顶点
     */
    public void setVertex(Vertex vertex) {
        this.vertex = vertex;
    }

    /**
     * 获得上一个弧结点
     * @return
     */
    public ArcEdge getPrior() {
        return prior;
    }

    /**
     * 设置上一个弧结点
     * @param prior
     */
    public void setPrior(ArcEdge prior) {
        this.prior = prior;
    }

    /**
     * 获得下一个弧结点
     * @return
     */
    public ArcEdge getNext() {
        return next;
    }

    /**
     * 设置下一个弧结点
     * @param next
     */
    public void setNext(ArcEdge next) {
        this.next = next;
    }

    /**
     * 获得前一个顶点
     * @return
     */
    @Override
    public Object getFirstVertex() {
        return prior.vertex.getData();
    }

    /**
     * 获得下一个顶点
     * @return
     */
    @Override
    public Object getSecondVertex() {
        return next.vertex.getData();
    }

    @Override
    public int compareTo(Object o) {
        double w2 = ((Edge)o).getWeight();
        if(this.weight< w2)
            return -1;
        else if(this.weight > w2)
            return 1;
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        ArcEdge arc = (ArcEdge)obj;
        if(this.next == arc.next && this.weight == arc.weight)
            return true;
        return false;
    }
}
