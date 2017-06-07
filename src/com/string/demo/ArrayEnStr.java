package com.string.demo;

/**
 * Created by Hanson on 2017/6/7.
 * <p>
 * 串值可变字符串，操作后字符串改变
 */
public class ArrayEnStr implements Str {
    private int len;    //长度
    private char[] s;   //字符数组

    public ArrayEnStr() {
        len = 0;
    }

    public ArrayEnStr(char[] ch) {
        len = ch.length;
        this.s = ch;
    }

    public ArrayEnStr(Str str) {
        this.len = str.length();
        for (int i = 0; i < len; i++) {
            this.s[i] = str.charAt(i);
        }
    }

    public ArrayEnStr(String string) {
        this.len = string.length();
        this.s = new char[len];
        for (int i = 0; i < len; i++) {
            s[i] = string.charAt(i);
        }
    }

    @Override
    public int length() {
        return len;
    }

    @Override
    public char charAt(int index) {
        if (index < 0 || index > len) {
            throw new StringIndexOutOfBoundsException("索引超出范围：" + index);
        }
        return s[index];
    }

    @Override
    public int indexOf(char c) {
        return indexOf(c, 0);
    }

    @Override
    public int indexOf(char c, int from) {
        int i = from;
        while (i < len) {
            if (c == s[i])
                return i;
            i++;
        }
        return -1;
    }

    @Override
    public int indexOf(Str str) {
        return indexOf(str, 0);
    }

    @Override
    public int indexOf(Str str, int from) {
        int i = from, j = 0;
        int sLen = str.length();
        while ((i < len) && (j < sLen)) {
            if (s[i] == str.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == sLen)
            return i - sLen;
        else
            return -1;
    }

    @Override
    public Str substring(int strartIndex) {
        return substring(strartIndex, len);
    }

    @Override
    public Str substring(int beginIndex, int endIndex) {
        int n = endIndex - beginIndex;
        char[] ss = new char[n];
        for (int i = 0; i < n; i++) {
            ss[i] = s[i + beginIndex];
        }
        return new ArrayEnStr(ss);
    }

    @Override
    public Str insert(int pos, Str str) {
        if (pos < 0 || pos > len) {
            throw new StringIndexOutOfBoundsException("插入地方超出范围：" + pos);
        } else {
            Str str2 = this.substring(pos);
            delete(pos, len);
            concat(str);
            concat(str2);
        }
        return this;
    }

    @Override
    public Str delete(int begin, int end) {
        int n = end - begin;
        for (int i = end; i < len; i++) {
            s[i - n] = s[i];
        }
        len = len - n;
        return this;
    }

    @Override
    public Str replace(Str target, Str replacement) {
        return replace(target, replacement, 0);
    }

    @Override
    public Str replace(Str target, Str replacement, int from) {
        int tLen = target.length();
        int rLen = replacement.length();
        int pos, k = 0;
        while (k < len) {
            pos = this.indexOf(target, from);
            if (-1 == pos) {
                break;
            } else {
                delete(pos, pos + tLen);
                insert(pos, replacement);
                k = pos + rLen;
            }
        }
        return this;
    }

    @Override
    public Str concat(Str str) {
        int n = len + str.length();
        expand(n);
        for (int i = 0; i < str.length(); i++) {
            s[i + len] = str.charAt(i);
        }
        len = n;
        return this;
    }

    /**
     * 扩充串长度
     *
     * @param size 扩充大小
     */
    private void expand(int size) {
        char[] c = new char[size];
        for (int i = 0; i < len; i++) {
            c[i] = s[i];
        }
        s = c;
    }

    @Override
    public char[] toCharArray() {
        return s;
    }

    /**
     * 判断串相同
     *
     * @param o
     * @return 0为相同
     */
    @Override
    public int compareTo(Object o) {
        Str str2 = (Str) o;
        int n = Math.min(len, str2.length());
        int i = 0;
        while (i < n) {
            char c1 = s[i];
            char c2 = str2.charAt(i);
            if (c1 != c2) {
                return c1 - c2;
            }
            i++;
        }
        return len - str2.length();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(s[i]);
        }
        return sb.toString();
    }
}
