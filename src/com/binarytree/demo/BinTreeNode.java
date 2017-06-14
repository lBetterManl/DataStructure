package com.binarytree.demo;

/**
 * Created by hp on 2017/6/14.
 *
 * 三叉链表示的二叉树定义
 */
public class BinTreeNode {
    private Object data;    //数据
    private BinTreeNode parent; //父结点
    private BinTreeNode lChild; //左孩子
    private BinTreeNode rChild; //右孩子
    private int height; //以该结点为根的子树的高度
    private int size;   //该结点子孙数（包括结点本身）

    public BinTreeNode(Object data) {
        this.data = data;
        this.parent = null;
        this.lChild = null;
        this.rChild = null;
        this.height = 0;
        this.size = 1;
    }

    public BinTreeNode() {
        this(null);
    }

    /** ---------<data相关方法>---------- **/
    public Object getData(){
        return this.data;
    }
    public void setData(Object data){
        this.data = data;
    }
    /** ---------</data相关方法>---------- **/


    /** ---------<判断辅助方法>---------- **/
    /**
     * 判断是否有父结点
     * @return
     */
    public boolean hasParent(){
        return parent!=null;
    }

    /**
     * 判断是否有左孩子
     * @return
     */
    public boolean hasLeftChild(){
        return lChild!=null;
    }

    /**
     * 判断是否有右孩子
     * @return
     */
    public boolean hasRightChild(){
        return rChild!=null;
    }

    /**
     * 判断是否为叶子结点
     * @return
     */
    public boolean isLeaf(){
        return (!hasLeftChild() && !hasRightChild());
    }

    /**
     * 是否为某结点的左孩子
     * @return
     */
    public boolean isLeftChild(){
        return (hasParent() && this == parent.lChild);
    }

    /**
     * 是否为某结点的右孩子
     * @return
     */
    public boolean isRightChild(){
        return (hasParent() && this == parent.rChild);
    }
    /** ---------</判断辅助方法>---------- **/


    /** ---------<height相关方法>---------- **/
    /**
     * 取结点的高度，即以该节点为根的树的高度
     * @return
     */
    public int getHeight(){
        return this.height;
    }

    public void updateHeight(){
        int newHeight = 0;  //新高度初始化为0，高度等于左右子树加1中的较大值
        if (hasLeftChild())
            newHeight = Math.max(newHeight, (lChild.getHeight()+1));
        if (hasRightChild())
            newHeight = Math.max(newHeight, (rChild.getHeight()+1));
        if (newHeight == height)
            return; //高度没有发生变化
        height = newHeight;
        if (hasParent())    //递归更新祖先的高度
            parent.updateHeight();
    }
    /** ---------</height相关方法>---------- **/


    /** ---------<size相关方法>---------- **/
    /**
     * 取以该结点为根的树的结点数
     * @return
     */
    public int getSize(){
        return size;
    }
    public void updateSize(){
        size = 1;   //初始化为1，结点本身
        if (hasLeftChild())
            size = size + lChild.getSize();
        if (hasRightChild())
            size = size + rChild.getSize();
        if (hasParent())
            parent.updateSize();
    }
    /** ---------</size相关方法>---------- **/


    /** ---------<parent相关方法>---------- **/
    /**
     * 取父结点
     * @return
     */
    public BinTreeNode getParent(){
        return parent;
    }

    /**
     * 断开与父结点的关系
     */
    public void sever(){
        if (!hasParent())
            return;
        if (isLeftChild())
            parent.lChild = null;
        else
            parent.rChild = null;
        parent.updateHeight();  //更新父节点及其祖先的高度
        parent.updateSize();    //更新父节点及其祖先的规模
        parent = null;
    }
    /** ---------</parent相关方法>---------- **/


    /** ---------<lChild相关方法>---------- **/
    /**
     * 取左孩子
     * @return
     */
    public BinTreeNode getLChild(){
        return lChild;
    }

    /**
     * 设置当前结点的左孩子，返回原左孩子
     * @param leftChild
     * @return
     */
    public BinTreeNode setLChild(BinTreeNode leftChild){
        BinTreeNode oldLeftChild = this.lChild;
        if (hasLeftChild())
            lChild.sever();
        if (null != leftChild){
            leftChild.sever();  //判断leftChild与其父结点的关系
            this.lChild = leftChild;    //确定父子关系
            leftChild.parent = this;
            this.updateHeight();    //更新当前结点及其祖先的高度
            this.updateSize();  //更新当前结点及其祖先的规模
        }
        return oldLeftChild;    //返回原左孩子
    }
    /** ---------</lChild相关方法>---------- **/


    /** ---------<rChild相关方法>---------- **/
    /**
     * 取右孩子
     * @return
     */
    public BinTreeNode getRChild(){
        return rChild;
    }

    public BinTreeNode setRChild(BinTreeNode rightChild){
        BinTreeNode oldRightChild = this.rChild;
        if (hasRightChild())
            rChild.sever(); //断开当前右孩子与结点的关系
        if (null != rightChild){
            rightChild.sever(); //断开rightChild与其父结点的关系
            this.rChild = rightChild;   //确定父子关系
            rightChild.parent = this;
            this.updateHeight();    //更新当前结点及其祖先的高度
            this.updateSize();  //更新当前结点及其祖先的规模
        }
        return oldRightChild;
    }
    /** ---------</rChild相关方法>---------- **/

    @Override
    public String toString() {
        return "" + data;
    }
}
