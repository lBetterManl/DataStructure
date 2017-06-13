package com.binarytree.demo;

/**
 * Created by Hanson on 2017/6/13.
 *
 * 二叉树接口定义
 *
 * 数据元素：具有相同特性的数据元素的集合。
 结构关系：树中数据元素间的结构关系由二叉树的定义确定。
 基本操作：树的主要操作有
 （1）创建树IntTree(&T)
 （2）销毁树DestroyTree(&T)
 （3）构造树CreatTree(&T，deinition)
 （4）置空树ClearTree(&T)
 （5）判空树TreeEmpty(T)
 （6）求树的深度TreeDepth(T)
 （7）获得树根Root(T)
 （8）获取结点Value(T，cur_e，&e)，将树中结点cur_e存入e单元中。
 （9）数据赋值Assign(T，cur_e，value)，将结点value，赋值于树T的结点cur_e中。
 （10）获得双亲Parent(T，cur_e)，返回树T中结点cur_e的双亲结点。
 （11）获得最左孩子LeftChild(T，cur_e)，返回树T中结点cur_e的最左孩子。
 （12）获得右兄弟RightSibling(T，cur_e)，返回树T中结点cur_e的右兄弟。
 （13）插入子树InsertChild(&T，&p，i，c)，将树c插入到树T中p指向结点的第i个子树之前。
 （14）删除子树DeleteChild(&T，&p，i)，删除树T中p指向结点的第i个子树。
 （15）遍历树TraverseTree(T，visit())
 */
public interface BTree {

    /**
     * 添加左子树
     * @param lChild 左子树
     */
    public void addLeftTree(BTree lChild);

    /**
     * 添加右子树
     * @param rChild 右子树
     */
    public void addRightTree(BTree rChild);

    /**
     * 置空树
     */
    public void clearTree();

    /**
     * 树的深度
     * @return 深度
     */
    public int dept();

    /**
     * 求左孩子结点
     * @return 左孩子
     */
    public BTree getLeftChild();

    /**
     * 求右孩子结点
     * @return 右孩子
     */
    public BTree getRightChild();

    /**
     * 获得根结点数据
     * @return 根结点数据
     */
    public Object getRootData();

    /**
     * 是否有左子树
     * @return
     */
    public boolean hasLeftTree();

    /**
     * 是否有右子树
     * @return
     */
    public boolean hasRightTree();

    /**
     * 是否为空树
     * @return true空  false非空
     */
    public boolean isEmpty();

    /**
     * 是否为叶子结点
     * @return
     */
    public boolean isLeaf();

    /**
     * 删除左子树
     */
    public void removeLeftChild();

    /**
     * 删除右子树
     */
    public void removeRightChild();

    /**
     * 获得树的根
     * @return 树的根
     */
    public BTree root();

    /**
     * 设置根结点的数据
     * @param data 根结点数据
     */
    public void setRootData(Object data);

    /**
     * 求结点数
     * @return 结点的个数
     */
    public int size();
}
