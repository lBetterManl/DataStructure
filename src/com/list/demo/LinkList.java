package com.list.demo;

/**
 * Created by Hanson on 2017/6/6.
 */

/**
 * 链表的节点——》包含数据和后驱节点
 */
class Node {
    Object data;    //数据元素
    Node next;  //后驱节点

    public Node() {
        this(null);
    }

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }
}

/**
 * 单向循环链表 下标从0开始
 */
public class LinkList implements List {
    Node head;  //头节点
    int size;   //链表大小

    public LinkList() {
        head = new Node();
        size = 0;
    }

    public LinkList(Object[] datas) {
        int n = datas.length;
        head = new Node();
        Node p = head;  //p与head为同一个对象
        for (int i = 0; i < n; i++) {
            p.next = new Node(datas[i]);
            p = p.next;
        }
        size = n;
    }

    /**
     * 返回第i位置节点
     *
     * @param i
     * @return
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
    public void add(Object e) {
        Node p;
        if (0 == size) {
            p = head;
        } else {
            p = index(size - 1);
        }
        p.next = new Node(e);
        size++;
    }

    @Override
    public void clear() {
        head.next = null;
        size = 0;
    }

    @Override
    public Object get(int i) {
        Node p = index(i);
        return p.data;
    }

    @Override
    public int indexOf(Object e) {
        Node p = head.next;
        int i = 0;
        while (!p.data.equals(e)) {
            p = p.next;
            i++;
        }
        if (i < size)
            return i;
        else
            return -1;
    }

    @Override
    public void insert(int i, Object e) {
        Node p = index(i);
        Node p2 = new Node(e);
        p2.next = p.next;
        p.next = p2;
        size++;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0)
            return true;
        else
            return false;
    }

    @Override
    public int lastIndexOf(Object e) {
        int i = size - 1;
        while (!get(i).equals(e)) {
            i--;
        }
        if (i >= 0)
            return i;
        else
            return -1;
    }

    @Override
    public void remove(int i) {
        if (i>=0 && i<size){
            Node p = null;
            if (i==0){
                p = head;
            } else {
                p = index(i-1);
            }
            p.next = index(i).next;
        }
        size--;
    }

    @Override
    public void set(int i, Object e) {
        Node p = index(i);
        p.data = e;
    }

    @Override
    public int size() {
        return size;
    }
}
