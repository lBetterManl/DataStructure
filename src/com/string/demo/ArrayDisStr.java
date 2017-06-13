package com.string.demo;

/**
 * Created by Hanson on 2017/6/7.
 * <p>
 * 串值不可变字符串，操作后字符串不改变
 */
public class ArrayDisStr implements Str {

    private int len;    //长度
    private char[] s;   //字符数组

    public ArrayDisStr() {
        len = 0;
    }

    public ArrayDisStr(char[] ch) {
        len = ch.length;
        this.s = ch;
    }

    public ArrayDisStr(Str str) {
        this.len = str.length();
        for (int i = 0; i < len; i++) {
            this.s[i] = str.charAt(i);
        }
    }

    public ArrayDisStr(String string) {
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
        if (pos < 0 || pos > len)
            throw new StringIndexOutOfBoundsException(pos);
        else if (pos != 0) {
            Str s1 = this.substring(0, pos);
            Str s2 = this.substring(pos);
            Str res1 = s1.concat(str);
            Str res2 = res1.concat(s2);
            return res2;
        } else {
            return str.concat(this);
        }
    }

    @Override
    public Str delete(int begin, int end) {
        if (begin < 0 || begin > end || end > len)
            throw new StringIndexOutOfBoundsException();
        else if (begin == 0 && end == len)
            return new ArrayDisStr();
        else {
            Str s1 = this.substring(0, begin);
            Str s2 = this.substring(end);
            return s1.concat(s2);
        }
    }

    @Override
    public Str replace(Str target, Str replacement) {
        return replace(target, replacement, 0);
    }

    @Override
    public Str replace(Str target, Str replacement, int from) {
        int pos, tLen, rLen, k = from;
        tLen = target.length();
        rLen = replacement.length();
        Str strx = new ArrayDisStr(s);
        while (k < len) {
            pos = this.indexOf(target, k);
            if (pos == -1)
                break;
            else {
                strx = strx.delete(pos, pos + tLen);
                strx = strx.insert(pos, replacement);
                k = pos + rLen;
            }
        }
        return strx;
    }

    @Override
    public Str concat(Str str) {
        int sLen = str.length();
        if (sLen == 0)
            return this;
        char buf[] = new char[len + sLen];
        for (int i = 0; i < len; i++) {
            buf[i] = s[i];
        }
        for (int i = 0; i < sLen; i++) {
            buf[len + i] = str.charAt(i);
        }
        return new ArrayDisStr(buf);
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
