package com.stack.demo;

/**
 * Created by Hanson on 2017/6/7.
 */

/**
 * 链式(堆)栈的结点
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
 * 链式(堆)栈，无头节点
 */
public class LinkStack implements Stack {
    private Node top;   //栈顶指针
    private int size;   //栈大小

    public LinkStack() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    @Override
    public void push(Object e) {
        Node p = new Node(e);
        if (top == null) {
            top = p;
        } else {
            p.next = top;
            top = p;
        }
        size++;
    }

    @Override
    public Object pop() {
        Node p = top;
        top = top.next;
        size--;
        return p.data;
    }

    @Override
    public boolean isEmpty() {
        return 0 == size;
    }

    @Override
    public Object peek() {
        return top.data;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * 从栈顶输出
     * @return 栈字符串
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node p = top;
        if(p == null) {
            sb.append("");
        } else {
            do{
                sb.append(p.data + ",  ");
            }while((p = p.next) != null);
        }
        sb.append("]");
        return sb.toString();
    }
}
