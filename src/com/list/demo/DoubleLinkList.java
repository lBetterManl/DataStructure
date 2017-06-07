package com.list.demo;

/**
 * Created by Hanson on 2017/6/6.
 */

/**
 * 链表结点
 */
class DlNode {
    Object data;
    DlNode prior, next;

    public DlNode(Object data) {
        this.data = data;   //数据元素
        this.prior = null;  //前驱节点
        this.next = null;   //后驱节点
    }

    public DlNode() {
        this(null);
    }
}

/**
 * 双向循环链表
 */
public class DoubleLinkList implements List {
    DlNode head;    //头节点
    int size;   //链表大小

    public DoubleLinkList() {
        head = new DlNode();
        head.prior = head;
        head.next = head;
        size = 0;
    }

    public DoubleLinkList(Object[] datas) {
        int n = datas.length;
        head = new DlNode();
        DlNode p = head;
        DlNode p2 = null;
        for (int i = 0; i < n; i++) {
            p2 = new DlNode(datas[i]);
            p.next = p2;
            p2.prior = p;
            p = p.next;
        }
        p2.next = head;
        head.prior = p2;
        size = n;
    }

    /**
     * 获取第i位置节点
     *
     * @param i
     * @return
     */
    private DlNode index(int i) {
        DlNode p = null;
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
        DlNode p, p2;   //p定位插入位置，p2创建插入节点
        if (0 == size) {
            p = head;
        } else {
            p = index(size - 1);
        }
        p2 = new DlNode(e);
        p.next = p2;
        p2.prior = p;
        p2.next = head;
        head.prior = p2;
        size++;
    }

    @Override
    public void clear() {
        head.prior = null;
        head.next = null;
        size = 0;
    }

    @Override
    public Object get(int i) {
        DlNode p = index(i);
        return p.data;
    }

    @Override
    public int indexOf(Object e) {
        DlNode p = head.next;
        int i = 0;
        while (!p.data.equals(e)) {
            i++;
        }
        if (i < size)
            return i;
        else
            return -1;
    }

    @Override
    public void insert(int i, Object e) {
        DlNode p = index(i);
        DlNode p2 = new DlNode(e);
        p2.next = p.next;
        p2.prior = p;
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
        DlNode p = head.prior;
        int i = size - 1;
        while (!p.data.equals(e)) {
            p = p.prior;
            i--;
        }
        if (i >= 0)
            return i;
        else
            return -1;
    }

    @Override
    public void remove(int i) {
        if (i >= 0 && i < size) {
            DlNode p = null;
            if (i == 0)
                p = head;
            else
                p = index(i - 1);
            DlNode p2 = index(i);
            p.next = p2.next;
            p2.next.prior = p;
        }
        size--;
    }

    @Override
    public void set(int i, Object e) {
        DlNode p = index(i);
        p.data = e;
    }

    @Override
    public int size() {
        return size;
    }
}
