package com.tree.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hanson on 2017/6/8.
 *
 * 树的定义和实现
 *
 * 数据元素：具有相同特性的数据元素的集合。
 结构关系：树中数据元素间的结构关系由树的定义确定。
 基本操作：树的主要操作有
 （1）创建树IntTree(&T)
 创建1个空树T。
 （2）销毁树DestroyTree(&T)
 （3）构造树CreatTree(&T，deinition)
 （4）置空树ClearTree(&T)
 将树T置为空树。
 （5）判空树TreeEmpty(T)
 （6）求树的深度TreeDepth(T)
 （7）获得树根Root(T)
 （8）获取结点Value(T，cur_e，&e)
 将树中结点cur_e存入e单元中。
 （9）数据赋值Assign(T，cur_e，value)
 将结点value，赋值于树T的结点cur_e中。
 （10）获得双亲Parent(T，cur_e)
 返回树T中结点cur_e的双亲结点。
 （11）获得最左孩子LeftChild(T，cur_e)
 返回树T中结点cur_e的最左孩子。
 （12）获得右兄弟RightSibling(T，cur_e)
 返回树T中结点cur_e的右兄弟。
 （13）插入子树InsertChild(&T，&p，i，c)
 将树c插入到树T中p指向结点的第i个子树之前。
 （14）删除子树DeleteChild(&T，&p，i)
 删除树T中p指向结点的第i个子树。
 （15）遍历树TraverseTree(T，visit())
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
}
