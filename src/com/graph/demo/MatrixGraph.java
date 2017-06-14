package com.graph.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 2017/6/14.
 *
 * 邻接矩阵表示法-图的定义
 */
public class MatrixGraph implements Graph {
    private static final int defaultSize = 10;
    private int maxLen; //矩阵的最大长度
    private int edgeNum;    //边的条数
    private List vertexs;
    private Edge edges[][];

    private enum Visit{unvisited, visited};

    public MatrixGraph() {
        this.maxLen = defaultSize;
        vertexs = new ArrayList();
        edges = new MatrixEdge[maxLen][maxLen];
    }

    /**
     * 构造函数
     * @param vexs 顶点的数组
     */
    public MatrixGraph(Object vexs[]) {
        this.maxLen = vexs.length;
        this.vertexs = new ArrayList();
        edges = new MatrixEdge[maxLen][maxLen];
        for (int i = 0; i < maxLen; i++) {
            vertexs.add(vexs[i]);
        }
    }


    @Override
    public void addVex(Object v) {
        vertexs.add(v);
        if (vertexs.size() > maxLen){
            expand();
        }
    }

    private void expand(){
        MatrixEdge newEdges[][] = new MatrixEdge[2*maxLen][2*maxLen];
        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < maxLen; j++) {
                newEdges[i][j] = (MatrixEdge) edges[i][j];
            }
        }
    }

    @Override
    public void addEdge(Object v1, Object v2, double weight) {
        int i1 = vertexs.indexOf(v1);
        int i2 = vertexs.indexOf(v2);
        if (i1>=0 && i1<vertexs.size() && i2 >=0 && i2<vertexs.size()){
            edges[i1][i2] = new MatrixEdge(v1, v2, null, weight);
            edgeNum++;
        } else {
            throw new ArrayIndexOutOfBoundsException("顶点越界或对应的边不合法");
        }
    }

    @Override
    public void addEdge(Object v1, Object v2, Object info, double weight) {
        int i1 = vertexs.indexOf(v1);
        int i2 = vertexs.indexOf(v2);
        if (i1>=0 && i1<vertexs.size() && i2>=0 && i2<vertexs.size()){
            edges[i1][i2] = new MatrixEdge(v1, v2, info, weight);
            edgeNum++;
        } else {
            throw new ArrayIndexOutOfBoundsException("顶点越界或对应的边不合法");
        }
    }

    @Override
    public void clear() {
        this.maxLen = defaultSize;
        vertexs.clear();
        edges = null;
    }

    @Override
    public Object getFirstVertex(Object v) {
        int i = vertexs.indexOf(v);
        if (i<0)
            throw new ArrayIndexOutOfBoundsException("顶点v不存在！");
        for (int col = 0; col < vertexs.size(); col++) {
            if (edges[i][col] != null)
                return vertexs.get(col);
        }
        return null;
    }

    @Override
    public Object getNextVertex(Object v1, Object v2) {
        int i1 = vertexs.indexOf(v1);
        int i2 = vertexs.indexOf(v2);
        if(i1<0 || i2<0)
            throw new ArrayIndexOutOfBoundsException("顶点v不存在！");
        for(int col=i2+1; col<vertexs.size(); col++)
            if(edges[i1][col] != null)
                return vertexs.get(col);
        return null;
    }

    @Override
    public int getVertexSize() {
        return vertexs.size();
    }

    @Override
    public int getEdgeSize() {
        return edgeNum;
    }

    @Override
    public void removeVex(Object v) {
        int index = vertexs.indexOf(v);
        int n = vertexs.size();
        vertexs.remove(v);
        for (int i = 0; i < n; i++) {
            edges[i][n-1] = null;
            edges[n-1][i] = null;
        }
    }

    @Override
    public void removeEdge(Object v1, Object v2) {
        int i1 = vertexs.indexOf(v1);
        int i2 = vertexs.indexOf(v2);
        if (i1>=0 && i1<vertexs.size() && i2>=0 && i2<vertexs.size()){
            if (edges[i1][i2] == null){
                try {
                    throw new Exception("该边不存在！");
                } catch (Exception e){
                    e.printStackTrace();
                }
            } else {
                edges[i1][i2] = null;
                edgeNum--;
            }
        } else {
            throw new ArrayIndexOutOfBoundsException("顶点越界或对应的边不合法！");
        }
    }

    @Override
    public String deptFirst(Object o) {
        return null;
    }

    @Override
    public String printGraph() {
        StringBuilder sb = new StringBuilder();
        int n = getVertexSize();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(" " + edges[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
