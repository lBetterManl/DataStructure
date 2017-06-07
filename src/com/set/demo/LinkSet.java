package com.set.demo;

/**
 * Created by Hanson on 2017/6/7.
 *
 * 链式集合
 */

class Node {
    Object data;    //元素
    Node next;  //后驱

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }

    public Node() {
        this(null);
    }
}

public class LinkSet implements Set {
    Node head;  //头节点
    int size;   //集合大小

    public LinkSet() {
        head = new Node();
        size = 0;
    }

    public LinkSet(Object[] datas) {
        int n = datas.length;
        head = new Node();
        Node p = head;
        for (int i = 0; i < n; i++) {
            p.next = new Node(datas[i]);
            p = p.next;
        }
        size = n;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * 查找 i 位置节点
     *
     * @param i
     * @return 节点
     */
    private Node index(int i) {
        Node p = null;
        if (i >= 0 && i < size) {
            p = head;
            for (int j = 0; j <= i; j++) {
                p = p.next;
            }
        }
        return p;
    }

    @Override
    public void add(Object o) {
        Node p = null;
        if (0 == size) {
            p = head;
        } else {
            p = index(size - 1);
        }
        p.next = new Node(o);
        size++;
    }

    @Override
    public Object get(int i) {
        Node p = index(i);
        return p.data;
    }

    @Override
    public void remove(Object o) {
        if (!contain(o)) {
            throw new IllegalArgumentException("集合中不包含 " + o + "元素");
        } else {
            Node p = null;
            int i = 0;
            while (i < size && get(i) != o) {
                i++;
            }
            if (i == 0) {
                p = head;
            } else {
                p = index(i - 1);
            }
            p.next = index(i).next;
            size--;
        }
    }

    @Override
    public boolean contain(Object o) {
        for (int i = 0; i < size; i++) {
            if (get(i) == o)
                return true;
        }
        return false;
    }

    @Override
    public boolean include(Set set) {
        if (set.size()>size){
            return false;
        } else if (set.size() == 0){
            return true;
        } else {
            boolean bool = true;
            for (int i = 0; i < set.size(); i++) {
                bool = bool && contain(set.get(i));
                if (!bool)
                    return false;
            }
            return bool;
        }
    }

    @Override
    public Set unionSet(Set set) {
        Set unSet = new LinkSet();
        for (int i = 0; i < size; i++) {
            unSet.add(set.get(i));
        }
        for (int i = 0; i < set.size(); i++) {
            Object obj = set.get(i);
            if (!contain(obj)) {
                unSet.add(obj);
            }
        }
        return unSet;
    }

    @Override
    public Set intersectionSet(Set set) {
        Set inSet = new LinkSet();
        for (int i = 0; i < size; i++) {
            Object obj = set.get(i);
            if (contain(obj))
                inSet.add(obj);
        }
        return inSet;
    }

    @Override
    public Set differenceSet(Set set) {
        Set difSet = new LinkSet();
        for (int i = 0; i < size; i++) {
            if (!set.contain(get(i)))
                difSet.add(get(i));
        }
        return difSet;
    }

    @Override
    public boolean isEmpty() {
        return 0 == size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for(int i=0; i<size; i++) {
            if(i == size-1)
                sb.append(get(i));
            else
                sb.append(get(i) + ", ");
        }
        sb.append("}");
        return sb.toString();
    }
}
