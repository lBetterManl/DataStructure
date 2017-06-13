package com.set.demo;

/**
 * Created by Hanson on 2017/6/7.
 * <p>
 * 集合也是一种特殊的线性表，可以用顺序结构和链式结构存储。
 * 顺序集合
 */
public class ArraySet implements Set {

    public static final int defLen = 10;    //集合默认大小
    private int maxLen; //数组的大小
    private int size;   //元素的大小
    private Object[] datas;

    public ArraySet() {
        this.maxLen = defLen;
        datas = new Object[maxLen];
        size = 0;
    }

    public ArraySet(int len) {
        this.maxLen = len;
        datas = new Object[maxLen];
        size = 0;
    }

    public ArraySet(Set set) {
        size = maxLen = set.size();
        for (int i = 0; i < size; i++) {
            datas[i] = set.get(i);
        }
    }

    /**
     * 清空集合
     */
    public void clear() {
        size = 0;
    }

    /**
     * 扩展集合空间
     */
    public void expand() {
        maxLen = 2 * maxLen;
        Object[] newArray = new Object[maxLen];
        for (int i = 0; i < size; i++) {
            newArray[i] = datas[i];
        }
        datas = newArray;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(Object o) {
        if (!contain(o)) {
            if (size >= maxLen) {
                expand();
            }
            datas[size] = o;
            size++;
        }
    }

    @Override
    public Object get(int i) {
        if (i < 0 || i >= size) {
            throw new StringIndexOutOfBoundsException("索引超出范围：" + i);
        }
        return datas[i];
    }

    /**
     * 查看元素所在索引
     *
     * @param o
     * @return 索引，不存在返回 -1
     */
    public int index(Object o) {
        int i = 0;
        while (i < size) {
            if (datas[i] == o) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override
    public void remove(Object o) {
        if (!contain(o)) {
            throw new IllegalArgumentException("集合中不包含 " + o + "元素");
        } else {
            int k = index(o);
            for (int i = k; i < size - 1; i++) {
                datas[i] = datas[i + 1];
            }
            size--;
        }

    }

    @Override
    public boolean contain(Object o) {
        int i = 0;
        while (i < size) {
            if (datas[i] == o)
                return true;
            i++;
        }
        return false;
    }

    @Override
    public boolean include(Set set) {
        if (set.size() > size) {
            return false;
        } else if (set.size() == 0) {
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
        int len = size + set.size();
        Set unSet = new ArraySet(len);
        for (int i = 0; i < size; i++) {
            unSet.add(datas[i]);
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
        int len = size < set.size() ? size : set.size();
        Set inSet = new ArraySet(len);
        for (int i = 0; i < set.size(); i++) {
            Object obj = set.get(i);
            if (contain(obj))
                inSet.add(obj);
        }
        return inSet;
    }

    @Override
    public Set differenceSet(Set set) {
        Set diSet = new ArraySet(size);
        for (int i = 0; i < size; i++) {
            if (!set.contain(datas[i]))
                diSet.add(datas[i]);
        }
        return diSet;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < size; i++) {
            if (i == size - 1)
                sb.append(datas[i]);
            else
                sb.append(datas[i] + ", ");
        }
        sb.append("}");
        return sb.toString();
    }
}
