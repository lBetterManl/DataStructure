package com.graph.demo;

import com.queue.demo.ArrayQueue;
import com.queue.demo.Queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 2017/6/15.
 *
 * 图-邻接链表示-图
 */
public class ListGraph implements Graph {
    private List<Vertex> vertexs;
    private int edgeNum;    //边的条数
    private enum Visit{unvisited, visited};

    public ListGraph() {
        vertexs = new ArrayList<>();
    }

    public List getVertexs() {
        return vertexs;
    }

    public ListGraph(Object[] vexs) {
        this();
        for (int i = 0; i < vexs.length; i++) {
            vertexs.add(new Vertex(vexs[i]));
        }
    }

    /**
     * 查找顶点
     * @param v 顶点
     * @return
     */
    public Vertex find(Object v){
        Vertex vex = new Vertex(v);
        int i = vertexs.indexOf(vex);
        if(i<0 || i>=vertexs.size()) {
            throw new ArrayIndexOutOfBoundsException("顶点" + v + "不存在！");
        }
        return (Vertex)vertexs.get(i);
    }

    @Override
    public void addVex(Object v) {
        vertexs.add(new Vertex(v));
    }

    @Override
    public void addEdge(Object v1, Object v2, double weight) {
        addEdge(v1, v2, null, weight);
    }

    @Override
    public void addEdge(Object v1, Object v2, Object info, double weight) {
        Vertex vex1 = find(v1);
        Vertex vex2 = find(v2);
        if(vex1 != null && vex2 != null) {
            ArcEdge e = new ArcEdge(weight, info, vex2);
            if(vex1.getFirstArc() == null) {
                vex1.setFirstArc(e);
            } else {
                ArcEdge arc = vex1.getFirstArc();
                while(arc.getNext() != null) {
                    arc = arc.getNext();
                }
                arc.setNext(e);
                e.setPrior(arc);
            }
            edgeNum ++;
        } else {
            throw new ArrayIndexOutOfBoundsException("顶点" + v1 + "或" + v2 + "不存在！");
        }
    }

    @Override
    public void clear() {
        vertexs.clear();
    }

    @Override
    public Object getFirstVertex(Object v) {
        Vertex vex = find(v);
        return getFirstVertex(vex).getData();
    }

    private Vertex getFirstVertex(Vertex v) {
        if(v.getFirstArc() != null && v.getFirstArc().getVertex() != null)
            return v.getFirstArc().getVertex();
        return null;
    }

    @Override
    public Object getNextVertex(Object v1, Object v2) {
        Vertex vex1 = find(v1);
        Vertex vex2 = find(v2);
        return getNextVertex(vex1, vex2).getData();
    }

    private Vertex getNextVertex(Vertex vex1, Vertex vex2) {
        ArcEdge arc = vex1.getFirstArc();
        while(arc.getNext() != null && arc.getVertex()!=vex2) {
            arc = arc.getNext();
        }
        if(arc.getVertex() != null)  {
            //System.out.println(arc.getVertex());
            return arc.getNext().getVertex();
        }
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
        for (int i = 0; i < vertexs.size(); i++) {
            Vertex vex1 = (Vertex)(vertexs.get(i));
            ArcEdge arc = vex1.getFirstArc();
            if (arc != null){
                while (arc.getNext() != null){
                    if (arc.getVertex().getData() == v){
                        removeEdge(vex1, v);
                    }
                }
            }
        }
        Vertex vex = find(v);
        if (vex != null){
            int i = vertexs.indexOf(vex);
            vertexs.remove(i);
        }
    }

    @Override
    public void removeEdge(Object v1, Object v2) {
        Vertex vex1 = find(v1);
        Vertex vex2 = find(v2);
        if(vex1 != null && vex2 != null) {
            ArcEdge arc = vex1.getFirstArc();
            while(arc.getNext() != null && arc.getVertex() != vex2) {
                arc = arc.getNext();
            }
            if(arc.getVertex() == vex2) {
                ArcEdge priEdge = arc.getPrior();
                ArcEdge nextEdge = arc.getNext();
                priEdge.setNext(nextEdge);
                nextEdge.setPrior(priEdge);
                edgeNum--;
            } else {
                throw new ArrayIndexOutOfBoundsException("边" + v1 + "到" + v2 + "不存在！");
            }
        } else {
            throw new ArrayIndexOutOfBoundsException("顶点" + v1 + "或" + v2 + "不存在！");
        }
    }

    @Override
    public String deptFirst(Object o) {
        Visit visit[] = new Visit[vertexs.size()];
        for(int i=0; i<vertexs.size(); i++)
            visit[i] = Visit.unvisited;
        StringBuilder sb = new StringBuilder();
        Vertex vex = new Vertex(o);//find(o);
        deptFirst(vex, visit, sb);
        return sb.toString();
    }

    private void deptFirst(Vertex vex, Visit[] visit, StringBuilder sb){
        Queue queue = new ArrayQueue();

        int n = vertexs.indexOf(vex);
        sb.append(vex.getData() + "\t");
        visit[n] = Visit.visited;

        queue.push(vex);
        while(!queue.isEmpty()) {
            Vertex u = (Vertex) queue.deQueue();
            Vertex v = getFirstVertex(u);
            while(null != v) {
                if(Visit.unvisited == visit[vertexs.indexOf(v)]) {
                    sb.append(v.getData() + "\t");
                    visit[vertexs.indexOf(v)] = Visit.visited;
                    queue.push(v);
                }
                v = getNextVertex(u, v);
            }
        }
    }

    @Override
    public String printGraph() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<vertexs.size(); i++) {
            Vertex vex = (Vertex) vertexs.get(i);
            sb.append("\n顶点：" + vex.getData() + "\t");
            ArcEdge arc = vex.getFirstArc();
            if(arc != null) {
                sb.append("孤，" + arc.getVertex().getData());
                while(arc.getNext() != null) {
                    sb.append("\t" + arc.getNext().getVertex().getData());
                    arc = arc.getNext();
                }
            }
        }
        return sb.toString();
    }
}
