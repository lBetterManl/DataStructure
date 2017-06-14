package com.graph.demo;

/**
 * Created by hp on 2017/6/14.
 *
 * 邻接矩阵表示法-边的定义
 */
public class MatrixEdge extends Edge {

    private Object v1, v2;

    public MatrixEdge(double weight) {
        v1 = null;
        v2 = null;
        this.info = null;
        this.weight = weight;
    }

    public MatrixEdge(Object v1, Object v2, Object info, double weight) {
        super(weight, info);
        this.v1 = v1;
        this.v2 = v2;
    }

    @Override
    public Object getFirstVertex() {
        return v1;
    }

    @Override
    public Object getSecondVertex() {
        return v2;
    }

    @Override
    public int compareTo(Object o) {
        Edge e = (Edge)o;
        if (this.weight > e.getWeight())
            return 1;
        else if (this.weight < e.getWeight())
            return -1;
        else
            return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Edge)obj).info.equals(info) && ((Edge)obj).getWeight() == this.weight;
    }

    @Override
    public String toString() {
        //return "边信息：" + info + "\t权值：" + weight + "\t顶点1:" + getFirstVertex() + "\t顶点2：" + getSecondVertex();
        return "" + weight;
    }
}
