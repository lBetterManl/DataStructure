package com.tree.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Hanson on 2017/6/8.
 * <p>
 * 树的定义和实现
 * <p>
 * 数据元素：具有相同特性的数据元素的集合。
 * 结构关系：树中数据元素间的结构关系由树的定义确定。
 * 基本操作：树的主要操作有
 * （1）创建树IntTree(&T)
 * 创建1个空树T。
 * （2）销毁树DestroyTree(&T)
 * （3）构造树CreatTree(&T，deinition)
 * （4）置空树ClearTree(&T)
 * 将树T置为空树。
 * （5）判空树TreeEmpty(T)
 * （6）求树的深度TreeDepth(T)
 * （7）获得树根Root(T)
 * （8）获取结点Value(T，cur_e，&e)
 * 将树中结点cur_e存入e单元中。
 * （9）数据赋值Assign(T，cur_e，value)
 * 将结点value，赋值于树T的结点cur_e中。
 * （10）获得双亲Parent(T，cur_e)
 * 返回树T中结点cur_e的双亲结点。
 * （11）获得最左孩子LeftChild(T，cur_e)
 * 返回树T中结点cur_e的最左孩子。
 * （12）获得右兄弟RightSibling(T，cur_e)
 * 返回树T中结点cur_e的右兄弟。
 * （13）插入子树InsertChild(&T，&p，i，c)
 * 将树c插入到树T中p指向结点的第i个子树之前。
 * （14）删除子树DeleteChild(&T，&p，i)
 * 删除树T中p指向结点的第i个子树。
 * （15）遍历树TraverseTree(T，visit())
 */
public class Tree {
    private Object data;
    private List<Tree> childs;

    public Tree() {
        this.data = null;
        childs = new ArrayList<Tree>();
        childs.clear();
    }

    public Tree(Object data) {
        this.data = data;
        childs = new ArrayList<>();
        childs.clear();
    }

    /**
     * 添加子树
     *
     * @param tree
     */
    public void addNode(Tree tree) {
        childs.add(tree);
    }

    /**
     * 置空树
     */
    public void clear() {
        data = null;
        childs.clear();
    }

    /**
     * 返回第i个子树
     *
     * @param i
     * @return 子树
     */
    public Tree getChild(int i) {
        return childs.get(i);
    }

    /**
     * 求第一个孩子 结点
     *
     * @return
     */
    public Tree getFirstChild() {
        return childs.get(0);
    }

    /**
     * 求最后一个孩子结点
     *
     * @return
     */
    public Tree getLastChild() {
        return childs.get(childs.size() - 1);
    }

    /**
     * 得到所有孩子结点
     *
     * @return
     */
    public List<Tree> getChilds() {
        return childs;
    }

    /**
     * 得到根结点数据
     *
     * @return
     */
    public Object getRootData() {
        return data;
    }

    /**
     * 判断是否为空树
     *
     * @return
     */
    public boolean isEmpty() {
        if (childs.isEmpty() && data == null)
            return true;
        return false;
    }

    /**
     * 是否为叶子结点
     *
     * @return
     */
    public boolean isLeaf() {
        if (childs.isEmpty())
            return true;
        return false;
    }

    /**
     * 获得树根
     *
     * @return
     */
    public Tree root() {
        return this;
    }

    /**
     * 设置根结点数据
     *
     * @param data
     */
    public void setRootData(Object data) {
        this.data = data;
    }

    /**
     * 结点个数
     *
     * @return
     */
    public int size() {
        if (this.isEmpty()) {
            return 0;
        } else if (this.isLeaf()) {
            return 1;
        } else {
            int count = 1;
            int n = childs.size();
            for (int i = 0; i < n; i++) {
                if (!childs.get(i).isEmpty()) {
                    count += childs.get(i).size();
                }
            }
            return count;
        }
    }

    /**
     * 树深度
     *
     * @return
     */
    public int dept() {
        if (this.isEmpty()) {
            return 0;
        } else if (this.isLeaf()) {
            return 1;
        } else {
            int n = childs.size();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                if (childs.get(i).isEmpty()) {
                    a[i] = 0 + 1;
                } else {
                    a[i] = childs.get(i).dept() + 1;
                }
            }
            Arrays.sort(a);
            return a[n - 1];
        }
    }
}
