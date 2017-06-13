package com.queue.demo;

/**
 * Created by Hanson on 2017/6/6.
 */

/**
 * 链式队列节点
 */
class Node {
    Object data;    //数据元素
    Node next;  //后驱节点

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }

    public Node() {
        this(null);
    }
}

/**
 * 链式队列
 */
public class LinkQueue implements Queue {
    private Node front, rear;   //队头指针和尾指针
    private int size;

    public LinkQueue() {
        front = rear = new Node();
        size = 0;
    }

    @Override
    public void clear() {
        front.next = null;
        rear = front;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0)
            return true;
        else
            return false;
    }

    @Override
    public Object deQueue() {
        Node p = front.next;
        front.next = p.next;
        size--;
        return p.data;
    }

    @Override
    public Object peek() {
        return front.next.data;
    }

    @Override
    public void push(Object e) {
        Node p = new Node(e);
        rear.next = p;
        rear = p;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node p = front;
        while ((p = p.next) != null) {
            sb.append(p.data + ", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
